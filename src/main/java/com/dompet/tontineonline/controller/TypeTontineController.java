package com.dompet.tontineonline.controller;

import com.dompet.tontineonline.entity.TypeTontine;
import com.dompet.tontineonline.exception.EntityAlreadyExistsException;
import com.dompet.tontineonline.exception.message.SuccessMessage;
import com.dompet.tontineonline.service.TypeTontineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/typeTontine/")
public class TypeTontineController {
    @Autowired
    private TypeTontineService typeTontineService;

    @PostMapping()
    public ResponseEntity<Object> create (@RequestBody TypeTontine typeTontine){
        try{
            this.typeTontineService.create(typeTontine);
            SuccessMessage successMessage = SuccessMessage.builder()
                    .code(200).message("record successfully")
                    .build();
                return new ResponseEntity<>(successMessage, HttpStatus.OK);

        }catch (EntityAlreadyExistsException exception){
            return   new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        }
    }
}
