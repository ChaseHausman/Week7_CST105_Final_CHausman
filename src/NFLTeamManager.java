/**
 * Program: Final
 * File: .java
 * Summary:
 * Author: Chase Hausman
 * Date: April 01, 2018
 */

import javafx.application.Application;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class NFLTeamManager extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private ObservableList<NFLPlayer> allData;
    private ObservableList<NFLPlayer> yourData;

    @Override
    public void start(Stage primaryStage) {
        // Establish a panel to hold everything
        Pane pane = new VBox();
        pane.setPrefHeight(800);
        pane.setPrefWidth(600);

        // Make a header, that can persist between the different views
        Pane header = new HBox();
        header.setPrefHeight(50);
        header.setPadding(new Insets(12));
        header.setBackground(new Background(new BackgroundFill(
                new Color(0.8353, 0.8353, 0.8353, 1),
                new CornerRadii(0),
                new Insets(0))));

        Image logo = new Image("/CH Circle Lens.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitHeight(50);
        logoView.setPreserveRatio(true);

        Text headerText = new Text("  NFL Draft Manager v0.1");
        headerText.setTextOrigin(VPos.CENTER);
        Font headerFont = Font.font("Helvetica", 22);
        headerText.setFont(headerFont);

        header.getChildren().addAll(logoView, headerText);

        pane.getChildren().add(header);

        // Create a collection of players for the demo
        NFLPlayerManager allPlayerData = new NFLPlayerManager();
        NFLPlayerManager yourPlayerData = new NFLPlayerManager();

        allPlayerData.createPlayers(20);
        yourPlayerData.createPlayers(12);

        // Store player data in a format that can be used by the TableView
        allData = FXCollections.observableArrayList(allPlayerData.getPlayers());
        yourData = FXCollections.observableArrayList(yourPlayerData.getPlayers());

        // Define tables and columns in the tables
        TableView<NFLPlayer> yourPlayers = new TableView<NFLPlayer>();
        yourPlayers.setPrefWidth(600);
        yourPlayers.setPrefHeight(800);
        yourPlayers.setEditable(true);

        TableColumn yourNameCol = new TableColumn("Name");
        yourNameCol.setCellValueFactory(new PropertyValueFactory<NFLPlayer, String>("name"));
        TableColumn yourPositionCol = new TableColumn("Position");
        yourPositionCol.setCellValueFactory(new PropertyValueFactory<NFLPlayer, String>("position"));
        TableColumn yourControlsCol = new TableColumn("Rating");
        yourControlsCol.setCellValueFactory(new PropertyValueFactory<NFLPlayer, Double>("rating"));

        TableView<NFLPlayer> allPlayers = new TableView<NFLPlayer>();
        allPlayers.setPrefWidth(600);
        allPlayers.setPrefHeight(800);
        allPlayers.setEditable(true);

        TableColumn allNameCol = new TableColumn("Name");
        allNameCol.setCellValueFactory(new PropertyValueFactory<NFLPlayer, String>("name"));
        TableColumn allPositionCol = new TableColumn("Position");
        allPositionCol.setCellValueFactory(new PropertyValueFactory<NFLPlayer, String>("position"));
        TableColumn allControlsCol = new TableColumn("Rating");
        allControlsCol.setCellValueFactory(new PropertyValueFactory<NFLPlayer, Double>("rating"));

        yourPlayers.getColumns().addAll(yourNameCol, yourPositionCol, yourControlsCol);
        yourPlayers.setItems(yourData);
        allPlayers.getColumns().addAll(allNameCol, allPositionCol, allControlsCol);
        allPlayers.setItems(allData);

        // Setup right click handling
        ContextMenu addPlayerMenu = new ContextMenu();
        ContextMenu removePlayerMenu = new ContextMenu();
        MenuItem view1 = new MenuItem("View Details");
        view1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NFLPlayer clicked = yourPlayers.getSelectionModel().getSelectedItem();
                openPlayerDetails(clicked);
            }
        });
        MenuItem view2 = new MenuItem("View Details");
        view2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NFLPlayer clicked = allPlayers.getSelectionModel().getSelectedItem();
                openPlayerDetails(clicked);
            }
        });

        MenuItem add = new MenuItem("Add To Roster");
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NFLPlayer clicked = allPlayers.getSelectionModel().getSelectedItem();
                int index = allPlayers.getSelectionModel().getSelectedIndex();
                addPlayerToRoster(clicked, index);
            }
        });

        MenuItem remove = new MenuItem("Remove From Roster");
        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NFLPlayer clicked = yourPlayers.getSelectionModel().getSelectedItem();
                int index = yourPlayers.getSelectionModel().getSelectedIndex();
                removePlayerFromRoster(clicked, index);
            }
        });

        removePlayerMenu.getItems().addAll(view1, remove);
        addPlayerMenu.getItems().addAll(view2, add);

        yourPlayers.setContextMenu(removePlayerMenu);
        allPlayers.setContextMenu(addPlayerMenu);

        // Allow double-clicking on a player to view their details
        yourPlayers.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2) {
                    NFLPlayer clicked = yourPlayers.getSelectionModel().getSelectedItem();
                    openPlayerDetails(clicked);
                }
            }
        });
        allPlayers.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                NFLPlayer clicked = allPlayers.getSelectionModel().getSelectedItem();
                openPlayerDetails(clicked);
            }
        });

        // Defining the tabs for the two tables
        TabPane rosterTabPane = new TabPane();
        Tab yourRoster = new Tab();
        yourRoster.setText("Your Roster");
        yourRoster.setClosable(false);
        yourRoster.setContent(yourPlayers);

        Tab allRoster = new Tab();
        allRoster.setText("All Players");
        allRoster.setClosable(false);
        allRoster.setContent(allPlayers);

        rosterTabPane.getTabs().add(yourRoster);
        rosterTabPane.getTabs().add(allRoster);

        pane.getChildren().add(rosterTabPane);

        // Create the main window.
        Scene scene = new Scene(pane);
        primaryStage.setTitle("NFL Draft Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Handle adding a player to the collection of the users roster
    public void addPlayerToRoster(NFLPlayer player, int index) {
        allData.remove(index);

        yourData.add(player);
    }

    // Move a player from the roster and place it in the general list
    public void removePlayerFromRoster(NFLPlayer player, int index) {
        yourData.remove(index);

        allData.add(player);
    }

    // Create and show a popup window with a players stats
    public void openPlayerDetails(NFLPlayer clicked) {
        Pane details = new VBox(10.0);
        details.setPrefWidth(300);
        details.setPrefHeight(275);
        details.setPadding(new Insets(20));

        // The two fonts used on the details page
        Font standardFont = new Font("Helvetica Nueue", 16.0);
        Font headlineFont = Font.font("Helvetica Nueue", FontWeight.SEMI_BOLD, 20.0);

        // All of the common text 'fields'
        Text name = new Text(clicked.getName()+"'s Stats");
        name.setFont(headlineFont);
        Text position = new Text(clicked.getPosition());
        position.setFont(standardFont);
        Text height = new Text("Height: "+clicked.getFormattedHeight());
        height.setFont(standardFont);
        Text weight = new Text("Weight: "+clicked.getWeight()+"lbs");
        weight.setFont(standardFont);
        Text firstYear = new Text("Started: "+clicked.getFirstYear());
        firstYear.setFont(standardFont);
        Text rating = new Text("Rating: "+clicked.getRating());
        rating.setFont(standardFont);
        Text college = new Text("School: "+clicked.getCollege());
        college.setFont(standardFont);

        details.getChildren().addAll(name, position, rating, height, weight, firstYear, college);

        // Create a divider
        Rectangle divider = new Rectangle();
        divider.setHeight(2);
        divider.setWidth(300);

        details.getChildren().add(divider);

        // Add the last few fields, depending on what kind player we've clicked on
        if(clicked instanceof OffensivePlayer) {
            Text yards = new Text("Yards: "+((OffensivePlayer) clicked).getYards());
            yards.setFont(standardFont);
            Text touchdowns = new Text("Touchdowns: "+((OffensivePlayer) clicked).getTouchdowns());
            touchdowns.setFont(standardFont);

            details.getChildren().addAll(yards, touchdowns);
        } else if(clicked instanceof DefensivePlayer) {
            Text interceptions = new Text("Interceptions: "+((DefensivePlayer) clicked).getInterceptions());
            interceptions.setFont(standardFont);

            details.getChildren().add(interceptions);
        }

        // Finish creating the window
        Scene detailScene = new Scene(details);
        Stage detailPopup = new Stage();
        detailPopup.setTitle(clicked.getName());
        detailPopup.setScene(detailScene);
        detailPopup.setResizable(false);
        detailPopup.show();
    }
}
