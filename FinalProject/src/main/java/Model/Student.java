package Model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public final class Student extends Person{
    private int groupNumber;
    private String groupName;

    public Student(int personalId, String name, String secondName, int age, int groupNumber, String groupName) {
        super(personalId, name, secondName, age);
        this.groupNumber = groupNumber;
        this.groupName = groupName;
    }

    public Student() {
        super();
        this.groupNumber = 0;
        this.groupName = "unnamed";
    }

    @Column(name = "group_number")
    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
