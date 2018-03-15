package com.shop.dao;

import java.util.List;

import com.shop.domain.User;

public interface UserDAO {
public boolean save(User user);
public boolean update(User user);
public boolean delete(String emailId);
public User get(String emailId);
public User validate(String emailId,String password);
public List<User> userlist();
}
