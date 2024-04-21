package event.manager.ms3;


import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MergeScenes extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the root group
        Group root = new Group();
        
        // Create the first scene with a red rectangle
        Rectangle rectangle1 = new Rectangle(0, 0, 800, 600);
        rectangle1.setFill(Color.RED);
        Scene scene1 = new Scene(root, 800, 600);
        root.getChildren().add(rectangle1);
        
        // Create the second scene with a blue rectangle
        Rectangle rectangle2 = new Rectangle(0, 0, 800, 600);
        rectangle2.setFill(Color.BLUE);
        Scene scene2 = new Scene(root, 800, 600);
        root.getChildren().add(rectangle2);
        
        // Show the first scene initially
        primaryStage.setScene(scene1);
        primaryStage.show();
        
        // Transition from scene1 to scene2
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), rectangle1);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setOnFinished(e -> {
            primaryStage.setScene(scene2);
            FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(2), rectangle2);
            fadeTransition2.setFromValue(0.0);
            fadeTransition2.setToValue(1.0);
            fadeTransition2.play();
        });
        fadeTransition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

