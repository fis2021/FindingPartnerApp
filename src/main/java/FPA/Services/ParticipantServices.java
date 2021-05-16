package FPA.Services;

import FPA.Moderator.moderator;
import FPA.Tournament.Tournament;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import static FPA.Services.FyleSystemService.getPathToFile;

public class ParticipantServices {

    private static ObjectRepository<Tournament> participantRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Paricipants.db").toFile())
                .openOrCreate("test","test" );

        participantRepository = database.getRepository(Tournament.class);
    }

    public static void add(String tournament_name, String username) {
        participantRepository.insert(new Tournament(tournament_name,username,1));
    }
}
