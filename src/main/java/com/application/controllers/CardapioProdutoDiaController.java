package com.application.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.application.entities.CardapioProdutoDia;

@RestController
@RequestMapping("/cardapio-produto-dia")
public class CardapioProdutoDiaController {

    @Autowired
    private CardapioProdutoDiaRepository cardapioProdutoDiaRepository;

    @GetMapping
    public ResponseEntity<List<CardapioProdutoDia>> listarTodos() {
        return ResponseEntity.ok(cardapioProdutoDiaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardapioProdutoDia> buscarPorId(@PathVariable Integer id) {
        return cardapioProdutoDiaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CardapioProdutoDia> criar(@RequestBody CardapioProdutoDia cardapioProdutoDia) {
        CardapioProdutoDia salvo = cardapioProdutoDiaRepository.save(cardapioProdutoDia);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardapioProdutoDia> atualizar(@PathVariable Integer id, @RequestBody CardapioProdutoDia cardapioProdutoDiaAtualizado) {
        return cardapioProdutoDiaRepository.findById(id).map(cardapioProdutoDia -> {
            cardapioProdutoDia.setProduto(cardapioProdutoDiaAtualizado.getProduto());
            cardapioProdutoDia.setCardapioDia(cardapioProdutoDiaAtualizado.getCardapioDia());
            CardapioProdutoDia atualizado = cardapioProdutoDiaRepository.save(cardapioProdutoDia);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!cardapioProdutoDiaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cardapioProdutoDiaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
