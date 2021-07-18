package com.dms.service.Imp;

import com.dms.mapper.BaseDictMapper;
import com.dms.pojo.QueryVo;
import com.dms.pojo.category;
import com.dms.pojo.paging;
import com.dms.pojo.selldetail;
import com.dms.service.BaseDictService;
import com.dms.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    private BaseDictMapper mapper;
    @Override
    public Page<category> findItemNameByTypeCode(String keyWord, paging pg) {
        PageHelper.startPage(pg.getPage(),pg.getRows());
        List<category> categorys =mapper.findItemNameByTypeCode(keyWord);
        PageInfo<category>pageInfo = new PageInfo<>(categorys);
        return new Page<>((int)pageInfo.getTotal(),pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());

    }

    @Override
    public List<category> findByCount(int type, int count) {
        return mapper.findByCount(type,count);
    }

    @Override
    public category findCategoryById(String id) {
        return mapper.findCategoryById(id);
    }

    @Override
    public void updateCategoryById(String name, String description, String id) {
        mapper.updateCategoryById(name,description,id);
    }


    @Override
    public void deleteCustomerById(String id) {
        mapper.deleteCustomerById(id);
    }

    @Override
    public void insertCategory(String name, String description, Date createTime) {
        mapper.insertCategory(name,description,createTime);
    }

    @Override
    public Page<selldetail> findSelldetailByTime(QueryVo<selldetail> vo, String begin, String end) {
        PageHelper.startPage(vo.getPage(),vo.getRows());
        List<selldetail> details =mapper.findSelldetailByTime(begin,end);
        PageInfo<selldetail> pageInfo =new PageInfo<selldetail>(details);
        Page<selldetail> page =new Page<selldetail>((int)pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getList());
        return  page;
    }
}
