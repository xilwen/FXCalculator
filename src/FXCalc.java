import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXCalc extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Calculator.fxml"));
        Parent root = loader.load();
        Controller ctlr = loader.getController();
        ctlr.init();
        primaryStage.setTitle("FXCalc//HW5:AdvancedVersion");
        primaryStage.setScene(new Scene(root, 480, 400));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);


    }
}