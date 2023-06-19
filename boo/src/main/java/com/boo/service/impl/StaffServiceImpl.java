package com.boo.service.impl;

import com.boo.mapper.StaffMapper;
import com.boo.pojo.Staff;
import com.boo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffMapper staffMapper;
    @Override
    public List<Staff> getStaffs() {
        return staffMapper.getStaffs();
    }

    @Override
    public int addStaff(Staff staff) {
        staff.setTotal_salary(staff.getBasic_salary()+staff.getAllowance()+staff.getHousing_fund()+staff.getMedical_insurance()+staff.getPosition_salary());
        int code = staffMapper.addStaff(staff);
        return code;
    }

    @Override
    public Staff findStaffById(int id) {
        return staffMapper.findStaffById(id);
    }

    @Override
    public int updateStaff(Staff staff) {
        staff.setTotal_salary(staff.getBasic_salary()+staff.getAllowance()+staff.getHousing_fund()+staff.getMedical_insurance()+staff.getPosition_salary());
        return staffMapper.updateStaff(staff);
    }

    @Override
    public int deleteStaff(int id) {
        return staffMapper.deleteStaff(id);
    }
}
