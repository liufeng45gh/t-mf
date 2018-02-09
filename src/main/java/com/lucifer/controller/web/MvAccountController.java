package com.lucifer.controller.web;

import com.lucifer.service.AccountService;
import com.lucifer.utils.Constant;
import com.lucifer.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class MvAccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String toRegister(){
        return "/web/register";
    }

    @RequestMapping(value="/account/send-check-code.json",method = RequestMethod.POST)
    @ResponseBody
    public Result sendCheckCode(String phone, String imgCode, HttpServletRequest request) throws IOException {
        String captchaCode = (String)request.getSession().getAttribute(Constant.KAPTCHA_SESSION_KEY);
        if (captchaCode == null || !captchaCode.equals(imgCode)) {
            return Result.fail("图片验证码错误");
        }
        return accountService.sendPhoneRegisterMsg(phone);
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    @ResponseBody
    public Result registerOrResetPass(String phone,String phoneCode,String password) throws Exception {
        return accountService.registerOrResetPass(phone,phoneCode,password);
    }
}
