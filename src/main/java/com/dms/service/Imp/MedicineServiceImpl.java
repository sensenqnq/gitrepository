package com.dms.service.Imp;

import com.dms.mapper.MedicineMapper;
import com.dms.pojo.medicine;
import com.dms.pojo.paging;
import com.dms.service.MedicineService;
import com.dms.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineMapper medicineMapper;
    @Override
    public Page<medicine> findMedicineByName(String name, paging pg) {
        PageHelper.startPage(pg.getPage(),pg.getRows());
        List<medicine> medicine = medicineMapper.findMedicineByName(name);
        PageInfo<com.dms.pojo.medicine> pageInfo = new PageInfo<>(medicine);
        return new Page<>((int)pageInfo.getTotal(),pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public medicine findMedicineById(int id) {
        return medicineMapper.findMedicineById(id);
    }

    @Override
    public void updateMedicineCount(medicine medicine) {
        medicineMapper.updateMedicineCount(medicine);
    }
}
