package FPA.Services;

import FPA.Exceptions.AccAlreadyExistException;
import FPA.Exceptions.UsernameOrPasswordIncorrectException;
import FPA.Exceptions.WrongRoleException;
import FPA.Moderator.moderator;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

import static FPA.Services.FyleSystemService.getPathToFile;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class ModeratorSevices {


    private static ObjectRepository<moderator> userRepository;
    private static Nitrite database;

    public static ObjectRepository<moderator> getUserRepository() {
        return userRepository;
    }

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

    public static String encodePassword(String salt, String password) {
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

    public static void checkUser(String username, String password) throws UsernameOrPasswordIncorrectException, IOException {
        checkPassAndAcc(username,password);
    }

    public static boolean checkPassAndAcc(String username, String password) throws UsernameOrPasswordIncorrectException {
        String new_password = encodePassword(username,password);
        for (moderator user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()) && Objects.equals(new_password,user.getPassword()))
            {
                return true;
            }
        }
        throw new UsernameOrPasswordIncorrectException(username);
    }

    public static boolean checkR(String username, String role) throws WrongRoleException {
        for (moderator user : userRepository.find())
        {
            if(Objects.equals(username,user.getUsername()) && Objects.equals(role,user.getRole()))
            {
                return true;
            }
        }
        throw new WrongRoleException(username);

    }

    public static int NumberOfPlayers() {
        int count=0;
        for(moderator user: userRepository.find())
        {
            if(Objects.equals(user.getRole(),"Customer"))
            {
                count++;
            }
        }
        return count;
    }

    public static List<moderator> getAllUsers() {
        return userRepository.find().toList();
    }

    public static void delete(String test_username) {
        userRepository.remove(eq("username",test_username));

    }

    public static void close() {
        userRepository.close();
    }

    public static List<moderator> getUsers() {
        return userRepository.find().toList();
    }
}
