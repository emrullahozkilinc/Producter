package com.emr.producter.dto;

import com.emr.producter.enums.Position;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPlayerDTO implements Serializable {

    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 2, max = 40, message = "Name must be between 2 and 40 characters.")
    private String name;

    @NotBlank(message = "Surname cannot be empty.")
    @Size(min = 2, max = 40, message = "Surname must be between 2 and 40 characters.")
    private String surname;

    private Position position;
}
