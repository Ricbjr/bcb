package com.example.BCB.controllers;

import com.example.BCB.dto.Mensagem.MensagemRecordBaseDto;
import com.example.BCB.dto.Mensagem.MensagemRecordDto;
import com.example.BCB.exceptions.ValidacaoException;
import com.example.BCB.services.impl.MensagemService;
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
@RequestMapping("/mensagem")
@Api(value = "Mensagem", tags = "Operações da mensagem")
public class MensagemController {

    @Autowired
    MensagemService mensagemService;

    @PostMapping
    @ApiOperation(value = "Incluir mensagem")
    @Transactional
    public ResponseEntity<String> saveMensagem(@RequestBody @Valid MensagemRecordBaseDto mensagemRecordBaseDto)
    {
        try{
            mensagemService.enviarMensagem(mensagemRecordBaseDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Mensagem enviada com sucesso.");
        }catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obter mensagem por ID")
    public  ResponseEntity<Object> getMensagem(@PathVariable(value="id") UUID idMensagem)
    {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mensagemService.getMensagemPorId(idMensagem));
        }catch (ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    @ApiOperation(value = "Obter mensagens do usuário")
    public  ResponseEntity<Object> getMensagensUsuario(@PathVariable(value="idUsuario") UUID idUsuario)
    {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mensagemService.getMensagensPorUsuario(idUsuario));
        }catch(ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar mensagem")
    @Transactional
    public ResponseEntity<Object> updateMensagem(@PathVariable(value="id") UUID idMensagem,
                                              @RequestBody @Valid MensagemRecordDto mensagemRecordDto)
    {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mensagemService.atualizarMensagem(idMensagem,mensagemRecordDto));
        }catch(ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Excluir mensagem")
    @Transactional
    public ResponseEntity<Object> deleteMensagem(@PathVariable(value="id")UUID idMensagem)
    {
        try{
            mensagemService.deletarMensagem(idMensagem);
            return ResponseEntity.status(HttpStatus.OK).body("Mensagem deletada com sucesso");
        }catch(ValidacaoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
