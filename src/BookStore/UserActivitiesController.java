package BookStore;

import Backend.Book;
import Backend.User;
import com.sun.org.apache.regexp.internal.RE;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserActivitiesController implements Initializable {
    //TODO manager is different from normal user

    @FXML private MenuBar menu;
    private static User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(
                "view/SignIn.fxml"));
        Parent root;
        try {
            root = (Parent) loader.load();
        } catch (Exception e) {

        }
        SignInController controller = loader.getController();
        if (controller.getUser() != null) {
            user = controller.getUser();
            return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(
                "view/SignUp.fxml"));
        Parent parentRoot;
        try {
            parentRoot = (Parent) fxmlLoader.load();
        } catch (Exception e) {

        }
        SignUpController ucontroller = fxmlLoader.getController();
        user = ucontroller.getUser();
        //disable some of user functions if not manager

    }

    public User getUser () {
        return user;
    }
    public void setUser (User user1) {
        user = user1;
    }
    @FXML
    private void editProfileHanlder (ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/EditProfile.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = new Stage();
        app_stage.setTitle("Edit Profile");
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void promotUserHandler (ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/PromoteUser.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = new Stage();
        app_stage.setTitle("Promoting User");
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void logoutHandler (ActionEvent event) throws Exception{
        //first we remove all lists in the cart
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(
                "view/UserCart.fxml"));
        Parent root = (Parent) loader.load();
        UserCartController controller = loader.getController();
        controller.clearList();

        //then we return to homepage
        Parent parent = FXMLLoader.load(getClass().getResource("View/HomePage.fxml"));
        Scene scene = new Scene(parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void addBookHanlder (ActionEvent event) throws Exception{

    }

    @FXML
    private void modifyBookHandler (ActionEvent event) throws Exception{

    }

    @FXML
    private void PlaceOrderHandler (ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/PlaceOrder.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = new Stage();
        app_stage.setTitle("Place Order");
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void confirmOrderHandler (ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/ConfirmOrder.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = new Stage();
        app_stage.setTitle("Confirm Order");
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void CartHandler (ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("View/UserCart.fxml"));
        Scene scene = new Scene(parent);
        Stage app_stage = (Stage) menu.getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void totalSalesHanlder (ActionEvent event) throws Exception{
        //TODO just call backend
    }

    @FXML
    private void topCustomerHandler (ActionEvent event) throws Exception{
        //TODO just call backend
    }

    @FXML
    private void topBookHandler (ActionEvent event) throws Exception{
        //TODO just call backend
    }

    @FXML
    private void SearchBookHandler (ActionEvent event) throws Exception{

    }
}
