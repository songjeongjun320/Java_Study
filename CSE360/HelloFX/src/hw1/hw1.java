package CSE360.HelloFX.src.hw1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class hw1 extends Application {

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

        // Bill display area
        TextArea billArea = new TextArea();
        billArea.setEditable(false);

        // Layout settings for Eat and Drink sections
        VBox foodBox = new VBox(10, eggSandwich, chickenSandwich, bagel, potatoSalad);
        foodBox.setPadding(new Insets(10));
        VBox drinkBox = new VBox(10, blackTea, greenTea, coffee, orangeJuice);
        drinkBox.setPadding(new Insets(10));

        // Titles for Eat and Drink sections
        VBox eatBox = new VBox(5, new Label("Eat:"), foodBox);
        VBox drinkBoxWithLabel = new VBox(5, new Label("Drink:"), drinkBox);

        HBox foodAndDrinkBox = new HBox(20, eatBox, drinkBoxWithLabel);
        HBox.setHgrow(eatBox, Priority.ALWAYS);
        HBox.setHgrow(drinkBoxWithLabel, Priority.ALWAYS);

        VBox leftPane = new VBox(10, foodAndDrinkBox);
        VBox.setVgrow(foodAndDrinkBox, Priority.ALWAYS);

        VBox billBox = new VBox(new Label("Bill"), billArea);
        billBox.setPadding(new Insets(10));
        billBox.setPrefSize(200, 150);
        VBox.setVgrow(billArea, Priority.ALWAYS);

        HBox buttonsBox = new HBox(10, orderButton, cancelButton, confirmButton);
        buttonsBox.setPadding(new Insets(10, 0, 5, 0)); // Reduce bottom padding to 5
        buttonsBox.setSpacing(20);
        HBox.setHgrow(orderButton, Priority.ALWAYS);
        HBox.setHgrow(cancelButton, Priority.ALWAYS);
        HBox.setHgrow(confirmButton, Priority.ALWAYS);

        HBox root = new HBox(20, leftPane, billBox);
        HBox.setHgrow(leftPane, Priority.ALWAYS);
        HBox.setHgrow(billBox, Priority.ALWAYS);
        VBox mainLayout = new VBox(10, new Label("Joe’s Deli"), root, buttonsBox);
        mainLayout.setPadding(new Insets(20, 20, 10, 20)); // Reduce bottom padding to 10
        VBox.setVgrow(root, Priority.ALWAYS);

        // Event handler for the Order button
        orderButton.setOnAction(e -> {
            double total = 0;
            StringBuilder orderSummary = new StringBuilder("Order Summary:\n");

            if (eggSandwich.isSelected()) {
                total += 7.99;
                orderSummary.append("Egg Sandwich: $7.99\n");
            }
            if (chickenSandwich.isSelected()) {
                total += 9.99;
                orderSummary.append("Chicken Sandwich: $9.99\n");
            }
            if (bagel.isSelected()) {
                total += 2.50;
                orderSummary.append("Bagel: $2.50\n");
            }
            if (potatoSalad.isSelected()) {
                total += 4.49;
                orderSummary.append("Potato Salad: $4.49\n");
            }

            // Add selected drink to the order
            RadioButton selectedDrink = (RadioButton) drinksGroup.getSelectedToggle();
            if (selectedDrink != null) {
                String drinkText = selectedDrink.getText();
                orderSummary.append(drinkText).append("\n");

                if (selectedDrink == blackTea) total += 1.25;
                else if (selectedDrink == greenTea) total += 0.99;
                else if (selectedDrink == coffee) total += 1.99;
                else if (selectedDrink == orangeJuice) total += 2.25;
            }

            // Add 7% sales tax
            total += total * 0.07;
            orderSummary.append(String.format("Total: $%.2f", total));

            // Display the order summary and total in the bill area
            billArea.setText(orderSummary.toString());
        });

        // Event handler for the Cancel button
        cancelButton.setOnAction(e -> {
            eggSandwich.setSelected(false);
            chickenSandwich.setSelected(false);
            bagel.setSelected(false);
            potatoSalad.setSelected(false);
            drinksGroup.selectToggle(null);
            billArea.clear();
        });

        // Event handler for the Confirm button
        confirmButton.setOnAction(e -> {
            billArea.appendText("\nOrder Confirmed.");
            eggSandwich.setSelected(false);
            chickenSandwich.setSelected(false);
            bagel.setSelected(false);
            potatoSalad.setSelected(false);
            drinksGroup.selectToggle(null);
        });

        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Make the layout responsive
        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            billArea.setPrefWidth(newVal.doubleValue() * 0.4); // Adjust width dynamically
        });

        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            billArea.setPrefHeight(newVal.doubleValue() * 0.5); // Adjust height dynamically
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
