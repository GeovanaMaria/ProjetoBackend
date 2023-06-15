package com.livraria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.model.Cliente;
import com.livraria.model.dto.LoginEntradaDto;
import com.livraria.service.ClienteService;

@RestController
@RequestMapping("/livraria")
public class LoginController {

    private final ClienteService clienteService;

    public LoginController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginEntradaDto entrada) {
        // Recupere as informações do cliente com base no email fornecido
        Cliente cliente = clienteService.getByEmail(entrada.getEmail());

        if (cliente != null && cliente.getSenha().equals(entrada.getSenha())) {
            // As credenciais são válidas, retorne o código de status 200 (OK)
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            // As credenciais são inválidas, retorne o código de status 401 (Unauthorized)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
        }
    }
}


