package App.akademik.Akademikunaspasim.Controllers;

import App.akademik.Akademikunaspasim.Repository.AkunRepository;
import App.akademik.Akademikunaspasim.Repository.DosenRepository;
import App.akademik.Akademikunaspasim.Repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Autowired
    DosenRepository dosenRepository;

    @Autowired
    AkunRepository akunRepository;
   // @GetMapping("")
    //public String viewHomePage() {
     //   return "login";
    //}

    @GetMapping("/dasboard")
    public String index(Model model){
        model.addAttribute("jmlMahasiswa",mahasiswaRepository.jumlahMahasiswa());
        model.addAttribute("jmlDosen",dosenRepository.jumlahDosen());
        model.addAttribute("namaAkun",akunRepository.nama());
        return "index";
    }


}
