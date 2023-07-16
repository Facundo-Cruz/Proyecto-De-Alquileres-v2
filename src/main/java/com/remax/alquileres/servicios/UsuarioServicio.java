package com.remax.alquileres.servicios;

import com.remax.alquileres.entidades.Usuario;
import com.remax.alquileres.enumeraciones.Rol;
import com.remax.alquileres.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UsuarioServicio implements UserDetailsService{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Transactional
    public void registrarUsuario(String email, String clave){
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setClave(new BCryptPasswordEncoder().encode(clave));
        usuario.setRol(Rol.ADMIN);
        usuarioRepositorio.save(usuario);
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.buscarUsuarioPorEmail(email);

        if (usuario != null) {
            List<GrantedAuthority> permisos = new ArrayList();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            permisos.add(p);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", usuario);

            User user = new User(usuario.getEmail(), usuario.getClave(), permisos);
            return user;
        } else {
            return null;
        }
    }
    
}
