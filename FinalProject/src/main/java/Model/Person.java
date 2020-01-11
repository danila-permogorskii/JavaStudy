package Model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person extends PersonalId {
    protected String name;
    protected String secondName;
    protected int age;

    public Person(int personalId, String name, String secondName, int age) {
        super(personalId);
        this.name = name;
        this.secondName = secondName;
        this.age = age;
    }

    public Person() {
        super();
        this.name = "unnamed";
        this.secondName = "unnamed";
        this.age = 0;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "second_name")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }
}
