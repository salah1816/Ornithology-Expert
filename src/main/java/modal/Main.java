package modal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static modal.Premise.ruleApplicable;

public class Main extends Application{
    public static ArrayList<Character> baseDesFaits;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        baseDesFaits=new ArrayList<>();
//        initBF();
        //run();
//        Premise r=new Premise();
////        System.out.println(ruleApplicable("ABF"));
//        baseDesFaits=r.enricherBF(baseDesFaits);
//        System.out.println(baseDesFaits);
//        r.convertBF(baseDesFaits);
        launch();
    }
    public static void run(){
        Premise r=new Premise();
        baseDesFaits=r.enricherBF(baseDesFaits);
    }
    public static void initBF(){
        baseDesFaits.add('A');
        baseDesFaits.add('B');
        //baseDesFaits.add('E');
    }

}