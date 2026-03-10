package com.facelesscoder.user_registration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author KK
 * @created 10/03/2026 - 18:46
 * @project user-registration
 */

@Entity
@Table(name = "agents")
@Getter
@Setter
public class AgentProfile {
    @Id
    private Long agentId; // same as user.id, not auto incremented

    private String timezone;

    private String skill;

    private String workingHoursStart; // eg "09:00"

    private String workingHoursEnd; // eg "17:30"
}
