/*
 * Copyright 2016 Robert Li.
 * Released under the MIT license
 * https://opensource.org/licenses/MIT
 */
package robertli.zero.dao.impl;

import org.springframework.stereotype.Component;
import robertli.zero.dao.AccessTokenDao;
import robertli.zero.entity.AccessToken;

/**
 *
 * @author Robert Li
 */
@Component("accessTokenDao")
public class AccessTokenDaoImpl extends GenericHibernateDao<AccessToken, String> implements AccessTokenDao {

}