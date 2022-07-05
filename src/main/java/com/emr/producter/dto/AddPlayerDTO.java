package com.emr.producter.dto;

import com.emr.producter.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPlayerDTO implements Serializable {

    private String name;
    private String surname;
    private Position position;
}
