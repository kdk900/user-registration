package com.facelesscoder.user_registration.service;

import com.facelesscoder.user_registration.dto.AgentProfileDto;
import com.facelesscoder.user_registration.dto.RegisterUserRequestDto;
import com.facelesscoder.user_registration.dto.RegisterUserResponse;

/**
 * @author KK
 * @created 10/03/2026 - 20:29
 * @project user-registration
 */
public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequestDto userRequestDto);

    AgentProfileDto getAgent(Long agentId);
}
