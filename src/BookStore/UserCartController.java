package BookStore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UserCartController implements Initializable {

    //TODO list of Items here
    @FXML VBox vbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void backHandler (ActionEvent event) throws Exception{

        for (int i = 0; i < 10; i++)
        {
            HBox hbox = createHbox();
            vbox.getChildren().add(hbox);
        }
    }

    private HBox createHbox () {
        Button b = new Button("Remove");
        b.setMaxWidth(85);
        b.setMinWidth(85);
        Label l = new Label("Book 1 author alaa");
        l.setMaxWidth(580);
        l.setMinWidth(580);
        HBox hbox = new HBox(l, b);
        hbox.setMaxWidth(660);
        hbox.setMinWidth(660);
        hbox.setMaxHeight(50);
        hbox.setMinHeight(20);

        return hbox;
    }

}
