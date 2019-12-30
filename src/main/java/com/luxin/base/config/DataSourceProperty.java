package com.luxin.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: luxinfl
 * @Date: 2019/12/28
 * @Description:
 */
@Component
@PropertySource(value = "classpath:application-ds.properties")
public class DataSourceProperty {

    @Value("${ds0.jdbcUrl}")
    private String url1;

    @Value("${ds0.username}")
    private String username1;

    @Value("${ds0.password}")
    private String password1;

    @Value("${ds0.driverClassName}")
    private String driverClassName1;

    @Value("${ds1.jdbcUrl}")
    private String url2;

    @Value("${ds1.username}")
    private String username2;

    @Value("${ds1.password}")
    private String password2;

    @Value("${ds1.driverClassName}")
    private String driverClassName2;

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUsername1() {
        return username1;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getDriverClassName1() {
        return driverClassName1;
    }

    public void setDriverClassName1(String driverClassName1) {
        this.driverClassName1 = driverClassName1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getDriverClassName2() {
        return driverClassName2;
    }

    public void setDriverClassName2(String driverClassName2) {
        this.driverClassName2 = driverClassName2;
    }
}
