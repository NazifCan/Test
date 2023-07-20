package springDeneme.Service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springDeneme.Config.UserDtoConvertor;
import springDeneme.Dto.CreateUserRequest;
import springDeneme.Dto.UserDto;
import springDeneme.Entity.User;
import springDeneme.Repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserDtoConvertor userDtoConvertor;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, UserDtoConvertor userDtoConvertor) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userDtoConvertor = userDtoConvertor;
    }


    public UserDto createUser(CreateUserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setId(user.getId());

        return userDto;

    }

    public List<UserDto> getUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(item->modelMapper.map(item,UserDto.class)).collect(Collectors.toList());
    }

    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> modelMapper.map(value, UserDto.class)).orElse(null);
    }

    public UserDto updateUser(Long id,CreateUserRequest userRequest){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.get().setName(userRequest.getName());
            user.get().setSurname(userRequest.getName());
            userRepository.save(user.get());
            return  userDtoConvertor.convert(user.get());
        }
        return null;
    }

    public Boolean deleteUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
            return true;
        }else return false;
    }


}