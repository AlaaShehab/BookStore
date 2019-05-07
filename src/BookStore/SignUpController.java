package BookStore;

import Backend.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    private static User user;

    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private TextField cpassword;
    @FXML private TextField phone;
    @FXML private TextField address;
    @FXML private TextField email;

    private boolean validUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validUser = false;
    }
    @FXML
    private void signUpHandler (ActionEvent event) throws Exception {

        setUser();

        if (validUser) {
            //TODO SQL Add user to db
            Parent root = FXMLLoader.load(getClass().getResource("View/UserCart.fxml"));
            Scene scene = new Scene(root);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        }
    }
    @FXML
    private void backHandler (ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/HomePage.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    public User getUser () {
        return user;
    }

    public void setUser () {
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
            validUser = false;
            return;
        }
        user.setFirstName(firstName.getText());
        user.setLastName(lastName.getText());


    }
}
