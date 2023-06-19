package com.ssm.service;

import com.ssm.pojo.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> getStaffs();

    int addStaff(Staff staff);

    Staff queryById(int id);

    int updateStaff(Staff staff);

    int deleteStaffById(int id);
}
