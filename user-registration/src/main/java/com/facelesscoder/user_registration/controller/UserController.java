package com.facelesscoder.user_registration.controller;

import com.facelesscoder.user_registration.dto.AgentProfileDto;
import com.facelesscoder.user_registration.dto.RegisterUserRequestDto;
import com.facelesscoder.user_registration.dto.RegisterUserResponse;
import com.facelesscoder.user_registration.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author KK
 * @created 10/03/2026 - 20:26
 * @project user-registration
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> registerUser(@Valid @RequestBody RegisterUserRequestDto userDto) {
//        return ResponseEntity.ok(userService.registerUser(userDto));
        return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/agents/{agentId}")
    public ResponseEntity<AgentProfileDto> getAgent(@PathVariable Long agentId) {
        AgentProfileDto agent = userService.getAgent(agentId);
        if(agent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agent);
    }
}
