package FPA.Services;

import FPA.Exceptions.AccAlreadyExistException;
import FPA.Moderator.moderator;
import FPA.annoucements.annoucements;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import static FPA.Services.FyleSystemService.getPathToFile;

public class AnnoucementServices {
    private static ObjectRepository<annoucements> annouceRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Annouce.db").toFile())
                .openOrCreate("test","test" );

        annouceRepository = database.getRepository(annoucements.class);
    }

    public static void addAnnouce(String annouce){
        annouceRepository.insert(new annoucements(annouce));
    }
}
