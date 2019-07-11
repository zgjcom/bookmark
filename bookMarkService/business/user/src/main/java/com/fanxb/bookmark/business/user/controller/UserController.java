package com.fanxb.bookmark.business.user.controller;

import com.fanxb.bookmark.business.user.entity.LoginBody;
import com.fanxb.bookmark.business.user.entity.RegisterBody;
import com.fanxb.bookmark.business.user.service.UserService;
import com.fanxb.bookmark.common.entity.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/7/4 19:51
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Description: 获取验证码
     *
     * @param email 邮箱
     * @return com.fanxb.bookmark.common.entity.Result
     * @author fanxb
     * @date 2019/7/5 17:37
     */
    @GetMapping("/authCode")
    public Result getAuthCode(@Param("email") String email) {
        userService.sendAuthCode(email);
        return Result.success(null);
    }

    /**
     * Description: 注册用户
     *
     * @param body 注册表单
     * @return com.fanxb.bookmark.common.entity.Result
     * @author fanxb
     * @date 2019/7/6 16:34
     */
    @PutMapping("")
    public Result register(@RequestBody RegisterBody body) {
        userService.register(body);
        return Result.success(null);
    }

    /**
     * Description: 用户登录
     *
     * @param user 登录表单
     * @return com.fanxb.bookmark.common.entity.Result
     * @author fanxb
     * @date 2019/7/6 16:35
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginBody body) {
        return Result.success(userService.login(body));
    }

    /**
     * Description: 重置密码
     *
     * @param body 重置密码表单
     * @return com.fanxb.bookmark.common.entity.Result
     * @author fanxb
     * @date 2019/7/9 19:57
     */
    @PostMapping("/resetPassword")
    public Result resetPassword(@RequestBody RegisterBody body) {
        userService.resetPassword(body);
        return Result.success(null);
    }


}