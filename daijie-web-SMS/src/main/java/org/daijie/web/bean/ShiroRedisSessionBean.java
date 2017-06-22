package org.daijie.web.bean;

import org.daijie.web.session.ShiroRedisSession;
import org.springframework.context.annotation.Bean;

/**
 * shiro redis管理类bean实例
 * @author daijie
 * @date 2017年6月22日
 */
public class ShiroRedisSessionBean {
	
	@Bean
	public ShiroRedisSession initShiroRedisSession(){
		return new ShiroRedisSession();
	}
}
