package com.chivalry.sf.web.clinet;

import com.chivalry.portal.business.domain.SysUser;
import com.chivalry.portal.business.domain.SsoToken;
import com.chivalry.portal.business.domain.SysRole;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("sso")
public interface SsoClient {

    /**单点登录获取token
     * @param sessionCode
     * @return
     */
    @RequestMapping(value="/sso/auth/token",method = RequestMethod.POST)
    SsoToken getToken(@RequestParam(value = "sessionCode") String sessionCode);

    /**获取登录人员所有菜单
     * @param username
     * @return
     */
    @RequestMapping(value="/sso/user/allMenus/{username}",method = RequestMethod.GET)
    SysUser getUserAllMenus(@PathVariable(value = "username") String username);

    /**获取登录人员菜单
     * @param username
     * @param appId
     * @return
     */
    @RequestMapping(value="/sso/user/menus/{username}/{appId}",method = RequestMethod.GET)
    SysUser getUserMenus(@PathVariable(value = "username") String username,
                        @PathVariable(value = "appId") String appId
    );


    /**获取登录人员信息
     * @param username
     * @return
     */
    @RequestMapping(value="/sso/user/account/{username}",method = RequestMethod.GET)
    SysUser getUserInfo(@RequestParam(value = "username") String username);

    /**账号注册
     * @param user
     * @return
     */
    @RequestMapping(value="/sso/user/account",method = RequestMethod.POST)
    SysUser addUser(@RequestBody SysUser user);

    /**账号修改
     * @param user
     * @return
     */
    @RequestMapping(value="/sso/user/account",method = RequestMethod.PUT)
    SysUser editUser(@RequestBody SysUser user);

    /**账号添加角色
     * @param code
     * @param roleCodes
     * @return
     */
    @RequestMapping(value="/sso/user/roles/{code}",method = RequestMethod.PUT)
    String addUserRoles(@RequestParam("code") String code, @RequestBody String roleCodes);

    /**获取账号角色
     * @param code
     * @return
     */
    @RequestMapping(value="/sso/user/roles/{code}",method = RequestMethod.GET)
    SysUser getUserRoles(@RequestParam("code") String code);


    /**获取角色（用于判断角色是否存在）
     * @param code
     * @return
     */
    @RequestMapping(value="/sso/role/{code}",method = RequestMethod.GET)
    SysRole getRole(@RequestParam("code") String code);

    /**获取所有角色
     * @return
     */
    @Cacheable("ssoRole")
    @RequestMapping(value="/sso/role",method = RequestMethod.GET)
    List<SysRole> getAllRoles();

    /**重制密码
     * @param code
     * @param newPassword
     */
    @RequestMapping(value="/sso/user/initPwd",method = RequestMethod.PUT)
    void initPwd(@RequestParam("code") String code, @RequestParam("newPassword") String newPassword);
}
