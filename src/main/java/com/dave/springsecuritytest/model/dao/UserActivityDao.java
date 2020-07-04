/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dave.springsecuritytest.model.dao;

import com.dave.springsecuritytest.model.UserActivity;
import java.time.Month;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author davej
 */
@Component
public interface UserActivityDao {
    public List<UserActivity> listUserActivity(Month month);
    public void createUserActivity(String username, int id);
}
