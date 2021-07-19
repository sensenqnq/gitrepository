package com.dms.web;

import com.dms.pojo.*;
import com.dms.service.BaseDictService;
import com.dms.service.MedicineService;
import com.dms.service.UserService;
import com.dms.service.medService;
import com.dms.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.User;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/dms")
public class dmsController {
    private medService medService;
    private MedicineService medicineService;
    private UserService userService;
    private BaseDictService baseDictService;
    @Autowired
    public void setMedService(com.dms.service.medService medService) {
        this.medService = medService;
    }

    @Autowired
    public void setMedicineService(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }


    @GetMapping(value = "/manager")
    public String toManager(){
        return "manager";
    }
    @PostMapping(value = "/login")
    @ResponseBody
    public String  login(user user,HttpServletRequest request){
        user user1 = medService.findUser(user);
        if (user1==null){
            return "a";
        }
        request.getSession().setAttribute("user",user);
        return "b";
    }

    @GetMapping(value = "/toTop1")
    public String loginManager(HttpServletRequest request,Model model){
        user user = (com.dms.pojo.user) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "top";
    }
    //查询所有类别
    @GetMapping(value = "/med_save")
    public String findCategory(Model model){
        List<category> category = medService.findAllCategory();
        model.addAttribute("list",category);
        return "baseData/med_save";
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
        return "baseData/med_list";
    }
//修改页面
    @GetMapping(value = "/med_update/{id}")
    public String findMedicineById(Model model,@PathVariable(name = "id") int id){
        medicine medicine = medService.findMedicineById(id);
        model.addAttribute("med",medicine);
        return "baseData/med_update";
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
        return "baseData/med_list_nopaging";
    }

    //查看库存
    @PostMapping(value = "/Count")
    public String QueryCount(Model model,int type,int count){
        List<medicine> list = medService.findByCount(type, count);
        model.addAttribute("list",list);
        return "baseData/med_list_nopaging";
    }

    //进入高级查询
    @GetMapping(value = "/med_query")
    public String toQuery(){
        return "baseData/med_query";
    }

    //进入查看仓库
    @GetMapping(value = "/med_count")
    public String toCount(){
        return "baseData/med_count";
    }


    @GetMapping(value = "/checkMedicine/{id}")
    public String toView(Model model,@PathVariable(name = "id") int id){
        medicine medicine = medService.findDetailed(id);
        model.addAttribute("med",medicine);
        return "baseData/med_view";
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
        return "require/req_list";
    }

    @GetMapping(value = "/req_add")
    public String toReqAAdd(){
        return "require/req_add";
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
        return "require/req_save";
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
        return "require/req_update";
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
    //王浩
    @RequestMapping (value = "/baseData/med_sell")
    public String findMedicine(@RequestParam(value = "keyWord",required = false) String name, Model model, paging pg){
        Page<medicine> medicine = medicineService.findMedicineByName(name, pg);
        model.addAttribute("page",medicine);
        return "baseData/med_sell";
    }
    @RequestMapping (value = "/sell/sell_add/{id}/{name}/{price}/{factoryAdd}")
    public String sellMedicine(@PathVariable(name = "id")int id,@PathVariable(name = "name") String name,@PathVariable(name = "price") double price,@PathVariable(name = "factoryAdd") String factoryAdd,Model model){
        medicine medicine = medicineService.findMedicineById(id);
        model.addAttribute("medicine",medicine);
        return  "sell/sell_add";
    }

    @PostMapping(value = "/sell/sell_save")
    public String sellSave(Model model,medicine medicine){
        medicineService.updateMedicineCount(medicine);
        return findMedicine("",model,new paging());
    }


    @RequestMapping(value = "/user_add")
    public String toUser_add(){
        return "system/user_add";
    }

    @RequestMapping (value = "/system/user_add")
    public String addUser(Model model, user user,paging pg){
        //判断是否添加成功没搞
        user.setCreateTime(new Date());
        userService.addUser(user);
        return ToUserList(model,pg);
    }
    @RequestMapping (value = "/system/user_list")
    public String ToUserList(Model model,paging pg){
        Page<user> user = userService.findAllUser(pg);
        model.addAttribute("page",user);
        return "system/user_list";
    }
    @RequestMapping (value = "/deleteUser/{id}")
    public String deleteUser(Model model,@PathVariable("id") int id,paging paging){
        userService.deleteUser(id);
        return ToUserList(model,paging);
    }
    @RequestMapping (value = "/updatePassword")
    public String updatePassword(Model model, String password, String repassword,  paging paging, HttpServletRequest request){
        user user = (com.dms.pojo.user) request.getSession().getAttribute("user");
            if (password.equals(repassword)){
                user.setPassword(password);
                userService.updatePassword(user);
            }
            return "system/user_password";
    }

    @GetMapping(value = "/Verify")
    @ResponseBody
    public String VerifyPS(String ps,HttpServletRequest request){
        user user = (com.dms.pojo.user) request.getSession().getAttribute("user");
        if (user.getPassword().equals(ps)){
            return "a";
        }
        return "b";
    }

    @RequestMapping(value = "/user_password")
    public String toUser_password(){
        return "system/user_password";
    }
    //唐慰
    @GetMapping(value = "/list")
    public String toMain(Model model,String keyWord,paging paging) {
        Page<category> page =baseDictService.findItemNameByTypeCode(keyWord,paging);
        model.addAttribute("page",page);
        return  "baseData/category_list";
    }
    @PostMapping(value = "/Count1")
    public String QueryCount1(Model model,int type,int count){
        List<category> list = baseDictService.findByCount(type, count);
        model.addAttribute("list",list);
        return "baseData/category_list";
    }

    @GetMapping("/delete")
    public String removeCustomerById(@RequestParam("id") String id){
        baseDictService.deleteCustomerById(id);
        return "forward:list.action";
    }
    @GetMapping(value = "/list1")
    public String toMain1() {
        return  "baseData/category_add";
    }
    @GetMapping(value = "/list2")
    public String toMain2() {
        return  "sell/sell_query";
    }
    @PostMapping("/add1")
    public String add(String name,String desc) {
        Date createTime = new Date();
        baseDictService.insertCategory(name,desc,createTime);
        return  "baseData/category_add";
    }
    @GetMapping("/query")
    public String query(QueryVo<selldetail> queryVo, String begin, String end, Model model){
        Page<selldetail> page = baseDictService.findSelldetailByTime(queryVo,begin,end);
        model.addAttribute("",page);
        return "sell/sell_list";
    }

    @PostMapping("/update1")
    public String update(Model model, String name, String desc,@RequestParam("id") String id) {
        baseDictService.updateCategoryById(name,desc,id);
        return "baseData/category_update";
    }

    @GetMapping("/category_update")
    public String findCategoryById(Model model, String id) {
        category category = baseDictService.findCategoryById(id);
        model.addAttribute("category", category);
        model.addAttribute("id", id);
        return "baseData/category_update";
    }
}
