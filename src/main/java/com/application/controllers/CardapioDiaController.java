package com.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.application.entities.CardapioDia;
import com.application.services.CardapioDiaService;

@RestController
@RequestMapping("/cardapio-dia")
public class CardapioDiaController {

    @Autowired
    private CardapioDiaService cardapioDiaService;

    @GetMapping
    public ResponseEntity<List<CardapioDia>> listarTodos() {
        return ResponseEntity.ok(cardapioDiaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardapioDia> buscarPorId(@PathVariable Long id) {
        return cardapioDiaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CardapioDia> criar(@RequestBody CardapioDia cardapioDia) {
        CardapioDia salvo = cardapioDiaService.salvar(cardapioDia);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardapioDia> atualizar(@PathVariable Long id, @RequestBody CardapioDia cardapioDia) {
        CardapioDia atualizado = cardapioDiaService.atualizar(id, cardapioDia);
        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = cardapioDiaService.deletar(id);
        if (!deletado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
