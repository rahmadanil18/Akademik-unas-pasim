package App.akademik.Akademikunaspasim.Controllers;

import App.akademik.Akademikunaspasim.Models.Fakultas;
import App.akademik.Akademikunaspasim.Repository.AkunRepository;
import App.akademik.Akademikunaspasim.Repository.FakultasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FakultasController {
   @Autowired
    FakultasRepository fakultasRepository;

   @Autowired
    AkunRepository akunRepository;

    @GetMapping("/fakultas")
    public String LihatFakultas(Model model){
        List<Fakultas> fakultasList = fakultasRepository.findAll();
        model.addAttribute("fakultas",fakultasList);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "TabelFakultas";
    }

    @GetMapping("/baru")
    public String TambahFakultas(Model model){
        model.addAttribute("fakultas",new Fakultas());
        model.addAttribute("namaAkun",akunRepository.nama());
        return "Form_fakultas";
    }

    @PostMapping("/fakultas/simpan")
    public String simpan(@ModelAttribute("fakultas") Fakultas fakultas){
        fakultasRepository.save(fakultas);
        return "redirect:/fakultas";
    }

    @GetMapping("/ubah/{id}")
    public String UbahFakultas(@PathVariable("id") Integer id, Model model){
        Fakultas fakultas =fakultasRepository.findById(id).get();
        model.addAttribute("fakultas",fakultas);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "Form_fakultas";
    }

    @GetMapping("/fakultas/hapus/{id}")
    public String HapusFakultas(@PathVariable("id") Integer id){
        fakultasRepository.deleteById(id);
        return "redirect:/fakultas";
    }
}
