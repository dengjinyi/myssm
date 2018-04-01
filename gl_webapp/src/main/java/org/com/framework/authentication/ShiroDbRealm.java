package org.com.framework.authentication;



import java.sql.Connection;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.com.framework.bean.SysUser;
import org.com.framework.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class ShiroDbRealm extends SimpleAccountRealm {

	@Autowired
	private ISysUserService sysUserService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		return info;
	}

	@Override
	public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		if (username == null) {
			throw new AccountException("请输入登录账号！");
		}
		SysUser shiroUser = this.sysUserService.getUserByAccount(username);
		if (shiroUser == null) {
			throw new UnknownAccountException("您所输入的帐号[" + username + "]不存在或者已被删除！");
		}
		/*else if(shiroUser.getStatus()==null||!shiroUser.getStatus().equals("1")){
            throw new UnknownAccountException("您所输入的帐号[" + username + "]已被注销,请联系管理员！");
        }*/
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(shiroUser, shiroUser.getPassword().toCharArray(), getName());
		return info;
	}

}
