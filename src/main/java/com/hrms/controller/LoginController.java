package com.hrms.controller;

import com.hrms.util.JsonMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ian
 */
@Controller
@RequestMapping(value = "/hrms")
public class LoginController {

    /**
     * 登入 : 跳轉到登入頁面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 對登入頁面输入的用户名和密碼做簡單的判断
     * @param request
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg dologin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password);
        if (!"admin1234".equals(username + password)) {
            

            return JsonMsg.fail().addInfo("login_error", "輸入賬號名與密碼不匹配，請重新輸入!");
        }
        return JsonMsg.success();
    }

    /**
     *  跳轉道主頁面
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    /**
     *退出登錄：從主頁面跳轉到登錄頁面
     * 
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "login";
    }

}
