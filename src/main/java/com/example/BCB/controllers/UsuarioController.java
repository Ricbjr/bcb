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
@Api(value = "Usuário", tags = "Operações do usuário")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService _usuarioService;

    @PostMapping
    @ApiOperation(value = "Incluir usuário")
    @Transactional
    public ResponseEntity<String> saveUsuario(@RequestBody @Valid UsuarioRecordBaseDto usuarioRecordDto)
    {
        try{
            _usuarioService.criarUsuario(usuarioRecordDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso");
        }catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    @ApiOperation(value = "Obter todos os usuários")
    public  ResponseEntity<Object> getUsuarios()
    {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(_usuarioService.getUsuarios());
        }catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Obter usuário por ID")
    public  ResponseEntity<Object> getUsuario(@PathVariable(value="id")UUID idUsuario)
    {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(_usuarioService.getUsuarioPorId(idUsuario));
        }catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar usuário")
    @Transactional
    public ResponseEntity<Object> updateUsuario(@PathVariable(value="id") UUID idUsuario,
                                                @RequestBody @Valid UsuarioRecordBaseDto usuarioRecordBaseDto)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(_usuarioService.atualizarUsuario(idUsuario,usuarioRecordBaseDto));
        }catch(ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Excluir usuário")
    @Transactional
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value="id")UUID idUsuario)
    {
        try{
            _usuarioService.deletarUsuario(idUsuario);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
        }catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
