package dika.springhibernate;

import dika.springhibernate.config.AppConfig;
import dika.springhibernate.model.Car;
import dika.springhibernate.model.User;
import dika.springhibernate.service.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class SpringHibernateApplication {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("Model1", 1);
        Car car2 = new Car("Modek1", 2);
        Car car3 = new Car("Model6", 1);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));

        userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));

        System.out.println(userService.findByCar("Model6", 1));
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

    }
}
