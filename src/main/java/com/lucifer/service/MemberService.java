package com.lucifer.service;

import com.lucifer.mapper.shop.MemberMapper;
import com.lucifer.mapper.shop.PictureMapper;
import com.lucifer.model.Member;
import com.lucifer.model.SearchParam;
import com.lucifer.utils.Result;
import com.lucifer.utils.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private MemberLoginService memberLoginService;

    @Resource
    private PictureMapper pictureMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Result updateNickName(String token,String nickName){
        Long tokenMemberId =  memberLoginService.getMemberIdByToken(token);
        Member nickNameMember =  memberMapper.getMemberByNickName(nickName);
        if (null != nickNameMember) {
            if (nickNameMember.getId().equals(tokenMemberId)) {
                return Result.ok("修改成功",null);
            }else {
                return Result.fail("昵称已被其它用户占用");
            }
        }
        memberMapper.updateMemberNick(tokenMemberId,nickName);
        return Result.ok("修改成功");
    }

    public void updateMemberInfo(String token, Member member){
        Long tokenMemberId =  memberLoginService.getMemberIdByToken(token);
        member.setId(tokenMemberId);
        memberMapper.updateMemberInfo(member);
    }

    public void updateMemberDescription(String token, Member member){
        Long tokenMemberId =  memberLoginService.getMemberIdByToken(token);
        member.setId(tokenMemberId);
        memberMapper.updateMemberDescription(member);
    }


    public void updateMemberSelfShow(String token, Integer selfShow){
        Long tokenMemberId =  memberLoginService.getMemberIdByToken(token);
        memberMapper.updateMemberSelfShow(tokenMemberId,selfShow);
    }

    public void updateMemberPrice(String token, Member member){
        Long tokenMemberId =  memberLoginService.getMemberIdByToken(token);
        member.setId(tokenMemberId);
        memberMapper.updateMemberPrice(member);
    }

    public void updateMemberMainPicture(String token, String picture){
        Long tokenMemberId =  memberLoginService.getMemberIdByToken(token);
        memberMapper.updateMemberMainPicture(tokenMemberId,picture);
    }

    public List<Member> memberCmsSearch(SearchParam param){
        String sql = "select * from member   where 1=1 ";
        if (!StringHelper.isEmpty(param.getPhone())) {
            sql = sql + "and member.phone like '"+param.getPhone()+"%' ";
        }
        if (!StringHelper.isEmpty(param.getNickName())) {
            sql = sql + "and member.nick_name like '"+param.getNickName()+"%' ";
        }

        if (null != param.getSelfShow()) {
            sql = sql + "and member.self_show = "+param.getSelfShow()+" ";
        }
        if (null != param.getIsCheck()) {
            sql = sql + "and member.is_check = "+param.getIsCheck()+" ";
        }
        sql = sql + "order by member.id desc limit "+param.getOffset()+","+param.getCount();



        logger.info("sql is : "+sql);

        List<Member> memberList = memberMapper.memberCmsSearch(sql);



        return memberList;
    }

    public Integer memberCmsSearchCount(SearchParam param){
        String sql = "select count(*) from member   where 1=1 ";
        if (!StringHelper.isEmpty(param.getPhone())) {
            sql = sql + "and member.phone like '"+param.getPhone()+"%' ";
        }
        if (!StringHelper.isEmpty(param.getNickName())) {
            sql = sql + "and member.nick_name like '"+param.getNickName()+"%' ";
        }

        if (null != param.getSelfShow()) {
            sql = sql + "and member.self_show = "+param.getSelfShow()+" ";
        }
        if (null != param.getIsCheck()) {
            sql = sql + "and member.is_check = "+param.getIsCheck()+" ";
        }

        logger.info("sql is : "+sql);

        Integer recordCount  = memberMapper.memberCmsSearchCount(sql);


        return recordCount;
    }


}
