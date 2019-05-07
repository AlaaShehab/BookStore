package BookStore;

import Backend.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    @FXML private CheckBox manager;

    private boolean validUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validUser = false;
    }
    @FXML
    private void signUpHandler (ActionEvent event) throws Exception {

        setUser();

        if (validUser) {
            //TODO SQL Add user to db and set ID
            Parent root = FXMLLoader.load(getClass().getResource("View/UserActivities.fxml"));
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
        if (!validName(firstName) || !validName(lastName)) {
            validUser = false;
            return;
        }
        user.setFirstName(firstName.getText());
        user.setLastName(lastName.getText());

        //TODO SQL to check that username and email is unique

        user.setUsername(username.getText());


        if (!validateEmaill()) {
            validUser = false;
            return;
        }
        user.setEmail(email.getText());

        if (!validateMobileNo()) {
            validUser = false;
            return;
        }
        user.setPhoneNumber(phone.getText());

        if (password.getText() != cpassword.getText() || password.getText().isEmpty()) {
            validUser = false;
            return;
        }
        user.setPassword(password.getText());

        if (address.getText().isEmpty()) {
            validUser = false;
            return;
        }
        user.setShippingAddress(address.getText());
        user.setManager(manager.isSelected());
    }
    private boolean validName (TextField name) {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(name.getText());
        if(m.find() && m.group().equals(name.getText())){
            return true;
        }
        return false;
    }
    private boolean validateEmaill(){
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(email.getText());
        if(m.find() && m.group().equals(email.getText())){
            return true;
        }
        return false;
    }
    private boolean validateMobileNo(){
        Pattern p = Pattern.compile("(01)[0-3][0-9]{7}");
        Matcher m = p.matcher(phone.getText());
        if(m.find() && m.group().equals(phone.getText())){
            return true;
        }
        return false;
    }
}
