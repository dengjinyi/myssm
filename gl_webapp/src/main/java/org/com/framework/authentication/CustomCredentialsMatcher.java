package org.com.framework.authentication;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.com.framework.common.AppConfig;
import org.com.framework.common.CryptUtil;


/**
 * 
 * @author liweiling
 *
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken,
			AuthenticationInfo info) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Object tokenCredentials = CryptUtil.encrypt((String.valueOf(token.getPassword())),AppConfig.key);
		Object accountCredentials = getCredentials(info);
		return equals(tokenCredentials, accountCredentials);
	}

}
