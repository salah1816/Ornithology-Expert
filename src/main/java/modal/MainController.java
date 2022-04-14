package modal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.crypto.spec.PSource;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import static modal.Main.baseDesFaits;
import static modal.Premise.clauses;


public class MainController implements Initializable {
    ArrayList<ToggleGroup> toggleGroups=new ArrayList<>();
    @FXML
    private RadioButton i0,i1,i2,i3,i4,n0,n1,n2,n3,n4;
    @FXML
    private TextArea txtAreaBF,txtAreaResult;
    private ToggleGroup toggleGroup0 = new ToggleGroup();
    private ToggleGroup toggleGroup1 = new ToggleGroup();
    private ToggleGroup toggleGroup2 = new ToggleGroup();
    private ToggleGroup toggleGroup3 = new ToggleGroup();
    private ToggleGroup toggleGroup4 = new ToggleGroup();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initRadios();
//        toggleGroup0.selectedToggleProperty().addListener((observable, oldVal, newVal) -> System.out.println(newVal + " was selected"));
//        toggleGroup1.selectedToggleProperty().addListener((observable, oldVal, newVal) -> System.out.println(newVal + " was selected"));
//        toggleGroup2.selectedToggleProperty().addListener((observable, oldVal, newVal) -> System.out.println(newVal + " was selected"));
//        toggleGroup3.selectedToggleProperty().addListener((observable, oldVal, newVal) -> System.out.println(newVal + " was selected"));
//        toggleGroup4.selectedToggleProperty().addListener((observable, oldVal, newVal) -> System.out.println(newVal + " was selected"));

        clauses=Clause.getClauses();

    }
    public void initRadios(){
        toggleGroups.add(toggleGroup0);
        toggleGroups.add(toggleGroup1);
        toggleGroups.add(toggleGroup2);
        toggleGroups.add(toggleGroup3);
        toggleGroups.add(toggleGroup4);
        i0.setToggleGroup(toggleGroup0);
        n0.setToggleGroup(toggleGroup0);
        i1.setToggleGroup(toggleGroup1);
        n1.setToggleGroup(toggleGroup1);
        i2.setToggleGroup(toggleGroup2);
        n2.setToggleGroup(toggleGroup2);
        i3.setToggleGroup(toggleGroup3);
        n3.setToggleGroup(toggleGroup3);
        i4.setToggleGroup(toggleGroup4);
        n4.setToggleGroup(toggleGroup4);
    }
    public void onClickValider(){
        txtAreaBF.clear();
        txtAreaResult.clear();
        baseDesFaits.clear();
//        baseDesFaits=new ArrayList<>();
        boolean pass=false;
        char[] cl= {'A', 'B', 'C', 'D', 'E'};
        for (int i = 0; i < toggleGroups.size(); i++) {
            if(toggleGroups.get(i).getSelectedToggle()!=null){
                if(Objects.equals(((RadioButton) toggleGroups.get(i).getSelectedToggle()).getText(), "Oui")){
                    pass=true;
                    baseDesFaits.add(cl[i]);
                }
            }
        }
        if(!pass){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "pour vous informer il faut au mois selectioner un fait juste", ButtonType.OK);
            a.show();
            return;
        }else{
            ArrayList bf0= (ArrayList) baseDesFaits.clone();
            txtAreaBF.setWrapText(true);
            txtAreaBF.setText(Premise.convertBF(bf0));
            System.out.println(bf0);
            Main.run();
            System.out.println(baseDesFaits);
            txtAreaResult.setWrapText(true);
            txtAreaResult.setText(Premise.convertBF(baseDesFaits,bf0.size()));
        }

    }

}