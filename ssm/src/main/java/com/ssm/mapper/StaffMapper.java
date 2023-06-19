package com.ssm.mapper;

import com.ssm.pojo.Staff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StaffMapper {
    @Select("select * from staff")
    List<Staff> getStaffs();

    @Insert("insert into \n" +
            "staff(name,basic_salary,position_salary,allowance,medical_insurance,housing_fund,total_salary)\n" +
            "values\n" +
            "(#{name},#{basic_salary},#{position_salary},#{allowance},#{medical_insurance},#{housing_fund},#{total_salary})")
    int addStaff(Staff staff);

    @Select("select * from staff where id = #{id}")
    Staff queryById(int id);

    @Update("update staff\n" +
            "        set name = #{name},basic_salary=#{basic_salary},position_salary=#{position_salary},\n" +
            "        allowance = #{allowance}, medical_insurance = #{medical_insurance},\n" +
            "        housing_fund = #{housing_fund},total_salary = #{total_salary}\n" +
            "        where id = #{id}")
    int updateStaff(Staff staff);

    @Delete("delete from staff where id = #{id}")
    int deleteStaffById(int id);
}
