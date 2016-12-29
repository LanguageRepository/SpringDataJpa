package com.example.utils;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserUtils {

    @Autowired
    private RoleRepository roleRepository;

    public UserDto convertEntityToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setRoles(user.getRoles());
        return dto;
    }

    public User convertDtoToEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setRoles(dto.getRoles());
        return user;
    }

    public List<UserDto> convertEntitiesToDtos(List<User> entities) {
        List<UserDto> dtos = new ArrayList<>();
        for(int i = 0; i < entities.size(); i++) {
            UserDto userDto = new UserDto();
            userDto.setId(entities.get(i).getId());
            userDto.setName(entities.get(i).getName());
            userDto.setUsername(entities.get(i).getUsername());
            userDto.setRoles(entities.get(i).getRoles());
            dtos.add(userDto);
        }
        return dtos;
    }

}
