package App.akademik.Akademikunaspasim.Repository;

import App.akademik.Akademikunaspasim.Models.Jurusan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurusanRepository extends JpaRepository<Jurusan,Integer> {}
