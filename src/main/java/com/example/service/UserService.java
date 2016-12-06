package com.example.service;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public UserDto getUser(Long id) {
        User user = userRepository.getOne(id);
        return userUtils.convertEntityToDto(user);
    }

    @Transactional
    public void saveUser(UserDto dto) {
        userRepository.save(userUtils.convertDtoToEntity(dto));
    }

    @Transactional
    public void updateUser(UserDto dto) {
        userRepository.saveAndFlush(userUtils.convertDtoToEntity(dto));
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Transactional
    public List<UserDto> getUserByRole(Long id) {
        return userUtils.convertEntitiesToDtos(userRepository.findByRole(roleRepository.getOne(id)));
    }

}
