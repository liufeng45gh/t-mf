package com.lucifer.service;



import com.lucifer.exception.Oauth2CodeInvalidException;
import com.lucifer.mapper.shop.MemberMapper;
import com.lucifer.model.AccessToken;

import com.lucifer.model.Member;
import com.lucifer.utils.*;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MemberLoginService {

	
	@Resource
	private UserService userService;
	


	Logger logger = LoggerFactory.getLogger(this.getClass());


	@Resource
	private MemberMapper memberMapper;

	@Autowired
	private RedisTemplate redisTemplate;
	/**
	 * 手机号登录
	 * @param member
	 * @return
	 * @throws Exception 
	 */
	public Result loginByPhone(Member member) throws Exception{

		Member dbUser = memberMapper.getMemberByPhone(member.getPhone());
		if  (null == dbUser)  {
			return Result.fail("用户未找到");
		}
		String md5Password = Md5Utils.md5(Md5Utils.md5(member.getPassword())+dbUser.getSalt());
		if (!md5Password.equals(dbUser.getPassword())) {
			return Result.fail("密码错误");
		}

		String token = this.newUserLoginToken(dbUser.getId());
		return this.loginSuccess(dbUser,token);

	}

	public String newUserLoginToken(Long userId){
		String token = RandomStringUtils.randomAlphanumeric(20);
		redisTemplate.opsForValue().set(Constant.CACHE_KEY_PERSISTENCE_TOKEN_PRE+token,userId);
		redisTemplate.expire(Constant.CACHE_KEY_PERSISTENCE_TOKEN_PRE+token,Constant.LOGIN_TIME_OUT, TimeUnit.SECONDS);
		return token;
	}


	/**
	 * 返回token
	 * @param user
	 * @return
	 */
	public Result loginSuccess(Member user, String token){
		Map resultMap = new HashMap();
		resultMap.put("user", user);
		resultMap.put("token", token);
		user.setPassword(null);
		return Result.ok(resultMap);
	}
	

	
	public void logout(String token){
		redisTemplate.delete(Constant.CACHE_KEY_PERSISTENCE_TOKEN_PRE+token);
	}



}
