package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "soldiers")
public class Soldier extends Person {
    private String typeOfArmy;

    public Soldier(int personalId, String name, String secondName, int age, String typeOfArmy) {
        super(personalId, name, secondName, age);
        this.typeOfArmy = typeOfArmy;
    }

    public Soldier() {
        super();
        this.typeOfArmy = "untyped";
    }

    @Column(name = "type_of_army")
    public String getTypeOfArmy() {
        return typeOfArmy;
    }

    public void setTypeOfArmy(String typeOfArmy) {
        this.typeOfArmy = typeOfArmy;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "typeOfArmy='" + typeOfArmy + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", personalId=" + personalId +
                '}';
    }
}
