package com.chenqian.controller.user;

import com.chenqian.controller.Result;
import com.chenqian.entity.CiBaInfo;
import com.chenqian.entity.User;
import com.chenqian.exception.CustomException;
import com.chenqian.service.PageService;
import com.chenqian.service.RegService;
import com.chenqian.service.UserService;
import com.chenqian.vo.UserRegVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private RegService regService;

    @Autowired
    private PageService pageService;

    /**
     *点击用户中心, 没登陆进入登入页，否则去个人中心
     */
    @RequestMapping(value = {"/", ""})
    public ModelAndView goUserUI(HttpServletRequest request) throws IOException {
        //获取第二张图片
        List<CiBaInfo> ciBaInfo = pageService.getCiBaInfo();
        String backImg = ciBaInfo.get(1).getPicture2();

        ModelAndView model = new ModelAndView();
        model.addObject("backImg",backImg);
        model.setViewName("user/user");
        return model;
    }

    /**
     * 登录界面
     * @param request
     * @return
     */
    @RequestMapping(value = {"loginUI"})
    public ModelAndView loginUI(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.addObject("backImg",request.getParameter("backImg"));
        model.setViewName("user/user");
        return model;
    }

    /**
     *用户注册，
     *      调用注册服务，判断是否重名，发送邮件
     *      返回json信息。
     */
    @RequestMapping(value = {"/reg"})
    @ResponseBody
    public Result reg(UserRegVo userRegVo) throws CustomException {
        System.out.println(userRegVo.getPassword());
       // System.out.println(userRegVo.getPassword());
        regService.regHandler(userRegVo);
        return Result.success("注册成功");
    }
    /**
     * 用户激活
     * @param request
     * @return
     */
    @RequestMapping(value = {"/activate"})
    @ResponseBody
    public Result activate(HttpServletRequest request) throws CustomException {
        regService.activateHandler(request);
        return null;
    }

    /**
     * 用户登录
     * @param request
     * @return
     */
    @RequestMapping(value = {"login"}, method = RequestMethod.POST)
    @ResponseBody
    public Result login(UserRegVo userRegVo, HttpServletRequest request) throws CustomException {
        User user = userService.getUserByName(userRegVo.getUsername());
        if (user == null) {
            throw new CustomException("用户名不存在");
        }
        if (!user.getPassword().equals(userRegVo.getPassword())) {
            throw new CustomException("用户名或密码错误");
        }
        request.getSession().setAttribute("user", user);
        return Result.success("登录成功");
    }



}