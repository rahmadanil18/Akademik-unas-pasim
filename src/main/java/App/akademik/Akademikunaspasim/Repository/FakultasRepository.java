package App.akademik.Akademikunaspasim.Repository;

import App.akademik.Akademikunaspasim.Models.Fakultas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakultasRepository extends JpaRepository<Fakultas, Integer> {}
