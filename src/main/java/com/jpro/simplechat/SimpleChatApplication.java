package com.jpro.simplechat;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleChatApplication extends Application {

    static public ObservableList<String> messages = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception {

        ListView<String> messagesView = new ListView(messages);
        TextField input = new TextField();
        input.setPromptText("Your Message");
        Button button = new Button("send");
        HBox.setHgrow(input, Priority.ALWAYS);

        VBox vbox = new VBox(messagesView, new HBox(input,button));
        vbox.setMaxHeight(500);
        vbox.setMaxWidth(400);

        EventHandler<ActionEvent> handler = (e) -> {
            if(!input.getText().isEmpty()) {
                messages.add(input.getText());
                input.setText("");
            }
        };
        input.setOnAction(handler);
        button.setOnAction(handler);

        StackPane container = new StackPane(vbox);
        container.setAlignment(Pos.CENTER);
        container.setStyle("-fx-background-image: url('/com/jpro/simplechat/background.jpg');" +
                "-fx-background-size: cover;");

        stage.setScene(new Scene(container, 800, 800));
        stage.show();
    }

}
