package App.akademik.Akademikunaspasim.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/dasboard","/fakultas","/jurusan","/makul","/mahasiswa","/dosen","/jadwal","/baru","/ubah/*","/dosen_baru","/dosen/*","/dosen_ubah/*","/dosen_hapus/*","/fakultas/*","/fakultas/**","/jadwal_ubah/*","/jadwal_baru","/jadwal/*","/jadwal_hapus/*","/jurusan_baru","/jurusan/*","/jurusan_ubah/*","/jurusan_hapus/*","/mahasiswa_baru","/mahasiswa/*","/mahasiswa_ubah/*","/mahasiswa_hapus/*","/makul_baru","/makul/*","/makul_ubah/*","/makul_hapus/*","/nilai_baru","/nilai_ubah/*","/nilai/*","/nilai_hapus/*","/register").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/dasboard")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/login").permitAll();
    }

}
