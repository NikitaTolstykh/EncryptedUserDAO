package pl.coderslab;

import pl.coderslab.UserCRUD.User;
import pl.coderslab.UserCRUD.UserDao;

public class MainDao {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        User user1 = new User();

        user1.setEmail("email1@gmail.com");
        user1.setUsername("nickname1");
        user1.setPassword("password1");
        user1 = userDao.create(user1);
        System.out.println(user1.getId());


        User user2 = new User();


        user2.setEmail("email2@gmail.com");
        user2.setUsername("nickname2");
        user2.setPassword("password2");
        user2 = userDao.create(user2);
        System.out.println(user2.getId());


        User user3 = new User();

        user3.setEmail("email3@gmail.com");
        user3.setUsername("nickname3");
        user3.setPassword("password3");
        user3 = userDao.create(user3);
        System.out.println(user3.getId());


        user3 = userDao.read(3);
        user3.setEmail("newEmail@gmail.com");
        user3.setUsername("newUsername");
        user3.setPassword("newPassword");
        userDao.update(user3);
        System.out.println(user3.getId());

        userDao.delete(user3.getId());


        User[] users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

        userDao.deleteAll();
    }
}
