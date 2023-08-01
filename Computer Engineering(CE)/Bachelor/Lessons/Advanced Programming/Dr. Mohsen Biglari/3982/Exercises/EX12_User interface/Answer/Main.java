package Graphic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.function.Consumer;

public class Main extends Application {
    private static int id = 0;
    private final static int COL = 3;

    @Override
    public void start(Stage primaryStage){


        Button addSection = new Button("Add new section");
        Button removeSection = new Button("Remove last Section");
        FlowPane topButtons = new FlowPane(Orientation.HORIZONTAL);
        topButtons.setAlignment(Pos.TOP_CENTER);
        topButtons.setHgap(30);
        topButtons.getChildren().addAll(addSection , removeSection);

        GridPane Pane = new GridPane();
        Pane.setVgap(0);
        Pane.setHgap(0);
        Pane.setAlignment(Pos.CENTER);


        addSection.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane.add(passAPackage(id++),(id-1) % COL,(id-1) / COL);
            }
        });


        removeSection.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(Pane.getChildren().size() > 0){
                    Pane.getChildren().remove(Pane.getChildren().size()-1);
                    id -= 1;
                }

            }
        });


        ScrollPane scrollPane = new ScrollPane(new StackPane(Pane));

        BorderPane mainPane = new BorderPane();
        mainPane.setTop(topButtons);
        mainPane.setCenter(scrollPane);
        BorderPane.setMargin(topButtons,new Insets(20));
        BorderPane.setMargin(scrollPane,new Insets(5,15,5,15));
        BorderPane.setAlignment(topButtons,Pos.TOP_CENTER);
        BorderPane.setAlignment(scrollPane,Pos.CENTER);

        Scene scene = new Scene(mainPane);
        primaryStage.setWidth(1300);
        primaryStage.setHeight(700);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen (true);
        primaryStage.show();
    }


    private static Group passAPackage(int id){
        CheckBox availabilitySwitch = new CheckBox("Enable/Disable section");
        availabilitySwitch.setId(Integer.toString(id));
        availabilitySwitch.setAlignment (Pos.CENTER);

        Text firstNameText = new Text("First name");
        TextField firstNameField = new TextField();
        FlowPane firstNamePane = new FlowPane(Orientation.HORIZONTAL);
        firstNamePane.getChildren().addAll(firstNameText,firstNameField);
        firstNamePane.setAlignment(Pos.CENTER);
        FlowPane.setMargin(firstNameText,new Insets(5,5,5,20));
        FlowPane.setMargin(firstNameField,new Insets(5,20,5,5));

        Text lastNameText = new Text("Last name");
        TextField lastNameField = new TextField();
        FlowPane lastNamePane = new FlowPane(Orientation.HORIZONTAL);
        lastNamePane.getChildren().addAll(lastNameText,lastNameField);
        FlowPane.setMargin(lastNameText,new Insets(5,5,5,20));
        FlowPane.setMargin(lastNameField,new Insets(5,20,5,5));
        lastNamePane.setAlignment(Pos.CENTER);

        Button infoButton = new Button(String.format("%s %d","Show dialog for section",id));
        HBox buttonBox = new HBox(infoButton);
        buttonBox.setAlignment(Pos.CENTER);

        VBox result = new VBox();
        result.getChildren().addAll(availabilitySwitch,firstNamePane,lastNamePane,buttonBox);
        result.setAlignment(Pos.TOP_LEFT);
        result.setBorder(new Border(new BorderStroke(Color.BLUE,BorderStrokeStyle.DASHED,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        VBox.setMargin(availabilitySwitch,new Insets(20,5,5,20));
        VBox.setMargin(firstNamePane,new Insets(5,5,5,5));
        VBox.setMargin(lastNamePane,new Insets(5,5,5,5));
        VBox.setMargin(buttonBox,new Insets(20,0,15,5));

        result.getChildren().forEach(new Consumer<Node>() {
            @Override
            public void accept(Node node) {
                node.setId(Integer.toString(id));

            }
        });

        availabilitySwitch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                firstNameField.setDisable(!firstNameField.isDisable());
                lastNameField.setDisable(!lastNameField.isDisable());
                infoButton.setDisable(!infoButton.isDisable());
                event.consume();
            }
        });

        infoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert Window = new Alert(Alert.AlertType.INFORMATION);
                Window.setTitle("Information");
                Window.setHeaderText(String.format("Section %d info",id));
                Window.setContentText(String.format("%s %s",firstNameField.getText(),lastNameField.getText()));
                Window.getButtonTypes().clear();
                Window.getButtonTypes().add(ButtonType.CLOSE);
                Window.showAndWait();
            }
        });


        return new Group(result);
    }

    public static void main(String[] args) {
        launch(args);
    }

}