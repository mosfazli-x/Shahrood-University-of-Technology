import javafx.fxml.FXML;
import javafx.scene.control.Button;
import tetris.Tetris;

import javax.swing.*;
import java.awt.*;

public class MainController {

    @FXML
    Button NewGameButton,ScoresTableButton,SettingsButton,ExitButton;

    @FXML
    public void NewGameButtonClicked(){
        Tetris tetris = new Tetris();
        tetris.main();
    }

    @FXML
    public void ScoresTableButtonClicked(){

    }

    @FXML
    public void SettingsButtonClicked(){

    }

    @FXML
    public void ExitButtonClicked(){
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f,"Goobye","Tetris Game",JOptionPane.WARNING_MESSAGE);
        System.exit(0);
    }


}
