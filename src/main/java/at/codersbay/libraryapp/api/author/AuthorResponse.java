package at.codersbay.libraryapp.api.author;

import at.codersbay.libraryapp.api.Response;

public class AuthorResponse extends Response {

    private Author author;

    private AuthorResponse() {

    }


    public static AuthorResponse getInstance(Author author) {
        AuthorResponse response = getInstance();
        response.author = author;

        return response;
    }

    public static AuthorResponse getInstance() {return new AuthorResponse();}
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
