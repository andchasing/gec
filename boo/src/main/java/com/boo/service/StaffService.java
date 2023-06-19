package com.boo.service;

import com.boo.pojo.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> getStaffs();
    int addStaff(Staff staff);
    Staff findStaffById(int id);
    int updateStaff(Staff staff);
    int deleteStaff(int id);
}
