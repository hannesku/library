package at.codersbay.libraryapp.api.user.get;

import at.codersbay.libraryapp.api.user.User;
import at.codersbay.libraryapp.api.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/user/")
public class GetUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById (
            @PathVariable
            long id) {
        Optional<User> optionalUser = this.userRepository.findById(id);

        if(!optionalUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

}
