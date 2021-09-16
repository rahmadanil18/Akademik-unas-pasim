package App.akademik.Akademikunaspasim.Controllers;

import App.akademik.Akademikunaspasim.Models.Fakultas;
import App.akademik.Akademikunaspasim.Models.Jurusan;
import App.akademik.Akademikunaspasim.Repository.AkunRepository;
import App.akademik.Akademikunaspasim.Repository.FakultasRepository;
import App.akademik.Akademikunaspasim.Repository.JurusanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JurusanController {
    @Autowired
    JurusanRepository jurusanRepository;

    @Autowired
    FakultasRepository fakultasRepository;

    @Autowired
    AkunRepository akunRepository;

    @GetMapping("/jurusan")
    public String TampilJurusan(Model model){
        List<Jurusan> jurusanList = jurusanRepository.findAll();
        model.addAttribute("jurusan",jurusanList);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "TabelJurusan";
    }

    @GetMapping("/jurusan_baru")
    public String TambahJurusan(Model model){
        List<Fakultas> fakultas = fakultasRepository.findAll();
        Jurusan jurusan = new Jurusan();
        model.addAttribute("listFakultas",fakultas);
        model.addAttribute("Jurusan",jurusan);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "form_jurusan";
    }

    @PostMapping("/jurusan/simpan")
    public String SimpanJurusan(Jurusan jurusan){
        jurusanRepository.save(jurusan);
        return "redirect:/jurusan";
    }

    @GetMapping("/jurusan_ubah/{id}")
    public String EditJurusan(@PathVariable("id") Integer id, Model model){
        Jurusan jurusan = jurusanRepository.findById(id).get();
        List<Fakultas> listFakultas = fakultasRepository.findAll();
        model.addAttribute("listFakultas",listFakultas);
        model.addAttribute("Jurusan",jurusan);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "form_jurusan";
    }

    @GetMapping("/jurusan_hapus/{id}")
    public String HapusJurusan(@PathVariable("id") Integer id){
        jurusanRepository.deleteById(id);
        return "redirect:/jurusan";
    }


}
