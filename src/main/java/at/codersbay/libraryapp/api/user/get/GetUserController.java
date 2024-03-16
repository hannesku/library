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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user/")
public class GetUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
    List<User> allUsers = this.userRepository.findAll();
    return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById (
            @PathVariable   // Definition des Endpunkts der Rest Schnittstelle
            long id) {
        Optional<User> optionalUser = this.userRepository.findById(id);

        if(!optionalUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        User user = optionalUser.get();

        return ResponseEntity.ok(user);

    }

}
