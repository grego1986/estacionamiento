package com.estacionamiento.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionamiento.pojo.Persona;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Long>{
	Persona findByDni(Long dni);
}
