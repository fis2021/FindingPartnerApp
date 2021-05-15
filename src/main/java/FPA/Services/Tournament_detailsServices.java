package FPA.Services;

import FPA.Tournament.Tournament;
import FPA.Tournament.TournamentDetails;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import static FPA.Services.FyleSystemService.getPathToFile;

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
}
