package App.akademik.Akademikunaspasim.Controllers;

import App.akademik.Akademikunaspasim.Models.*;
import App.akademik.Akademikunaspasim.Repository.AkunRepository;
import App.akademik.Akademikunaspasim.Repository.MahasiswaRepository;
import App.akademik.Akademikunaspasim.Repository.MakulRepository;
import App.akademik.Akademikunaspasim.Repository.NilaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NilaiController {
    @Autowired
    NilaiRepository nilaiRepository;

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Autowired
    MakulRepository makulRepository;

    @Autowired
    AkunRepository akunRepository;

    @GetMapping("/nilai")
    public String TampilNilai(Model model){
        List<Nilai> nilaiList = nilaiRepository.findAll();
        model.addAttribute("nilai",nilaiList);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "TabelNilai";
    }

    @GetMapping("/nilai_baru")
    public String TambahNilai(Model model){
        List<Mahasiswa> mahasiswas = mahasiswaRepository.findAll();
        List<Makul> makuls = makulRepository.findAll();
        model.addAttribute("mahasiswa",mahasiswas);
        model.addAttribute("makul",makuls);
        model.addAttribute("nilai", new Nilai());
        model.addAttribute("namaAkun",akunRepository.nama());
        return "form_nilai";
    }

    @GetMapping("/nilai_ubah/{id}")
    public String EditNilai(@PathVariable("id") Integer id, Model model){
        List<Mahasiswa> mahasiswa = mahasiswaRepository.findAll();
        List<Makul> makul = makulRepository.findAll();
        Nilai nilai = nilaiRepository.findById(id).get();
        System.out.println(mahasiswa);
        model.addAttribute("mahasiswa ",mahasiswa );
        model.addAttribute("makul",makul);
        model.addAttribute("nilai",nilai);
        model.addAttribute("namaAkun",akunRepository.nama());
        return "form_nilai";
    }

    @PostMapping("/nilai/simpan")
    public String SimpanNilai(Nilai nilai){
        nilaiRepository.save(nilai);
        return "redirect:/nilai";
    }

    @GetMapping("/nilai_hapus/{id}")
    public String HapusNilai(@PathVariable("id") Integer id){
        nilaiRepository.deleteById(id);
        return "redirect:/nilai";
    }


}
