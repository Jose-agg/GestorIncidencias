package asw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.entities.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{

}
