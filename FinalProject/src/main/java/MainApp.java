import Model.Soldier;
import Model.Student;
import Repository.SoldierRepository;
import Repository.SoldierRepositoryImpl;
import Repository.StudentRepository;
import Repository.StudentRepositoryImpl;
import ViewModel.SoldierViewModel;
import ViewModel.StudentViewModel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.*;
import java.io.File;
import java.util.List;

public class MainApp extends Application {

    private Stage window;
    private Scene mainScene, addStudentScene, addSoldierScene, studentListScene, soldierListScene;
    private Desktop desktop = Desktop.getDesktop();

    private static EntityManagerFactory factory;
    private static EntityManager em;


    private static Student addedStudent;
    private static Soldier addedSoldier;

    private static TextField fieldStudentPersonalId;
    private static TextField fieldStudentName;
    private static TextField fieldStudentSecondName;
    private static TextField fieldStudentAge;
    private static TextField fieldStudentGroupName;
    private static TextField fieldStudentGroupNumber;
    private static TextField fieldSoldierPersonalId;
    private static TextField fieldSoldierName;
    private static TextField fieldSoldierSecondName;
    private static TextField fieldSoldierAge;
    private static TextField fieldSoldierTypeOfArmy;

    private static Button addStudentButton;
    private static Button addSoldierButton;

    private static TableView<StudentViewModel> studentTable;
    private static TableView<SoldierViewModel> soldierTable;

    private static Button backButton;

    private static SoldierRepository soldierRepository;
    private static StudentRepository studentRepository;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Course Work");

        initMainScene();
        initAddSoldierScene();
        initAddStudentScene();
        initListStudentScene();
        initListSoldierScene();

