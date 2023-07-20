package springDeneme.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springDeneme.Dto.CreateUserRequest;
import springDeneme.Dto.UserDto;
import springDeneme.Entity.User;
import springDeneme.Service.UserService;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class Controller {


    private final UserService userService;



    public Controller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest createUserRequest) {
        UserDto result=userService.createUser(createUserRequest);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getUsers(){
      List<UserDto> dtos = userService.getUsers();
      return ResponseEntity.ok(dtos);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable ("id") Long id){
        UserDto userDto=userService.getUser(id);
        return ResponseEntity.ok(userDto);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody CreateUserRequest userRequest){
        UserDto updatedUser=userService.updateUser(id,userRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable ("id") Long id){
         Boolean ok = userService.deleteUser(id);
         return ResponseEntity.ok(ok);
    }

}
