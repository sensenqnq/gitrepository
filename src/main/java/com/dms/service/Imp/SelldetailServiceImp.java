package com.dms.service.Imp;

import com.dms.mapper.SellMapper;
import com.dms.pojo.QueryVo;
import com.dms.pojo.selldetail;
import com.dms.service.SelldetailService;
import com.dms.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelldetailServiceImp implements SelldetailService {
    @Autowired
    private SellMapper mapper;
    public Page<selldetail> findAllSelldetail(QueryVo<selldetail> vo) {
        PageHelper.startPage(vo.getPage(),vo.getRows());
        List<selldetail> details=mapper.findAllSelldetail();
        PageInfo<selldetail> pageInfo=new PageInfo<selldetail>(details);
        Page<selldetail> page=new Page<selldetail>((int)pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getList());
        return page;
    }

    public Page<selldetail> findSelldetailByName(QueryVo<selldetail> vo, String keyWord) {
        PageHelper.startPage(vo.getPage(),vo.getRows());
        List<selldetail> details=mapper.findSelldetailByName(keyWord);
        PageInfo<selldetail> pageInfo=new PageInfo<selldetail>(details);
        Page<selldetail> page=new Page<selldetail>((int)pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getList());
        return page;
    }
    public Page<selldetail> findSelldetailByTime(QueryVo<selldetail> vo, String begin, String end) {
        PageHelper.startPage(vo.getPage(),vo.getRows());
        List<selldetail> details=mapper.findSelldetailByTime(begin,end);
        PageInfo<selldetail> pageInfo=new PageInfo<selldetail>(details);
        Page<selldetail> page=new Page<selldetail>((int)pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getList());
        return page;
    }

}
