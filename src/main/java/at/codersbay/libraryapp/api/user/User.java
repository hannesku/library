package at.codersbay.libraryapp.api.user;

import at.codersbay.libraryapp.api.books.Book;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="TB_USERS")
public class User {

    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (!(obj instanceof User)) {
            return false;
        } else if ((this.getUsername().toLowerCase()).equals(((User) obj).getUsername().toLowerCase())) {
            return true;
        } else return false;
    }

    @Override
    public int hashCode () {
        if (this.getUsername() == null) {
            return 0;
        } else return this.getUsername().toLowerCase().hashCode();
    }

    @Id
    @GeneratedValue(generator = "user-sequence-generator")
    @GenericGenerator(
            name = "user-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;

    @Column(nullable = false, unique = true)  // der username muss ein uniquer Value sein und darf nicht leer (null) sein!)
    private String username;

    @Column()
    private String firstName;

    @Column()
    private String lastName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
