package at.codersbay.libraryapp.api.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // Long ist der Datentyp der Id, den man dem JpaRepository bekanntgeben muss


    List<User> findByLastName(String lastName);

    List<User> findByUsername(String userName);

}
