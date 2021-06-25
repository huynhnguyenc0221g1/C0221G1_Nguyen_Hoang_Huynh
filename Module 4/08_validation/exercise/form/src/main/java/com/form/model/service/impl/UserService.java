package com.form.model.service.impl;

import com.form.model.entity.User;
import com.form.model.repository.IUserRepository;
import com.form.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
