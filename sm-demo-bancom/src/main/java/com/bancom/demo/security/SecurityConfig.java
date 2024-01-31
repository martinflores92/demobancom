package com.bancom.demo.security;


//@Configuration
//@EnableWebSecurity
public class SecurityConfig {
	
//    @Autowired
//    private DataSource dataSource;
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	  PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//          auth
//              .inMemoryAuthentication()
//              .withUser("admin")
//              .password(encoder.encode("admin"));
////              .roles("USER");
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .authorizeRequests()
//            .requestMatchers("/usuarios/**").hasRole("USER") // Protege las rutas bajo /usuarios/** para usuarios autenticados
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        // Este bean es necesario para evitar errores relacionados con la codificación de contraseñas
//        return NoOpPasswordEncoder.getInstance();
//    }
}
