package com.facelesscoder.user_registration.repository;

import com.facelesscoder.user_registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KK
 * @created 10/03/2026 - 18:52
 * @project user-registration
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailId(String emailId); // TODO: it should be Optional<User>
}
