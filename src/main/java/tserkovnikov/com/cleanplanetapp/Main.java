package tserkovnikov.com.cleanplanetapp;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {
    private static ConfigurableApplicationContext applicationContext;

    @Override
    public void start(Stage stage) throws Exception {
        SpringFXMLLoader loader = applicationContext.getBean(SpringFXMLLoader.class);
        Parent root = loader.load("/tserkovnikov/com/cleanplanetapp/login-page.fxml");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Main.class);
        launch(args);
    }
}
