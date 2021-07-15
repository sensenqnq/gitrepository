package com.dms.web;

import com.dms.pojo.category;
import com.dms.pojo.medicine;
import com.dms.service.medService;
import com.dms.utils.Page;
import org.apache.ibatis.annotations.Param;
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
    public String addMedicine(Model model,medicine medicine,@RequestParam("photoPath") MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/WEB-INF/upload");
        String filename = file.getOriginalFilename();
        file.transferTo(new File(path,filename));
        medicine.setPath(filename);
        medService.addMedicine(medicine);
        return toMedicineList(model,"");
    }
//全部药品
    @GetMapping(value = "/med_list")
    public String toMedicineList(Model model,String keyWord){

        Page<medicine> list = medService.findAllMedicine();
        model.addAttribute("page",list);
        return "med_list";
    }
//修改页面
    @PutMapping(value = "/med_update/{id}")
    public String findMedicineById(Model model,@PathVariable("id") int id){
        medicine medicine = medService.findMedicineById(id);
        model.addAttribute("med",medicine);
        return "med_update";
    }

//提交修改
    @PostMapping(value = "/updateM")
    public String modifyMedicine(Model model,medicine medicine){
        medService.updateMedicineById(medicine);
        return toMedicineList(model,"");
    }

//删除
    @PutMapping(value = "/deleteMedicine/{id}")
    public String deleteMedicineById(Model model,@PathVariable("id") int id){
        medService.deleteMedicineById(id);
        return toMedicineList(model,"");
    }

//高级查询
    @PostMapping(value = "")
    public String AdvancedQuery(Model model,medicine medicine){
        medicine med = medService.findAdvanced(medicine);
        model.addAttribute("medicine",med);
        return "med_list_nopaging";
    }
}
