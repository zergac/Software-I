package com.example.demo2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

/**
 * ERROR - one error I had was that on my search bar, I was not able to retrieve the text after clearing the text. I was able to obtain the text by creating
 * a new event handler
 */
/**
 * FUTURE ENHANCEMENT - a future enhancement would be that if the delete button is clicked, a new layout should pop out asking "are you sure you want to delete"
 * with a yes and no button as well
 */
public class HelloApplication extends Application {

    final ObservableList<Part> data = FXCollections.observableArrayList();
    final ObservableList<Product> productData = FXCollections.observableArrayList();
    final ObservableList<Part> addProductData = FXCollections.observableArrayList();
    final ObservableList<Part> modifyProductData = FXCollections.observableArrayList();

    int id = 0;
    int pID = 999;


    @Override
    public void start(Stage stage) throws IOException {
        StackPane layout  = new StackPane();
        Scene scene = new Scene(layout, 1200, 800);


        StackPane addPartLayout = new StackPane();
        Scene sceneAddPart = new Scene(addPartLayout, 600, 600);

        StackPane modifyPartLayout = new StackPane();
        Scene sceneModifyPart = new Scene(modifyPartLayout, 600, 600);

        StackPane addProductLayout = new StackPane();
        Scene sceneAddProduct = new Scene(addProductLayout, 1200, 800);

        StackPane modifyProductLayout = new StackPane();
        Scene sceneModifyProduct = new Scene(modifyProductLayout, 1200, 800);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Can't find item");

        Alert alertMin = new Alert(Alert.AlertType.INFORMATION);
        alertMin.setTitle("Error");
        alertMin.setHeaderText(null);
        alertMin.setContentText("Minimum should be less than Maximum");

        Alert alertInv = new Alert(Alert.AlertType.INFORMATION);
        alertInv.setTitle("Error");
        alertInv.setHeaderText(null);
        alertInv.setContentText("Inventory should be between Min and Max");

        Alert alertText = new Alert(Alert.AlertType.INFORMATION);
        alertText.setTitle("Error");
        alertText.setHeaderText(null);
        alertText.setContentText("Inappropriate data");

        Label title = new Label();
        title.setText("Inventory Management System");
        title.setTranslateY(-350);
        title.setTranslateX(-350);
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 23));

        Label addProductTitle = new Label();
        addProductTitle.setText("Add Product");
        addProductTitle.setTranslateY(-350);
        addProductTitle.setTranslateX(-500);
        addProductTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Label modifyProductTitle = new Label();
        modifyProductTitle.setText("Modify Product");
        modifyProductTitle.setTranslateY(-350);
        modifyProductTitle.setTranslateX(-500);
        modifyProductTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Label titleTableOne = new Label();
        titleTableOne.setText("Parts");
        titleTableOne.setTranslateY(-225);
        titleTableOne.setTranslateX(-525);
        titleTableOne.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Label titleTableProduct = new Label();
        titleTableProduct.setText("Products");
        titleTableProduct.setTranslateY(-225);
        titleTableProduct.setTranslateX(90);
        titleTableProduct.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Label addPartTitle = new Label();
        addPartTitle.setText("Add Part");
        addPartTitle.setTranslateX(-250);
        addPartTitle.setTranslateY(-250);
        addPartTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 13));

        Label addID = new Label();
        addID.setText("ID");
        addID.setTranslateY(-180);
        addID.setTranslateX(-225);

        Label addName = new Label();
        addName.setText("Name");
        addName.setTranslateY(-140);
        addName.setTranslateX(-218);

        Label addInv = new Label();
        addInv.setText("Inv");
        addInv.setTranslateY(-100);
        addInv.setTranslateX(-225);

        Label addPrice = new Label();
        addPrice.setText("Price/Cost");
        addPrice.setTranslateY(-60);
        addPrice.setTranslateX(-208);

        Label addMax = new Label();
        addMax.setText("Max");
        addMax.setTranslateY(-20);
        addMax.setTranslateX(-223);

        Label addMin = new Label();
        addMin.setText("Min");
        addMin.setTranslateY(-20);
        addMin.setTranslateX(10);

        Label addMachine = new Label();
        addMachine.setText("Machine ID");
        addMachine.setTranslateY(20);
        addMachine.setTranslateX(-204);

        Label modifyPartTitle = new Label();
        modifyPartTitle.setText("Modify Part");
        modifyPartTitle.setTranslateX(-250);
        modifyPartTitle.setTranslateY(-250);

        Label modifyID = new Label();
        modifyID.setText("ID");
        modifyID.setTranslateY(-180);
        modifyID.setTranslateX(-225);

        Label modifyName = new Label();
        modifyName.setText("Name");
        modifyName.setTranslateY(-140);
        modifyName.setTranslateX(-218);

        Label modifyInv = new Label();
        modifyInv.setText("Inv");
        modifyInv.setTranslateY(-100);
        modifyInv.setTranslateX(-225);

        Label modifyPrice = new Label();
        modifyPrice.setText("Price/Cost");
        modifyPrice.setTranslateY(-60);
        modifyPrice.setTranslateX(-208);

        Label modifyMax = new Label();
        modifyMax.setText("Max");
        modifyMax.setTranslateY(-20);
        modifyMax.setTranslateX(-223);

        Label modifyMin = new Label();
        modifyMin.setText("Min");
        modifyMin.setTranslateY(-20);
        modifyMin.setTranslateX(10);

        Label modifyMachine = new Label();
        modifyMachine.setText("Machine ID");
        modifyMachine.setTranslateY(20);
        modifyMachine.setTranslateX(-204);

        Label addIDProduct = new Label();
        addIDProduct.setText("ID");
        addIDProduct.setTranslateY(-180);
        addIDProduct.setTranslateX(-525);

        Label addNameProduct = new Label();
        addNameProduct.setText("Name");
        addNameProduct.setTranslateY(-140);
        addNameProduct.setTranslateX(-518);

        Label addInvProduct = new Label();
        addInvProduct.setText("Inv");
        addInvProduct.setTranslateY(-100);
        addInvProduct.setTranslateX(-525);

        Label addPriceProduct = new Label();
        addPriceProduct.setText("Price");
        addPriceProduct.setTranslateY(-60);
        addPriceProduct.setTranslateX(-520);

        Label addMaxProduct = new Label();
        addMaxProduct.setText("Max");
        addMaxProduct.setTranslateY(-20);
        addMaxProduct.setTranslateX(-523);

        Label addMinProduct = new Label();
        addMinProduct.setText("Min");
        addMinProduct.setTranslateY(-20);
        addMinProduct.setTranslateX(-325);

        Label modifyIDProduct = new Label();
        modifyIDProduct.setText("ID");
        modifyIDProduct.setTranslateY(-180);
        modifyIDProduct.setTranslateX(-525);

        Label modifyNameProduct = new Label();
        modifyNameProduct.setText("Name");
        modifyNameProduct.setTranslateY(-140);
        modifyNameProduct.setTranslateX(-518);

        Label modifyInvProduct = new Label();
        modifyInvProduct.setText("Inv");
        modifyInvProduct.setTranslateY(-100);
        modifyInvProduct.setTranslateX(-525);

        Label modifyPriceProduct = new Label();
        modifyPriceProduct.setText("Price");
        modifyPriceProduct.setTranslateY(-60);
        modifyPriceProduct.setTranslateX(-520);

        Label modifyMaxProduct = new Label();
        modifyMaxProduct.setText("Max");
        modifyMaxProduct.setTranslateY(-20);
        modifyMaxProduct.setTranslateX(-523);

        Label modifyMinProduct = new Label();
        modifyMinProduct.setText("Min");
        modifyMinProduct.setTranslateY(-20);
        modifyMinProduct.setTranslateX(-325);

        TextField idText = new TextField();
        idText.setText("Auto-Gen Disabled");
        idText.setDisable(true);
        idText.setTranslateY(-180);
        idText.setTranslateX(-100);
        idText.setMaxWidth(100.00);

        TextField nameText = new TextField();
        nameText.setTranslateY(-140);
        nameText.setTranslateX(-100);
        nameText.setMaxWidth(100.00);

        TextField invText = new TextField();
        invText.setTranslateY(-100);
        invText.setTranslateX(-100);
        invText.setMaxWidth(100.00);

        TextField priceText = new TextField();
        priceText.setTranslateY(-60);
        priceText.setTranslateX(-100);
        priceText.setMaxWidth(100.00);

        TextField maxText = new TextField();
        maxText.setTranslateY(-20);
        maxText.setTranslateX(-100);
        maxText.setMaxWidth(100.00);

        TextField minText = new TextField();
        minText.setTranslateY(-20);
        minText.setTranslateX(90);
        minText.setMaxWidth(100.00);

        TextField machineText = new TextField();
        machineText.setTranslateY(20);
        machineText.setTranslateX(-100);
        machineText.setMaxWidth(100.00);

        TextField modifyIDText = new TextField();
        modifyIDText.setText("Auto-Gen Disabled");
        modifyIDText.setDisable(true);
        modifyIDText.setTranslateY(-180);
        modifyIDText.setTranslateX(-100);
        modifyIDText.setMaxWidth(100.00);

        TextField modifyNameText = new TextField();
        modifyNameText.setTranslateY(-140);
        modifyNameText.setTranslateX(-100);
        modifyNameText.setMaxWidth(100.00);

        TextField modifyInvText = new TextField();
        modifyInvText.setTranslateY(-100);
        modifyInvText.setTranslateX(-100);
        modifyInvText.setMaxWidth(100.00);

        TextField modifyPriceText = new TextField();
        modifyPriceText.setTranslateY(-60);
        modifyPriceText.setTranslateX(-100);
        modifyPriceText.setMaxWidth(100.00);

        TextField modifyMaxText = new TextField();
        modifyMaxText.setTranslateY(-20);
        modifyMaxText.setTranslateX(-100);
        modifyMaxText.setMaxWidth(100.00);

        TextField modifyMinText = new TextField();
        modifyMinText.setTranslateY(-20);
        modifyMinText.setTranslateX(90);
        modifyMinText.setMaxWidth(100.00);

        TextField modifyMachineText = new TextField();
        modifyMachineText.setTranslateY(20);
        modifyMachineText.setTranslateX(-100);
        modifyMachineText.setMaxWidth(100.00);

        TextField idTextProduct = new TextField();
        idTextProduct.setText("Auto-Gen Disabled");
        idTextProduct.setDisable(true);
        idTextProduct.setTranslateY(-180);
        idTextProduct.setTranslateX(-375);
        idTextProduct.setMaxWidth(200.00);

        TextField nameTextProduct = new TextField();
        nameTextProduct.setTranslateY(-140);
        nameTextProduct.setTranslateX(-375);
        nameTextProduct.setMaxWidth(200.00);

        TextField invTextProduct = new TextField();
        invTextProduct.setTranslateY(-100);
        invTextProduct.setTranslateX(-425);
        invTextProduct.setMaxWidth(100.00);

        TextField priceTextProduct = new TextField();
        priceTextProduct.setTranslateY(-60);
        priceTextProduct.setTranslateX(-425);
        priceTextProduct.setMaxWidth(100.00);

        TextField maxTextProduct = new TextField();
        maxTextProduct.setTranslateY(-20);
        maxTextProduct.setTranslateX(-425);
        maxTextProduct.setMaxWidth(100.00);

        TextField minTextProduct = new TextField();
        minTextProduct.setTranslateY(-20);
        minTextProduct.setTranslateX(-250);
        minTextProduct.setMaxWidth(100.00);

        TextField idTextModifyProduct = new TextField();
        idTextModifyProduct.setText("Auto-Gen Disabled");
        idTextModifyProduct.setDisable(true);
        idTextModifyProduct.setTranslateY(-180);
        idTextModifyProduct.setTranslateX(-375);
        idTextModifyProduct.setMaxWidth(200.00);

        TextField nameModifyTextProduct = new TextField();
        nameModifyTextProduct.setTranslateY(-140);
        nameModifyTextProduct.setTranslateX(-375);
        nameModifyTextProduct.setMaxWidth(200.00);

        TextField invModifyTextProduct = new TextField();
        invModifyTextProduct.setTranslateY(-100);
        invModifyTextProduct.setTranslateX(-425);
        invModifyTextProduct.setMaxWidth(100.00);

        TextField priceModifyTextProduct = new TextField();
        priceModifyTextProduct.setTranslateY(-60);
        priceModifyTextProduct.setTranslateX(-425);
        priceModifyTextProduct.setMaxWidth(100.00);

        TextField maxModifyTextProduct = new TextField();
        maxModifyTextProduct.setTranslateY(-20);
        maxModifyTextProduct.setTranslateX(-425);
        maxModifyTextProduct.setMaxWidth(100.00);

        TextField minModifyTextProduct = new TextField();
        minModifyTextProduct.setTranslateY(-20);
        minModifyTextProduct.setTranslateX(-250);
        minModifyTextProduct.setMaxWidth(100.00);

        Button exitButton = new Button();
        exitButton.setText("Exit");
        exitButton.setTranslateX(500);
        exitButton.setTranslateY(300);
        exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Platform.exit();
            }
        });

        RadioButton modifyInHouse = new RadioButton();
        modifyInHouse.setText("In-House");
        modifyInHouse.setTranslateX(-125);
        modifyInHouse.setTranslateY(-250);

        RadioButton modifyOutsourced = new RadioButton();
        modifyOutsourced.setText("Outsourced");
        modifyOutsourced.setTranslateX(50);
        modifyOutsourced.setTranslateY(-250);
        modifyOutsourced.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                modifyInHouse.setSelected(false);
                modifyOutsourced.setSelected(true);
                modifyMachine.setText("Company Name");
            }
        });

        modifyInHouse.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                modifyOutsourced.setSelected(false);
                modifyMachine.setText("Machine ID");
            }
        });

        RadioButton inHouse = new RadioButton();
        inHouse.setText("In-House");
        inHouse.setTranslateX(-125);
        inHouse.setTranslateY(-250);
        inHouse.setSelected(true);

        RadioButton outsourced = new RadioButton();
        outsourced.setText("Outsourced");
        outsourced.setTranslateX(50);
        outsourced.setTranslateY(-250);
        outsourced.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                inHouse.setSelected(false);
                outsourced.setSelected(true);
                addMachine.setText("Company Name");
            }
        });

        inHouse.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                outsourced.setSelected(false);
                addMachine.setText("Machine ID");
            }
        });


        TableView tableOne = new TableView();
        tableOne.setMaxSize(500.00, 400.00);
        tableOne.setTranslateX(-300);
        TableColumn partIDCol = new TableColumn("Part ID");
        partIDCol.setCellValueFactory(new PropertyValueFactory<Part,Integer>("id"));
        TableColumn partNameCol = new TableColumn("Part Name");
        partNameCol.setCellValueFactory(new PropertyValueFactory<Part,String>("name"));
        TableColumn inventoryCol = new TableColumn("Inventory Level");
        inventoryCol.setCellValueFactory(new PropertyValueFactory<Part,Integer>("stock"));
        TableColumn priceCol = new TableColumn("Price/ Cost per Unit");
        priceCol.setCellValueFactory(new PropertyValueFactory<Part,Integer>("price"));

        tableOne.getColumns().addAll(partIDCol, partNameCol, inventoryCol, priceCol);

        tableOne.setItems(data);



        TableView tableProduct = new TableView();
        tableProduct.setMaxSize(500.00, 400.00);
        tableProduct.setTranslateX(300);
        TableColumn productIDCol = new TableColumn("Product ID");
        productIDCol.setCellValueFactory(new PropertyValueFactory<Product,Integer>("id"));
        TableColumn productNameCol = new TableColumn("Product Name");
        productNameCol.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
        TableColumn inventoryProductCol = new TableColumn("Inventory Level");
        inventoryProductCol.setCellValueFactory(new PropertyValueFactory<Product,Integer>("stock"));
        TableColumn priceProductCol = new TableColumn("Price/ Cost per Unit");
        priceProductCol.setCellValueFactory(new PropertyValueFactory<Product,Integer>("price"));

        tableProduct.getColumns().addAll(productIDCol, productNameCol, inventoryProductCol, priceProductCol);

        tableProduct.setItems(productData);



        TableView tableOneProduct = new TableView();
        tableOneProduct.setMaxSize(500.00, 200.00);
        tableOneProduct.setTranslateX(300);
        tableOneProduct.setTranslateY(-200);
        TableColumn AddProductIDCol = new TableColumn("Part ID");
        AddProductIDCol.setCellValueFactory(new PropertyValueFactory<Part,Integer>("id"));
        TableColumn addProductNameCol = new TableColumn("Part Name");
        addProductNameCol.setCellValueFactory(new PropertyValueFactory<Part,String>("name"));
        TableColumn addProductInventoryCol = new TableColumn("Inventory Level");
        addProductInventoryCol.setCellValueFactory(new PropertyValueFactory<Part,Integer>("stock"));
        TableColumn addProductPriceCol = new TableColumn("Price/ Cost per Unit");
        addProductPriceCol.setCellValueFactory(new PropertyValueFactory<Part,Integer>("price"));

        tableOneProduct.getColumns().addAll(AddProductIDCol, addProductNameCol, addProductInventoryCol, addProductPriceCol);

        tableOneProduct.setItems(data);



        TableView tableTwoProduct = new TableView();
        tableTwoProduct.setMaxSize(500.00, 200.00);
        tableTwoProduct.setTranslateX(300);
        tableTwoProduct.setTranslateY(125);
        TableColumn addProductIDColTwo = new TableColumn("Part ID");
        addProductIDColTwo.setCellValueFactory(new PropertyValueFactory<Part,Integer>("id"));
        TableColumn addProductNameColTwo = new TableColumn("Part Name");
        addProductNameColTwo.setCellValueFactory(new PropertyValueFactory<Part,String>("name"));
        TableColumn addProductInventoryColTwo = new TableColumn("Inventory Level");
        addProductInventoryColTwo.setCellValueFactory(new PropertyValueFactory<Part,Integer>("stock"));
        TableColumn addProductPriceColTwo = new TableColumn("Price/ Cost per Unit");
        addProductPriceColTwo.setCellValueFactory(new PropertyValueFactory<Part,Integer>("price"));

        tableTwoProduct.getColumns().addAll(addProductIDColTwo, addProductNameColTwo, addProductInventoryColTwo, addProductPriceColTwo);

        tableTwoProduct.setItems(addProductData);



        TableView tableOneModifyProduct = new TableView();
        tableOneModifyProduct.setMaxSize(500.00, 200.00);
        tableOneModifyProduct.setTranslateX(300);
        tableOneModifyProduct.setTranslateY(-200);
        TableColumn ModifyProductIDCol = new TableColumn("Part ID");
        ModifyProductIDCol.setCellValueFactory(new PropertyValueFactory<Part,Integer>("id"));
        TableColumn ModifyProductNameCol = new TableColumn("Part Name");
        ModifyProductNameCol.setCellValueFactory(new PropertyValueFactory<Part,String>("name"));
        TableColumn ModifyProductInventoryCol = new TableColumn("Inventory Level");
        ModifyProductInventoryCol.setCellValueFactory(new PropertyValueFactory<Part,Integer>("stock"));
        TableColumn ModifyProductPriceCol = new TableColumn("Price/ Cost per Unit");
        ModifyProductPriceCol.setCellValueFactory(new PropertyValueFactory<Part,Integer>("price"));

        tableOneModifyProduct.getColumns().addAll(ModifyProductIDCol, ModifyProductNameCol, ModifyProductInventoryCol, ModifyProductPriceCol);

        tableOneModifyProduct.setItems(data);



        TableView tableTwoModifyProduct = new TableView();
        tableTwoModifyProduct.setMaxSize(500.00, 200.00);
        tableTwoModifyProduct.setTranslateX(300);
        tableTwoModifyProduct.setTranslateY(125);
        TableColumn modifyProductIDColTwo = new TableColumn("Part ID");
        modifyProductIDColTwo.setCellValueFactory(new PropertyValueFactory<Part,Integer>("id"));
        TableColumn modifyProductNameColTwo = new TableColumn("Part Name");
        modifyProductNameColTwo.setCellValueFactory(new PropertyValueFactory<Part,String>("name"));
        TableColumn modifyProductInventoryColTwo = new TableColumn("Inventory Level");
        modifyProductInventoryColTwo.setCellValueFactory(new PropertyValueFactory<Part,Integer>("stock"));
        TableColumn modifyProductPriceColTwo = new TableColumn("Price/ Cost per Unit");
        modifyProductPriceColTwo.setCellValueFactory(new PropertyValueFactory<Part,Integer>("price"));

        tableTwoModifyProduct.getColumns().addAll(modifyProductIDColTwo, modifyProductNameColTwo, modifyProductInventoryColTwo, modifyProductPriceColTwo);

        tableTwoModifyProduct.setItems(modifyProductData);



        Button deletePartButton = new Button();
        deletePartButton.setText("Delete");
        deletePartButton.setTranslateY(225);
        deletePartButton.setTranslateX(-125);
        deletePartButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                tableOne.getItems().removeAll(tableOne.getSelectionModel().getSelectedItem());

            }
        });

        Button deleteProductButton = new Button();
        deleteProductButton.setText("Delete");
        deleteProductButton.setTranslateY(225);
        deleteProductButton.setTranslateX(475);
        deleteProductButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                tableProduct.getItems().removeAll(tableProduct.getSelectionModel().getSelectedItem());
            }
        });

        Button saveAddPart = new Button();
        saveAddPart.setText("Save");
        saveAddPart.setTranslateX(5);
        saveAddPart.setTranslateY(75);
        saveAddPart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (inHouse.isSelected()) {
                    id = id + 1;
                    String name = nameText.getText();
                    int min = Integer.parseInt(minText.getText());
                    int max = Integer.parseInt(maxText.getText());
                    int machineID = Integer.parseInt(machineText.getText());
                    int inventory = 0;
                    double price = 0;

                    String inv = invText.getText();
                    String pri = priceText.getText();
                    boolean isInv = isNum(inv);
                    boolean isPri = isNum(pri);

                    if (!isInv){
                        alertText.showAndWait();
                    }

                    else {
                        inventory = Integer.parseInt(invText.getText());
                    }

                    if (!isPri){
                        alertText.showAndWait();
                    }

                    else {
                        price = Double.parseDouble(priceText.getText());
                    }

                    if (min > max){
                        alertMin.showAndWait();
                    }

                    if (inventory > max || inventory < min){
                        alertInv.showAndWait();
                    }

                    else {
                        Part inh = new InHouse(id, name, inventory, price, min, max, machineID);

                        data.add(inh);

                        tableOne.setItems(data);

                        nameText.clear();
                        invText.clear();
                        priceText.clear();
                        maxText.clear();
                        minText.clear();
                        machineText.clear();

                        stage.setScene(scene);
                        stage.centerOnScreen();
                    }
                }

                else if (outsourced.isSelected()){
                    id = id + 1;
                    String name = nameText.getText();
                    int min = Integer.parseInt(minText.getText());
                    int max = Integer.parseInt(maxText.getText());
                    String compName = machineText.getText();
                    int inventory = 0;
                    double price = 0;

                    String inv = invText.getText();
                    String pri = priceText.getText();
                    boolean isInv = isNum(inv);
                    boolean isPri = isNum(pri);

                    if (!isInv){
                        alertText.showAndWait();
                    }

                    else {
                        inventory = Integer.parseInt(invText.getText());
                    }

                    if (!isPri){
                        alertText.showAndWait();
                    }

                    else {
                        price = Double.parseDouble(priceText.getText());
                    }

                    if (min > max){
                        alertMin.showAndWait();
                    }

                    if (inventory > max || inventory < min){
                        alertInv.showAndWait();
                    }

                    else {
                        Part out = new Outsourced(id, name, inventory, price, min, max, compName);

                        data.add(out);

                        tableOne.setItems(data);

                        nameText.clear();
                        invText.clear();
                        priceText.clear();
                        maxText.clear();
                        minText.clear();
                        machineText.clear();

                        stage.setScene(scene);
                        stage.centerOnScreen();
                    }
                }
            }
        });

        Button cancelAddPart = new Button();
        cancelAddPart.setText("Cancel");
        cancelAddPart.setTranslateX(75);
        cancelAddPart.setTranslateY(75);
        cancelAddPart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                nameText.clear();
                invText.clear();
                priceText.clear();
                maxText.clear();
                minText.clear();
                machineText.clear();
                stage.setScene(scene);
                stage.centerOnScreen();
            }
        });

        addPartLayout.getChildren().addAll(addPartTitle, inHouse, outsourced, addID, addName, addInv, addPrice, addMax, addMin, addMachine, idText,
                nameText, invText, priceText, maxText, minText, machineText, saveAddPart, cancelAddPart);

        Button addButtonOne = new Button();
        addButtonOne.setText("Add");
        addButtonOne.setTranslateY(225);
        addButtonOne.setTranslateX(-250);
        addButtonOne.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setScene(sceneAddPart);
                stage.centerOnScreen();

            }
        });

        Button addButtonProductMain = new Button();
        addButtonProductMain.setText("Add");
        addButtonProductMain.setTranslateY(225);
        addButtonProductMain.setTranslateX(350);
        addButtonProductMain.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setScene(sceneAddProduct);
                stage.centerOnScreen();

                tableTwoProduct.getItems().clear();
            }
        });

        Button removeButtonAddProduct = new Button();
        removeButtonAddProduct.setText("Remove Associated Part");
        removeButtonAddProduct.setTranslateY(275);
        removeButtonAddProduct.setTranslateX(450);
        removeButtonAddProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                tableTwoProduct.getItems().removeAll(tableTwoProduct.getSelectionModel().getSelectedItem());
            }
        });

        Button removeButtonModifyProduct = new Button();
        removeButtonModifyProduct.setText("Remove Associated Part");
        removeButtonModifyProduct.setTranslateY(275);
        removeButtonModifyProduct.setTranslateX(450);
        removeButtonModifyProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                tableTwoModifyProduct.getItems().removeAll(tableTwoModifyProduct.getSelectionModel().getSelectedItem());
            }
        });

        Button addButtonAddProduct = new Button();
        addButtonAddProduct.setText("Add");
        addButtonAddProduct.setTranslateY(-50);
        addButtonAddProduct.setTranslateX(500);
        addButtonAddProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ObservableList<Part> p;
                p = tableOneProduct.getSelectionModel().getSelectedItems();
                addProductData.add(p.get(0));

                tableTwoProduct.setItems(addProductData);
            }
        });

        Button saveButtonAddProduct = new Button();
        saveButtonAddProduct.setText("Save");
        saveButtonAddProduct.setTranslateY(325);
        saveButtonAddProduct.setTranslateX(400);
        saveButtonAddProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pID = pID + 1;
                String name = nameTextProduct.getText();
                int min = Integer.parseInt(minTextProduct.getText());
                int max = Integer.parseInt(maxTextProduct.getText());
                int inventory = 0;
                double price = 0;

                String inv = invTextProduct.getText();
                String pri = priceTextProduct.getText();
                boolean isInv = isNum(inv);
                boolean isPri = isNum(pri);

                if (!isInv){
                    alertText.showAndWait();
                }

                else {
                    inventory = Integer.parseInt(invTextProduct.getText());
                }

                if (!isPri){
                    alertText.showAndWait();
                }

                else {
                    price = Double.parseDouble(priceTextProduct.getText());
                }

                if (min > max){
                    alertMin.showAndWait();
                }

                if (inventory > max || inventory < min){
                    alertInv.showAndWait();
                }

                else {
                    Product p = new Product(pID, name, inventory, price, min, max);
                    productData.add(p);

                    for (int i = 0; i < addProductData.size(); i++) {
                        Part part = addProductData.get(i);
                        p.setAssociatedPart(part);
                    }

                    tableProduct.setItems(productData);

                    nameTextProduct.clear();
                    invTextProduct.clear();
                    priceTextProduct.clear();
                    maxTextProduct.clear();
                    minTextProduct.clear();

                    stage.setScene(scene);
                    stage.centerOnScreen();
                }
            }
        });

        Button addButtonModifyProduct = new Button();
        addButtonModifyProduct.setText("Add");
        addButtonModifyProduct.setTranslateY(-50);
        addButtonModifyProduct.setTranslateX(500);
        addButtonModifyProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                ObservableList<Part> p;
                p = tableOneModifyProduct.getSelectionModel().getSelectedItems();
                modifyProductData.add(p.get(0));


                tableTwoModifyProduct.setItems(modifyProductData);
            }
        });

        Button saveButtonModifyProduct = new Button();
        saveButtonModifyProduct.setText("Save");
        saveButtonModifyProduct.setTranslateY(325);
        saveButtonModifyProduct.setTranslateX(400);
        saveButtonModifyProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ObservableList<Product> products = tableProduct.getSelectionModel().getSelectedItems();
                Product p  = products.get(0);
                p.setName(nameModifyTextProduct.getText());
                p.setMax(Integer.parseInt(maxModifyTextProduct.getText()));
                p.setMin(Integer.parseInt(minModifyTextProduct.getText()));

                String inv = invModifyTextProduct.getText();
                String pri = priceModifyTextProduct.getText();
                boolean isInv = isNum(inv);
                boolean isPri = isNum(pri);

                if (!isInv){
                    alertText.showAndWait();
                }

                else {
                    p.setStock(Integer.parseInt(invModifyTextProduct.getText()));
                }

                if (!isPri){
                    alertText.showAndWait();
                }

                else {
                    p.setPrice(Double.parseDouble(priceModifyTextProduct.getText()));
                }

                if (p.getMin() > p.getMax()){
                    alertMin.showAndWait();
                }

                if (p.getStock() > p.getMax() || p.getStock() < p.getMin()){
                    alertInv.showAndWait();
                }

                else {
                    int num = p.getId();
                    for (int i = 0; i < productData.size(); i++) {
                        Product pro = productData.get(i);
                        if (pro.getId() == num) {
                            productData.set(i, pro);
                        }
                    }

                    ObservableList<Part> partList = p.getAllAssociatedParts();
                    for (int i = 0; i < partList.size(); i++) {
                        p.deleteAssociatedPart(partList.get(i));
                    }

                    for (int i = 0; i < modifyProductData.size(); i++) {
                        Part part = modifyProductData.get(i);
                        p.setAssociatedPart(part);
                    }

                    tableProduct.setItems(productData);

                    nameTextProduct.clear();
                    invTextProduct.clear();
                    priceTextProduct.clear();
                    maxTextProduct.clear();
                    minTextProduct.clear();

                    stage.setScene(scene);
                    stage.centerOnScreen();
                }
            }
        });

        Button cancelButtonAddProduct = new Button();
        cancelButtonAddProduct.setText("Cancel");
        cancelButtonAddProduct.setTranslateY(325);
        cancelButtonAddProduct.setTranslateX(500);
        cancelButtonAddProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setScene(scene);
                stage.centerOnScreen();
            }
        });

        Button cancelButtonModifyProduct = new Button();
        cancelButtonModifyProduct.setText("Cancel");
        cancelButtonModifyProduct.setTranslateY(325);
        cancelButtonModifyProduct.setTranslateX(500);
        cancelButtonModifyProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setScene(scene);
                stage.centerOnScreen();
            }
        });

        Button modifyPartButton = new Button();
        modifyPartButton.setText("Modify");
        modifyPartButton.setTranslateY(225);
        modifyPartButton.setTranslateX(-190);
        modifyPartButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ObservableList<Part> lista = tableOne.getSelectionModel().getSelectedItems();
                Class a = lista.get(0).getClass();


                if (a == InHouse.class) {
                    ObservableList<InHouse> inH = tableOne.getSelectionModel().getSelectedItems();
                    InHouse ihSelected = inH.get(0);
                    modifyInHouse.setSelected(true);

                    String s = String.valueOf(ihSelected.getId());
                    modifyIDText.setText(s);
                    String name = ihSelected.getName();
                    modifyNameText.setText(name);
                    String i = String.valueOf(ihSelected.getStock());
                    modifyInvText.setText(i);
                    String p = String.valueOf(ihSelected.getPrice());
                    modifyPriceText.setText(p);
                    String max = String.valueOf(ihSelected.getMax());
                    modifyMaxText.setText(max);
                    String min = String.valueOf(ihSelected.getMin());
                    modifyMinText.setText(min);
                    String mID = String.valueOf(ihSelected.getMachineId());
                    modifyMachineText.setText(mID);

                } else {
                    ObservableList<Outsourced> out = tableOne.getSelectionModel().getSelectedItems();
                    Outsourced outSelected = out.get(0);
                    modifyOutsourced.setSelected(true);
                    modifyInHouse.setSelected(false);
                    modifyMachineText.setText("Company Name");

                    String s = String.valueOf(outSelected.getId());
                    modifyIDText.setText(s);
                    String name = outSelected.getName();
                    modifyNameText.setText(name);
                    String i = String.valueOf(outSelected.getStock());
                    modifyInvText.setText(i);
                    String p = String.valueOf(outSelected.getPrice());
                    modifyPriceText.setText(p);
                    String max = String.valueOf(outSelected.getMax());
                    modifyMaxText.setText(max);
                    String min = String.valueOf(outSelected.getMin());
                    modifyMinText.setText(min);
                    String cName = outSelected.getCompanyName();
                    modifyMachineText.setText(cName);
                }

                stage.setScene(sceneModifyPart);
                stage.centerOnScreen();

            }

        });

        Button modifyProductButton = new Button();
        modifyProductButton.setText("Modify");
        modifyProductButton.setTranslateY(225);
        modifyProductButton.setTranslateX(410);
        modifyProductButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                ObservableList<Product> modProduct = tableProduct.getSelectionModel().getSelectedItems();
                Product modSelected = modProduct.get(0);

                String s = String.valueOf(modSelected.getId());
                idTextModifyProduct.setText(s);
                String name = modSelected.getName();
                nameModifyTextProduct.setText(name);
                String i = String.valueOf(modSelected.getStock());
                invModifyTextProduct.setText(i);
                String p = String.valueOf(modSelected.getPrice());
                priceModifyTextProduct.setText(p);
                String max = String.valueOf(modSelected.getMax());
                maxModifyTextProduct.setText(max);
                String min = String.valueOf(modSelected.getMin());
                minModifyTextProduct.setText(min);

                tableTwoModifyProduct.setItems(modSelected.getAllAssociatedParts());

                stage.setScene(sceneModifyProduct);
                stage.centerOnScreen();
            }
        });

        TextField searchModifyProduct = new TextField();
        searchModifyProduct.setText("Search by Part Name");
        searchModifyProduct.setMaxWidth(200.00);
        searchModifyProduct.setTranslateY(-350);
        searchModifyProduct.setTranslateX(450);
        searchModifyProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                searchModifyProduct.setText("");

            }
        });

        searchModifyProduct.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if ((keyCode == keyCode.ENTER)){
                String search = searchModifyProduct.getText();
                search = search.toLowerCase();
                ObservableList<Part> other = FXCollections.observableArrayList();

                boolean isAvailable = false;
                for (int i = 0; i < data.size(); i++){
                    Part p = data.get(i);
                    String name = p.getName();
                    name = name.toLowerCase();
                    if (name.equals(search)){
                        other.add(p);
                        isAvailable = true;
                        break;
                    }
                }

                if (searchModifyProduct.getText().equals("")){
                    tableOneModifyProduct.setItems(data);
                }

                else if (isAvailable == false) {
                    alert.showAndWait();
                }

                else{
                    tableOneModifyProduct.setItems(other);
                }
            }
        });

        modifyProductLayout.getChildren().addAll(modifyProductTitle, modifyIDProduct, modifyNameProduct, modifyInvProduct, modifyPriceProduct, modifyMinProduct,
                modifyMaxProduct, idTextModifyProduct, nameModifyTextProduct, priceModifyTextProduct, invModifyTextProduct, minModifyTextProduct,
                maxModifyTextProduct, searchModifyProduct, tableOneModifyProduct, addButtonModifyProduct, tableTwoModifyProduct, removeButtonModifyProduct,
                saveButtonModifyProduct, cancelButtonModifyProduct);

        Button saveModifyPart = new Button();
        saveModifyPart.setText("Save");
        saveModifyPart.setTranslateX(5);
        saveModifyPart.setTranslateY(75);
        saveModifyPart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ObservableList<Part> lista = tableOne.getSelectionModel().getSelectedItems();
                Class a = lista.get(0).getClass();

                if (modifyInHouse.isSelected() && a == InHouse.class) {
                    ObservableList<InHouse> inH = tableOne.getSelectionModel().getSelectedItems();
                    InHouse ihSelected = inH.get(0);
                    //id = id + 1;
                    ihSelected.setName(modifyNameText.getText());
                    ihSelected.setMax(Integer.parseInt(modifyMaxText.getText()));
                    ihSelected.setMin(Integer.parseInt(modifyMinText.getText()));
                    ihSelected.setMachineId(Integer.parseInt(modifyMachineText.getText()));

                    String inv = modifyInvText.getText();
                    String pri = modifyPriceText.getText();
                    boolean isInv = isNum(inv);
                    boolean isPri = isNum(pri);

                    if (!isInv){
                        alertText.showAndWait();
                    }

                    else {
                        ihSelected.setStock(Integer.parseInt(modifyInvText.getText()));
                    }

                    if (!isPri){
                        alertText.showAndWait();
                    }

                    else {
                        ihSelected.setPrice(Double.parseDouble(modifyPriceText.getText()));
                    }

                    if (ihSelected.getMin() > ihSelected.getMax()){
                        alertMin.showAndWait();
                    }

                    if(ihSelected.getStock() > ihSelected.getMax() || ihSelected.getStock() < ihSelected.getMin()){
                        alertInv.showAndWait();
                    }

                    else {
                        int num = ihSelected.getId();
                        for (int i = 0; i < data.size(); i++) {
                            Part p = data.get(i);
                            if (p.getId() == num) {
                                data.set(i, ihSelected);
                            }
                        }

                        tableOne.setItems(data);

                        stage.setScene(scene);
                        stage.centerOnScreen();
                    }
                }

                else if (modifyInHouse.isSelected() && a == Outsourced.class) {

                    int id = Integer.parseInt(modifyIDText.getText());
                    String name = modifyNameText.getText();
                    int min = Integer.parseInt(modifyMinText.getText());
                    int max = Integer.parseInt(modifyMaxText.getText());
                    int machineID = Integer.parseInt(modifyMachineText.getText());
                    int inventory = 0;
                    double price = 0;

                    String inv = modifyInvText.getText();
                    String pri = modifyPriceText.getText();
                    boolean isInv = isNum(inv);
                    boolean isPri = isNum(pri);

                    if (!isInv){
                        alertText.showAndWait();
                    }

                    else {
                        inventory = Integer.parseInt(modifyInvText.getText());;
                    }

                    if (!isPri){
                        alertText.showAndWait();
                    }

                    else {
                        price = Double.parseDouble(modifyPriceText.getText());
                    }

                    if(min > max){
                        alertMin.showAndWait();
                    }

                    if (inventory > max || inventory < min){
                        alertInv.showAndWait();
                    }

                    else {
                        Part inh = new InHouse(id, name, inventory, price, min, max, machineID);

                        int num = inh.getId();
                        for (int i = 0; i < data.size(); i++) {
                            Part p = data.get(i);
                            if (p.getId() == num) {
                                data.set(i, inh);
                            }
                        }

                        tableOne.setItems(data);

                        stage.setScene(scene);
                        stage.centerOnScreen();
                    }
                }

                else if (modifyOutsourced.isSelected() && a == Outsourced.class){
                    ObservableList<Outsourced> out = tableOne.getSelectionModel().getSelectedItems();
                    Outsourced outSelected = out.get(0);
                    //id = id + 1;
                    outSelected.setName(modifyNameText.getText());
                    outSelected.setMax(Integer.parseInt(modifyMaxText.getText()));
                    outSelected.setMin(Integer.parseInt(modifyMinText.getText()));
                    outSelected.setCompanyName(modifyMachineText.getText());

                    String inv = modifyInvText.getText();
                    String pri = modifyPriceText.getText();
                    boolean isInv = isNum(inv);
                    boolean isPri = isNum(pri);

                    if (!isInv){
                        alertText.showAndWait();
                    }

                    else {
                        outSelected.setStock(Integer.parseInt(modifyInvText.getText()));
                    }

                    if (!isPri){
                        alertText.showAndWait();
                    }

                    else {
                        outSelected.setPrice(Double.parseDouble(modifyPriceText.getText()));
                    }

                    if(outSelected.getMin() > outSelected.getMax()){
                        alertMin.showAndWait();
                    }

                    if (outSelected.getStock() > outSelected.getMax() || outSelected.getStock() < outSelected.getMin()){
                        alertInv.showAndWait();
                    }

                    else {
                        int num = outSelected.getId();
                        for (int i = 0; i < data.size(); i++) {
                            Part p = data.get(i);
                            if (p.getId() == num) {
                                data.set(i, outSelected);
                            }
                        }

                        tableOne.setItems(data);

                        stage.setScene(scene);
                        stage.centerOnScreen();
                    }
                }

                else{
                    int id = Integer.parseInt(modifyIDText.getText());
                    String name = modifyNameText.getText();
                    int min = Integer.parseInt(modifyMinText.getText());
                    int max = Integer.parseInt(modifyMaxText.getText());
                    String compName = modifyMachineText.getText();
                    int inventory = 0;
                    double price = 0;

                    String inv = modifyInvText.getText();
                    String pri = modifyPriceText.getText();
                    boolean isInv = isNum(inv);
                    boolean isPri = isNum(pri);

                    if (!isInv){
                        alertText.showAndWait();
                    }

                    else {
                        inventory =  Integer.parseInt(modifyInvText.getText());
                    }

                    if (!isPri){
                        alertText.showAndWait();
                    }

                    else {
                        price = Double.parseDouble(modifyPriceText.getText());
                    }

                    if(min > max){
                        alertMin.showAndWait();
                    }

                    if (inventory > max || inventory < min){
                        alertInv.showAndWait();
                    }

                    else {
                        Part outh = new Outsourced(id, name, inventory, price, min, max, compName);

                        int num = outh.getId();
                        for (int i = 0; i < data.size(); i++) {
                            Part p = data.get(i);
                            if (p.getId() == num) {
                                data.set(i, outh);
                            }
                        }

                        tableOne.setItems(data);

                        stage.setScene(scene);
                        stage.centerOnScreen();
                    }
                }
            }
        });

        Button modifyCancelPart = new Button();
        modifyCancelPart.setText("Cancel");
        modifyCancelPart.setTranslateX(75);
        modifyCancelPart.setTranslateY(75);
        modifyCancelPart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setScene(scene);
                stage.centerOnScreen();
            }
        });

        modifyPartLayout.getChildren().addAll(modifyPartTitle, modifyInHouse, modifyOutsourced, modifyID, modifyName, modifyInv, modifyPrice, modifyMax, modifyMin,
                modifyMachine, modifyIDText, modifyNameText, modifyInvText, modifyPriceText, modifyMaxText, modifyMinText, modifyMachineText, saveModifyPart,
        modifyCancelPart);

        TextField searchPart = new TextField();
        searchPart.setText("Search by Part Name");
        searchPart.setMaxWidth(150.00);
        searchPart.setTranslateY(-225);
        searchPart.setTranslateX(-150);
        searchPart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                searchPart.clear();

            }
        });

        searchPart.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if ((keyCode == KeyCode.ENTER)){
                String search = searchPart.getText();
                search = search.toLowerCase();
                ObservableList<Part> other = FXCollections.observableArrayList();

                boolean isAvailable = false;
                for (int i = 0; i < data.size(); i++){
                    Part p = data.get(i);
                    String name = p.getName();
                    name = name.toLowerCase();
                    if (name.equals(search)){
                        other.add(p);
                        isAvailable = true;
                        break;
                    }
                }

                if (searchPart.getText().equals("")){
                    tableOne.setItems(data);
                }

                else if (isAvailable == false) {
                    alert.showAndWait();
                }

                else{
                    tableOne.setItems(other);
                }
            }
        });

        TextField searchProduct = new TextField();
        searchProduct.setText("Search by Product Name");
        searchProduct.setMaxWidth(150.00);
        searchProduct.setTranslateY(-225);
        searchProduct.setTranslateX(450);
        searchProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                searchProduct.clear();
            }
        });

        searchProduct.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if ((keyCode == KeyCode.ENTER)){
                String search = searchProduct.getText();
                search = search.toLowerCase();
                ObservableList<Product> other = FXCollections.observableArrayList();

                boolean isAvailable = false;
                for (int i = 0; i < productData.size(); i++){
                    Product p = productData.get(i);
                    String name = p.getName();
                    name = name.toLowerCase();
                    if (name.equals(search)){
                        other.add(p);
                        isAvailable = true;
                        break;
                    }
                }

                if (searchProduct.getText().equals("")){
                    tableProduct.setItems(productData);
                }

                else if (isAvailable == false) {
                    alert.showAndWait();
                }

                else{
                    tableProduct.setItems(other);
                }
            }
        });

        TextField searchAddProduct = new TextField();
        searchAddProduct.setText("Search by Part Name");
        searchAddProduct.setMaxWidth(200.00);
        searchAddProduct.setTranslateY(-350);
        searchAddProduct.setTranslateX(450);
        searchAddProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                searchAddProduct.clear();
            }
        });

        searchAddProduct.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if ((keyCode == keyCode.ENTER)){
                String search = searchAddProduct.getText();
                search = search.toLowerCase();
                ObservableList<Part> other = FXCollections.observableArrayList();

                boolean isAvailable = false;
                for (int i = 0; i < data.size(); i++){
                    Part p = data.get(i);
                    String name = p.getName();
                    name = name.toLowerCase();
                    if (name.equals(search)){
                        other.add(p);
                        isAvailable = true;
                        break;
                    }
                }

                if (searchAddProduct.getText().equals("")){
                    tableOneProduct.setItems(data);
                }

                else if (isAvailable == false) {
                    alert.showAndWait();
                }

                else{
                    tableOneProduct.setItems(other);
                }

            }
        });

        addProductLayout.getChildren().addAll(addProductTitle,addIDProduct, addNameProduct, addInvProduct, addMaxProduct, addMinProduct, addPriceProduct,
                idTextProduct, nameTextProduct, invTextProduct, maxTextProduct, minTextProduct, priceTextProduct, searchAddProduct, tableOneProduct,
                addButtonAddProduct, tableTwoProduct, removeButtonAddProduct, saveButtonAddProduct, cancelButtonAddProduct);


        layout.getChildren().add(addButtonOne);
        layout.getChildren().add(addButtonProductMain);
        layout.getChildren().add(modifyPartButton);
        layout.getChildren().add(modifyProductButton);
        layout.getChildren().add(deletePartButton);
        layout.getChildren().add(deleteProductButton);
        layout.getChildren().add(exitButton);
        layout.getChildren().add(searchPart);
        layout.getChildren().add(searchProduct);
        layout.getChildren().add(titleTableOne);
        layout.getChildren().add(titleTableProduct);
        layout.getChildren().add(tableOne);
        layout.getChildren().add(tableProduct);
        layout.getChildren().add(title);
        stage.setScene(scene);
        stage.show();
        }


    public static void main(String[] args) {
        launch();
    }


    public static boolean isNum(String s){
        for (int i = 0; i < s.length(); i++) {
            boolean answer = false;
            String letter = String.valueOf(s.charAt(i));
            if (letter.equals("0") || letter.equals("1") || letter.equals("2") || letter.equals("3") || letter.equals("4") || letter.equals("5") ||
                    letter.equals("6") || letter.equals("7") || letter.equals("8") || letter.equals("9")) {
                answer = true;
            }
            if (!answer){
                return false;
            }
        }
        return true;
    }
}