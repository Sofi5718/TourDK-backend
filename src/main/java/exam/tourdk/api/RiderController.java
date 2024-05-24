package exam.tourdk.api;

import exam.tourdk.entity.Rider;
import exam.tourdk.service.RiderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/riders")
public class RiderController {

    private final RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @GetMapping
    public List<Rider> getRiders() {
        return riderService.getRiders();
    }

    @GetMapping("/{riderId}")
    public Rider getRiderById(@PathVariable int riderId){
        return riderService.getRiderById(riderId);
    }

    @PostMapping
    public Rider saveRider(@RequestBody Rider rider) {
        return riderService.saveRider(rider);
    }
    @PutMapping("/{riderId}")
    public Rider updateRider(@PathVariable int riderId, @RequestBody Rider rider) {
        return riderService.updateRider(riderId, rider);
    }

    @DeleteMapping("/{riderId}")
    public void deleteRider(@PathVariable int riderId) {
        riderService.deleteRider(riderId);
    }
}
