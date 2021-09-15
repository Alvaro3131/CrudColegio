package pe.edu.eupeu.clase02.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.eupeu.clase02.model.Colegio;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio, Long>{

}
