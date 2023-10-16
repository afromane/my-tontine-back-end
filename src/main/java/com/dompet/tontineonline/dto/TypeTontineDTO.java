package com.dompet.tontineonline.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TypeTontineDTO {
    public Long id;

    public String label;

    public Boolean isRequired;

    public Integer amount ;

    public Boolean isActive ;
}
