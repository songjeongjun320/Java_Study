import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class hw1 extends Application {

    // Tax rate set to 7%
    double taxRate = 0.07;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Joe’s Deli");

        // Food selection checkboxes
        CheckBox eggSandwich = new CheckBox("Egg Sandwich ($7.99)");
        CheckBox chickenSandwich = new CheckBox("Chicken Sandwich ($9.99)");
        CheckBox bagel = new CheckBox("Bagel ($2.50)");
        CheckBox potatoSalad = new CheckBox("Potato Salad ($4.49)");

        // Drink selection radio buttons
        ToggleGroup drinksGroup = new ToggleGroup();
        RadioButton blackTea = new RadioButton("Black Tea ($1.25)");
        RadioButton greenTea = new RadioButton("Green Tea ($0.99)");
        RadioButton coffee = new RadioButton("Coffee ($1.99)");
        RadioButton orangeJuice = new RadioButton("Orange Juice ($2.25)");
        blackTea.setToggleGroup(drinksGroup);
        greenTea.setToggleGroup(drinksGroup);
        coffee.setToggleGroup(drinksGroup);
        orangeJuice.setToggleGroup(drinksGroup);

        // Order, Cancel, Confirm buttons
        Button orderButton = new Button("Order");
        Button cancelButton = new Button("Cancel");
        Button confirmButton = new Button("Confirm");

        // Bill display area with "Bill" label
        TextArea billArea = new TextArea("Bill");  // "Bill" label inside the text area
        billArea.setEditable(false);

        // Adding Labels for "Eat" and "Drink" sections
        Label eatLabel = new Label("Eat:");
        Label drinkLabel = new Label("Drink:");
        Label billLabel = new Label("Bill");  // This will be added above the Bill area as a header

        // Layout adjustments
        VBox foodBox = new VBox(10, eggSandwich, chickenSandwich, bagel, potatoSalad);
        VBox drinksBox = new VBox(10, blackTea, greenTea, coffee, orangeJuice);
        VBox eatSection = new VBox(10, eatLabel, foodBox);
        VBox drinkSection = new VBox(10, drinkLabel, drinksBox);
        foodBox.setPrefWidth(150);
        drinksBox.setPrefWidth(150);
        billArea.setPrefWidth(200);

        // Buttons box
        HBox buttonsBox = new HBox(10, orderButton, cancelButton, confirmButton);
        buttonsBox.setPadding(new Insets(10, 0, 0, 0));
        buttonsBox.setAlignment(Pos.CENTER);

        // Title and layout
        Label titleLabel = new Label("Joe's Deli");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        HBox titleBox = new HBox(titleLabel);
        titleBox.setAlignment(Pos.CENTER);  // Center the title

        // Make food, drink, and bill areas flexible
        HBox.setHgrow(eatSection, Priority.ALWAYS);   // Food section grows
        HBox.setHgrow(drinkSection, Priority.ALWAYS); // Drink section grows
        HBox.setHgrow(billArea, Priority.ALWAYS);     // Bill area grows

        // Root layout with centered title
        HBox root = new HBox(20, eatSection, drinkSection, billArea);
        root.setSpacing(20);
        VBox mainLayout = new VBox(10, titleBox, root, buttonsBox);
        mainLayout.setPadding(new Insets(10));

        // Order button action: calculate and display order summary with tax
        orderButton.setOnAction(e -> {
            double subtotal = 0.0;
            StringBuilder orderSummary = new StringBuilder();
            orderSummary.append("Order Summary:\n");

            if (eggSandwich.isSelected()) {
                subtotal += 7.99;
                orderSummary.append("Egg Sandwich: $7.99\n");
            }
            if (chickenSandwich.isSelected()) {
                subtotal += 9.99;
                orderSummary.append("Chicken Sandwich: $9.99\n");
            }
            if (bagel.isSelected()) {
                subtotal += 2.50;
                orderSummary.append("Bagel: $2.50\n");
            }
            if (potatoSalad.isSelected()) {
                subtotal += 4.49;
                orderSummary.append("Potato Salad: $4.49\n");
            }
            // Add selected drink price
            if (blackTea.isSelected()) {
                subtotal += 1.25;
                orderSummary.append("Black Tea: $1.25\n");
            } else if (greenTea.isSelected()) {
                subtotal += 0.99;
                orderSummary.append("Green Tea: $0.99\n");
            } else if (coffee.isSelected()) {
                subtotal += 1.99;
                orderSummary.append("Coffee: $1.99\n");
            } else if (orangeJuice.isSelected()) {
                subtotal += 2.25;
                orderSummary.append("Orange Juice: $2.25\n");
            }

            // Calculate tax and total
            double tax = subtotal * taxRate;
            double total = subtotal + tax;

            // Display subtotal, tax, and total
            orderSummary.append(String.format("Subtotal: $%.2f\n", subtotal));
            orderSummary.append(String.format("Tax: $%.2f\n", tax));
            orderSummary.append(String.format("Total: $%.2f\n", total));

            billArea.setText(orderSummary.toString());
        });

        // Cancel button action: clear all selections and reset the bill area
        cancelButton.setOnAction(e -> {
            eggSandwich.setSelected(false);
            chickenSandwich.setSelected(false);
            bagel.setSelected(false);
            potatoSalad.setSelected(false);
            drinksGroup.selectToggle(null);  // Clear drink selection
            billArea.clear();  // Clear the bill text area
            billArea.setText("Bill");  // Reset Bill label
        });

        // Confirm button action: display final bill and clear selections
        confirmButton.setOnAction(e -> {
            String currentBill = billArea.getText();
            if (!currentBill.isEmpty()) {
                currentBill += "\nOrder Confirmed.";
                billArea.setText(currentBill);
            }
            eggSandwich.setSelected(false);
            chickenSandwich.setSelected(false);
            bagel.setSelected(false);
            potatoSalad.setSelected(false);
            drinksGroup.selectToggle(null);  // Clear drink selection
        });

        // Set up and show the scene
        Scene scene = new Scene(mainLayout, 600, 400);  // Initial width and height
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);  // Allow resizing for flexibility
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
