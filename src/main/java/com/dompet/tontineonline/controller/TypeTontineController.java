package com.dompet.tontineonline.controller;

import com.dompet.tontineonline.dto.TypeTontineDTO;
import com.dompet.tontineonline.entity.TypeTontine;
import com.dompet.tontineonline.exception.EntityAlreadyExistsException;
import com.dompet.tontineonline.exception.message.ErrorEntity;
import com.dompet.tontineonline.exception.message.SuccessMessage;
import com.dompet.tontineonline.service.TypeTontineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/typeTontine/")
public class TypeTontineController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TypeTontineService typeTontineService;

    @PostMapping()
    public ResponseEntity<Object> create (@RequestBody TypeTontine typeTontine){
        this.typeTontineService.create(typeTontine);
        SuccessMessage successMessage = SuccessMessage.builder()
                .code(200).message("record successfully")
                .build();
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TypeTontineDTO>> findAll(){
        return new ResponseEntity<>( this.typeTontineService.findAll()
                .stream()
                .map(typeTontine -> modelMapper.map(typeTontine,TypeTontineDTO.class))
                .collect(Collectors.toList()),HttpStatus.OK );

    }
    @GetMapping("{id}")
    public ResponseEntity<TypeTontineDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(
                modelMapper.map(this.typeTontineService.findById(id),TypeTontineDTO.class),
                HttpStatus.OK);
    }

}
