/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview_test;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class TableView_Test extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        TableView tableView = new TableView();
        TableColumn firstNameColumn = new TableColumn("名");
        TableColumn lastNameColumn = new TableColumn("姓");
        TableColumn emailColumn = new TableColumn("信箱");
        emailColumn.setMinWidth(300);
        tableView.getColumns().addAll(firstNameColumn, lastNameColumn, emailColumn);
        
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName")); //指定為傳資料的方式
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        
        ObservableList list = FXCollections.observableArrayList(
                new Person("zoe", "Lin", "aaaa@com.tw", "25252"),
                new Person("Lendle", "Tesng", "bbbb@com.tw", "5522")
        );
        tableView.setItems(list);
        
        VBox vBox = new VBox();
        Label labelFirstName = new Label("First Name");
        Label labelLastName = new Label("Last Name");
        Label labelEmail = new Label("email");
        Label labelMoble = new Label("Moble");
        labelFirstName.setPrefWidth(100);
        labelLastName.setPrefWidth(100);
        labelEmail.setPrefWidth(100);
        labelMoble.setPrefWidth(100);
        TextField textFirstName = new TextField();
        TextField textLastName = new TextField();
        TextField textEmail = new TextField();
        TextField textMoble = new TextField();
        
        vBox.getChildren().addAll(
                new HBox(labelFirstName, textFirstName),
                new HBox(labelLastName, textLastName),
                new HBox(labelEmail, textEmail),
                new HBox(labelMoble, textMoble)
        );
        
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    Person person = (Person) tableView.getSelectionModel().getSelectedItem();
                    textFirstName.setText(person.getFirstName());
                    textLastName.setText(person.getLastName());
                    textEmail.setText(person.getEmail());
                    textMoble.setText(person.getMoble());
                }
            }
        });
        
        root.setCenter(vBox);
        root.setLeft(tableView);
        Scene scene = new Scene(root, 800, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
