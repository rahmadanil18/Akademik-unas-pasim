package App.akademik.Akademikunaspasim.Controllers;

import App.akademik.Akademikunaspasim.Models.Akun;
import App.akademik.Akademikunaspasim.Repository.AkunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AkunController {
    @Autowired
    AkunRepository akunRepository;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("akun",new Akun());
        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(Akun akun) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hasil =encoder.encode(akun.getPassword());
        akun.setPassword(hasil);
        akunRepository.save(akun);

        return "redirect:/logout";
    }
}
