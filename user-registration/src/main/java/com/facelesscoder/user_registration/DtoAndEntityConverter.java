package com.facelesscoder.user_registration;

import com.facelesscoder.user_registration.dto.AgentProfileDto;
import com.facelesscoder.user_registration.dto.RegisterUserRequestDto;
import com.facelesscoder.user_registration.entity.AgentProfile;
import com.facelesscoder.user_registration.entity.User;
import io.micrometer.common.util.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author KK
 * @created 10/03/2026 - 20:57
 * @project user-registration
 */
public class DtoAndEntityConverter {
    public static User toUserEntity(RegisterUserRequestDto dto) {
        User user = new User();
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setEmailId(dto.emailId());
        user.setDob(toLocalDate(dto.dob()));
        user.setPhoneNumber(dto.phoneNumber());
        user.setRole(dto.role());
        user.setStatus(User.Status.NEW);
        user.setCity(dto.city());
        user.setState(dto.state());
        user.setCountry(dto.country());
        user.setAddressLine1(dto.addressLine1());
        user.setAddressLine2(dto.addressLine2());
        user.setAddressLine3(dto.addressLine3());
        user.setZipcode(dto.zipcode());
        return user;
    }

    private static LocalDate toLocalDate(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return LocalDate.parse(dob, formatter);
    }

    public static AgentProfile toAgentProfileEntity(AgentProfileDto agentProfileDto) {

        return null;
    }

    public static AgentProfile toAgentProfileEntity(User registeredUser, RegisterUserRequestDto userRequestDto) {
        AgentProfile agentProfile = new AgentProfile();
        agentProfile.setAgentId(registeredUser.getId());
        agentProfile.setSkill(StringUtils.isEmpty(userRequestDto.skill()) ? "Effective Communication, Time Management, CRM Proficiency, Scheduling Software" : userRequestDto.skill());
        agentProfile.setTimezone(StringUtils.isEmpty(userRequestDto.timezone()) ? String.valueOf(ZoneOffset.UTC) : userRequestDto.timezone());
        agentProfile.setWorkingHoursStart(StringUtils.isEmpty(userRequestDto.workingHoursStart()) ? "09:00" : userRequestDto.workingHoursStart());
        agentProfile.setWorkingHoursEnd(StringUtils.isEmpty(userRequestDto.workingHoursEnd()) ? "17:30" : userRequestDto.workingHoursEnd());
        return agentProfile;
    }

    public static AgentProfileDto toAgentProfileDto(AgentProfile agentProfile) {
        if(agentProfile == null) {
            return null;
        }
        AgentProfileDto agentProfileDto = new AgentProfileDto();
        agentProfileDto.setAgentId(agentProfile.getAgentId());
        agentProfileDto.setSkill(agentProfile.getSkill());
        agentProfileDto.setTimezone(agentProfile.getTimezone());
        agentProfileDto.setWorkingHoursStart(agentProfile.getWorkingHoursStart());
        agentProfileDto.setWorkingHoursEnd(agentProfile.getWorkingHoursEnd());
        return agentProfileDto;
    }
}
