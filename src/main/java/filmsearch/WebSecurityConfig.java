package filmsearch;

//import filmsearch.authentication.CustomTokenBasedRememberMeService;
import filmsearch.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Stas on 28-Nov-16.
 */
/*@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/user/**", "/api-docs/**").permitAll()
                .anyRequest().authenticated().and()
                .httpBasic().and()
                .csrf().disable();
    }

}*/

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userDetailsServiceImpl;
    /*@Autowired
    private CustomTokenBasedRememberMeService tokenBasedRememberMeService;*/
    /*@Autowired
    private RememberMeAuthenticationProvider rememberMeAuthenticationProvider;*/

    @Override protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                //.antMatchers("/resources/**").permitAll()
                .antMatchers("/api/user/register/", "/api-docs/**").permitAll()
                //.antMatchers("").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //.loginPage("/")
                .loginProcessingUrl("/api/user/login/")
                //.successForwardUrl("/api/user/success/")
                //.failureUrl("/mobile/app/sign-in?loginFailure=true")
                .permitAll()
                ;//.and()
                //.rememberMe().rememberMeServices(tokenBasedRememberMeService);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
    }

}
