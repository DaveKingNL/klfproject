/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dave.springsecuritytest.model.dao;

import com.dave.springsecuritytest.model.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author davej
 */
@Component
public interface UserDao {
    public User readUser (String username);
    public void createUser(User user);
    public void updateUser(User user);
}
