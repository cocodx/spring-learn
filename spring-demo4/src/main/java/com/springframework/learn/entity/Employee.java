package com.springframework.learn.entity;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 17/1/2022 上午12:36
 */
public abstract class Employee {

    protected String group;
    protected boolean usesDialUp;
    protected Employee manager;
    protected String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

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
}
