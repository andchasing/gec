package com.ssm.pojo;

public class Staff {
    private Integer id;
    private String name;
    private Float basic_salary;
    private Float position_salary;
    private Float allowance;
    private Float medical_insurance;
    private Float housing_fund;
    private Float total_salary;

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basic_salary=" + basic_salary +
                ", position_salary=" + position_salary +
                ", allowance=" + allowance +
                ", medical_insurance=" + medical_insurance +
                ", housing_fund=" + housing_fund +
                ", total_salary=" + total_salary +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(Float basic_salary) {
        this.basic_salary = basic_salary;
    }

    public Float getPosition_salary() {
        return position_salary;
    }

    public void setPosition_salary(Float position_salary) {
        this.position_salary = position_salary;
    }

    public Float getAllowance() {
        return allowance;
    }

    public void setAllowance(Float allowance) {
        this.allowance = allowance;
    }

    public Float getMedical_insurance() {
        return medical_insurance;
    }

    public void setMedical_insurance(Float medical_insurance) {
        this.medical_insurance = medical_insurance;
    }

    public Float getHousing_fund() {
        return housing_fund;
    }

    public void setHousing_fund(Float housing_fund) {
        this.housing_fund = housing_fund;
    }

    public Float getTotal_salary() {
        return total_salary;
    }

    public void setTotal_salary(Float total_salary) {
        this.total_salary = total_salary;
    }
}
