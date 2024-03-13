package at.codersbay.libraryapp.api.user.create;


import at.codersbay.libraryapp.api.user.User;
import at.codersbay.libraryapp.api.user.UserResponseBody;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/")
public class CreateUserController {

    @Autowired
    private CreateUserService userService;

    @PostMapping
    public ResponseEntity<UserResponseBody> createResponse(
            @RequestBody
            CreateUserDTO createUserDTO) {

        if (createUserDTO == null || StringUtils.isEmpty(createUserDTO.getUsername())) {
            return new ResponseEntity<>(new UserResponseBody(), HttpStatus.BAD_REQUEST);
        }

        User user = this.userService.create(createUserDTO.getUsername(), createUserDTO.getFirstName(), createUserDTO.getLastName());

        return new ResponseEntity<>(new UserResponseBody(user), HttpStatus.OK);

    }


}
