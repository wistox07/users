package org.fernando.users.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Integer idUser;
    private String userName;
    private boolean enabled;
}
