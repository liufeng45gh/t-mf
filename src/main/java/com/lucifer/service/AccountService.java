package com.lucifer.service;



import com.lucifer.enums.SmsCodeType;
import com.lucifer.mapper.oauth2.UserMapper;
import com.lucifer.mapper.shop.MemberMapper;
import com.lucifer.mapper.shop.SmsCodeMapper;
import com.lucifer.model.Member;
import com.lucifer.model.SmsCode;
import com.lucifer.model.User;
import com.lucifer.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

@Service
public class AccountService {
	
	@Resource
	private SmsService smsService;
	
	@Resource
	private UserLoginService userLoginService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private UserMapper userMapper;

	@Resource
	private SmsCodeMapper smsCodeMapper;

	@Resource
	private MemberMapper memberMapper;

	@Resource
	private MemberLoginService memberLoginService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Transactional(propagation= Propagation.REQUIRED)
	public Result resetPassword(User user) throws Exception{
		Result  result = smsService.checkCode(user.getPhone(), user.getCode());
		if (!result.isOk()) {
			return Result.fail("验证码错误");
		}
		if (!user.getPassword().equals(user.getRePassword())) {
			return Result.fail("2次密码不一致");
		}
		User dbUser = userMapper.getUserByPhone(user.getPhone());
		if  (null == dbUser)  {
			return Result.fail("用户未找到");
		}
		//userCenterService.resetPassword(user);
		String encrypt_password = Md5Utils.md5(Md5Utils.md5(user.getPassword())+dbUser.getSalt());
		dbUser.setPassword(encrypt_password);
		

		userMapper.updatePassword(dbUser);
		return Result.ok();
	}
	
	@Transactional(propagation= Propagation.REQUIRED)
	public Result bindPhone(User user,String token) throws Exception{
		
		Result  result = smsService.checkCode(user.getPhone(), user.getCode());
		if (!result.isOk()) {
			return Result.fail("验证码错误");
		}
		if (!user.getPassword().equals(user.getRePassword())) {
			return Result.fail("2次密码不一致");
		}
		
		User dbUser = userMapper.getUserById(user.getId());
		
		
		if (null == dbUser) {
			return Result.fail("未找到用户");
		}
		
		if (!StringHelper.isEmpty(dbUser.getPhone())) {
			return Result.fail("用户已绑定手机");
		}
		
		Boolean isExist = this.isMemberExist(user.getPhone());
		
		if (isExist) {
			return Result.fail("该手机号已被占用");
		}
		//userCenterService.thirdLoginBindPhone(user, token);
		
		dbUser.setPhone(user.getPhone());
		String salt = RandomUtil.getNextSalt();
		dbUser.setSalt(salt);
		String encrypt_password = Md5Utils.md5(Md5Utils.md5(user.getPassword())+salt);
		dbUser.setPassword(encrypt_password);		
		//
		this.bindPhoneWidthCache(dbUser);
				
		return Result.ok();
	}
	
	
	
	public Result checkPassword(User user){
		User dbUser = userMapper.getUserById(user.getId());
		if  (null == dbUser)  {
			return Result.fail("用户未找到");
		}
		String md5Password = Md5Utils.md5(Md5Utils.md5(user.getPassword())+dbUser.getSalt());
		if (md5Password.equals(dbUser.getPassword())) {
			return Result.ok();
		}		
		return Result.fail("密码错误");
	}
	
