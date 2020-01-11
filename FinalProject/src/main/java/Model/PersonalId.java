package Model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PersonalId extends DbEntity {
    protected int personalId;

    public PersonalId(int personalId){
        super();
        this.personalId = personalId;
    }

    public PersonalId(){
        super();
        this.personalId = 0;
    }

    @Column(name = "personal_id")
    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

}
