package com.mp.pojo;

import lombok.Data;

@Data
public class Staff {
    private Integer id;
    private String name;
    private Float basic_salary;
    private Float position_salary;
    private Float allowance;
    private Float medical_insurance;
    private Float housing_fund;
    private Float total_salary;
}
