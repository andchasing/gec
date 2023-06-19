package com.boo.mapper;

import com.boo.pojo.Staff;

import java.util.List;

public interface StaffMapper {
    List<Staff> getStaffs();
    int addStaff(Staff staff);
    Staff findStaffById(int id);
    int updateStaff(Staff staff);
    int deleteStaff(int id);
}
