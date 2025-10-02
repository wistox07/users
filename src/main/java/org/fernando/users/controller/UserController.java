package org.fernando.users.controller;

import lombok.AllArgsConstructor;
import org.fernando.users.dto.request.UserRequestDto;
import org.fernando.users.dto.response.GenericResponseDto;
import org.fernando.users.dto.response.UserResponseDto;
import org.fernando.users.model.User;
import org.fernando.users.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;
    private final RestClient.Builder builder;

    @GetMapping
    public ResponseEntity<GenericResponseDto<List<UserResponseDto>>> readAll() throws Exception{
        /*List<UserDTO> users = userService.readAll().stream().map(e -> new UserDTO(
                e.getIdUser(),
                e.getUsername(),
                e.isEnabled()
        )).toList();
        */

        List<UserResponseDto> users = userService.readAll().stream().map(e ->
                UserResponseDto.builder()
                        .idUser(e.getIdUser())
                        .userName(e.getUsername())
                        .enabled(e.isEnabled())
                        .build())
                .toList();

        //return ResponseEntity.ok(new GenericResponseDto<>(200,"success",users));
        return ResponseEntity.ok( GenericResponseDto.<List<UserResponseDto>>builder()
                .message("success")
                .status(200)
                .data(users) // T = List<UserResponseDto>
                .build());

    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseDto<UserResponseDto>> readById(@PathVariable Integer id) throws Exception{
       User user = userService.readById(id);
       UserResponseDto userDto = UserResponseDto.builder()
               .idUser(user.getIdUser())
               .userName(user.getUsername())
               .enabled(user.isEnabled())
               .build();

       //return ResponseEntity.ok(new  GenericResponseDto<>(200,"success",userDto));
        return ResponseEntity.ok( GenericResponseDto.<UserResponseDto>builder()
                .message("success")
                .status(200)
                .data(userDto) // T = List<UserResponseDto>
                .build());    }

    @PostMapping
    public ResponseEntity<GenericResponseDto<UserResponseDto>> save(@RequestBody UserRequestDto dto) throws Exception{
        User user = User.builder()
                .username(dto.getUserName())
                .password(dto.getPassword())
                .enabled(dto.isEnabled())
                .build();

        User save = userService.save(user);


        UserResponseDto userDto = UserResponseDto.builder()
                .idUser(save.getIdUser())
                .userName(save.getUsername())
                .enabled(save.isEnabled())
                .build();


        //return ResponseEntity.status(HttpStatus.CREATED).body(save);
        return new ResponseEntity<>(GenericResponseDto.<UserResponseDto>builder()
                .message("success")
                .status(200)
                .data(userDto) // T = List<UserResponseDto>
                .build()
                , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponseDto<UserResponseDto>> update(@RequestBody  UserRequestDto dto, @PathVariable Integer id) throws Exception{
        User user = User.builder()
                .username(dto.getUserName())
                .password(dto.getPassword())
                .build();

        User update = userService.update(user, id);

        UserResponseDto userDto = UserResponseDto.builder()
                .idUser(update.getIdUser())
                .userName(update.getUsername())
                .enabled(update.isEnabled())
                .build();

        return ResponseEntity.ok(GenericResponseDto.<UserResponseDto>builder()
                .message("success")
                .status(200)
                .data(userDto) // T = List<UserResponseDto>
                .build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id)  throws Exception{
        //return ResponseEntity.ok().body(userService.delete(id));
        userService.delete(id);
        //return ResponseEntity.noContent().build();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
