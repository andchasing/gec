package com.boo.controller;

import com.boo.pojo.Staff;
import com.boo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
//@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    StaffService staffService;
    @GetMapping("/staffs")
    public String getStaffs(Model model){
        List<Staff> staffs = staffService.getStaffs();
        model.addAttribute("stafflist", staffs);
        return "list";
    }
    @PostMapping("/staffs")
    public String addStaff(Staff staff){
        int code = staffService.addStaff(staff);
        System.out.println("code:"+code);
        return "redirect:/staffs";
    }
    @GetMapping("/toUpdate")
    public String findStaffById (Model model, int id) {
        model.addAttribute("staff", staffService.findStaffById(id));
        return "updateStaff";
    }
    @PostMapping("/updateStaff")
    public String updateStaff (Staff staff) {
        int code = staffService.updateStaff(staff);
        return "redirect:/staffs";
    }
    @GetMapping("/deleteStaff")
    public String deleteStaff (int id){
        staffService.deleteStaff(id);
        return "redirect:/staffs";
    }
}
