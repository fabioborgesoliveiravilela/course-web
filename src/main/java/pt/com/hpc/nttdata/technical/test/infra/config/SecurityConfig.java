package pt.com.hpc.nttdata.technical.test.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pt.com.hpc.nttdata.technical.test.adapter.entrypoint.filter.AuthSecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthSecurityFilter filter() {
        return new AuthSecurityFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/v3/api-docs/swagger-config").permitAll()
                .antMatchers("/v3/api-docs").permitAll()
                .antMatchers("/*.png").permitAll()
                .antMatchers("/usuario/token").permitAll()
                .antMatchers(HttpMethod.POST).hasAuthority("Professor")
                .antMatchers(HttpMethod.PUT).hasAuthority("Professor")
                .antMatchers(HttpMethod.DELETE).hasAuthority("Professor")
                .anyRequest().authenticated();

        http.addFilterBefore(filter(), UsernamePasswordAuthenticationFilter.class);
    }
}
