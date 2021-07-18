package com.dms.service.Imp;

import com.dms.mapper.UserMapper;
import com.dms.pojo.paging;
import com.dms.pojo.user;
import com.dms.service.UserService;
import com.dms.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addUser(user usr) {
        userMapper.addUser(usr);
    }

    @Override
    public Page<user> findAllUser(paging pg) {
        PageHelper.startPage(pg.getPage(),pg.getRows());
        List<user> user = userMapper.findAllUser();
        PageInfo<com.dms.pojo.user> pageInfo = new PageInfo<>(user);
        return new Page<>((int)pageInfo.getTotal(),pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void updatePassword(user user) {
        userMapper.updatePassword(user);
    }
}
