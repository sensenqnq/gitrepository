package com.dms.service;

import com.dms.pojo.QueryVo;
import com.dms.pojo.category;
import com.dms.pojo.paging;
import com.dms.pojo.selldetail;
import com.dms.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BaseDictService {
    Page<category> findItemNameByTypeCode(String keyWord, paging pg);
    List<category> findByCount(int type, int count);

    category findCategoryById(String id);

    void updateCategoryById(String name, String description,String id);

    void deleteCustomerById(String id);

    void insertCategory(@Param("name") String name, @Param("description") String description, @Param("createTime") Date createTime);

    Page<selldetail> findSelldetailByTime(QueryVo<selldetail> vo, String begin, String end);
}
