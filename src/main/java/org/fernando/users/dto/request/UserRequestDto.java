package org.fernando.users.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@AllArgsConstructor
@Builder
public class UserRequestDto {

    private String userName;
    private String password;
    private boolean enabled;
}
