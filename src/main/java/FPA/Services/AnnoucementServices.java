package FPA.Services;

import FPA.Annoucements.annoucements;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.List;

import static FPA.Services.FyleSystemService.getPathToFile;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

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

    public static ObjectRepository<annoucements> getAnnouceRepository() {

        return annouceRepository;
    }

    public static List<annoucements> getAllAnnoucements() {

        return annouceRepository.find().toList();
    }

    public static void delete(String test_annouce) {
        annouceRepository.remove(eq("annouce",test_annouce));


    }

}
