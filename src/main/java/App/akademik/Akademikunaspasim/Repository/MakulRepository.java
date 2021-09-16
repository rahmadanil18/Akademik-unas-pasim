package App.akademik.Akademikunaspasim.Repository;

import App.akademik.Akademikunaspasim.Models.Makul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakulRepository extends JpaRepository<Makul,Integer>{}
