package FPA.Services;

import FPA.Tournament.Tournament;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectFilter;
import org.dizitart.no2.objects.ObjectRepository;

import static FPA.Services.FyleSystemService.getPathToFile;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class TournamentServices {
    private static ObjectRepository<Tournament> TournyRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Tourny.db").toFile())
                .openOrCreate("test","test" );

       TournyRepository = database.getRepository(Tournament.class);
    }

    public static boolean add(String name, String date) {
        TournyRepository.insert(new Tournament(name,date));
        return true;
    }

    public static ObjectRepository<Tournament> getTournyRepository() {
        return TournyRepository;
    }

    public static void setTournyRepository(ObjectRepository<Tournament> tournyRepository) {
        TournyRepository = tournyRepository;
    }

    public static boolean remove(Tournament t) {
       TournyRepository.remove(eq("name",t.getName()));
        return true;
    }
}
