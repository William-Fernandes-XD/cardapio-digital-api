package com.application.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.application.entities.CardapioDia;
import com.application.repositories.CardapioDiaRepository;

@RestController
@RequestMapping("/cardapio-dia")
public class CardapioDiaController {

    @Autowired
    private CardapioDiaRepository cardapioDiaRepository;

    @GetMapping
    public ResponseEntity<List<CardapioDia>> listarTodos() {
        return ResponseEntity.ok(cardapioDiaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardapioDia> buscarPorId(@PathVariable Long id) {
        return cardapioDiaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CardapioDia> criar(@RequestBody CardapioDia cardapioDia) {
        CardapioDia salvo = cardapioDiaRepository.save(cardapioDia);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardapioDia> atualizar(@PathVariable Long id, @RequestBody CardapioDia cardapioDiaAtualizado) {
        return cardapioDiaRepository.findById(id).map(cardapioDia -> {
            // ajuste aqui os setters conforme os campos reais da sua entidade CardapioDia
            CardapioDia atualizado = cardapioDiaRepository.save(cardapioDia);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!cardapioDiaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cardapioDiaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
