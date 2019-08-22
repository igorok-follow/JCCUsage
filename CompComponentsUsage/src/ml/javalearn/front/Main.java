package ml.javalearn.front;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ml.javalearn.back.app.RAMUsage;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application{

    Label label = new Label("test");

    @Override
    public void start(Stage primaryStage) throws Exception {
        initFrame(primaryStage);
        test();
    }

    private void initFrame(Stage stage) {
        stage.setTitle("Usage widget");
        Scene scene = new Scene(label, 500, 50);
        stage.setScene(scene);
        stage.show();
    }

    void test() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> label.setText(new RAMUsage().getInfoRam()));
            }
        };

        timer.schedule(timerTask, 10, 1000);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
