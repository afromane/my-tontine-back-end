package com.dompet.tontineonline.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Data
@NoArgsConstructor
@Transactional
@Entity
@Table(name= "type_tontine")
public class TypeTontine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String label;

    public Boolean isRequired;

    public Integer amount ;

    public Boolean isActive ;
}
