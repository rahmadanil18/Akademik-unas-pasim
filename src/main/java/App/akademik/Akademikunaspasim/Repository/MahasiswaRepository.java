package App.akademik.Akademikunaspasim.Repository;

import App.akademik.Akademikunaspasim.Models.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa,Integer> {
    @Query(value="SELECT count(nim) FROM mahasiswa", nativeQuery=true)
    public Integer jumlahMahasiswa();

}
