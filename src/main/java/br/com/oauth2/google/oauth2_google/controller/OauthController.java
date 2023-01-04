package br.com.oauth2.google.oauth2_google.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthController {
    
    @GetMapping("/publico")
    public String getPublic(){
        return "<h1>Essa rota é publica</h1>";
    }

    @GetMapping("/privado")
    public String getPrivate(){
        return "<h1>Essa rota é privada</h1>";
    }
}
