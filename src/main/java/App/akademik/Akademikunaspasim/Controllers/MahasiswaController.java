package App.akademik.Akademikunaspasim.Controllers;

import App.akademik.Akademikunaspasim.Models.Fakultas;
import App.akademik.Akademikunaspasim.Models.Jurusan;
import App.akademik.Akademikunaspasim.Models.Mahasiswa;
import App.akademik.Akademikunaspasim.Models.Semester;
import App.akademik.Akademikunaspasim.Repository.AkunRepository;
import App.akademik.Akademikunaspasim.Repository.JurusanRepository;
import App.akademik.Akademikunaspasim.Repository.MahasiswaRepository;
import App.akademik.Akademikunaspasim.Repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MahasiswaController {
    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Autowired
    JurusanRepository jurusanRepository;

    @Autowired
    SemesterRepository semesterRepository;

    @Autowired
    AkunRepository akunRepository;

    @GetMapping("/mahasiswa")
    public String Mahasiswa(Model model){
        List<Mahasiswa> mahasiswaList = mahasiswaRepository.findAll();
        model.addAttribute("mahasiswa",mahasiswaList);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "TabelMahasiswa";
    }

    @GetMapping("/mahasiswa_baru")
    public String TambahMahasiswa(Model model){
        List<Semester> ListSemester =semesterRepository.findAll();
        List<Jurusan> Listjurusan =jurusanRepository.findAll();
        model.addAttribute("ListSemester",ListSemester);
        model.addAttribute("Listjurusan",Listjurusan);
        model.addAttribute("mahasiswa",new Mahasiswa());
        model.addAttribute("namaAkun",akunRepository.nama());
        return "form_mahasiswa";
    }

    @PostMapping("/mahasiswa/simpan")
    public String simpan(Mahasiswa mahasiswa){
        mahasiswaRepository.save(mahasiswa);
        return "redirect:/mahasiswa";
    }

    @GetMapping("/mahasiswa_ubah/{id}")
    public String EditMahasiswa(@PathVariable("id") Integer id, Model model){
        Mahasiswa mahasiswa = mahasiswaRepository.findById(id).get();
        List<Jurusan> Listjurusan =jurusanRepository.findAll();
        List<Semester> ListSemester =semesterRepository.findAll();
        model.addAttribute("Listjurusan",Listjurusan);
        model.addAttribute("ListSemester",ListSemester);
        model.addAttribute("mahasiswa",mahasiswa);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "form_mahasiswa";
    }

    @GetMapping("/mahasiswa_hapus/{id}")
    public String HapusMahasiswa(@PathVariable("id") Integer id){
        mahasiswaRepository.deleteById(id);
        return "redirect:/mahasiswa";
    }

}
