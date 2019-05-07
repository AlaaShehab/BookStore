package BookStore;

import Backend.Book;
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
    //TODO u need to send the user here.

    @FXML private MenuBar menu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private void editProfileHanlder (ActionEvent event) throws Exception{

    }

    @FXML
    private void promotUserHandler (ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("View/PromoteUser.fxml"));
        Scene scene = new Scene(parent);
        Stage app_stage = (Stage) menu.getScene().getWindow();
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

    }

    @FXML
    private void topCustomerHandler (ActionEvent event) throws Exception{

    }

    @FXML
    private void topBookHandler (ActionEvent event) throws Exception{

    }

    @FXML
    private void SearchBookHandler (ActionEvent event) throws Exception{

    }
}
