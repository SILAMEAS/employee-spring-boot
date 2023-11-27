package net.javaguide.emsbackend.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
    private  String email;
}
