package exam.tourdk;

import exam.tourdk.entity.Rider;
import exam.tourdk.entity.Shirt;
import exam.tourdk.entity.Team;
import exam.tourdk.repository.RiderRepository;
import exam.tourdk.repository.ShirtRepository;
import exam.tourdk.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class TourDKApplication {

    public static void main(String[] args) {
        SpringApplication.run(TourDKApplication.class, args);
    }

@Bean
    public CommandLineRunner importData(TeamRepository teamRepository, RiderRepository riderRepository, ShirtRepository shirtRepository){
        return args -> {
            Team team1 = new Team ("Team 1");

            Team team2 = new Team ("Team 2");

            Team team3 = new Team ("Team 3");


            Rider rider1 = new Rider();
            rider1.setName("Sebastian");
            rider1.setAge(25);
            rider1.setMountainPoints(12);
            rider1.setSprintPoints(8);
            rider1.setTime(LocalTime.of(3, 40,34));
            riderRepository.save(rider1);

            Rider rider2 = new Rider();
            rider2.setName("Michael");
            rider2.setAge(23);
            rider2.setMountainPoints(10);
            rider2.setSprintPoints(6);
            rider2.setTime(LocalTime.of(3, 42, 12));
            riderRepository.save(rider2);

            Rider rider3 = new Rider();
            rider3.setName("Chris");
            rider3.setAge(27);
            rider3.setMountainPoints(8);
            rider3.setSprintPoints(4);
            rider3.setTime(LocalTime.of(3, 45, 23));
            riderRepository.save(rider3);

            Rider rider4 = new Rider();
            rider4.setName("John");
            rider4.setAge(29);
            rider4.setMountainPoints(6);
            rider4.setSprintPoints(2);
            rider4.setTime(LocalTime.of(3, 47, 45));
            riderRepository.save(rider4);


            List<Rider> team1Riders = team1.getRiders();
            team1Riders.add(rider1);
            team1.setRiders(team1Riders);


            List<Rider> team2Riders = team2.getRiders();
            team2Riders.add(rider2);
            team2.setRiders(team2Riders);


            List<Rider> team3Riders = team3.getRiders();
            team3Riders.add(rider3);
            team3Riders.add(rider4);
            team3.setRiders(team3Riders);

            teamRepository.save(team1);
            teamRepository.save(team2);
            teamRepository.save(team3);

Shirt shirt1 = new Shirt();
shirt1.setName("yellow");
shirtRepository.save(shirt1);

Shirt shirt2 = new Shirt();
shirt2.setName("green");
shirtRepository.save(shirt2);

Shirt shirt3 = new Shirt();
shirt3.setName("white");
shirtRepository.save(shirt3);

Shirt shirt4 = new Shirt();
shirt4.setName("Polka Dot");
shirtRepository.save(shirt4);



        };
    }
}
