/*
 * Copyright 2016 Robert Li.
 * Released under the MIT license
 * https://opensource.org/licenses/MIT
 */
package robertli.zero.dao.impl;

import org.springframework.stereotype.Component;
import robertli.zero.dao.UserAuthDao;
import robertli.zero.entity.User;
import robertli.zero.entity.UserAuth;

@Component("userAuthDao")
public class UserAuthDaoImpl extends GenericHibernateDao<UserAuth, String> implements UserAuthDao {

    @Override
    public String makeAuthId(String userType, String platformName, String username) {
        return userType + ":" + platformName + ":" + username;
    }

    @Override
    public UserAuth saveUserAuth(String userType, String platformName, String username, String label, String usernameType, User user) {
        String authId = makeAuthId(userType, platformName, username);
        UserAuth userAuth = new UserAuth();
        userAuth.setAuthId(authId);
        userAuth.setLabel(label);
        userAuth.setUsernameType(usernameType);
        userAuth.setUser(user);
        save(userAuth);
        return userAuth;
    }

}
