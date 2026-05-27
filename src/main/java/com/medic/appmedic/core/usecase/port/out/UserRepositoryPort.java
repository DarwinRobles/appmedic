package com.medic.appmedic.core.usecase.port.out;

import java.util.Optional;
import java.util.UUID;

import com.medic.appmedic.core.entity.User;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(UUID id);
}
