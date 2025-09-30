package org.fernando.users.controller;

import lombok.AllArgsConstructor;
import org.fernando.users.model.User;
import org.fernando.users.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping
    public ResponseEntity<List<User>> readAll() throws Exception{
        List<User> users = userService.readAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> readById(@PathVariable Integer id) throws Exception{
       User user = userService.readById(id);
       return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) throws Exception{
        User save = userService.save(user);
        //return ResponseEntity.status(HttpStatus.CREATED).body(save);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody  User user, @PathVariable Integer id) throws Exception{
        User update = userService.update(user, id);
        return ResponseEntity.ok(update);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id)  throws Exception{
        //return ResponseEntity.ok().body(userService.delete(id));
        userService.delete(id);
        //return ResponseEntity.noContent().build();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
