package com.example.AluraForoHub.controller;

import com.example.AluraForoHub.dto.DatosAutenticacionUsuarioDTO;
import com.example.AluraForoHub.dto.DatosJWTtokenDTO;
import com.example.AluraForoHub.infra.security.TokenService;
import com.example.AluraForoHub.modelos.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticacionUsuario(@RequestBody @Valid DatosAutenticacionUsuarioDTO datosAutenticacion){

        Authentication authToken=new UsernamePasswordAuthenticationToken(datosAutenticacion.usuario(),
                datosAutenticacion.contraseña());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken=tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTtokenDTO(JWTtoken));
    }
}
