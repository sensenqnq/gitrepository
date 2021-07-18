package com.dms.service;

import com.dms.pojo.paging;
import com.dms.pojo.user;
import com.dms.utils.Page;

public interface UserService {
    void addUser(user usr);
    Page<user> findAllUser(paging pg);
    void deleteUser(int id);
    void updatePassword(user user);
}
