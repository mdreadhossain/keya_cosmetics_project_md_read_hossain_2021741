package event.manager.ms3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class event_manager implements Initializable {
    @FXML
    private TableView<HRUser> table;
    @FXML
    private TextField EmployeeIdTextField;
    @FXML
    private TextField EmployeeNameTextField;
    @FXML
    private TextField EmployeeRoleTextField;
    @FXML
    private TableColumn<HRUser, Integer> EmployeID;
    @FXML
    private TableColumn<HRUser, String> EmployeeName;
    @FXML
    private TableColumn<HRUser, String> EmployeeRole;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    // Load existing HRUser objects into the TableView
    loadHRUserList();
    EmployeID.setCellValueFactory(new PropertyValueFactory<HRUser, Integer>("userID"));
        EmployeeName.setCellValueFactory(new PropertyValueFactory<HRUser, String>("name"));
        EmployeeRole.setCellValueFactory(new PropertyValueFactory<HRUser, String>("role"));

        
        
//table set value
        table.setItems(HRUser.getTariffInfoToLoadInTableview());
    
    
    
}

// Method to load HRUser data into the TableView
private void loadHRUserList() {
    ObservableList<HRUser> HRUserList = HRUser.readHRUserList();
    
    // Debugging output to console
    System.out.println("Loaded " + HRUserList.size() + " HRUser(s).");

    // Set the loaded data into the TableView
    table.setItems(HRUserList);
}

    @FXML
    private void SaveButtonOnClick(ActionEvent event) {
    try {
        int userID = Integer.parseInt(EmployeeIdTextField.getText());
        String name = EmployeeNameTextField.getText();
        String role = EmployeeRoleTextField.getText();

        // Add new employee and serialize to file
        boolean success = HRUser.addNewEmployee(userID, name, role);

        if (success) {
            // Clear the input fields after successful addition
            EmployeeIdTextField.clear();
            EmployeeNameTextField.clear();
            EmployeeRoleTextField.clear();

            // Refresh the TableView to reflect the addition of a new employee
            // updateTableView();

            // Consider adding a success feedback mechanism here (e.g., updating a status label)
        } else {
            // Consider handling the case where adding a new employee is unsuccessful
            // For example, you might log this event or update a status label with an error message
        }
    } catch (NumberFormatException e) {
        // Handle the case where the provided userID is not an integer
        // Consider informing the user through a status label or logging the error
    }
}

    @FXML
    private void LoadTableOnClick(ActionEvent event) {
    // Assuming you've fixed the readPatientList method to correctly read from "newHRUser.bin"
    // and it's now correctly named as readHRUserList:
    ObservableList<HRUser> HRUserList = HRUser.readHRUserList();
    
    // Now, set this list to your TableView
    table.setItems(HRUserList);
    
    // Also ensure your TableColumn bindings are correct, matching the HRUser property names
}

    @FXML
    private void ReturnToDashBoardButtonOnClick(ActionEvent event) {
    }


    
    


    
}


