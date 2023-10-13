package martins.ramonie.todolist.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import martins.ramonie.todolist.repository.UserRepository;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {
    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var servletPath = request.getServletPath();
        if(servletPath.equals("/tasks/")){

        //PEGAR A AUTENTICAÇÃO
        System.out.println("Autenticação");
        var authorization= request.getHeader("Authorization");
        var authEncoded =  authorization.substring("Basic".length()).trim();
        byte[] authDecode  = Base64.getDecoder().decode(authEncoded);
        var authString = new  String(authDecode);

        String[] credentials = authString.split(":");
        String username = credentials[0];
        String password = credentials[1];

        // VALIDAÇÃO DE USUÁRIO
        var user = this.userRepository.findByUsername(username);
       if( user == null){

       }else {
           //VALIDAÇÃO DE SENHA
           var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
           if (passwordVerify.verified) {
               request.setAttribute("idUser", user.getId());
               filterChain.doFilter(request, response);
           } else {
               response.sendError(401);
           }


       }

    }else {
            filterChain.doFilter(request, response);
        }
    }
}
