package com.dms.service;

import com.dms.pojo.QueryVo;
import com.dms.pojo.selldetail;
import com.dms.utils.Page;


public interface SelldetailService {
    public Page<selldetail> findAllSelldetail(QueryVo<selldetail> vo);
    public Page<selldetail> findSelldetailByName(QueryVo<selldetail> vo, String keyWord);
    public Page<selldetail> findSelldetailByTime(QueryVo<selldetail> vo, String begin, String end);

}