	public Result reBindPhone(User user,String token) throws Exception{
		
		Result  result = smsService.checkCode(user.getPhone(), user.getCode());
		if (!result.isOk()) {
			return Result.fail("验证码错误");
		}
		
		User dbUser = userMapper.getUserById(user.getId());
		
		if  (null == dbUser)  {
			return Result.fail("未找到用户");
		}
		String md5Password = Md5Utils.md5(Md5Utils.md5(user.getPassword())+dbUser.getSalt());
		if (!md5Password.equals(dbUser.getPassword())) {
			return Result.fail("密码错误");
		}		
		
				
		Boolean isExist = this.isMemberExist(user.getPhone());
		
		if (isExist) {
			return Result.fail("该手机号已被占用");
		}
		user.setId(dbUser.getId());
//		Result resultUserCenter = userCenterService.reBindPhone(user, token);
//		if (!resultUserCenter._isOk()) {
//			return resultUserCenter;
//		}
		dbUser.setPhone(user.getPhone());
		String salt = RandomUtil.getNextSalt();
		dbUser.setSalt(salt);
		String encrypt_password = Md5Utils.md5(Md5Utils.md5(user.getPassword())+salt);
		dbUser.setPassword(encrypt_password);
		
		this.bindPhoneWidthCache(dbUser);
		
		
		return Result.ok();
	}
	
	public Result isPhoneExist(String phone) throws Exception{
		if (this.isMemberExist(phone)) {
			return Result.fail("用户已经存在");
		}
		return Result.ok("手机未注册");
	}
	
	public void bindPhoneWidthCache(User user){
		
		userMapper.userBindPhone(user);
	}
	
	public Boolean isMemberExist(String telephone) {
		Member member = memberMapper.getMemberByPhone(telephone);
		if (null != member) {
			return true;
		}
		return false;
	}
	
	public Integer allUserCount(){
		return userMapper.allUserCount();
	}

	public boolean resetPassword(String account,String oldPass,String newPass){
		User user = userMapper.getUserByAccount(account);
		String md5OldPassword = Md5Utils.md5(Md5Utils.md5(oldPass)+user.getSalt());
		if(md5OldPassword.equals(user.getPassword())){
			String md5NewPassword = Md5Utils.md5(Md5Utils.md5(newPass)+user.getSalt());
			user.setPassword(md5NewPassword);
			userMapper.updatePassword(user);
			return true;
		}else{
			return false;
		}
	}

	public Result sendPhoneRegisterMsg(String phone){
//		if(this.isMemberExist(phone)) {
//			return Result.fail("手机号已存在");
//		}
		String code = RandomUtil.getRamdomIntString(6);
		logger.info("send sms code is: {}",code);
		SmsCode smsCode = new SmsCode();
		smsCode.setCode(code);
		smsCode.setPhone(phone);
		smsCode.setType(SmsCodeType.register.name());
		smsCode.setCreatedAt(DateUtils.now());
		smsCode.setUpdatedAt(DateUtils.now());
		smsCodeMapper.insertSmsCode(smsCode);
		return Result.ok();
	}

	public Result registerOrResetPass(String phone,String phoneCode,String password) throws Exception {
		Result checkResult = this.checkPhoneRegisterCode(phone,phoneCode);
		if(!checkResult.isOk()){
			return checkResult;
		}
		Member member = memberMapper.getMemberByPhone(phone);
		if (null == member) {
			member = new Member();
			member.setPhone(phone);
			String salt = RandomUtil.getNextSalt();
			member.setSalt(salt);
			String encrypt_password = Md5Utils.md5(Md5Utils.md5(password)+salt);
			member.setPassword(encrypt_password);
			member.setCreatedAt(DateUtils.now());
			member.setUpdatedAt(DateUtils.now());
			String account = "mp_"+RandomUtil.getNextAccount();
			member.setNickName(account);
			memberMapper.insertMember(member);
		} else {
			String encrypt_password = Md5Utils.md5(Md5Utils.md5(password)+member.getSalt());
			member.setPassword(encrypt_password);
			member.setUpdatedAt(DateUtils.now());
			memberMapper.updateMemberPassword(member);
		}

		//member.setPassword(password);
		Result loginResult = memberLoginService.loginByPhone(phone,password);
		return loginResult;
	}

	private Result checkPhoneRegisterCode(String phone,String code) throws IOException {
		String dbCode = smsCodeMapper.getLastSmsCode(phone,SmsCodeType.register.name());
		logger.info("dbCode sms code is: {}",dbCode);
		if (code.equals(dbCode)) {
			return Result.ok();
		}
		return Result.fail("验证码错误");
	}

}
