package com.facelesscoder.user_registration.repository;

import com.facelesscoder.user_registration.entity.AgentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KK
 * @created 10/03/2026 - 18:55
 * @project user-registration
 */
public interface AgentProfileRepository extends JpaRepository<AgentProfile, Long> {
    // no need to declare any method, as we intend to findById only which is by default present through JpaRepository
}
