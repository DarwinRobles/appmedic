package com.medic.appmedic.core.usecase.port.out;

import com.medic.appmedic.core.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(UUID id);
    void deleteById(UUID id);
}
