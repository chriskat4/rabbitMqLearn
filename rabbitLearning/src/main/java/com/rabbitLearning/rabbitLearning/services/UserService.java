package com.rabbitLearning.rabbitLearning.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rabbitLearning.rabbitLearning.model.User;
import com.rabbitLearning.rabbitLearning.producers.UserProducer;
import com.rabbitLearning.rabbitLearning.repositories.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;
    final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public User save(User userModel){
        userModel = userRepository.save(userModel);
        userProducer.publishMessageEmail(userModel);
        return userModel;
    }

}
