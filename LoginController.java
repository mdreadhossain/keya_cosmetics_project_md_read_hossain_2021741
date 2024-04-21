package event.manager.ms3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void handleLoginButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Placeholder for actual authentication logic
        if ("admin".equals(username) && "password".equals(password)) {
            try {
                // Load the next scene
                Parent dashboardRoot = FXMLLoader.load(getClass().getResource("HR_DashBoard.fxml"));
                Scene dashboardScene = new Scene(dashboardRoot);

                // Get the current window (stage) and set the new scene
                Stage primaryStage = (Stage) usernameField.getScene().getWindow(); // usernameField is a node in the current scene
                primaryStage.setScene(dashboardScene);

            } catch (Exception e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Scene Switch Failed", "Could not load the dashboard scene.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization code here, if any
    }
}