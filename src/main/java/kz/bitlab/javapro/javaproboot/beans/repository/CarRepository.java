package kz.bitlab.javapro.javaproboot.beans.repository;

import kz.bitlab.javapro.javaproboot.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {

}
