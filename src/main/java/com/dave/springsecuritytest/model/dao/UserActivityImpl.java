/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dave.springsecuritytest.model.dao;

import com.dave.springsecuritytest.model.UserActivity;
import java.time.Month;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davej
 */
@Repository
public class UserActivityImpl implements UserActivityDao {

    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public List<UserActivity> listUserActivity(Month month) {
         
        String sql = "SELECT user_id, activity_name, count(*) as amount, "
                + "min(occurrence) as first_occurrence, max(occurrence) as last_occurrence "
                + "FROM user_activity ua "
                + "JOIN activity a ON ua.activity_id = a.id "
                + "WHERE monthname(occurrence)='July' "
                + "AND year(occurrence)='2020' "
                + "group by user_id, activity_id";
            
        
        return jdbcTemplate.query(
            sql,(rs, rowNum) ->
                new UserActivity(
                        rs.getString("user_id"),
                        rs.getTimestamp("first_occurrence"),
                        rs.getTimestamp("last_occurrence"),
                        rs.getString("activity_name"),
                        rs.getInt("amount")
                        
                )
        );
    }

    @Override
    public void createUserActivity(String username, int id) {
        jdbcTemplate.update("INSERT INTO user_activity (id, user_id, activity_id, occurrence) VALUES (null, ?, ?, current_timestamp)",
    				    username, id);
    }
    
    
}
