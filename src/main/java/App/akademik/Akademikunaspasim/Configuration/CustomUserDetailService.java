package App.akademik.Akademikunaspasim.Configuration;

import App.akademik.Akademikunaspasim.Models.Akun;
import App.akademik.Akademikunaspasim.Repository.AkunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    AkunRepository akunRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Akun akun = akunRepository.findByEmail(email);
        System.out.println("hii");
        if(akun == null){
            throw new UsernameNotFoundException("Akun Tidak Ditemukan");
        }
        return new CustomUserDetail(akun);
    }
}
