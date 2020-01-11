package ViewModel;

public class StudentViewModel {
    private int personalId;
    private String name;
    private String secondName;
    private int age;
    private String groupName;
    private int groupNumber;

    public StudentViewModel(int personalId, String name, String secondName, int age, String groupName, int groupNumber) {
        this.personalId = personalId;
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.groupName = groupName;
        this.groupNumber = groupNumber;
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

    public int getPersonalId() {
        return personalId;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }
}
