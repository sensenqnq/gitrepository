package com.dms.service;

import com.dms.pojo.medicine;
import com.dms.pojo.paging;
import com.dms.utils.Page;


public interface MedicineService {
    Page<medicine> findMedicineByName(String name, paging pg);
    medicine findMedicineById(int id);
    void updateMedicineCount(medicine medicine);
}
