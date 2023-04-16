package com.springjpa;

import com.springjpa.dao.UserRepository;
import com.springjpa.entities.User;
import jakarta.persistence.Id;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

//        CURD Operations
        /**       Creating User Object
        User user = new User();

        user.setName("Da");
        user.setCity("Heaven");
        user.setStatus("Learning Spring Boot");

        User user1 = userRepository.save(user);
        System.out.println(user1);*/

//    Creating user object
      /*  User user1 = new User();
        user1.setName("Di");
        user1.setCity("Bangalore");
        user1.setStatus("Working In Software");

        User user2 = new User();
        user2.setName("Da");
        user2.setCity("Bangalore");
        user2.setStatus("Working In Govt.Sector");*/

//    Saving Single User
//        User save = userRepository.save(user1);
//        System.out.println(save);

//   Saving Multiple User
       /* List<User> list = List.of(user1, user2);
        Iterable<User> users = userRepository.saveAll(list);
        users.forEach(user -> {
            System.out.println(user);
        });*/
//        System.out.println(user);

//   Update the user Id 253 (Single)
       /* Optional<User> byId = userRepository.findById(253);
        User user = byId.get();
        user.setCity("Bangaluru");
        User update = userRepository.save(user);
        System.out.println(update);*/

//  Get User Data
//         findById(id)-> return optional containing  your data
//  Get All User Data
//        Iterable<User> all = userRepository.findAll();
//  Using Iterator:
       /* Iterator<User> iterator = all.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            System.out.println(user);
        }*/
//  Using Lambda Expression:
    /*  all.forEach(user -> {
          System.out.println(user);
      });*/

//  Deleting The User Data
        /*userRepository.deleteById(203);
        System.out.println("Deleted");*/

//  Deleting All User Data
      /*  Iterable<User> allusers = userRepository.findAll();
        allusers.forEach(user -> {
            System.out.println(user);
        });

        userRepository.deleteAll(allusers);
        System.out.println("Deleted All Users");*/


//        User user = new User();
//        user.setName("Di");
//        user.setCity("Bangalore");
//        user.setStatus("Engaged");
//        User save = userRepository.save(user);
//        System.out.println(save);

//        Custom Finder Methods
//        Find By Name
       /* List<User> byName = userRepository.findByName("Da");
        byName.forEach(e->{
            System.out.println(e);
        });
        System.out.println("Done");*/

//    Find By Name And City
       /* List<User> byNameAndCity = userRepository.findByNameAndCity("Di", "Bangalore");
        if (byNameAndCity.isEmpty()){
            System.out.println("No Record found");

        }else {
            byNameAndCity.forEach(System.out::println);
            System.out.println("One Record Found "+byNameAndCity);
        }*/

//    Executing JPQL and Native Queries
        List<User> allUser = userRepository.getAllUser();
        allUser.forEach(user -> {
            System.out.println(user);
        });
        System.out.println("======================");

        List<User> da = userRepository.getUserByName("Da","Engaged");
        da.forEach(user -> {
            System.out.println(user);
        });
        System.out.println("=========================");
        userRepository.getUsers().forEach(user -> {
            System.out.println(user);
        });



    }

}
