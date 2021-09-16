package App.akademik.Akademikunaspasim.Controllers;

import App.akademik.Akademikunaspasim.Models.Dosen;
import App.akademik.Akademikunaspasim.Models.Fakultas;
import App.akademik.Akademikunaspasim.Models.Jurusan;
import App.akademik.Akademikunaspasim.Models.Makul;
import App.akademik.Akademikunaspasim.Repository.AkunRepository;
import App.akademik.Akademikunaspasim.Repository.DosenRepository;
import App.akademik.Akademikunaspasim.Repository.MakulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MakulController {
    @Autowired
    MakulRepository makulRepository;

    @Autowired
    DosenRepository dosenRepository;

    @Autowired
    AkunRepository akunRepository;

    @GetMapping("/makul")
    public String Makul(Model model){
        model.addAttribute("makul",makulRepository.findAll());
        model.addAttribute("namaAkun",akunRepository.nama());
        return "Tabel_Makul";
    }

    @GetMapping("/makul_baru")
    public String TambahMakul(Model model){
        List<Dosen> dosens = dosenRepository.findAll();
        model.addAttribute("dosens",dosens);
        model.addAttribute("makul",new Makul());
        model.addAttribute("namaAkun",akunRepository.nama());
        return "form_makul";
    }

    @PostMapping("/makul/simpan")
    public String SimpanMakul(Makul makul){
        makulRepository.save(makul);
        return "redirect:/makul";
    }

    @GetMapping("/makul_ubah/{id}")
    public String EditMakul(@PathVariable("id") Integer id, Model model){
        Makul makul = makulRepository.findById(id).get();
        List<Dosen> listDosen = dosenRepository.findAll();
        model.addAttribute("dosens",listDosen);
        model.addAttribute("makul",makul);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "form_makul";
    }

    @GetMapping("/makul_hapus/{id}")
    public String HapusMakul(@PathVariable("id") Integer id){
        makulRepository.deleteById(id);
        return "redirect:/makul";
    }

}
