package com.dms.web;

import com.dms.pojo.category;
import com.dms.pojo.medicine;
import com.dms.pojo.paging;
import com.dms.pojo.user;
import com.dms.service.medService;
import com.dms.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/baseData")
public class dmsController {
    private medService medService;

    @Autowired
    public void setMedService(com.dms.service.medService medService) {
        this.medService = medService;
    }


    @PostMapping(value = "/login")
    @ResponseBody
    public String  login(user user,HttpServletRequest request){
        request.getSession().setAttribute("user",user);
        user user1 = medService.findUser(user);
        if (user1==null){
            return "a";
        }
        return "b";
    }
    //查询所有类别
    @GetMapping(value = "/med_save")
    public String findCategory(Model model){
        List<category> category = medService.findAllCategory();
        model.addAttribute("list",category);
        return "med_save";
    }
//添加药品
    @PostMapping(value = "/add")
    public String addMedicine(Model model, medicine medicine, @RequestParam("file") MultipartFile file, paging paging,  HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/static/upload");
        String filename = file.getOriginalFilename();
        file.transferTo(new File(path,filename));
        medicine.setPhotoPath(filename);
        medService.addMedicine(medicine);
        return toMedicineList(model,"",paging);
    }
//全部药品
    @GetMapping(value = "/med_list")
    public String toMedicineList(Model model,String keyWord,paging paging){
        Page<medicine> list = medService.findAllMedicine(keyWord,paging);
        model.addAttribute("page",list);
        return "med_list";
    }
//修改页面
    @GetMapping(value = "/med_update/{id}")
    public String findMedicineById(Model model,@PathVariable(name = "id") int id){
        medicine medicine = medService.findMedicineById(id);
        model.addAttribute("med",medicine);
        return "med_update";
    }

//提交修改
    @PostMapping(value = "/updateM")
    public String modifyMedicine(Model model,medicine medicine,paging paging){
        medService.updateMedicineById(medicine);
        return toMedicineList(model,"",paging);
    }

//删除
    @GetMapping(value = "/deleteMedicine/{id}")
    public String deleteMedicineById(Model model,@PathVariable("id") int id,paging paging){
        medService.deleteMedicineById(id);
        return toMedicineList(model,"",paging);
    }

//高级查询
    @PostMapping(value = "/Advanced")
    public String AdvancedQuery(Model model,medicine medicine){
        List<medicine> list = medService.findAdvanced(medicine);
        model.addAttribute("list",list);
        return "med_list_nopaging";
    }

    //查看库存
    @PostMapping(value = "/Count")
    public String QueryCount(Model model,int type,int count){
        List<medicine> list = medService.findByCount(type, count);
        model.addAttribute("list",list);
        return "med_list_nopaging";
    }

    //进入高级查询
    @GetMapping(value = "/med_query")
    public String toQuery(){
        return "med_query";
    }

    //进入查看仓库
    @GetMapping(value = "/med_count")
    public String toCount(){
        return "med_count";
    }


    @GetMapping(value = "/checkMedicine/{id}")
    public String toView(Model model,@PathVariable(name = "id") int id){
        medicine medicine = medService.findDetailed(id);
        model.addAttribute("med",medicine);
        return "med_view";
    }
    //
    @GetMapping(value = "toTop")
    public String toTop(Model model,HttpServletRequest request){
        user user = (com.dms.pojo.user) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "top";
    }

    //进入订单页面
    @GetMapping(value = "/req_list")
    public String VPurchase(Model model,String keyWord,paging paging){
        Page<medicine> list = medService.findAllOrder(keyWord,paging);
        model.addAttribute("page",list);
        return "req_list";
    }

    @GetMapping(value = "/req_add")
    public String toReqAAdd(){
        return "req_add";
    }
    @GetMapping(value = "/ch")
    @ResponseBody
    public String chByMedNo(String medNo){
        if (medNo.equals("")){
            return "abb";
        }
        String medNo1 = medService.findMedicineMedNo(medNo);
        if (medNo1==null){
            return "aaa";
        }
        return "abc";
    }
    @PostMapping(value = "/req_save")
    public String order(Model model,String id){
        model.addAttribute("medNo",id);
        List<category> category = medService.findAllCategory();
        model.addAttribute("list",category);
        return "req_save";
    }

    @PostMapping(value = "/save")
    public String insertOrder(Model model, medicine medicine, @RequestParam("file") MultipartFile file, paging paging,  HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/static/upload");
        String filename = file.getOriginalFilename();
        file.transferTo(new File(path,filename));
        medicine.setPhotoPath(filename);
        medService.addOrder(medicine);
        return VPurchase(model,"",paging);
    }
    @GetMapping(value = "/req_update/{id}")
    public String toUpdate(Model model,@PathVariable(name = "id") int id){
        medicine medicine = medService.findOrderId(id);
        model.addAttribute("med",medicine);
        return "req_update";
    }
    @GetMapping(value = "/deleteReq/{id}")
    public String deleteById(Model model,@PathVariable(name = "id") int id,paging paging){
       medService.deleteOrderById(id);
        return VPurchase(model,"",paging);
    }
    @PostMapping(value = "/update")
    public String modify(Model model,medicine medicine,paging paging){
        medService.modCount(medicine);
        return VPurchase(model,"",paging);
    }
}
