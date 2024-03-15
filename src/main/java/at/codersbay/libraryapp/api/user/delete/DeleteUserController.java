package at.codersbay.libraryapp.api.user.delete;

import at.codersbay.libraryapp.api.Response;
import at.codersbay.libraryapp.api.user.User;
import at.codersbay.libraryapp.api.user.UserRepository;
import at.codersbay.libraryapp.api.user.UserResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user/")
public class DeleteUserController {

    @Autowired
    private UserRepository userRepository;

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseBody> deleteUserById (
            @PathVariable
            long id) {

        Optional<User> userToBeDeleted = this.userRepository.findById(id);
        if (!userToBeDeleted.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        userRepository.deleteById(id);

        Response response = new Response();

        Optional<User> optionalUser = this.userRepository.findById(id);

        if(optionalUser.isPresent()) {
            response.addErrorMessage("Der Users mit de ID " + id + " konnte nicht gelöscht werden!");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        } else {
            response.addMessage("Der User mit der ID " + id + " wurde gelöscht.");
            return new ResponseEntity(response, HttpStatus.OK);
        }

    }


}
