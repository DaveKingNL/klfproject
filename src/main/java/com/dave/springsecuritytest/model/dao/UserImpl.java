/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dave.springsecuritytest.model.dao;

import com.dave.springsecuritytest.model.User;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davej
 */
@Repository
public class UserImpl implements UserDao {
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public User readUser(String username){
        String sql = "SELECT * FROM users WHERE username = ?";

        return (User) jdbcTemplate.queryForObject(
			sql,
			new Object[]{username},
			new BeanPropertyRowMapper(User.class));
    }
    
    public void createUser(User user) {
		
                
		jdbcTemplate.update("INSERT INTO users (username, password, email, enabled) VALUES (?, ?, ?, TRUE)",
    				    user.getUsername(), user.getPassword(), user.getEmail()
    				);
                jdbcTemplate.update("INSERT INTO authorities (username, authority) VALUES (?, 'ROLE_USER')",
                        user.getUsername());
	}

	public void updateUser(User user) {
		jdbcTemplate.update("UPDATE users SET password = ?, email = ? WHERE username = ?",
				user.getPassword(), user.getEmail(), user.getUsername()
				);
	}
}
