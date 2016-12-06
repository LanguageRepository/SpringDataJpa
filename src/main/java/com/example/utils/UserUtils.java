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
        dto.setNickName(user.getNickname());
        dto.setRoleId(user.getRole().getId());
        return dto;
    }

    public User convertDtoToEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setNickname(dto.getNickName());
        user.setRole(roleRepository.getOne(dto.getRoleId()));
        return user;
    }

    public List<UserDto> convertEntitiesToDtos(List<User> entities) {
        List<UserDto> dtos = new ArrayList<>();
        for(int i = 0; i < entities.size(); i++) {
            UserDto userDto = new UserDto();
            userDto.setId(entities.get(i).getId());
            userDto.setName(entities.get(i).getName());
            userDto.setNickName(entities.get(i).getNickname());
            userDto.setRoleId(entities.get(i).getRole().getId());
            dtos.add(userDto);
        }
        return dtos;
    }

}
