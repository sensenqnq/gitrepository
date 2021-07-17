package com.dms.service;


import com.dms.pojo.category;
import com.dms.pojo.medicine;
import com.dms.pojo.paging;
import com.dms.pojo.user;
import com.dms.utils.Page;

import java.util.List;

public interface medService {
    void addMedicine(medicine medicine);
    List<category> findAllCategory();
    Page<medicine> findAllMedicine(String keyWord, paging pg);
    void  deleteMedicineById(int id);
    medicine findMedicineById(int id);
    void updateMedicineById(medicine medicine);
    List<medicine> findAdvanced(medicine medicine);
    List<medicine> findByCount(int type,int count);
    medicine findDetailed(int id);
    String findMedicineMedNo(String medNo);
    void addOrder(medicine medicine);
    Page<medicine> findAllOrder(String keyWord, paging pg);
    medicine findOrderId(int id);
    void modCount(medicine medicine);
    user findUser(user user);
    void deleteOrderById(int id);
}
