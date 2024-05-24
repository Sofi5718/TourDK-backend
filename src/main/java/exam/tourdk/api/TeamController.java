package exam.tourdk.api;

import exam.tourdk.dto.TeamDto;
import exam.tourdk.entity.Team;
import exam.tourdk.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/{teamId}")
    public Team getTeamById(@PathVariable int teamId){
        return teamService.getTeamById(teamId);
    }

    @PostMapping
    public Team saveTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }

    @PutMapping("/{teamId}")
    public TeamDto updateTeam(@PathVariable int teamId, @RequestBody TeamDto team) {
        return teamService.updateTeam(teamId, team);
    }

}
