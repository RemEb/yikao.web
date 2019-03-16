package com.lcy.yikao.web.controller;

import com.lcy.yikao.web.Util.m5Password;
import com.lcy.yikao.web.dao.BmUserMapper;
import com.lcy.yikao.web.dataobject.BmUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Lcy
 * @date 2019/3/15 22:16
 */
@Controller
public class LoginControl {
    @Autowired
    BmUserMapper bmUserMapper;

    private static final Logger log = LoggerFactory.getLogger(LoginControl.class);


    @RequestMapping(path = "login",method = RequestMethod.POST)
    public ModelAndView login(BmUser user, HttpSession session) {
        BmUser bmUser = bmUserMapper.selectByEmailKey(user.getEmail());
        if (bmUser == null){
            log.info("用户未注册");
            return new ModelAndView("redirect:login.html");
        }
        String encryptPwd = m5Password.encrypt(user.getPwd(),bmUser.getSalt());
        if (encryptPwd.equals(bmUser.getPwd())) {
            log.info("登陆成功！");
            session.setAttribute("user",user);
            return new ModelAndView("redirect:index.html");
        }else {
            log.info("密码错误！");
            return new ModelAndView("redirect:login.html");
        }
    }

    @RequestMapping(path = "/api/getuser")
    @ResponseBody
    public BmUser getUser(@SessionAttribute("user")BmUser user){
        return user;
    }


}
