package App.akademik.Akademikunaspasim.Repository;

import App.akademik.Akademikunaspasim.Models.Dosen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DosenRepository extends JpaRepository<Dosen,Integer> {
    @Query(value="SELECT count(d.nip) FROM Dosen d")
    public Integer jumlahDosen();
}
