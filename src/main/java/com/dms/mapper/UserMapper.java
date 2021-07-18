package com.dms.mapper;

import com.dms.pojo.user;

import java.util.List;

public interface UserMapper {
    void addUser(user usr);
    List<user> findAllUser();
    void deleteUser(int id);
    void updatePassword(user user);
}
