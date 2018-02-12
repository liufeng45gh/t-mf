package com.lucifer.controller.web;

import com.lucifer.mapper.shop.MemberMapper;
import com.lucifer.model.Member;
import com.lucifer.service.MemberLoginService;
import com.lucifer.service.MemberService;
import com.lucifer.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/u-center")
public class UCenterController {


    @Resource
    private MemberLoginService memberLoginService;

    @Resource
    private MemberService memberService;


    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(@CookieValue String token, HttpServletRequest request){
        Member member = memberLoginService.getMemberByToken(token);
        request.setAttribute("member",member);
        return "/web/u-center/index";
    }


    @RequestMapping(value="/nick-update",method = RequestMethod.GET)
    public String toUpdateNickName(@CookieValue String token, HttpServletRequest request){
        Member member = memberLoginService.getMemberByToken(token);
        request.setAttribute("member",member);
        return "/web/u-center/up-nick";
    }

    @RequestMapping(value="/nick-update",method = RequestMethod.POST)
    @ResponseBody
    public Result submitUpdateNickName(@CookieValue String token, String nickName){
        return memberService.updateNickName(token,nickName);
    }

    @RequestMapping(value="/info-update",method = RequestMethod.GET)
    public String toUpdateInfo(@CookieValue String token, HttpServletRequest request){
        Member member = memberLoginService.getMemberByToken(token);
        request.setAttribute("member",member);
        return "/web/u-center/up-info";
    }

    @RequestMapping(value="/info-update",method = RequestMethod.POST)
    @ResponseBody
    public Result submitUpdateInfo(@CookieValue String token, Member member){
        memberService.updateMemberInfo(token,member);
        return Result.ok();
    }

    @RequestMapping(value="/description-update",method = RequestMethod.GET)
    public String toUpdateDescription(@CookieValue String token, HttpServletRequest request){
        Member member = memberLoginService.getMemberByToken(token);
        request.setAttribute("member",member);
        return "/web/u-center/up-description";
    }

    @RequestMapping(value="/description-update",method = RequestMethod.POST)
    @ResponseBody
    public Result submitUpdateDescription(@CookieValue String token, Member member){
        memberService.updateMemberDescription(token,member);
        return Result.ok();
    }

    @RequestMapping(value="/self-show",method = RequestMethod.POST)
    @ResponseBody
    public Result submitUpdateSelfShow(@CookieValue String token, Integer selfShow){
        memberService.updateMemberSelfShow(token,selfShow);
        return Result.ok();
    }

    @RequestMapping(value="/price-update",method = RequestMethod.GET)
    public String toUpdatePrice(@CookieValue String token, HttpServletRequest request){
        Member member = memberLoginService.getMemberByToken(token);
        request.setAttribute("member",member);
        return "/web/u-center/up-price";
    }

    @RequestMapping(value="/price-update",method = RequestMethod.POST)
    @ResponseBody
    public Result submitUpdatePrice(@CookieValue String token, Member member){
        memberService.updateMemberPrice(token,member);
        return Result.ok();
    }

    @RequestMapping(value="/picture-update",method = RequestMethod.GET)
    public String toUpdatePicture(@CookieValue String token, HttpServletRequest request){
        Member member = memberLoginService.getMemberByToken(token);
        request.setAttribute("member",member);
        return "/web/u-center/up-picture";
    }

    @RequestMapping(value="/main-picture-update",method = RequestMethod.POST)
    @ResponseBody
    public Result submitUpdateMainPicture(@CookieValue String token, String picture){
        memberService.updateMemberMainPicture(token,picture);
        return Result.ok();
    }

}
