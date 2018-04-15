package com.chenqian.controller;

import com.chenqian.entity.ParticipantRepository;
import com.chenqian.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *登录和注册的控制器
 */
@Controller
public class LoginController {

//    //定义一个订阅消息标志
//    private static final String SUBSCRIBE_LOGIN_URI = "/topic/login";
//
//
//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;
//
//    /**
//     * 用户仓库列表
//     */
//    @Autowired
//    ParticipantRepository participantRepository;
//
//    @RequestMapping(value = "/login222", method = RequestMethod.POST)
//    @ResponseBody
//    public String login(HttpServletRequest request){
//        return "success";
//    }
//
//    /**
//     * 登录的用户进入聊天室
//     */
//    @RequestMapping(value = "/intoChatRoom", method = RequestMethod.POST)
//    public String intoChatRoom(User user, HttpServletRequest request){
//        System.out.println("添加仓库");
//        //1. 存入session
//        //2. 添加到当前在线用户仓库
//        //3. messagingTemplate发布上线消息， 将消息发布给监听的客户端
//        System.out.println(user);
//        request.getSession().setAttribute("user",user);
//        participantRepository.add(user.getName(), user);
//        messagingTemplate.convertAndSend(SUBSCRIBE_LOGIN_URI, user);
//        return "chatRoom";
//    }
//
//    //由客户端向服务器发起， 获取当前人数。
//    @SubscribeMapping("/chat/participants")
//    public Long participants(){
//        return Long.valueOf(participantRepository.getActiveSessions().size());
//    }



//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private UserService userService; //用户service类
//    @Autowired
//    private SimpMessagingTemplate messagingTemplate; //消息模板
//    @Autowired
//    private ParticipantRepository participantRepository; //在线用户存储
//
//    private static final String SUBSCRIBE_LOGIN_URI = "/topic/login"; //订阅的登录地址
//
//    /**
//     * 反馈前端ajax登录的消息
//     * @param user
//     * @return
//     */
//    @RequestMapping(value = "/reply/login", method = RequestMethod.POST)
//    @ResponseBody
//    public ReplyLoginMessage replayLoginMessage(@RequestBody User user){
//        System.out.println("user:"+user.toString());
//        if (user.getName() == null || user.getName().trim().equals("")
//                || user.getPassword() == null || user.getPassword().equals("")){
//            return new ReplyLoginMessage(false, ReplyLoginMessage.USER_NAME_OR_PASSWORD_NULL);
//        }
//        boolean isExist = userService.isExistUser(user.getName());
//        if (!isExist){
//            return new ReplyLoginMessage(false, ReplyLoginMessage.USER_NAME_NOT_EXIST);
//        }
//        User res = userService.validateUserPassword(user.getName(), user.getPassword());
//        if (res == null){
//            return new ReplyLoginMessage(false, ReplyLoginMessage.USER_PASSWORD_WRONG);
//        }
//        return new ReplyLoginMessage(true);
//    }
//
//    /**
//     * 反馈前端ajax注册的消息
//     * @param user
//     * @return
//     */
//    @RequestMapping(value = "/reply/regist", method = RequestMethod.POST)
//    @ResponseBody
//    public ReplyRegistMessage replyRegistMessage(@RequestBody User user){
//        boolean isExist = userService.isExistUser(user.getName());
//        if (isExist){
//            return new ReplyRegistMessage(false, ReplyRegistMessage.USER_NAME_EXIST);
//        }
//        if (user.getPassword() != null){
//            userService.insertUser(user.getName(), user.getPassword());
//        }
//        return new ReplyRegistMessage(true);
//    }
//
//    /**
//     * 登录进入聊天室
//     * @param user
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "/chat", method = RequestMethod.POST)
//    public String loginIntoChatRoom(User user, HttpServletRequest request){
//        user = userService.validateUserPassword(user.getName(), user.getPassword());
//        if (user == null){
//            return "login";
//        }
//        user.setLoginDate(new Date());
//        user.setPassword(null);  //设空防止泄露给其他用户
//        HttpSession session = request.getSession();
//        session.setAttribute("user", user);
//
//        messagingTemplate.convertAndSend(SUBSCRIBE_LOGIN_URI, user);
//        participantRepository.add(user.getName(), user);
//        logger.info(user.getLoginDate() + ", " + user.getName() + " login.");
//        return "chatroom";
//    }
//
//    /**
//     * 登录页面
//     * @return
//     */
//    @RequestMapping(value = {"/", "/index", ""}, method = RequestMethod.GET)
//    public String index(){
//        return "index";
//    }
//
//    /**
//     * 返回当前在线人数
//     * SubscribeMapping处理目的地的订阅
//     * @return
//     */
//    @SubscribeMapping("/chat/participants")
//    public Long getActiveUserNumber(){
//        return Long.valueOf(participantRepository.getActiveSessions().values().size());
//    }
}