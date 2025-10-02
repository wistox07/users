package org.fernando.users.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class GenericResponseDto<T> {
    private int status;
    private String message;
    private T data;
}
