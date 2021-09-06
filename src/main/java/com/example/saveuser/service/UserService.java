package com.example.saveuser.service;

import com.example.saveuser.config.rabbitmq.RabbitMQConstant;
import com.example.saveuser.model.DAO.UserDAO;
import com.example.saveuser.model.User;
import com.example.saveuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RabbitMQService rabbitMQService;

    @Transactional
    public User save(User user) {
        user = this.userRepository.save(user);
        UserDAO userDAO = UserDAO.builder().build();
        BeanUtils.copyProperties(user, userDAO, "password");
        this.sendTORabbitMQ(userDAO);
        return user;
    }

    private void sendTORabbitMQ(UserDAO userDAO) {
        this.rabbitMQService.sendMessage(RabbitMQConstant.FILA_EMAIL, userDAO);
    }

}
