package ViewModel;

public class SoldierViewModel {
    private int personalId;
    private String name;
    private String secondName;
    private int age;
    private String typeOfArmy;

    public SoldierViewModel(int personalId, String name, String secondName, int age, String typeOfArmy) {
        this.personalId = personalId;
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.typeOfArmy = typeOfArmy;
    }

    public int getPersonalId() {
        return personalId;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String getTypeOfArmy() {
        return typeOfArmy;
    }
}
