package com.dompet.tontineonline.controller;

import com.dompet.tontineonline.dto.MembreDTO;
import com.dompet.tontineonline.entity.Membre;
import com.dompet.tontineonline.exception.message.SuccessMessage;
import com.dompet.tontineonline.service.MembreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/membre/")
public class MembreController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MembreService membreService ;

    @PostMapping()
    public ResponseEntity<Object> create (@RequestBody Membre membre){
        this.membreService.create(membre);
        SuccessMessage successMessage = SuccessMessage.builder()
                .code(200).message("record successfully")
                .build();
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<MembreDTO>> findAll(){
        return new ResponseEntity<>( this.membreService.findAll()
                .stream()
                .map(membre -> modelMapper.map(membre,MembreDTO.class))
                .collect(Collectors.toList()),HttpStatus.OK );

    }
    @GetMapping("{id}")
    public ResponseEntity<MembreDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(
                modelMapper.map(this.membreService.findById(id),MembreDTO.class),
                HttpStatus.OK);
    }
}
