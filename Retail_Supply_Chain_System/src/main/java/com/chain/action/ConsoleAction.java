package com.chain.action;


import com.chain.entity.UserEntity;
import com.chain.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleAction extends ActionSupport {

    @Autowired
    private UserService userService;

    private String username;
    private String password;

    private Integer totalDay;

    public String index() {
        return SUCCESS;
    }

    public String login() {
        return SUCCESS;
    }

    public String logon() {
        UserEntity userEntity = userService.getUserEntity(username, password);
        if (userEntity != null) {
            ActionContext.getContext().getSession().put("loginuser", userEntity);
            return SUCCESS;
        } else {
            this.addActionError("用户名或者密码不正确");
            return INPUT;
        }
    }

    public String logout() {
        ActionContext.getContext().getSession().remove("loginuser");
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(Integer totalDay) {
        this.totalDay = totalDay;
    }
}
