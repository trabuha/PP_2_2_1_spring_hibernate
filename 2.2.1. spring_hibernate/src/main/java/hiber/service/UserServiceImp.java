package hiber.service;

import com.mysql.cj.Session;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public void addCar(Car car) {
      userDao.addCar(car);
   }

   @Transactional
   @Override
   public User getUserByModelAndSeries(String model, int series) {
      return userDao.getUserByModelAndSeries(model, series);
   }


   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

}
