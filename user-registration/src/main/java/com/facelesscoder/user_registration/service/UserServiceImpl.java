package com.facelesscoder.user_registration.service;

import com.facelesscoder.user_registration.DtoAndEntityConverter;
import com.facelesscoder.user_registration.dto.AgentProfileDto;
import com.facelesscoder.user_registration.dto.RegisterUserRequestDto;
import com.facelesscoder.user_registration.dto.RegisterUserResponse;
import com.facelesscoder.user_registration.entity.AgentProfile;
import com.facelesscoder.user_registration.entity.User;
import com.facelesscoder.user_registration.repository.AgentProfileRepository;
import com.facelesscoder.user_registration.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * @author KK
 * @created 10/03/2026 - 20:30
 * @project user-registration
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AgentProfileRepository agentProfileRepository;

    public UserServiceImpl(UserRepository userRepository, AgentProfileRepository agentProfileRepository) {
        this.userRepository = userRepository;
        this.agentProfileRepository = agentProfileRepository;
    }
    @Transactional
    @Override
    public RegisterUserResponse registerUser(RegisterUserRequestDto userRequestDto) {
        User user = userRepository.findByEmailId(userRequestDto.emailId());
        if(user != null) {
            throw new IllegalArgumentException("Email Id already registered!");
        }
        User registeredUser = userRepository.save(DtoAndEntityConverter.toUserEntity(userRequestDto));
        if(User.Role.AGENT.equals(registeredUser.getRole())) {
            saveAgent(registeredUser, userRequestDto);
        }
        return new RegisterUserResponse(registeredUser.getId(), registeredUser.getRole().name());
    }

    private void saveAgent(User registeredUser, RegisterUserRequestDto userRequestDto) {
        agentProfileRepository.save(DtoAndEntityConverter.toAgentProfileEntity(registeredUser, userRequestDto));
    }

    @Override
    public AgentProfileDto getAgent(Long agentId) {
        AgentProfile agentProfile = agentProfileRepository.findById(agentId).orElse(null);
        return DtoAndEntityConverter.toAgentProfileDto(agentProfile);
    }
}
