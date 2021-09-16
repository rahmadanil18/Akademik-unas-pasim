package App.akademik.Akademikunaspasim.Controllers;

import App.akademik.Akademikunaspasim.Models.Dosen;
import App.akademik.Akademikunaspasim.Models.Fakultas;
import App.akademik.Akademikunaspasim.Repository.AkunRepository;
import App.akademik.Akademikunaspasim.Repository.DosenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DosenControlller {
    @Autowired
    DosenRepository dosenRepository;

    @Autowired
    AkunRepository akunRepository;

    @GetMapping("/dosen")
    public String Dosen(Model model){
        List<Dosen> dosens = dosenRepository.findAll();
        model.addAttribute("dosen",dosens);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "TabelDosen";
    }

    @GetMapping("/dosen_baru")
    public String TambahDosen(Model model){
        model.addAttribute("dosen",new Dosen());
        model.addAttribute("namaAkun",akunRepository.nama());
        return "Form_dosen";
    }

    @PostMapping("/dosen/simpan")
    public String SimpanDosen(Dosen dosen){
        dosenRepository.save(dosen);
        return "redirect:/dosen";
    }

    @GetMapping("/dosen_ubah/{id}")
    public String UbahDosen(@PathVariable("id") Integer id, Model model){
        Dosen dosen =dosenRepository.findById(id).get();
        model.addAttribute("dosen",dosen);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "Form_dosen";
    }

    @GetMapping("/dosen_hapus/{id}")
    public String HapusDosen(@PathVariable("id") Integer id){
        dosenRepository.deleteById(id);
        return "redirect:/dosen";
    }
}
