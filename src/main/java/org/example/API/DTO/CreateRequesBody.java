package org.example.API.DTO;

import lombok.Data;
import lombok.Getter;


@Data
@Getter
public class CreateRequesBody {
    private String name;
    private Integer salary;
    private Integer age;

    public CreateRequesBody(String name, Integer salary, Integer age) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
