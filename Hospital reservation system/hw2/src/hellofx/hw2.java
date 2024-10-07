package hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class hw2 extends Application {

    // Map to store patient data (for simplicity, we're storing it in memory)
    private Map<String, PatientData> patientDataMap = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        jun_createMainUI(primaryStage);
    }

    // Main UI with buttons for different views
    private void jun_createMainUI(Stage stage) {
        stage.setTitle("Heart Health Imaging and Recording System");

        // Create buttons for different views
        Button jun_patientIntakeBtn = new Button("Patient Intake");
        Button jun_ctScanTechBtn = new Button("CT Scan Tech View");
        Button jun_patientViewBtn = new Button("Patient View");
        Button jun_doctorViewBtn = new Button("Doctor View");

        // Set the button size
        jun_patientIntakeBtn.setPrefWidth(200);
        jun_ctScanTechBtn.setPrefWidth(200);
        jun_patientViewBtn.setPrefWidth(200);
        jun_doctorViewBtn.setPrefWidth(200);

        // Set actions for buttons
        jun_patientIntakeBtn.setOnAction(e -> jun_openPatientIntake(stage));
        jun_ctScanTechBtn.setOnAction(e -> jun_openCTScanTech(stage));
        jun_patientViewBtn.setOnAction(e -> jun_openPatientView(stage));
        jun_doctorViewBtn.setOnAction(e -> jun_openDoctorView(stage));

        // Create a VBox to arrange the buttons vertically and center them
        VBox jun_vbox = new VBox(20);  // 20 is the spacing between the buttons
        jun_vbox.setPadding(new Insets(20, 20, 20, 20));  // Add padding around the VBox
        jun_vbox.setAlignment(Pos.CENTER);  // Center the content
        jun_vbox.getChildren().addAll(jun_patientIntakeBtn, jun_ctScanTechBtn, jun_patientViewBtn, jun_doctorViewBtn);

        // Add a label at the top for the title
        Label jun_titleLabel = new Label("Welcome to Heart Health Imaging and Recording System");
        jun_titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Create a VBox that contains the title and the buttons
        VBox jun_mainLayout = new VBox(30);  // 30 is the spacing between the title and the buttons
        jun_mainLayout.setAlignment(Pos.CENTER);  // Center everything
        jun_mainLayout.getChildren().addAll(jun_titleLabel, jun_vbox);

        // Create the scene and set it on the stage
        Scene jun_scene = new Scene(jun_mainLayout, 400, 400);  // Adjust the scene size
        stage.setScene(jun_scene);
        stage.show();
    }

    // CT Scan Technician View (Entering Data)
    private void jun_openCTScanTech(Stage stage) {
        stage.setTitle("CT Scan Technician View");

        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(10, 10, 10, 10));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);

        TextField jun_patientID = new TextField();
        jun_patientID.setPromptText("Patient ID");
        jun_grid.add(new Label("Patient ID:"), 0, 0);
        jun_grid.add(jun_patientID, 1, 0);

        TextField jun_totalScore = new TextField();
        jun_totalScore.setPromptText("Total Agatston CAC Score");
        jun_grid.add(new Label("Total Agatston CAC Score:"), 0, 1);
        jun_grid.add(jun_totalScore, 1, 1);

        TextField jun_LM = new TextField();
        jun_LM.setPromptText("LM");
        jun_grid.add(new Label("LM:"), 0, 2);
        jun_grid.add(jun_LM, 1, 2);

        TextField jun_LAD = new TextField();
        jun_LAD.setPromptText("LAD");
        jun_grid.add(new Label("LAD:"), 0, 3);
        jun_grid.add(jun_LAD, 1, 3);

        TextField jun_LCX = new TextField();
        jun_LCX.setPromptText("LCX");
        jun_grid.add(new Label("LCX:"), 0, 4);
        jun_grid.add(jun_LCX, 1, 4);

        TextField jun_RCA = new TextField();
        jun_RCA.setPromptText("RCA");
        jun_grid.add(new Label("RCA:"), 0, 5);
        jun_grid.add(jun_RCA, 1, 5);

        TextField jun_PDA = new TextField();
        jun_PDA.setPromptText("PDA");
        jun_grid.add(new Label("PDA:"), 0, 6);
        jun_grid.add(jun_PDA, 1, 6);

        Button jun_saveBtn = new Button("Save");
        jun_grid.add(jun_saveBtn, 1, 7);

        // Back button to return to the main screen
        Button jun_backBtn = new Button("Back");
        jun_backBtn.setOnAction(e -> jun_createMainUI(stage));
        jun_grid.add(jun_backBtn, 0, 7);

        // Save button action handler
        jun_saveBtn.setOnAction(e -> {
            // Retrieve values from input fields
            String patientID = jun_patientID.getText();
            String totalScore = jun_totalScore.getText();
            String LM = jun_LM.getText();
            String LAD = jun_LAD.getText();
            String LCX = jun_LCX.getText();
            String RCA = jun_RCA.getText();
            String PDA = jun_PDA.getText();

            // Validate patient ID
            if (patientID.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter a valid Patient ID");
                return;
            }

            // Store the patient data in a map
            patientDataMap.put(patientID, new PatientData(patientID, totalScore, LM, LAD, LCX, RCA, PDA));

            // Display confirmation message
            showAlert(Alert.AlertType.INFORMATION, "Success", "Patient data saved successfully!");
        });

        Scene jun_scene = new Scene(jun_grid, 400, 400);
        stage.setScene(jun_scene);
        stage.show();
    }

    // Patient Intake Form
    private void jun_openPatientIntake(Stage stage) {
        stage.setTitle("Patient Intake Form");

        // Create a grid for the form fields
        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(10, 10, 10, 10));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);

        // Add input fields and labels
        TextField jun_firstName = new TextField();
        jun_firstName.setPromptText("First Name");
        jun_grid.add(new Label("First Name:"), 0, 0);
        jun_grid.add(jun_firstName, 1, 0);

        TextField jun_lastName = new TextField();
        jun_lastName.setPromptText("Last Name");
        jun_grid.add(new Label("Last Name:"), 0, 1);
        jun_grid.add(jun_lastName, 1, 1);

        TextField jun_email = new TextField();
        jun_email.setPromptText("Email");
        jun_grid.add(new Label("Email:"), 0, 2);
        jun_grid.add(jun_email, 1, 2);

        TextField jun_phoneNumber = new TextField();
        jun_phoneNumber.setPromptText("Phone Number");
        jun_grid.add(new Label("Phone Number:"), 0, 3);
        jun_grid.add(jun_phoneNumber, 1, 3);

        TextField jun_healthHistory = new TextField();
        jun_healthHistory.setPromptText("Health History");
        jun_grid.add(new Label("Health History:"), 0, 4);
        jun_grid.add(jun_healthHistory, 1, 4);

        TextField jun_insuranceID = new TextField();
        jun_insuranceID.setPromptText("Insurance ID");
        jun_grid.add(new Label("Insurance ID:"), 0, 5);
        jun_grid.add(jun_insuranceID, 1, 5);

        // Add a Save button
        Button jun_saveBtn = new Button("Save");
        jun_grid.add(jun_saveBtn, 1, 6);

        // Back button to return to the main screen
        Button jun_backBtn = new Button("Back");
        jun_backBtn.setOnAction(e -> jun_createMainUI(stage));
        jun_grid.add(jun_backBtn, 0, 6);

        // Save button action handler
        jun_saveBtn.setOnAction(e -> {
            // Retrieve values from input fields
            String firstName = jun_firstName.getText();
            String lastName = jun_lastName.getText();
            String email = jun_email.getText();
            String phoneNumber = jun_phoneNumber.getText();
            String healthHistory = jun_healthHistory.getText();
            String insuranceID = jun_insuranceID.getText();

            // Validate the input fields
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || healthHistory.isEmpty() || insuranceID.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Form Error!", "Please fill all the fields");
                return;
            }

            // Generate a unique 5-digit Patient ID
            String patientID = generatePatientID();

            // Display saved data and patient ID
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Health History: " + healthHistory);
            System.out.println("Insurance ID: " + insuranceID);
            System.out.println("Generated Patient ID: " + patientID);

            // Show success message to the user
            showAlert(Alert.AlertType.INFORMATION, "Success", "Data saved successfully! Your Patient ID is: " + patientID);
        });

        // Set up the scene for the Patient Intake form
        Scene jun_scene = new Scene(jun_grid, 400, 300);
        stage.setScene(jun_scene);
        stage.show();
    }
    // Patient View (Seeing the Results)
    private void jun_openPatientView(Stage stage) {
        stage.setTitle("Patient View");

        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(10, 10, 10, 10));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);

        TextField jun_patientID = new TextField();
        jun_patientID.setPromptText("Enter Patient ID");
        jun_grid.add(new Label("Patient ID:"), 0, 0);
        jun_grid.add(jun_patientID, 1, 0);

        TextField jun_totalScore = new TextField();
        jun_totalScore.setPromptText("Total Agatston CAC Score");
        jun_totalScore.setEditable(false); // 환자가 직접 수정할 수 없게 비활성화
        jun_grid.add(new Label("Total Agatston CAC Score:"), 0, 1);
        jun_grid.add(jun_totalScore, 1, 1);

        TextField jun_LM = new TextField();
        jun_LM.setPromptText("LM");
        jun_LM.setEditable(false);
        jun_grid.add(new Label("LM:"), 0, 2);
        jun_grid.add(jun_LM, 1, 2);

        TextField jun_LAD = new TextField();
        jun_LAD.setPromptText("LAD");
        jun_LAD.setEditable(false);
        jun_grid.add(new Label("LAD:"), 0, 3);
        jun_grid.add(jun_LAD, 1, 3);

        TextField jun_LCX = new TextField();
        jun_LCX.setPromptText("LCX");
        jun_LCX.setEditable(false);
        jun_grid.add(new Label("LCX:"), 0, 4);
        jun_grid.add(jun_LCX, 1, 4);

        TextField jun_RCA = new TextField();
        jun_RCA.setPromptText("RCA");
        jun_RCA.setEditable(false);
        jun_grid.add(new Label("RCA:"), 0, 5);
        jun_grid.add(jun_RCA, 1, 5);

        TextField jun_PDA = new TextField();
        jun_PDA.setPromptText("PDA");
        jun_PDA.setEditable(false);
        jun_grid.add(new Label("PDA:"), 0, 6);
        jun_grid.add(jun_PDA, 1, 6);

        Button jun_searchBtn = new Button("Search");
        jun_grid.add(jun_searchBtn, 1, 7);

        jun_searchBtn.setOnAction(e -> {
            String patientID = jun_patientID.getText();

            if (patientDataMap.containsKey(patientID)) {
                // If patient data is found, populate the fields
                PatientData data = patientDataMap.get(patientID);
                jun_totalScore.setText(data.getTotalScore());
                jun_LM.setText(data.getLM());
                jun_LAD.setText(data.getLAD());
                jun_LCX.setText(data.getLCX());
                jun_RCA.setText(data.getRCA());
                jun_PDA.setText(data.getPDA());
            } else {
                // Show error message if patient data not found
                showAlert(Alert.AlertType.ERROR, "Error", "No data available for the given Patient ID");
            }
        });

        Button jun_backBtn = new Button("Back");
        jun_grid.add(jun_backBtn, 0, 7);
        jun_backBtn.setOnAction(e -> jun_createMainUI(stage));  // 메인 화면으로 돌아가기

        Scene jun_scene = new Scene(jun_grid, 400, 400);
        stage.setScene(jun_scene);
        stage.show();
    }
    private void jun_openDoctorView(Stage stage) {
        stage.setTitle("Doctor View");
    
        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(10, 10, 10, 10));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);
    
        TextField jun_patientID = new TextField();
        jun_patientID.setPromptText("Enter Patient ID");
        jun_grid.add(new Label("Patient ID:"), 0, 0);
        jun_grid.add(jun_patientID, 1, 0);
    
        TextField jun_totalScore = new TextField();
        jun_totalScore.setPromptText("Total Agatston CAC Score");
        jun_totalScore.setEditable(false);
        jun_grid.add(new Label("Total Agatston CAC Score:"), 0, 1);
        jun_grid.add(jun_totalScore, 1, 1);
    
        TextField jun_LM = new TextField();
        jun_LM.setPromptText("LM");
        jun_LM.setEditable(false);
        jun_grid.add(new Label("LM:"), 0, 2);
        jun_grid.add(jun_LM, 1, 2);
    
        TextField jun_LAD = new TextField();
        jun_LAD.setPromptText("LAD");
        jun_LAD.setEditable(false);
        jun_grid.add(new Label("LAD:"), 0, 3);
        jun_grid.add(jun_LAD, 1, 3);
    
        TextField jun_LCX = new TextField();
        jun_LCX.setPromptText("LCX");
        jun_LCX.setEditable(false);
        jun_grid.add(new Label("LCX:"), 0, 4);
        jun_grid.add(jun_LCX, 1, 4);
    
        TextField jun_RCA = new TextField();
        jun_RCA.setPromptText("RCA");
        jun_RCA.setEditable(false);
        jun_grid.add(new Label("RCA:"), 0, 5);
        jun_grid.add(jun_RCA, 1, 5);
    
        TextField jun_PDA = new TextField();
        jun_PDA.setPromptText("PDA");
        jun_PDA.setEditable(false);
        jun_grid.add(new Label("PDA:"), 0, 6);
        jun_grid.add(jun_PDA, 1, 6);
    
        Button jun_riskBtn = new Button("Determine Risk");
        jun_grid.add(jun_riskBtn, 1, 7);
    
        // Create a TextArea to display the Risk evaluation result
        TextArea jun_riskResult = new TextArea();
        jun_riskResult.setPromptText("RISK");
        jun_riskResult.setEditable(false);  // Non-editable area for displaying results
        jun_grid.add(jun_riskResult, 2, 0, 1, 7);  // Place the Risk box in the grid
    
        jun_riskBtn.setOnAction(e -> {
            String patientID = jun_patientID.getText();
    
            if (patientDataMap.containsKey(patientID)) {
                // If patient data is found, calculate the risk
                PatientData data = patientDataMap.get(patientID);
                int totalScore = Integer.parseInt(data.getTotalScore());
                String riskMessage;
    
                if (totalScore == 0) {
                    riskMessage = "Zero: No plaque. Low risk of heart attack.";
                } else if (totalScore <= 10) {
                    riskMessage = "Small amount of plaque. Less than 10% chance of heart disease.";
                } else if (totalScore <= 100) {
                    riskMessage = "Mild plaque. Moderate heart attack risk.";
                } else if (totalScore <= 400) {
                    riskMessage = "Moderate plaque. Moderate to high risk of heart attack.";
                } else {
                    riskMessage = "Large plaque. High risk of heart attack.";
                }
    
                // Display the risk evaluation in the TextArea
                jun_riskResult.setText(riskMessage);
    
            } else {
                // Show error message if patient data not found
                showAlert(Alert.AlertType.ERROR, "Error", "No data available for the given Patient ID");
            }
        });
    
        Button jun_backBtn = new Button("Back");
        jun_backBtn.setOnAction(e -> jun_createMainUI(stage));  // Add functionality to go back to the main UI
        jun_grid.add(jun_backBtn, 0, 8);  // Place the back button
    
        Scene jun_scene = new Scene(jun_grid, 600, 400);  // Increase width to accommodate the Risk box
        stage.setScene(jun_scene);
        stage.show();
    }
    


    // Utility function to generate a unique 5-digit Patient ID
    private String generatePatientID() {
        return String.valueOf((int) (Math.random() * 90000) + 10000);  // Generate a random 5-digit number
    }

    // Utility function to show an alert message
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// Helper class to store patient data
class PatientData {
    private String patientID;
    private String totalScore;
    private String LM;
    private String LAD;
    private String LCX;
    private String RCA;
    private String PDA;

    public PatientData(String patientID, String totalScore, String LM, String LAD, String LCX, String RCA, String PDA) {
        this.patientID = patientID;
        this.totalScore = totalScore;
        this.LM = LM;
        this.LAD = LAD;
        this.LCX = LCX;
        this.RCA = RCA;
        this.PDA = PDA;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public String getLM() {
        return LM;
    }

    public String getLAD() {
        return LAD;
    }

    public String getLCX() {
        return LCX;
    }

    public String getRCA() {
        return RCA;
    }

    public String getPDA() {
        return PDA;
    }
}
