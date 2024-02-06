/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rest.test.main.services;
import Rest.test.main.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "sya", 23, "sya@gmail.com");
        User user2 = new User(2, "len", 27, "len@gmail.com");
        User user3 = new User(3, "sif", 22, "sifi@gmail.com");
        User user4 = new User(4, "nes", 26, "nes@gmail.com");
        User user5 = new User(5, "khai", 21, "khai@gmail.com");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
    }
    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(int id) {
        Optional<User> userOptional = userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst();

        return userOptional.orElse(null);
    }

    public User createUser(User user) {
        user.setId(getNextUserId());
        userList.add(user);
        return user;
    }

    public User updateUser(int id, User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                userList.set(i, user);
                return user;
            }
        }
        return null;
    }

    public void deleteUser(int id) {
        userList.removeIf(user -> user.getId() == id);
    }

    private int getNextUserId() {
        int maxId = userList.stream()
                .mapToInt(User::getId)
                .max()
                .orElse(0);
        return maxId + 1;
    }
}