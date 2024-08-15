package org.example.API.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
@Getter
public class CreateRequesBody {
    private String name;
    private Integer salary;
    private Integer age;

}
