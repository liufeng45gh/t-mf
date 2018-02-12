package com.lucifer.service;

import com.lucifer.mapper.shop.MemberMapper;
import com.lucifer.mapper.shop.PictureMapper;
import com.lucifer.model.Member;
import com.lucifer.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private MemberLoginService memberLoginService;

    @Resource
    private PictureMapper pictureMapper;

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


}
