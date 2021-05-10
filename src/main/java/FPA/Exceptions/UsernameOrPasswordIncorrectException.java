package FPA.Exceptions;

public class UsernameOrPasswordIncorrectException extends Exception {
    private String username;

    public UsernameOrPasswordIncorrectException(String username) {
        super(String.format("Acc or password incorrect", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
