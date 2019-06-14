package org.alex.entity;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import org.alex.entity.Permission;
import org.alex.entity.Role;
import org.alex.entity.Logins;
import org.alex.service.LoginsService;
import org.alex.service.PermissionService;
import org.alex.service.RoleService;

/**
 * �û������֤,��Ȩ Realm ���
 * 
 **/

public class ShiroAuthorizingRealm extends AuthorizingRealm{
	private static final Logger LOGGER = Logger.getLogger(ShiroAuthorizingRealm.class);

    @Resource
    private LoginsService loginService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    /**
     * Ȩ�޼��
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = String.valueOf(principals.getPrimaryPrincipal());
        LOGGER.info("Ȩ�޼��----" + username + "-----------------");
        Logins param = new Logins();
        param.setUserid(username);
        final Logins loginer = loginService.getSigle(param);
        if (loginer != null) {
            Role role = roleService.getSingle(loginer.getRoleid());
            if (role != null) {
                authorizationInfo.addRole(role.getRoleDefine());
                LOGGER.info("��ɫ��" + role.getRoleDefine());
                List<Permission> permissions = permissionService.getByRole(role);
                for (Permission p : permissions) {
                    if (p.getPermissionDefine() != null) {
                        LOGGER.info("Ȩ�ޣ�" + p.getPermissionDefine());
                        authorizationInfo.addStringPermission(p.getPermissionDefine());
                    }
                    if (p.getUrl() != null) {
                        authorizationInfo.addStringPermission(p.getUrl());
                    }
                }

            }
        }
        return authorizationInfo;
    }

    /**
     * ��¼��֤
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());

        SimpleAuthenticationInfo authenticationInfo = null;
        // ͨ�����ݿ������֤

        try {
            Logins loginer = new Logins();
            loginer.setLoginid(username);
            loginer.setPassword(password);
            final Logins authenticatedUser = loginService.getSigle(loginer);
            if (authenticatedUser == null) {
                throw new AuthenticationException("�û������������.");
            } else {
                Subject currentUser = SecurityUtils.getSubject();
                Session session = currentUser.getSession();
                session.setAttribute("user", authenticatedUser);
            }

            authenticationInfo = new SimpleAuthenticationInfo(username,
                    password, authenticatedUser.getUserid());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return authenticationInfo;
    }
}
