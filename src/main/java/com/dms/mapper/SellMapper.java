package com.dms.mapper;

import com.dms.pojo.selldetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellMapper {
    public List<selldetail> findAllSelldetail();
    public List<selldetail> findSelldetailByName(String keyWord);
    public List<selldetail> findSelldetailByTime(@Param("begin") String begin, @Param("end") String end);

}
