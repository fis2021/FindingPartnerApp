package FPA.Services;

import FPA.Customer.customer;
import FPA.Messages.messages;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import static FPA.Services.FyleSystemService.getPathToFile;

public class MessagesServices {
    private static ObjectRepository<messages> MessageryRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Messages.db").toFile())
                .openOrCreate("test", "test");

        MessageryRepository = database.getRepository(messages.class);

    }

    public static void addMessage (String from, String to, String mess){
        MessageryRepository.insert(new messages(from,to,mess));
    }

    public static ObjectRepository<messages> getMessageryRepository() {
        return MessageryRepository;
    }
}
