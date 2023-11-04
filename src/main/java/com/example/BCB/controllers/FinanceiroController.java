package com.example.BCB.controllers;

import com.example.BCB.dto.Usuario.UsuarioRecordBaseDto;
import com.example.BCB.exceptions.ValidacaoException;
import com.example.BCB.services.impl.UsuarioService;
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
@RequestMapping("/financeiro")
@Api(value = "Financeiro", tags = "Operações financeiras")
public class FinanceiroController {

    @Autowired
    UsuarioService _usuarioService;

    @PutMapping("/cliente/credito/{id}")
    @ApiOperation(value = "Incluir credito cliente")
    @Transactional
    public ResponseEntity<Object> incluirCreditoCliente(@PathVariable(value="id") UUID idUsuario,
                                                @RequestBody @Valid UsuarioRecordBaseDto usuarioRecordBaseDto)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(_usuarioService.atualizarUsuario(idUsuario,usuarioRecordBaseDto));
        }catch(ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/cliente/credito/{id}")
    @ApiOperation(value = "Pegar saldo usuário")
    public ResponseEntity<String> getSaldoUsuario(@PathVariable(value="id")UUID idUsuario)
    {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(_usuarioService.getUsuarioPorId(idUsuario).getSaldo().toString());
        }catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/cliente/limite/{id}")
    @ApiOperation(value = "Alterar limite cliente")
    @Transactional
    public ResponseEntity<Object> alterarLimiteCliente(@PathVariable(value="id") UUID idUsuario,
                                                       @RequestBody @Valid UsuarioRecordBaseDto usuarioRecordBaseDto)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(_usuarioService.atualizarUsuario(idUsuario,usuarioRecordBaseDto));
        }catch(ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/cliente/plano/{id}")
    @ApiOperation(value = "Alterar plano cliente")
    @Transactional
    public ResponseEntity<Object> alterarPlanoCliente(@PathVariable(value="id") UUID idUsuario,
                                                       @RequestBody @Valid UsuarioRecordBaseDto usuarioRecordBaseDto)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(_usuarioService.atualizarUsuario(idUsuario,usuarioRecordBaseDto));
        }catch(ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/cliente/{id}")
    @ApiOperation(value = "Pegar informações do usuário por ID")
    public  ResponseEntity<Object> getUsuario(@PathVariable(value="id")UUID idUsuario)
    {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(_usuarioService.getUsuarioPorId(idUsuario));
        }catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
