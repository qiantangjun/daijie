package org.daijie.shiro.authc;

import java.util.List;

/**
 * 用户角色权限实体
 * @author daijie
 * @date 2017年6月22日
 */
public class UserToken {

	private Object authc;
	
	private List<String> roles;
	
	private List<String> permissions;

	public Object getAuthc() {
		return authc;
	}

	public void setAuthc(Object authc) {
		this.authc = authc;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
}
