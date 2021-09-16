package App.akademik.Akademikunaspasim.Repository;

import App.akademik.Akademikunaspasim.Models.Nilai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NilaiRepository extends JpaRepository<Nilai,Integer> {}
