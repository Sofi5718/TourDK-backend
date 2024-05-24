package exam.tourdk.service;

import exam.tourdk.dto.TeamDto;
import exam.tourdk.entity.Rider;
import exam.tourdk.entity.Team;
import exam.tourdk.repository.RiderRepository;
import exam.tourdk.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final RiderRepository riderRepository;

    public TeamService(TeamRepository teamRepository, RiderRepository riderRepository) {
        this.teamRepository = teamRepository;
        this.riderRepository = riderRepository;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(int teamId) {
        return teamRepository.findById(teamId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found"));
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public TeamDto updateTeam(int teamId, TeamDto team) {
        Team currentTeam = teamRepository.findById(teamId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found"));
        currentTeam.setName(team.getName());
        Rider r = riderRepository.findById(team.getRiderId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rider not found"));
        List<Rider> riders = currentTeam.getRiders();
        riders.add(r);
        currentTeam.setRiders(riders);
        teamRepository.save(currentTeam);
        return new TeamDto(currentTeam, r.getId());

    }
}
