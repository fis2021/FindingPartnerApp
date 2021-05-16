package FPA.Services;

import FPA.Tournament.TournamentDetails;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.List;

import static FPA.Services.FyleSystemService.getPathToFile;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class Tournament_detailsServices {

    private static ObjectRepository<TournamentDetails> Tourny_DetailsRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Tourny_details.db").toFile())
                .openOrCreate("test","test" );

        Tourny_DetailsRepository = database.getRepository(TournamentDetails.class);
    }

    public static boolean addDetails(String name, String details) {
        Tourny_DetailsRepository.insert(new TournamentDetails(name,details));
        return true;
    }

    public static ObjectRepository<TournamentDetails> getTourny_DetailsRepository() {
        return Tourny_DetailsRepository;
    }

    public static void setTourny_DetailsRepository(ObjectRepository<TournamentDetails> tourny_DetailsRepository) {
        Tourny_DetailsRepository = tourny_DetailsRepository;
    }

    public static void delete(String details) {
        Tourny_DetailsRepository.remove(eq("name",details));
    }

    public static List<TournamentDetails> getAllDetails() {
        return Tourny_DetailsRepository.find().toList();
    }

}
