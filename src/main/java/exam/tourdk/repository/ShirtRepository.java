package exam.tourdk.repository;

import exam.tourdk.entity.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShirtRepository extends JpaRepository<Shirt, Integer> {
}
