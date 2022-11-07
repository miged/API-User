package com.dizon.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dizon.models.User;
//import com.dizon.datasource.UserRepository;
import com.dizon.models.UserUpdate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserUpdateService {

    // @Autowired
    // UserRepository userRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserUpdate getUserUpdate(long id) {
        try {
            String sql = "select * from User_updates where Id = ?";
            Map<String, Object> result = jdbcTemplate.queryForMap(sql, new Object[] { id });

            UserUpdate usr = new UserUpdate();
            usr.setId((int) result.get("Id"));
            usr.setUserName((String) result.get("Username"));
            usr.setFirstName((String) result.get("Firstname"));
            usr.setLastName((String) result.get("Lastname"));
            usr.setEmail((String) result.get("Email"));
            usr.setApproved_by((String) result.get("Approved_by"));
            usr.setApproved_date((String) result.get("Approved_date"));
            usr.setSubmitted_by((String) result.get("Submitted_by"));

            return usr;
        } catch (Exception ex) {
            return null;
        }
    }

    public long updateUserUpdate(User usr) {
        String sql = "update User_updates set Firstname = ?, Lastname = ?, Email = ? where Id = ?";
        jdbcTemplate.update(sql, new Object[] { usr.getFirstname(), usr.getLastName(), usr.getEmail(), usr.getId() });

        return usr.getId();
    }
}
