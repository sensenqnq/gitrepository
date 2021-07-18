package com.dms.mapper;

import com.dms.pojo.medicine;

import java.util.List;

public interface MedicineMapper {
    List<medicine> findMedicineByName(String name);
    medicine findMedicineById(int id);
    void updateMedicineCount(int id,int sell);
}
