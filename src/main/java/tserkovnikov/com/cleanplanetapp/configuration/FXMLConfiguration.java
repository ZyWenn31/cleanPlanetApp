package tserkovnikov.com.cleanplanetapp.configuration;

import jakarta.persistence.EntityManagerFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URL;

@Configuration
public class FXMLConfiguration implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public FXMLLoader createLoader(URL path) {
        FXMLLoader fxmlLoader = new FXMLLoader(path);
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        return fxmlLoader;
    }


    public Stage authPageFXNLLoader() throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-page.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/tserkovnikov/com/cleanplanetapp/login-page.fxml")
        );
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        return stage;
    }

    public Stage helloPageFXNLLoader() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/tserkovnikov/com/cleanplanetapp/main-menu.fxml")
        );
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        return stage;
    }

    public Stage PartnerFormFXNLLoader() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/tserkovnikov/com/cleanplanetapp/partner-form.fxml")
        );
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        return stage;
    }

    public Stage getHistory() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/tserkovnikov/com/cleanplanetapp/partner_service_history.fxml")
        );
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        return stage;
    }

    public Stage getAllUsers() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/tserkovnikov/com/cleanplanetapp/user-list.fxml")
        );
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        return stage;
    }

    public Stage getUserForm() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/tserkovnikov/com/cleanplanetapp/user-form.fxml")
        );
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        return stage;
    }

    public Stage PartnerListFXNLLoader() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/tserkovnikov/com/cleanplanetapp/partner-list.fxml")
        );
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        return stage;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

   /* @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
        return new org.hibernate.cfg.Configuration().buildSessionFactory()
    }*/


}
