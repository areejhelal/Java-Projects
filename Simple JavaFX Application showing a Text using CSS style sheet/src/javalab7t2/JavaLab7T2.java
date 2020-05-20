/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab7t2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Areej
 */


    /**
     *
     * @author Areej
     */
    public class JavaLab7T2 extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {

            Text HelloAreej = new Text("Hello Areej!");
            StackPane rootPane = new StackPane(HelloAreej);
            Scene scene = new Scene(rootPane, 400, 300);
            primaryStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("new 1.css").toString());
            HelloAreej.getStyleClass().add("root");
            primaryStage.show();

        }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            Application.launch(args);

        }
        // TODO code application logic here
    }


