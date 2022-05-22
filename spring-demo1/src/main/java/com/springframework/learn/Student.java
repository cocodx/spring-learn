package com.springframework.learn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 15/3/2022 上午11:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;

    private String name;

    private String gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
