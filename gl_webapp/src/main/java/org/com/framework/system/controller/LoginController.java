package org.com.framework.system.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.com.framework.bean.SysMenu;
import org.com.framework.bean.SysUser;
import org.com.framework.common.FrameWorkConfig;
import org.com.framework.service.ISysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/")
public class LoginController {

	private static Logger log = Logger.getLogger(LoginController.class.getName());
	
	@Resource
	private ISysMenuService sysMenuService;
	
	@RequestMapping(value="main")
	public String main(){
		return "login";
	}
	
	
	
  /**
   * 根据用户名和密码获取新的token值
   * 
   * @param req
   * @param rep
   * @throws Exception
   */

  @RequestMapping("/login")
  public ModelAndView login(HttpServletRequest req, HttpServletResponse rep, String account, String password) throws Exception {

    AuthenticationToken token = new UsernamePasswordToken(account, password);
    // 2. 获取当前Subject：
    Subject currentUser = SecurityUtils.getSubject();
    ModelAndView mav = new ModelAndView("main");
    if (currentUser.isAuthenticated()) {
      return mav;
    }
    try {
      currentUser.login(token);
      mav.addObject("loginMsg", "用户登录成功！");
      SysUser user = (SysUser) currentUser.getPrincipal();
      currentUser.getSession().setAttribute(FrameWorkConfig.CURRENT_USER, user);
      List<SysMenu> menuList = sysMenuService.findMenuTree(null);
      req.getSession().setAttribute("menuList", menuList);
    } catch (IncorrectCredentialsException ice) {
      ice.printStackTrace();
      mav = new ModelAndView("login");
      mav.addObject("loginMsg", "用户密码错误！");
      mav.addObject("account", account);
    } catch (LockedAccountException lae) {
      lae.printStackTrace();
      mav = new ModelAndView("login");
      mav.addObject("loginMsg", "用户账号被锁！");
      mav.addObject("account", account);
    } catch (AuthenticationException ae) {
      ae.printStackTrace();
      mav = new ModelAndView("login");
      mav.addObject("loginMsg", "用户认证异常！--" + ae.getMessage());
      mav.addObject("account", account);
    }
    return mav;
  }

  @RequestMapping("/index")
  public String index(HttpServletRequest req, HttpServletResponse rep) throws Exception {
    Subject currentUser = SecurityUtils.getSubject();
    Session session = currentUser.getSession(false);
    if (session != null && session.getAttribute(FrameWorkConfig.CURRENT_USER) != null) {
      return "/framework/index";
    }
    return "/framework/login";
  }

  @RequestMapping("/logOut")
  public String logOut(HttpServletRequest req, HttpServletResponse rep) throws Exception {
    Subject subject = SecurityUtils.getSubject();
    subject.getSession().removeAttribute(FrameWorkConfig.CURRENT_USER);
    subject.logout();
    return "/framework/login";
  }

	
	
}
