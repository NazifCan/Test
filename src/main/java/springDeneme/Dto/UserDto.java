package springDeneme.Dto;

import lombok.Data;
import springDeneme.Entity.BaseUser;

@Data
public class UserDto  {
    private String name;
    private String surname;
    private Long id;
}
