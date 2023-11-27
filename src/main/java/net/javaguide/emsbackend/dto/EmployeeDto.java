package net.javaguide.emsbackend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    @NotEmpty(message = "first name can't be null")
    private  String firstName;
    @NotEmpty(message = "last name can't be null")
    private  String lastName;
    @NotEmpty(message = "Email can't be null")
    private  String email;
    @NotNull(message = "Age cannot be null")
    @PositiveOrZero(message = "Age must be a positive number or zero")
    private  Number age;
}
