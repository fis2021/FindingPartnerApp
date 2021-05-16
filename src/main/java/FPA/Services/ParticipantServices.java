package FPA.Services;

import FPA.Tournament.Tournament;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.List;

import static FPA.Services.FyleSystemService.getPathToFile;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class ParticipantServices {

    private static ObjectRepository<Tournament> participantRepository;

    public static void initPartDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Paricipants.db").toFile())
                .openOrCreate("test","test" );

        participantRepository = database.getRepository(Tournament.class);
    }

    public static void add(String tournament_name, String username) {
        participantRepository.insert(new Tournament(tournament_name,username,1));
    }

    public static List<Tournament> getTour_part() {
        return participantRepository.find().toList();
    }

    public static void delete_participants(String test_username) {
        participantRepository.remove(eq("name",test_username));

    }
}
