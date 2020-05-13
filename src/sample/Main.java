package sample;


import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {

    public static class Table{
        private final SimpleStringProperty firstColumn;
        private final SimpleStringProperty secondColumn;

        private Table(String first, String second){
            this.firstColumn = new SimpleStringProperty(first);
            this.secondColumn = new SimpleStringProperty(second);
        }

        public String getFirstColumn(){
            return firstColumn.get();
        }
        public void setFirstColumn(String str){
            firstColumn.set(str);
        }

        public String getSecondColumn(){
            return secondColumn.get();
        }
        public void setSecondColumn(String str){
            secondColumn.set(str);
        }
    }

    public static class Cycle{

        private boolean Work = false;
        private int Size;
        private int Number;
        private int Step;
        private RadioButton[] J6RadioButtons;
        private ToggleGroup ButtonGroup = new ToggleGroup();

        private void SetButtons(int quantity){
            J6RadioButtons = new RadioButton[quantity];
            for (int i=0; i<quantity; i++){
                J6RadioButtons[i] = new RadioButton();
                J6RadioButtons[i].setToggleGroup(ButtonGroup);
                J6RadioButtons[i].setText(Integer.toString(i+1));
            }
            Size = quantity;
            Number = 0;
            Step = 1;
        }

        private void Show(){
            VBox root7 = new VBox(J6RadioButtons);
            Stage stage7 = new Stage();
            Scene scene7 = new Scene(root7);
            stage7.setScene(scene7);
            stage7.setTitle("Java");
            stage7.setWidth(200);
            stage7.setHeight(400);
            stage7.show();
        }

        private void WorkOn(){
            Work = true;
        }

        private void WorkOff(){
            Work = false;
        }

        private void CycleWork(){
            Thread J6T = new Thread(new Runnable() {
                @Override
                public void run() {
                    int chet = 0;
                    while(Work){
                        if(Step<=Size){
                            J6RadioButtons[Number].fire();
                            if (chet==0){
                                chet = 1;
                                Number = Number + (Size - Step);
                            } else {
                                chet = 0;
                                Number = Number - (Size - Step);
                            }
                            Step++;
                        } else {
                            Step = 1;
                            Number = 0;
                            chet = 0;
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            });
            J6T.start();
        }

    }

    @Override
    public void start(Stage stage) {

        ComboBox<String> J1ComboBox = new ComboBox<String >();
        TextField J1TextField = new TextField();
        Button J1Button = new Button("J1Button");
        J1Button.setText("Add_Text");
        J1Button.setOnAction(e -> {
            String text = J1TextField.getText();
            int x=1;
            for(int j = 0; j < J1ComboBox.getItems().size(); j++){
                if(J1ComboBox.getItems().get(j).equals(text)) {
                    x = 0;
                    Alert alert = new Alert(Alert.AlertType.ERROR);

                    alert.setTitle("Error alert");
                    alert.setHeaderText("Can not add text");
                    alert.setContentText("This text is already exist!");

                    alert.showAndWait();
                    j=J1ComboBox.getItems().size();
                }
            }
            if (x==1){
                J1ComboBox.getItems().addAll(text);
            }
        });

        TextField J2TextField = new TextField();
        Button J2Button1 = new Button("J2Button1");
        Button J2Button2 = new Button("J2Button2");
        J2Button1.setOnAction(e -> {
            J2Button2.setText(J2TextField.getText());
        });
        J2Button2.setOnAction(e -> {
            String JText1 = J2Button2.getText();
            J2Button2.setText(J2Button1.getText());
            J2Button1.setText(JText1);
        });

        TextField J3TextField = new TextField();
        Button J3Button = new Button("J3Button");
        ToggleGroup J3RadioButtonGroup = new ToggleGroup();
        RadioButton J3RadioButton1 = new RadioButton("1");
        J3RadioButton1.setToggleGroup(J3RadioButtonGroup);
        RadioButton J3RadioButton2 = new RadioButton("2");
        J3RadioButton2.setToggleGroup(J3RadioButtonGroup);
        RadioButton J3RadioButton3 = new RadioButton("3");
        J3RadioButton3.setToggleGroup(J3RadioButtonGroup);
        J3Button.setOnAction(e ->{
            int x=0;
            if (J3TextField.getText().equals(J3RadioButton1.getText())){
                J3RadioButton1.fire();
                x=1;
            }
            if (J3TextField.getText().equals(J3RadioButton2.getText())){
                J3RadioButton2.fire();
                x=1;
            }
            if (J3TextField.getText().equals(J3RadioButton3.getText())){
                J3RadioButton3.fire();
                x=1;
            }
            if (x==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Error alert");
                alert.setHeaderText("Can not find RadioButton");
                alert.setContentText("This RadioButton does not exists!");

                alert.showAndWait();
            }
        });

        TextField J4TextField = new TextField();
        Button J4Button = new Button("J4Button");
        CheckBox J4CheckBox1 = new CheckBox("1");
        CheckBox J4CheckBox2 = new CheckBox("2");
        CheckBox J4CheckBox3 = new CheckBox("3");
        J4Button.setOnAction(e ->{
            int x=0;
            if (J4TextField.getText().equals(J4CheckBox1.getText())){
                J4CheckBox1.fire();
                x=1;
            }
            if (J4TextField.getText().equals(J4CheckBox2.getText())){
                J4CheckBox2.fire();
                x=1;
            }
            if (J4TextField.getText().equals(J4CheckBox3.getText())){
                J4CheckBox3.fire();
                x=1;
            }
            if (x==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Error alert");
                alert.setHeaderText("Can not find CheckBox");
                alert.setContentText("The is CheckBox does not exists!");

                alert.showAndWait();
            }
        });

        ObservableList<Table> NewList = FXCollections.observableArrayList();
        TableView<Table> J5Table = new TableView<Table>();
        TableColumn<Table, String> J5Column1 = new TableColumn<>("First column");
        TableColumn<Table, String> J5Column2 = new TableColumn<>("Second column");
        J5Column1.setCellValueFactory(new PropertyValueFactory<>("FirstColumn"));
        J5Column2.setCellValueFactory(new PropertyValueFactory<>("SecondColumn"));
        J5Table.setItems(NewList);
        J5Table.getColumns().addAll(J5Column1, J5Column2);
        TextField J5TextField = new TextField();
        Button J5Button1 = new Button("J5Button1");
        Button J5Button2 = new Button("J5Button2");
        Button J5Button3 = new Button("J5Button3");
        J5Button1.setOnAction(e->{
            NewList.add(new Table(J5TextField.getText(), ""));
        });
        J5Button2.setOnAction(e->{
            Table selectedColumn = J5Table.getSelectionModel().getSelectedItem();
            if(selectedColumn.getFirstColumn() != "") {
                selectedColumn.setSecondColumn(selectedColumn.getFirstColumn());
                selectedColumn.setFirstColumn("");
                J5Table.refresh();
            }
        });
        J5Button3.setOnAction(e->{
            Table selectedColumn = J5Table.getSelectionModel().getSelectedItem();
            if(selectedColumn.getSecondColumn() != "") {
                selectedColumn.setFirstColumn(selectedColumn.getSecondColumn());
                selectedColumn.setSecondColumn("");
                J5Table.refresh();
            }
        });
        J5Table.setPrefWidth(200);
        J5Table.setPrefHeight(150);
        J5Table.setLayoutY(40);
        J5Table.setLayoutX(60);

        TextField J6TextField = new TextField();
        Button J6Button1 = new Button("J6Button1");
        Button J6Button2 = new Button("J6Button2");
        Button J6Button3 = new Button("J6Button3");
        Cycle J6Cycle = new Cycle();
        J6Button1.setOnAction(e->{
            J6Cycle.WorkOff();
            J6Cycle.SetButtons(Integer.parseInt(J6TextField.getText()));
            J6Cycle.Show();
        });
        J6Button2.setOnAction(e->{
            J6Cycle.WorkOn();
            J6Cycle.CycleWork();
        });
        J6Button3.setOnAction(e->{
            J6Cycle.WorkOff();
        });


        HBox root1 = new HBox(J1Button, J1TextField, J1ComboBox);
        HBox root2 = new HBox(J2Button1, J2TextField, J2Button2);
        HBox root3 = new HBox(J3TextField, J3Button, J3RadioButton1, J3RadioButton2, J3RadioButton3);
        HBox root4 = new HBox(J4TextField, J4Button, J4CheckBox1, J4CheckBox2, J4CheckBox3);
        HBox root5 = new HBox(J5TextField, J5Button1, J5Button2, J5Button3, J5Table);
        HBox root6 = new HBox(J6TextField, J6Button1, J6Button2, J6Button3);
        VBox root = new VBox (root1, root2, root3, root4, root5, root6);
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setTitle("JavaFX");
        stage.setWidth(800);
        stage.setHeight(600);

        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
