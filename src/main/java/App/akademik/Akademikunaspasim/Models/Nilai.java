package App.akademik.Akademikunaspasim.Models;

import javax.persistence.*;

@Entity
@Table(name = "tb_nilai")
public class Nilai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nilai")
    private Integer nilai;

    @ManyToOne
    @JoinColumn(name = "id_siswa")
    private Mahasiswa mahasiswa;

    @ManyToOne
    @JoinColumn(name = "id_makul")
    private Makul makul;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNilai() {
        return nilai;
    }

    public void setNilai(Integer nilai) {
        this.nilai = nilai;
    }

    public Makul getMakul() {
        return makul;
    }

    public void setMakul(Makul makul) {
        this.makul = makul;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
}
