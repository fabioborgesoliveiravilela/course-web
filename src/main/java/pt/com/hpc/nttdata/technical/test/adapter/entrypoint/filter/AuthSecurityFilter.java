package pt.com.hpc.nttdata.technical.test.adapter.entrypoint.filter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import pt.com.hpc.nttdata.technical.test.core.model.usuario.UsuarioResult;
import pt.com.hpc.nttdata.technical.test.core.usecase.usuario.ReadUsuarioByNifUseCase;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class AuthSecurityFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(AuthSecurityFilter.class);

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private ReadUsuarioByNifUseCase readUsuarioByNifUseCase;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = getToken(request);

            String nif = jwtUtils.getNifFromJwtToken(jwt);

            UsuarioResult usuario = readUsuarioByNifUseCase.read(nif);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,
                    null, Arrays.asList(new SimpleGrantedAuthority(usuario.getPerfil())));
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }

        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.isNoneBlank(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        throw new IllegalArgumentException("Token not found");
    }
}