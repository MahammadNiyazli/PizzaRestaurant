package com.company.controller;

import com.company.dto.ResponseDto;
import com.company.dto.UserDto;
import com.company.entity.User;
import com.company.respository.UserRepository;
import com.company.service.UserServiceInter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/user")
public class UserWebServices {

    private final UserServiceInter userService;

    public UserWebServices(UserServiceInter userService) {
        this.userService = userService;
    }

    @GetMapping("/userList")
    public ResponseEntity<ResponseDto> getAllusers(){
        List<User> users = userService.findAll();
        List<UserDto> userDtoList = users.stream().map(UserDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(ResponseDto.of(userDtoList));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ResponseDto> findUserById(@PathVariable("id") int id){
        User user = userService.findById(id);
        UserDto userDto = user == null ? new UserDto():new UserDto(user) ;
        return ResponseEntity.ok(ResponseDto.of(userDto));
    }

    @PostMapping("/updateUser")
    public ResponseEntity<ResponseDto> updateUser(@RequestBody UserDto userDto){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        User user = mapper.convertValue(userDto, User.class);
        userService.updateUser(user);
        return ResponseEntity.ok(ResponseDto.of(new UserDto(user)));
    }


    @PostMapping("/addUser")
    public ResponseEntity<ResponseDto> addUser(@RequestBody UserDto userDto){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        User user = mapper.convertValue(userDto, User.class);

        userService.addUser(user);
        return ResponseEntity.ok(ResponseDto.of(new UserDto(user)));
    }


    @PostMapping("/removeUser")
    public ResponseEntity<ResponseDto> removeUser(@RequestBody UserDto userDto){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        User user = mapper.convertValue(userDto, User.class);
        userService.removeUser(user.getId());
        return ResponseEntity.ok(ResponseDto.of(new UserDto(user)));
    }
}
