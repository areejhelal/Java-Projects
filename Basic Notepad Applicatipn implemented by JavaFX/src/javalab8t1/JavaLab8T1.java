/*
 * Areej Ayman Helal
 * V0
 * 24 Nov,2019
 */
package javalab8t1;

import java.io.File;
import java.io.FileWriter;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
//import javafx.scene.web.HTMLEditor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCombination;

/**
 *
 * @author Areej
 */
public class JavaLab8T1 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea T = new TextArea();
        T.setPromptText("Write whatever you want :) ");

        MenuBar m = new MenuBar();
        Menu file = new Menu("file");
        MenuItem item1 = new MenuItem("New");
        item1.setAccelerator(KeyCombination.keyCombination("ctrl+n"));
        item1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                T.clear();
            }
        });
        

        MenuItem item2 = new MenuItem("Open");
        item2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                FileChooser fileChooser = new FileChooser();

                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);

                //Show save file dialog
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    T.setText(readFile(file));
                }
            }
        });

        MenuItem item3 = new MenuItem("Save");
        item3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(primaryStage);
             
            if(file != null){
                SaveFile(T.getText(), file);
            }

            }
        });

        SeparatorMenuItem item4 = new SeparatorMenuItem();

        MenuItem item5 = new MenuItem("Exit");
        file.getItems().addAll(item1, item2, item3, item4, item5);
        m.getMenus().addAll(file);
        item5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Platform.exit();

            }
        });

        Menu Edit = new Menu("Edit");
        //MenuItem item6 = new MenuItem("Undo");
        //SeparatorMenuItem item7 = new SeparatorMenuItem();
        MenuItem item6 = new MenuItem("Cut");
        item6.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                T.cut();
            }
        });

        MenuItem item7 = new MenuItem("Copy");
        item7.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                T.copy();

            }
        });

        MenuItem item8 = new MenuItem("Paste");
        item8.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                T.paste();

            }
        });

        MenuItem item9 = new MenuItem("Delete");
        item9.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                T.deletePreviousChar();

            }
        });
        //SeparatorMenuItem item12 = new SeparatorMenuItem();
        //MenuItem item13 = new MenuItem("Select All");
        Edit.getItems().addAll(item6, item7, item8, item9);
        m.getMenus().addAll(Edit);

        Menu Help = new Menu("Help");
        m.getMenus().addAll(Help);

        //HTMLEditor h = new HTMLEditor();
        FlowPane f = new FlowPane(m);
        f.setOrientation(Orientation.HORIZONTAL);

        BorderPane p = new BorderPane();
        p.setTop(f);

        p.setCenter(T);

        Scene scene = new Scene(p, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("NotePad");
        primaryStage.show();

    }

    private String readFile(File file) {
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(file));

            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaLab8T1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JavaLab8T1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(JavaLab8T1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return stringBuffer.toString();
    }

    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;
              
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(JavaLab8T1.class
                .getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Application.launch(args);

    }

}
