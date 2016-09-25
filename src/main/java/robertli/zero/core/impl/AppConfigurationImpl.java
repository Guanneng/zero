/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robertli.zero.core.impl;

import java.util.TimeZone;
import org.springframework.beans.factory.InitializingBean;
import robertli.zero.core.AppConfiguration;

public class AppConfigurationImpl implements AppConfiguration, InitializingBean {

    private String md5Salt;
    private String timeZone;
    private String initAdminName;
    private String initAdminPassword;

    @Override
    public String getMd5Salt() {
        return md5Salt;
    }

    public void setMd5Salt(String md5Salt) {
        this.md5Salt = md5Salt;
    }

    @Override
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String getInitAdminName() {
        return initAdminName;
    }

    public void setInitAdminName(String initAdminName) {
        this.initAdminName = initAdminName;
    }

    @Override
    public String getInitAdminPassword() {
        return initAdminPassword;
    }

    public void setInitAdminPassword(String initAdminPassword) {
        this.initAdminPassword = initAdminPassword;
    }

    @Override
    public void afterPropertiesSet() {
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
    }

}
