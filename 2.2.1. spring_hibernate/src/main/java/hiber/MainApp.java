package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        /*Car car1 = new Car("KIA", 100);
        Car car2 = new Car("BMW", 200);
        Car car3 = new Car("PORSCHE", 300);
        Car car4 = new Car("ZEEKR", 001);


        userService.addCar(car1);
        userService.addCar(car2);
        userService.addCar(car3);
        userService.addCar(car4);*/

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        Car car1 = new Car("KIA", 100);
        user1.setCar(car1);
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        Car car2 = new Car("BMW", 200);
        user2.setCar(car2);
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        Car car3 = new Car("PORSCHE", 300);
        user3.setCar(car3);
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        Car car4 = new Car("ZEEKR", 001);
        user4.setCar(car4);


        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);


        /*userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
*/
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car Model = " + user.getCar().getModel());
            System.out.println("Car Series = " + user.getCar().getSeries());
            System.out.println();
        }

        User user = userService.getUserByModelAndSeries("KIA", 100);

        System.out.println();
        System.out.println(user.toString());

       /* try {
            User notFoundUser = userService.getUserByModelAndSeries("Lada", 9);
        } catch (NoResultException e) {
        }*/

        context.close();
    }
}
