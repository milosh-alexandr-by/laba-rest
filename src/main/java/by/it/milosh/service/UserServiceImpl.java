package by.it.milosh.service;

import by.it.milosh.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private static List<User> users;

    private static Long userIdCounter;

    static {
        users = populateDummyUsers();
        userIdCounter = 6L;
    }

    @Override
    public User findById(long userId) {
        for(User user : users){
            if(user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByName(String username) {
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        user.setUserId(userIdCounter);
        userIdCounter += 1L;
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    @Override
    public void deleteUserById(long id) {

    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public void deleteAllUsers() {

    }

    @Override
    public boolean isUserExist(User user) {
        return false;
    }

    private static List<User> populateDummyUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User(1L, "sasha"));
        users.add(new User(2L, "slava"));
        users.add(new User(3L, "andrey"));
        users.add(new User(4L, "igor"));
        users.add(new User(5L, "vitia"));
        return users;
    }

}
