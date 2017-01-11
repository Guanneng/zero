/*
 * Copyright 2017 Robert Li.
 * Released under the MIT license
 * https://opensource.org/licenses/MIT
 */
package robertli.zero.service;

import java.util.List;
import robertli.zero.dto.user.UserPlatformDto;
import robertli.zero.dto.user.UserRoleDto;
import robertli.zero.dto.user.UserTypeDto;
import robertli.zero.entity.User;

/**
 * This service is design to manage user data.<br>
 *
 * Don't use this service in controller layer. This service is used for other
 * services.
 *
 * @version 1.0.5 2017-01-10
 * @author Robert Li
 */
public interface UserService {

    public static final String USER_TYPE_GENERAL = "general";
    public static final String USER_TYPE_STAFF = "staff";
    public static final String USER_TYPE_ADMIN = "admin";

    public static final String USER_PLATFORM_GENERAL = "general";
    public static final String USER_PLATFORM_ADMIN = "admin";

    public static final String USERNAME_TYPE_STRING = "string";
    public static final String USERNAME_TYPE_EMAIL = "email";

    public static final String USER_ROLE_ADMIN_ROOT = "admin_root";
    public static final String USER_ROLE_PLATFORM_ROOT = "platform_root";

    public void addUserType(String name);

    public void deleteUserType(String name);

    public void addUserPlatform(String userTypeName, String name);

    public void deleteUserPlatform(String name);

    public void addUserRole(String name);

    public void deleteUserRole(String name);

    public User getUser(String userPlatformName, String username);

    public User addUser(String userPlatformName, String username,
            String usernameType, String label, String orginealPassword,
            String name, String telephone, boolean locked);

    public void deleteUser(String userPlatformName, String username);

    public void resetPassword(String userPlatformName, String username, String orginealPassword);

    public void putRoleForUser(int userId, String roleName);

    public void deleteRoleForUser(int userId, String roleName);

    public void setLock(int userId, boolean locked);

    public List<UserTypeDto> getUserTypeList();

    public List<User> getUserListByPlatform(String userPlatformName);

    public List<User> getUserListByRole(String roleName);

    public List<UserPlatformDto> getUserPlatformList();

    public List<UserRoleDto> getUserRoleList();

}
