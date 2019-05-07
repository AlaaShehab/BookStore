package BookStore;

import Backend.Book;
import Backend.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.util.List;

public class CreditCardController {

    @FXML
    Button closeBtn;

    @FXML
    private void closeWindowHandler (ActionEvent event) throws Exception{
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void verifyHanlder (ActionEvent event) throws Exception{

        //TODO verify input data
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(
                "view/UserCart.fxml"));
        Parent root = (Parent) loader.load();
        UserCartController controller = loader.getController();
        List<Book> list = controller.getCartItems();

       //TODO SQL code
        controller.clearList();
        controller.refresh();
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
        stage.close();
    }
}
