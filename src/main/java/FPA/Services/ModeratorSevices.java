package FPA.Services;

import FPA.Exceptions.AccAlreadyExistException;
import FPA.Moderator.moderator;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static FPA.Services.FyleSystemService.getPathToFile;
public class ModeratorSevices {


    private static ObjectRepository<moderator> userRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("FPA.db").toFile())
                .openOrCreate("test","test" );

        userRepository = database.getRepository(moderator.class);
    }

    public static void addUser(String username, String password, String role) throws AccAlreadyExistException {
        checUserDoesNotAlreadyExist(username);
        userRepository.insert(new moderator(username, encodePassword(username, password), role));
    }

    private static void checUserDoesNotAlreadyExist(String username) throws AccAlreadyExistException {
        for (moderator user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new AccAlreadyExistException(username);
        }
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }



}
