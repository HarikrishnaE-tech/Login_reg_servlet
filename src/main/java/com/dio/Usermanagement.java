package com.dio;

import java.sql.SQLException;
import java.util.List;

import com.entity.User;

 interface Usermanagement {
    public int save(User user) throws SQLException;
    public User fetch(String email,int password);
    public List<User> fetchAll();
    public boolean updateuser(User user);
    public boolean deleteuser(int userid);

}
