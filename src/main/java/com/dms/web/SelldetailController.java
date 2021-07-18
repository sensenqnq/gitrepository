package com.dms.web;

import com.dms.pojo.QueryVo;
import com.dms.pojo.selldetail;
import com.dms.service.SelldetailService;
import com.dms.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/selldetail")
public class SelldetailController {
    @Autowired
    private SelldetailService selldetailService;

    @GetMapping("/sell_list")//查看明细
    public String sell_list(QueryVo<selldetail> queryVo, String keyWord, Model model) {
        Page<selldetail> page = null;
        if (keyWord != null) {
            page = selldetailService.findSelldetailByName(queryVo, keyWord);
        } else {
            page=selldetailService.findAllSelldetail(queryVo);
        }
        model.addAttribute("page", page);
        return "sell/sell_list";
    }

    @GetMapping("/query")//日期查询
    public String query(QueryVo<selldetail> queryVo, String begin, String end, Model model) {
        Page<selldetail> page = selldetailService.findSelldetailByTime(queryVo,begin,end);
        model.addAttribute("page", page);
        return "sell/sell_list";
    }
    @GetMapping("/sell_query")//点击日期查询，跳转到日期查询页面
    public String sell_query(){
        return "sell/sell_query";
    }


}
