package com.ssm.service.impl;

import com.ssm.mapper.StaffMapper;
import com.ssm.pojo.Staff;
import com.ssm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffMapper staffMapper;
    @Override
    public List<Staff> getStaffs() {
        List<Staff> list = staffMapper.getStaffs();
        return list;
    }

    @Override
    public int addStaff(Staff staff) {
        // 计算总工资
        staff.setTotal_salary(staff.getBasic_salary()+staff.getPosition_salary()+staff.getAllowance()+staff.getHousing_fund()+staff.getMedical_insurance());
        int code = staffMapper.addStaff(staff);
        return code;
    }

    @Override
    public Staff queryById(int id) {
        return staffMapper.queryById(id);
    }

    @Override
    public int updateStaff(Staff staff) {
        // 计算新的总工资
        staff.setTotal_salary(staff.getBasic_salary()+staff.getPosition_salary()+staff.getAllowance()+staff.getHousing_fund()+staff.getMedical_insurance());
        return staffMapper.updateStaff(staff);
    }

    @Override
    public int deleteStaffById(int id) {
        return staffMapper.deleteStaffById(id);
    }
}
