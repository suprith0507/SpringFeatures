package com.example.SpringFeatures.dtos;




import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO


{

    private Long id;

    private String name;


    private String email;

    private Integer age;



    private LocalDate dateOfJoining;

    private Boolean isActive;
}
