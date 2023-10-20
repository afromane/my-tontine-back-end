package com.dompet.tontineonline.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Data
@Transactional
@NoArgsConstructor
@Entity
@Table(name="membre")
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String firstName;

    public String lastName;

    public Date dateOfBirth;

    public String placeOfBirth ;

    public String sex ;

    public String email;

}
