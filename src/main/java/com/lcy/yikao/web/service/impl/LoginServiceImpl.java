package com.lcy.yikao.web.service.impl;

import com.lcy.yikao.web.Util.m5Password;
import com.lcy.yikao.web.dao.BmUserMapper;
import com.lcy.yikao.web.dataobject.BmUser;
import com.lcy.yikao.web.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lcy
 * @date 2019/3/15 22:16
 */
@Controller
public class LoginServiceImpl implements LoginService {
    @Autowired
    BmUserMapper bmUserMapper;

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    /**
     * 登陆业务
     * 未完成：
     * 1改为POST请求
     * 2跳转页面or不跳转
     *
     * @param email
     * @param pwd
     * @return
     */
    @Override
    @RequestMapping(path = "/login")
    public String login(String email, String pwd) {
        BmUser bmUser = bmUserMapper.selectByEmailKey(email);
        if (bmUser == null){
            log.info("用户未注册");
            return "index";
        }
        String encryptPwd = m5Password.encrypt(pwd,bmUser.getSalt());
        if (encryptPwd.equals(bmUser.getPwd())) {
            log.info("登陆成功！");
            return "index";
        }else {
            log.info("密码错误！");
            return "index";
        }

    }





}
