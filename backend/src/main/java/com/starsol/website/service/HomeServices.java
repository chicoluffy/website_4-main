package com.starsol.website.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.starsol.website.exceptions.FinancialSystemException;
import com.starsol.website.exceptions.FinancialSystemException.CODES;
import com.starsol.website.models.request.UserLoginRequest;
import com.starsol.website.models.response.UserLoginResponse;
import com.starsol.website.service.user_manager.UserManagerServices;
import com.starsol.website.models.Privilege;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HomeServices {

@Autowired
private UserManagerServices userManagerServices;

@Autowired
private UserServices userServices;

public UserLoginResponse login(UserLoginRequest request) throws FinancialSystemException, Exception {
    String username = request.getUsername();
    String password = request.getPassword();
    String appkey = request.getAppkey();
    UserLoginResponse response = new UserLoginResponse();
    // app validate..

   

    // user validate
    response.setUserId( this.checkUserPassword(username, password) );
    response.setToken(this.CreateSession(username, password));
    response.setPrivilege(this.getPrivilege(response.getUserId()));
       
    return response;
}

public int checkUserPassword(String username, String password) throws FinancialSystemException, Exception {
    if (username == null || username.isEmpty()) {
        throw new FinancialSystemException(CODES.USERNAME_EMPTY);
    }

    if (password == null || password.isEmpty()) {
        throw new FinancialSystemException(CODES.PASSWORD_EMPTY);
    }

    int user_id = userManagerServices.authenticateUser(username, password);
    if (user_id <= 0) {
        throw new FinancialSystemException(CODES.WRONG_USERNAME_PASSWORD);
    }

    return user_id;
}

public List<Privilege> getPrivilege(int user_id) throws Exception {
    return userServices.getUserPrivilegeIds(user_id);
}

public String CreateSession(String username, String password) throws FinancialSystemException, Exception {
    return userManagerServices.CreateSession(username, password);
}

}