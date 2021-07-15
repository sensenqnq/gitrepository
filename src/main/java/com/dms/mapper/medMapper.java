package com.dms.mapper;

import com.dms.pojo.category;
import com.dms.pojo.medicine;
import com.dms.utils.Page;

import java.util.List;

public interface medMapper {
    void addMedicine(medicine medicine);
    List<category> findAllCategory();
    List<medicine> findAllMedicine();
    void  deleteMedicineById(int id);
    medicine findMedicineById(int id);
    void updateMedicineById(medicine medicine);
    List<medicine> findMedicineByNameOrAddress(String keyWord);
    medicine findAdvanced(medicine medicine);
}
