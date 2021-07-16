package com.dms.web;

import com.dms.pojo.category;
import com.dms.pojo.medicine;
import com.dms.pojo.paging;
import com.dms.service.medService;
import com.dms.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping(value = "/Count")
    public String QueryCount(Model model,int type,int count){
        List<medicine> list = medService.findByCount(type, count);
        model.addAttribute("list",list);
        return "med_list_nopaging";
    }

    @GetMapping(value = "/med_query")
    public String toQuery(){
        return "med_query";
    }
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
}
