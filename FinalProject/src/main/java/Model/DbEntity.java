package Model;

import javax.persistence.*;

@MappedSuperclass
public abstract class DbEntity {
    protected Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
