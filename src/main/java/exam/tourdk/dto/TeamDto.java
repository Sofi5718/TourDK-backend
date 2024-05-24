package exam.tourdk.dto;

import exam.tourdk.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
    private int id;
    private String name;
    private int riderId;

    public TeamDto(Team team, int riderId){
        this.id = team.getId();
        this.name = team.getName();
        this.riderId = riderId;
    }

}
