package manager.repository;

import org.springframework.data.repository.CrudRepository;

import manager.entities.Location;

public interface LocationRepository extends CrudRepository <Location, Long> {

}
