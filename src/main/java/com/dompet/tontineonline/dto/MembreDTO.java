package com.dompet.tontineonline.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor

public class MembreDTO {

    public Long id;

    public String firstName;

    public String lastName;

    public Date dateOfBirth;

    public String placeOfBirth ;

    public String sex ;

    public String email;
}