        window.setScene(mainScene);
        window.show();
    }

    private void initListSoldierScene() {
        GridPane listSoldierGrid = new GridPane();

        listSoldierGrid.setPadding(new Insets(20));
        listSoldierGrid.setHgap(20);
        listSoldierGrid.setVgap(15);

        TableColumn<SoldierViewModel, Integer> columnPersonalId = new TableColumn<>("Personal_id");
        columnPersonalId.setMinWidth(20);
        columnPersonalId.setCellValueFactory(new PropertyValueFactory<>("personalId"));

        TableColumn<SoldierViewModel, String> columnName = new TableColumn<>("Name");
        columnName.setMinWidth(20);
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<SoldierViewModel, String> columnSecondName = new TableColumn<>("Second_name");
        columnSecondName.setMinWidth(20);
        columnSecondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));

        TableColumn<SoldierViewModel, Integer> columnAge = new TableColumn<>("Age");
        columnAge.setMinWidth(20);
        columnAge.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<SoldierViewModel, String> columnTypeOfArmy = new TableColumn<>("Type_of_army");
        columnTypeOfArmy.setMinWidth(20);
        columnTypeOfArmy.setCellValueFactory(new PropertyValueFactory<>("typeOfArmy"));

        soldierTable = new TableView<>();
        soldierTable.setItems(getSoldiers());
        soldierTable.getColumns().addAll(columnPersonalId, columnName, columnSecondName, columnAge, columnTypeOfArmy);

        listSoldierGrid.add(soldierTable, 0, 0, 10, 10);

        backButton = new Button("Back");
        backButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        window.setScene(mainScene);
                    }
                });

        listSoldierGrid.add(backButton, 5, 11, 1, 3);

        soldierListScene = new Scene(listSoldierGrid, 450, 400);
    }

    private void initListStudentScene() {
        GridPane listStudentGrid = new GridPane();

        listStudentGrid.setPadding(new Insets(20));
        listStudentGrid.setHgap(20);
        listStudentGrid.setVgap(15);

        TableColumn<StudentViewModel, Integer> columnPersonalId = new TableColumn<>("Personal_id");
        columnPersonalId.setMinWidth(20);
        columnPersonalId.setCellValueFactory(new PropertyValueFactory<>("personalId"));

        TableColumn<StudentViewModel, String> columnName = new TableColumn<>("Name");
        columnName.setMinWidth(20);
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<StudentViewModel, String> columnSecondName = new TableColumn<>("Second_name");
        columnSecondName.setMinWidth(20);
        columnSecondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));

        TableColumn<StudentViewModel, Integer> columnAge = new TableColumn<>("Age");
        columnAge.setMinWidth(20);
        columnAge.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<StudentViewModel, String> columnGroupName = new TableColumn<>("Group_name");
        columnGroupName.setMinWidth(20);
        columnGroupName.setCellValueFactory(new PropertyValueFactory<>("groupName"));

        TableColumn<StudentViewModel, Integer> columnGroupNumber = new TableColumn<>("Group_number");
        columnGroupNumber.setMinWidth(20);
        columnGroupNumber.setCellValueFactory(new PropertyValueFactory<>("groupNumber"));

        studentTable = new TableView<>();
        studentTable.setItems(getStudents());
        studentTable.getColumns().addAll(columnPersonalId, columnName, columnSecondName, columnAge,columnGroupName, columnGroupNumber);

        listStudentGrid.add(studentTable, 0, 0, 10, 10);

        backButton = new Button("Back");
        backButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        window.setScene(mainScene);
                    }
                });

        listStudentGrid.add(backButton, 5, 11, 1, 3);

        studentListScene = new Scene(listStudentGrid, 450, 400);
    }

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("CourseDB");
        em = factory.createEntityManager();

        studentRepository = new StudentRepositoryImpl(em);
        soldierRepository = new SoldierRepositoryImpl(em);
        addStudentButton = new Button("Add Student");
        addSoldierButton = new Button("Add Student");

        fieldStudentPersonalId = new TextField();
        fieldStudentName = new TextField();
        fieldStudentSecondName = new TextField();
        fieldStudentAge = new TextField();
        fieldStudentGroupName = new TextField();
        fieldStudentGroupNumber = new TextField();

        fieldSoldierPersonalId = new TextField();
        fieldSoldierName = new TextField();
        fieldSoldierSecondName = new TextField();
        fieldSoldierAge = new TextField();
        fieldSoldierTypeOfArmy = new TextField();
        backButton = new Button("Back");
        launch(args);
    }

    private void initAddSoldierScene() {
        GridPane addSoldierGrid = new GridPane();

        addSoldierGrid.setPadding(new Insets(20));
        addSoldierGrid.setHgap(25);
        addSoldierGrid.setVgap(15);

        Label labelTitle = new Label("Add student data and image:");

        addSoldierGrid.add(labelTitle, 0, 0, 2, 1);

        Label labelPersonalId = new Label("Personal id:");
        Label labelName = new Label("Name:");
        Label labelSecondName = new Label("Second name:");
        Label labelAge = new Label("Age:");
        Label labelTypeOfArmy = new Label("TypeOfArmy:");

        addSoldierButton.setDisable(false);
        addSoldierButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                            addedSoldier = new Soldier(Integer.parseInt(fieldSoldierPersonalId.getText()), fieldSoldierName.getText(), fieldSoldierSecondName.getText(), Integer.parseInt(fieldSoldierAge.getText()),  fieldSoldierTypeOfArmy.getText());
                            soldierRepository.addSoldier(addedSoldier);
                            addedSoldier = null;
                            fieldSoldierPersonalId.clear();
                            fieldSoldierName.clear();
                            fieldSoldierSecondName.clear();
                            fieldSoldierAge.clear();
                            fieldSoldierTypeOfArmy.clear();
                            addSoldierButton.setDisable(false);
                            window.setScene(mainScene);
                    }
                });

        GridPane.setHalignment(labelPersonalId, HPos.RIGHT);
        addSoldierGrid.add(labelPersonalId, 0, 1);

        GridPane.setHalignment(labelName, HPos.RIGHT);
        addSoldierGrid.add(labelName, 0, 2);

        GridPane.setHalignment(labelSecondName, HPos.RIGHT);
        addSoldierGrid.add(labelSecondName, 0, 3);

        GridPane.setHalignment(labelAge, HPos.RIGHT);
        addSoldierGrid.add(labelAge, 0, 4);

        GridPane.setHalignment(labelTypeOfArmy, HPos.RIGHT);
        addSoldierGrid.add(labelTypeOfArmy, 0, 5);


        GridPane.setHalignment(fieldSoldierPersonalId, HPos.LEFT);
        addSoldierGrid.add(fieldSoldierPersonalId, 1, 1);

        GridPane.setHalignment(fieldSoldierName, HPos.LEFT);
        addSoldierGrid.add(fieldSoldierName, 1, 2);

        GridPane.setHalignment(fieldSoldierSecondName, HPos.LEFT);
        addSoldierGrid.add(fieldSoldierSecondName, 1, 3);

        GridPane.setHalignment(fieldSoldierAge, HPos.LEFT);
        addSoldierGrid.add(fieldSoldierAge, 1, 4);

        GridPane.setHalignment(fieldSoldierTypeOfArmy, HPos.LEFT);
        addSoldierGrid.add(fieldSoldierTypeOfArmy, 1, 5);

        GridPane.setHalignment(addSoldierButton, HPos.RIGHT);
        addSoldierGrid.add(addSoldierButton, 1, 6, 3, 1);

        addSoldierScene = new Scene(addSoldierGrid, 450, 400);
    }

    private void initAddStudentScene() {
        GridPane addStudentGrid = new GridPane();

        addStudentGrid.setPadding(new Insets(20));
        addStudentGrid.setHgap(25);
        addStudentGrid.setVgap(15);

        Label labelTitle = new Label("Add student data and image:");

        addStudentGrid.add(labelTitle, 0, 0, 2, 1);

        Label labelPersonalId = new Label("Personal id:");
        Label labelName = new Label("Name:");
        Label labelSecondName = new Label("Second name:");
        Label labelAge = new Label("Age:");
        Label labelGroupName = new Label("GroupName:");
        Label labelGroupNumber = new Label("GroupNumber:");

        addStudentButton.setDisable(false);
        addStudentButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                            addedStudent = new Student(Integer.parseInt(fieldStudentPersonalId.getText()), fieldStudentName.getText(), fieldStudentSecondName.getText(), Integer.parseInt(fieldStudentAge.getText()), Integer.parseInt(fieldStudentGroupNumber.getText()), fieldStudentGroupName.getText());
                            studentRepository.addStudent(addedStudent);
                            addedStudent = null;
                            fieldStudentPersonalId.clear();
                            fieldStudentName.clear();
                            fieldStudentSecondName.clear();
                            fieldStudentGroupName.clear();
                            fieldStudentAge.clear();
                            fieldStudentGroupNumber.clear();
                            addStudentButton.setDisable(false);
                            window.setScene(mainScene);
                    }
                });

        GridPane.setHalignment(labelPersonalId, HPos.RIGHT);
        addStudentGrid.add(labelPersonalId, 0, 1);

        GridPane.setHalignment(labelName, HPos.RIGHT);
        addStudentGrid.add(labelName, 0, 2);

        GridPane.setHalignment(labelSecondName, HPos.RIGHT);
        addStudentGrid.add(labelSecondName, 0, 3);

        GridPane.setHalignment(labelAge, HPos.RIGHT);
        addStudentGrid.add(labelAge, 0, 4);

        GridPane.setHalignment(labelGroupName, HPos.RIGHT);
        addStudentGrid.add(labelGroupName, 0, 5);

        GridPane.setHalignment(labelGroupNumber, HPos.RIGHT);
        addStudentGrid.add(labelGroupNumber, 0, 6);


        GridPane.setHalignment(fieldStudentPersonalId, HPos.LEFT);
        addStudentGrid.add(fieldStudentPersonalId, 1, 1);

        GridPane.setHalignment(fieldStudentName, HPos.LEFT);
        addStudentGrid.add(fieldStudentName, 1, 2);

        GridPane.setHalignment(fieldStudentSecondName, HPos.LEFT);
        addStudentGrid.add(fieldStudentSecondName, 1, 3);

        GridPane.setHalignment(fieldStudentAge, HPos.LEFT);
        addStudentGrid.add(fieldStudentAge, 1, 4);

        GridPane.setHalignment(fieldStudentGroupName, HPos.LEFT);
        addStudentGrid.add(fieldStudentGroupName, 1, 5);

        GridPane.setHalignment(fieldStudentGroupNumber, HPos.LEFT);
        addStudentGrid.add(fieldStudentGroupNumber, 1, 6);

        GridPane.setHalignment(addStudentButton, HPos.RIGHT);
        addStudentGrid.add(addStudentButton, 1, 7, 3, 1);

        addStudentScene = new Scene(addStudentGrid, 450, 400);
    }


    void initMainScene() {
        GridPane mainGrid = new GridPane();

        mainGrid.setPadding(new Insets(35, 25, 25, 25));
        mainGrid.setVgap(60);
        mainGrid.setHgap(15);

        Button addStudent = new Button("Add Student");
        addStudent.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        window.setScene(addStudentScene);
                    }
                });
        Button addSoldier = new Button("Add Soldier");
        addSoldier.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        window.setScene(addSoldierScene);
                    }
                });
        Button studentList = new Button("Student list");
        studentList.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        updateStudentTable();
                        window.setScene(studentListScene);
                    }
                });
        Button soldierList = new Button("Soldier list");
        soldierList.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        updateSoldierTable();
                        window.setScene(soldierListScene);
                    }
        });

        Image wImage = new Image(getClass().getClassLoader().getResource("zima_04.jpg").toString());
        ImageView wImageIV = new ImageView();
        wImageIV.setFitWidth(400);
        wImageIV.setFitHeight(200);
        wImageIV.setImage(wImage);

        mainGrid.add(wImageIV, 0, 0, 4, 1);

        mainGrid.add(addStudent, 1, 1);
        mainGrid.add(addSoldier, 2, 1);
        mainGrid.add(studentList, 3, 1);
        mainGrid.add(soldierList, 4, 1);

        mainScene = new Scene(mainGrid, 450, 400);
    }

    private void updateSoldierTable() {
        soldierTable.setItems(getSoldiers());
    }

    private ObservableList<SoldierViewModel> getSoldiers() {
        List<Soldier> soldiers = soldierRepository.getAll();
        ObservableList<SoldierViewModel> observableList = FXCollections.observableArrayList();
        observableList.clear();
        for (Soldier s: soldiers){
            observableList.add(new SoldierViewModel(s.getPersonalId(),s.getName(),s.getSecondName(),s.getAge(),s.getTypeOfArmy()));
        }
        return observableList;
    }

    private void updateStudentTable() {
        studentTable.setItems(getStudents());
    }

    private ObservableList<StudentViewModel> getStudents() {
        List<Student> students = studentRepository.getAll();
        ObservableList<StudentViewModel> observableList = FXCollections.observableArrayList();
        observableList.clear();
        for (Student s: students){
            observableList.add(new StudentViewModel(s.getPersonalId(),s.getName(),s.getSecondName(),s.getAge(),s.getGroupName(),s.getGroupNumber()));
        }
        return observableList;
    }

}
