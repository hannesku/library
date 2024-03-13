package at.codersbay.libraryapp.api.author.update;

import at.codersbay.libraryapp.api.author.Author;
import at.codersbay.libraryapp.api.author.AuthorRepository;
import at.codersbay.libraryapp.api.author.AuthorResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/author/")

public class UpdateAuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @PutMapping
    public ResponseEntity<AuthorResponse> update(
            @RequestBody
            UpdateAuthorDTO updateAuthorDTO) {
        if (updateAuthorDTO == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Optional<Author> optionalAuthor = this.authorRepository.findById(updateAuthorDTO.getId());

        if (optionalAuthor.isEmpty()) {
            AuthorResponse response = AuthorResponse.getInstance(null);
            response.addErrorMessage("could not find author by id " + updateAuthorDTO.getId());

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Author author = optionalAuthor.get();


        if(!StringUtils.isEmpty(updateAuthorDTO.getFirstName())) {
            author.setFirstName(updateAuthorDTO.getFirstName());
        }

        if (!StringUtils.isEmpty(updateAuthorDTO.getLastName())) {
            author.setLastName(updateAuthorDTO.getLastName());
        }

        System.out.println("save...");
        this.authorRepository.save(author);
        this.authorRepository.flush();

        System.out.println("save...");
        AuthorResponse response = AuthorResponse.getInstance(author);

        return ResponseEntity.ok(response);
    }

}
