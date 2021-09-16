package App.akademik.Akademikunaspasim.Models;

import javax.persistence.*;

@Entity
@Table(name = "jadwal")
public class Jadwal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "hari")
    private String hari;

    @Column(name = "mulai")
    private String mulai;

    @Column(name = "selesai")
    private String selesai;

    @ManyToOne
    @JoinColumn(name = "id_makul")
    private Makul makul;

    @ManyToOne
    @JoinColumn(name = "id_jur")
    private Jurusan jurusan;

    @ManyToOne
    @JoinColumn(name = "id_semester")
    private Semester semester;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getMulai() {
        return mulai;
    }

    public void setMulai(String mulai) {
        this.mulai = mulai;
    }

    public String getSelesai() {
        return selesai;
    }

    public void setSelesai(String selesai) {
        this.selesai = selesai;
    }

    public Makul getMakul() {
        return makul;
    }

    public void setMakul(Makul makul) {
        this.makul = makul;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
