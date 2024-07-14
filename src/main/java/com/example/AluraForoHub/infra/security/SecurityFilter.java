package com.example.AluraForoHub.infra.security;

import com.example.AluraForoHub.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //Obtener el token del header
        //Authorization viene por defecto
        var authHeader = request.getHeader("Authorization"); //.replace("Bearer ", "");

        if (authHeader!=null){
            var token = authHeader.replace("Bearer ", "");
            var nombreUsuario = tokenService.getSubjetc(token);//Aqui se extrae el username

            if (nombreUsuario != null){
                //Token valido
                var usuario = usuarioRepository.findByNombre(nombreUsuario);
                var autenticacion = new UsernamePasswordAuthenticationToken(usuario,
                        null, usuario.getAuthorities()); //Aqui se fuerza el inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(autenticacion);
            }
        }
        filterChain.doFilter(request, response);
    }
}
