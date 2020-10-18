package com.furkanozbudak.ealab1.service.imp;

import com.furkanozbudak.ealab1.model.UserEntity;
import com.furkanozbudak.ealab1.repository.UserEntityRepository;
import com.furkanozbudak.ealab1.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityServiceImp implements UserEntityService {
    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userEntityRepository.save(userEntity);
    }
}
