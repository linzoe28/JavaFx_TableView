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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Webview_Test extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane root=new BorderPane();
        WebView webView=new WebView();
        webView.getEngine().setJavaScriptEnabled(true);
        webView.getEngine().load("https://www.yzu.edu.tw/");
        Scene scene = new Scene(root, 800, 600);
        root.setCenter(webView);
        
        BorderPane addressPane=new BorderPane();
        TextField addrss=new TextField();
        Button goButton=new Button("GO");
        addressPane.setCenter(addrss);
        addressPane.setRight(goButton);
        root.setTop(addressPane);
        goButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(addrss.getText().startsWith("http")==false){
                   addrss.setText("https://www.google.com/search?q="+addrss.getText());
                }
                webView.getEngine().load(addrss.getText());
            }
        });
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
