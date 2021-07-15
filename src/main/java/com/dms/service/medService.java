package com.dms.service;


import com.dms.pojo.category;
import com.dms.pojo.medicine;
import com.dms.utils.Page;

import java.util.List;

public interface medService {
    void addMedicine(medicine medicine);
    List<category> findAllCategory();
    Page<medicine> findAllMedicine();
    void  deleteMedicineById(int id);
    medicine findMedicineById(int id);
    void updateMedicineById(medicine medicine);
    Page<medicine> findMedicineByNameOrAddress(String keyWord);
    medicine findAdvanced(medicine medicine);
}
