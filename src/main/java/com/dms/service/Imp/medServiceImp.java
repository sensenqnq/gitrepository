package com.dms.service.Imp;

import com.dms.mapper.medMapper;
import com.dms.pojo.category;
import com.dms.pojo.medicine;
import com.dms.service.medService;
import com.dms.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class medServiceImp implements medService {

    private medMapper mapper;

    @Autowired
    public void setMapper(medMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void addMedicine(medicine medicine) {
        mapper.addMedicine(medicine);
    }

    @Override
    public List<category> findAllCategory() {
        return mapper.findAllCategory();
    }

    @Override
    public Page<medicine> findAllMedicine() {
        PageHelper.startPage(1,10);
        List<medicine> list = mapper.findAllMedicine();
        PageInfo<medicine>pageInfo = new PageInfo<>(list);
        return new Page<>((int)pageInfo.getTotal(),pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public void deleteMedicineById(int id) {
        mapper.deleteMedicineById(id);
    }

    @Override
    public medicine findMedicineById(int id) {
        return mapper.findMedicineById(id);
    }

    @Override
    public void updateMedicineById(medicine medicine) {
        mapper.updateMedicineById(medicine);
    }

    @Override
    public Page<medicine> findMedicineByNameOrAddress(String keyWord) {
        PageHelper.startPage(1,10);
        List<medicine> list = mapper.findMedicineByNameOrAddress(keyWord);
        PageInfo<medicine>pageInfo = new PageInfo<>(list);
        return new Page<>((int)pageInfo.getTotal(),pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());

    }

    @Override
    public medicine findAdvanced(medicine medicine) {
        return mapper.findAdvanced(medicine);
    }


}
