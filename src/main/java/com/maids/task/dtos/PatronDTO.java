package com.maids.task.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatronDTO {
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @JsonProperty("contact_information")
    @NotBlank(message = "Contact information is required")
    private String contactInformation;

    public PatronDTO(long l, String s) {

    }
}
