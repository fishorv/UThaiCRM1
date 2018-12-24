package com.uthai.controller;

import com.uthai.po.TbUserRole;
import com.uthai.reponsePojo.WebToken;
import com.uthai.service.UserService;
import com.uthai.service.impl.TokenImpl;
import com.uthai.service.impl.UserServiceImpl;
import com.uthai.service.impl.WXServiceImpl;
import com.uthai.service.impl.WebServiceImp;
import com.uthai.util.CodeUtil;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.nio.cs.ext.GBK;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/web")
public class WebControl {
    static final String APPID="wx0331d8fe4217d8d6";
    static final String APPSECRET="b8949ff0e75591908fb5f7bd7d6b205d";
    @Resource
    WebServiceImp webService;
    @Resource
    WXServiceImpl wxService;
    @Resource
    UserServiceImpl userService;
    @Resource
    TokenImpl tokenImpl;
    @RequestMapping(value = "/getCode")
    public String getCode() throws UnsupportedEncodingException {
        String backUrl="http://www.fishor.com.cn/web/callBack.do";
        String url="https://open.weixin.qq.com/connect/oauth2/authorize" +
                "?appid="+APPID+
                "&redirect_uri="+URLEncoder.encode(backUrl,"GBK")+
                "&response_type=code" +
                "&scope=snsapi_userinfo"+
                "&state=123"+
                "#wechat_redirect";
        return "redirect:"+url.trim();
    }
    @RequestMapping(value = "/callBack")
    @ResponseBody
    public ModelAndView getWebToken(@Param("code")String code , @Param("state")String state ,HttpSession httpSession){
        String url=("https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code").replace("APPID",APPID).replace("SECRET",APPSECRET).replace("CODE",code);
        ModelAndView av= new ModelAndView();
        JSONObject logTest= (JSONObject) httpSession.getAttribute("user_info");
        JSONObject jsonObject;
        JSONObject sessionInfo ;
        if (logTest==null||!logTest.containsKey("access_token")){
            jsonObject=wxService.doGetStr(url);
            httpSession.setAttribute("user_info",jsonObject);
        }
        sessionInfo = (JSONObject) httpSession.getAttribute("user_info");
        Map<String,String> map= webService.getUserInfo(sessionInfo.getString("access_token"),sessionInfo.getString("openid"));
        TbUserRole tbUserRole= userService.login(map);
        if (tbUserRole!= null){
            av.addObject("userRole",tbUserRole.getUserRole());
            av.addObject("branch",tbUserRole.getBranchGroup());
            av.setViewName(tbUserRole.getUserRole());
        } else{
            av.addObject("openId",map.get("openid"));
            av.addObject("sex",map.get("sex"));
            av.addObject("province",map.get("province"));
            av.addObject("city",map.get("city"));
            av.setViewName("regist");
        }
        return av;
    }
    @RequestMapping(value = "/regist")
    public ModelAndView regist(@Param("userName")String userName,@Param("password")String password ,@Param("code")String code, HttpSession session){
        TbUserRole userRole= new TbUserRole();
        JSONObject jsonObject= (JSONObject) session.getAttribute("user_info");
        userRole.setUserId(userName);
        userRole.setOpenId(jsonObject.getString("openid"));
        userRole.setPass(password);
        userRole.setUserRole("customer");
        ModelAndView av= new ModelAndView();
        if (!code.equals(session.getAttribute("code"))){
            av.addObject("status","验证码错误！");
            av.addObject("userName",userName);
            av.setViewName("regist");
            return  av;
        }
        if (userService.checkIfExit(userName)){
            av.addObject("status","用户名已存在！");
            av.addObject("userName",userName);
            av.setViewName("regist");
            return av;
        }
        int result=userService.register(userRole);
        if (result==0) //注册成功
        {
            av.addObject("userRole",userRole.getUserRole());
            av.addObject("branch",userRole.getBranchGroup());
            av.setViewName(userRole.getUserRole());
        }
        return av;
    }

    @RequestMapping(value = "/getImgCode")
    public void getCodePic(HttpServletRequest request , HttpServletResponse response){
        ModelAndView av= new ModelAndView();
        try {
            request.setCharacterEncoding("gb2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 调用工具类生成的验证码和验证码图片
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();
        // 将四位数字的验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute("code", codeMap.get("code").toString());
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);
        response.setContentType("image/jpeg");
        ServletOutputStream sos;
        try {
            sos = response.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @RequestMapping(value = "/loginCheck")
//    @ResponseBody
//    public String loginCheck(@Param("code")String code ,@Param("userName")String userName,String o_code){
//        if (o)
//        return null;
//    }

}
