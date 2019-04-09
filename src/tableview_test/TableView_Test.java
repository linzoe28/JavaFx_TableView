/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview_test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
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
        TableColumn firstNameColumn = new TableColumn("姓");
        TableColumn lastNameColumn = new TableColumn("名");
        TableColumn emailColumn = new TableColumn("信箱");
        emailColumn.setMinWidth(300);
        tableView.getColumns().addAll(firstNameColumn, lastNameColumn, emailColumn);
        root.setCenter(tableView);
        Scene scene = new Scene(root, 500, 500);

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
