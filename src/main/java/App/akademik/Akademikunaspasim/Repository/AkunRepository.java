package App.akademik.Akademikunaspasim.Repository;

import App.akademik.Akademikunaspasim.Models.Akun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AkunRepository extends JpaRepository<Akun,Integer> {
    @Query("SELECT u FROM Akun u WHERE u.email=?1")
    public Akun findByEmail(String email);

    @Query("SELECT concat(u.firstName,' ',u.lastName)  FROM Akun u")
    public String nama();
}
