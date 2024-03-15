package at.codersbay.libraryapp.api.user.update;

import at.codersbay.libraryapp.api.user.User;
import at.codersbay.libraryapp.api.user.UserRepository;
import at.codersbay.libraryapp.api.user.UserResponseBody;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/")
public class UpdateUserController {

    @Autowired
    private UserRepository userRepository;

    @PutMapping
    public ResponseEntity<UserResponseBody> updateUserByUsername (
        @RequestBody
        UpdateUserDTO updateUserDTO) {

        List<User> allUsers = this.userRepository.findAll();


        for (User user : allUsers) {
            if (user.equals(updateUserDTO.getUsername())) {
                user.setFirstName(updateUserDTO.getFirsName());
                user.setLastName(updateUserDTO.getLastName());
                this.userRepository.save(user);
            }
        }


        return new ResponseEntity<>(HttpStatus.OK);

    }



}
