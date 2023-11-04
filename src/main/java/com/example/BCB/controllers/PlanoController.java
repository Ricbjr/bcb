package com.example.BCB.controllers;

import com.example.BCB.dto.Plano.PlanoRecordDto;
import com.example.BCB.exceptions.ValidacaoException;
import com.example.BCB.services.impl.PlanoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/planos")
@Api(value = "Plano", tags = "Operações do plano")
public class PlanoController {
    @Autowired
    PlanoService _planoService;
    @PostMapping
    @ApiOperation(value = "Incluir plano")
    @Transactional
    public ResponseEntity<String> savePlano(@RequestBody @Valid PlanoRecordDto planoRecordDto)
    {
        try{
            _planoService.criarPlano(planoRecordDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Plano criado com sucesso");
        }catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    @ApiOperation(value = "Obter todos os planos")
    public ResponseEntity<Object> getPlanos()
    {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(_planoService.getPlanos());
        }catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Obter plano por ID")
    public ResponseEntity<Object> getPlanoById(@PathVariable(value="id") UUID idPlano)
    {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(_planoService.getPlano(idPlano));
        }catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar plano")
    @Transactional
    public ResponseEntity<Object> updatePlano(@PathVariable(value="id") UUID idPlano,
                                              @RequestBody @Valid PlanoRecordDto planoRecordDto)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(_planoService.atualizarPlano(idPlano,planoRecordDto));
        }catch(ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Excluir plano")
    @Transactional
    public ResponseEntity<Object> deletePlano(@PathVariable(value="id")UUID idPlano)
    {
        try{
            _planoService.deletarPlano(idPlano);
            return ResponseEntity.status(HttpStatus.OK).body("Plano deletado com sucesso");
        }catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
