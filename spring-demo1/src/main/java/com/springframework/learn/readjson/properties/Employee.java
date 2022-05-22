package com.springframework.learn.readjson.properties;

import lombok.Data;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 12/3/2022 上午3:32
 */
public abstract class Employee {

    private String group;

    private boolean usesDialUp;

    private Employee manager;

    private String department;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isUsesDialUp() {
        return usesDialUp;
    }

    public void setUsesDialUp(boolean usesDialUp) {
        this.usesDialUp = usesDialUp;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
