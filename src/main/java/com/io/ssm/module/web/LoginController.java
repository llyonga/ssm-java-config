package com.io.ssm.module.web;

import com.io.ssm.module.web.common.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: llyong
 * @date: 2018/8/14
 * @time: 19:27
 * @version: 1.0
 */
@Controller
public class LoginController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String turnLogin () {
        return "login";
    }

    @PostMapping("login")
    public String login (String username, String password, boolean rememberMe, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            model.addAttribute("m",(String) SecurityUtils.getSubject().getPrincipal());
            return "index";
        } catch (IncorrectCredentialsException e) {
            LOGGER.error("用户或者密码错误！",e);
            model.addAttribute("msg","用户或者密码错误！");
            return "login";
        } catch (LockedAccountException e) {
            LOGGER.error("登录失败，该用户已被冻结！",e);
            model.addAttribute("msg","登录失败，该用户已被冻结！");
            return "login";
        } catch (AccountException e) {
            LOGGER.error("",e);
            model.addAttribute("msg",e.getMessage());
            return "login";
        } catch (AuthenticationException e) {
            LOGGER.error("该用户不存在！",e);
            model.addAttribute("msg","该用户不存在！");
            return "login";
        } catch (Exception e) {
            LOGGER.error("系统异常",e);
            model.addAttribute("msg","系统异常！");
            return "login";
        }
    }
}
