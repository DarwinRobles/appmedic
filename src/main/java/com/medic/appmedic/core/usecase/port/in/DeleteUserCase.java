package com.medic.appmedic.core.usecase.port.in;

import java.util.UUID;

public interface DeleteUserCase {
    void delete(UUID id);
}
