package kz.bitlab.javapro.javaproboot.beans.repository;

import kz.bitlab.javapro.javaproboot.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {

    //List<Car> findAllByIdNotNullOrdOrderByPriceDesc();
    List<Car> findAllByPriceGreaterThanEqualOrderByEngineVolumeAsc(int price);

    @Query("SELECT c.engineVolume FROM Car c WHERE c.id =:idshka")
    double getEngineVolume(@Param("idshka") Long id);



}
