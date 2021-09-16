package App.akademik.Akademikunaspasim.Controllers;

import App.akademik.Akademikunaspasim.Models.*;
import App.akademik.Akademikunaspasim.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JadwalController {
    @Autowired
    JurusanRepository jurusanRepository;

    @Autowired
    SemesterRepository semesterRepository;

    @Autowired
    MakulRepository makulRepository;

    @Autowired
    JadwalRepository jadwalRepository;

    @Autowired
    AkunRepository akunRepository;

    @GetMapping("/jadwal")
    public String TampilJadwal(Model model){
        List<Jadwal> jadwals = jadwalRepository.findAll();
        model.addAttribute("jadwal",jadwals);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "TabelJadwal";
    }

    @GetMapping("/jadwal_ubah/{id}")
    public String EditJadwal(@PathVariable("id") Integer id, Model model){
        List<Makul> makuls = makulRepository.findAll();
        List<Jurusan> jurusans = jurusanRepository.findAll();
        List<Semester> semesters = semesterRepository.findAll();
        Jadwal jadwal = jadwalRepository.findById(id).get();
        model.addAttribute("makul",makuls);
        model.addAttribute("jurusan",jurusans );
        model.addAttribute("semester",semesters);
        model.addAttribute("jadwal",jadwal);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "form_jadwal";
    }

    @GetMapping("/jadwal_baru")
    public String TambahJadwal(Model model){
        List<Makul> makuls = makulRepository.findAll();
        List<Jurusan> jurusans = jurusanRepository.findAll();
        List<Semester> semesters = semesterRepository.findAll();
        model.addAttribute("makul",makuls);
        model.addAttribute("jurusan",jurusans );
        model.addAttribute("semester",semesters);
        model.addAttribute("jadwal", new Jadwal());
        model.addAttribute("namaAkun",akunRepository.nama());
        return "form_jadwal";
    }

    @PostMapping("/jadwal/simpan")
    public String SimpanJadwal(Jadwal jadwal){
        jadwalRepository.save(jadwal);
        return "redirect:/jadwal";
    }

    @GetMapping("/jadwal_hapus/{id}")
    public String HapusJadwal(@PathVariable("id") Integer id){
        jadwalRepository.deleteById(id);
        return "redirect:/jadwal";
    }

}
