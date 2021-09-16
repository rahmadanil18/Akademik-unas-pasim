package App.akademik.Akademikunaspasim.Models;

import javax.persistence.*;

@Entity
@Table(name = "tb_semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
