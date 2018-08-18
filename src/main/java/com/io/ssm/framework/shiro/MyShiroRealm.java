package com.io.ssm.framework.shiro;

import com.io.ssm.module.domain.role.CmRole;
import com.io.ssm.module.domain.rolemenu.CmRoleMenu;
import com.io.ssm.module.domain.user.CmUser;
import com.io.ssm.module.domain.userrole.CmUserRole;
import com.io.ssm.module.service.role.CmRoleService;
import com.io.ssm.module.service.rolemenu.CmRoleMenuService;
import com.io.ssm.module.service.user.CmUserService;
import com.io.ssm.module.service.userrole.CmUserRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: llyong
 * @date: 2018/8/18
 * @time: 09:50
 * @version: 1.0
 */
@Component
public class MyShiroRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private CmUserService cmUserService;
    @Autowired
    private CmRoleService cmRoleService;
    @Autowired
    private CmUserRoleService cmUserRoleService;
    @Autowired
    private CmRoleMenuService cmRoleMenuService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LOGGER.info("--------------授权验证方法-------------------");
//        String username = (String) SecurityUtils.getSubject().getPrincipal();
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        //获得该用户角色
//        List<CmRoleMenu> allMenu = cmRoleMenuService.findAllMenu(username);
//        Set<String> set = new HashSet<>();
//        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
//        set.add(role);
//        //设置该用户拥有的角色
//        info.setRoles(set);
//        return info;
        return null;
    }

    /**
     * 认证 鉴权
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LOGGER.info("--------------身份验证方法-------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = (String) token.getPrincipal();
        CmUser cmUser = cmUserService.selectByUserName(username);
        if (null == cmUser) {
            throw new AccountException("用户不存在！");
        }
        if (!cmUser.getPassword().equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码不正确！");
        }
        return new SimpleAuthenticationInfo(username, cmUser.getPassword(), ByteSource.Util.bytes(username), getName());
    }

}
