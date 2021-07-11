package com.model.repository.user;

import com.model.entity.user.AppUser;
import com.model.entity.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByAppUser(AppUser appUser);
}
