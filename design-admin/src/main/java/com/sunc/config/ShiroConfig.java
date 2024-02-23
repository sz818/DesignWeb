package com.sunc.config;

import org.apache.catalina.Realm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ShiroConfig {
    public Realm realm(DataSource dataSource){
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(dataSource);
        //开启身份验证缓存，默认就是开启的
        realm.setAuthenticationCachingEnabled(true);
        return null;
    }
    public SecurityManager securityManager(Realm realm){
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //securityManager.setRealm(realm);
        return securityManager;
    }
}
