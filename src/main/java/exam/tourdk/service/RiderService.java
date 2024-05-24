package exam.tourdk.service;

import exam.tourdk.entity.Rider;
import exam.tourdk.repository.RiderRepository;
import exam.tourdk.repository.ShirtRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RiderService {
    private final RiderRepository riderRepository;
    private final ShirtRepository shirtRepository;

    public RiderService(RiderRepository riderRepository, ShirtRepository shirtRepository) {
        this.riderRepository = riderRepository;
        this.shirtRepository = shirtRepository;
    }

    public List<Rider> getRiders(){
        return riderRepository.findAll();
    }

    public Rider getRiderById(int riderId) {
        return riderRepository.findById(riderId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rider not found"));

    }

    public Rider saveRider(Rider rider) {
        return riderRepository.save(rider);
    }

    public Rider updateRider(int riderId, Rider rider) {
        Rider currentRider = riderRepository.findById(riderId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rider not found"));
        currentRider.setName(rider.getName());
        currentRider.setTime(rider.getTime());
        currentRider.setAge(rider.getAge());
        currentRider.setMountainPoints(rider.getMountainPoints());
        currentRider.setSprintPoints(rider.getSprintPoints());
        return riderRepository.save(currentRider);
    }


    public void deleteRider(int riderId) {
        Rider r = riderRepository.findById(riderId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rider not found"));
        riderRepository.deleteById(riderId);
    }
}
