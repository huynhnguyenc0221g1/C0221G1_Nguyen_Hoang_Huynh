package model.service.impl;

import model.bean.User;
import model.repository.UserRepository;
import model.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {


    UserRepository userRepository = new UserRepository();
    @Override
    public void insertUser(User user) {
         userRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }

    @Override
    public List<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }


}
