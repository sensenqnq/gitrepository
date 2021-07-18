package com.dms.mapper;

import com.dms.pojo.category;
import com.dms.pojo.selldetail;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BaseDictMapper {
    List<category> findItemNameByTypeCode(String keyWord);
    List<category> findByCount(int type, int count);

    category findCategoryById(String id);

    void updateCategoryById(@Param("name") String name,@Param("description") String description,@Param("id") String id);

    void deleteCustomerById(String id);

    void insertCategory(@Param("name") String name, @Param("description") String description, @Param("createTime") Date createTime);

    List<selldetail> findSelldetailByTime(@Param("begin") String begin, @Param("end") String end);
}
