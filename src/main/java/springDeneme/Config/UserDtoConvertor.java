package springDeneme.Config;


import org.springframework.context.annotation.Configuration;
import springDeneme.Dto.UserDto;
import springDeneme.Entity.User;

@Configuration
public class UserDtoConvertor {


    public UserDto convert(User user){
        UserDto userDto =new UserDto();
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setId(user.getId());
        return userDto;
    }
}
