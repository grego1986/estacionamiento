package com.estacionamiento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamiento.pojo.Comercio;
import com.estacionamiento.repository.IComercioRepo;

@Service
public class ComercioService implements IComercioService {

	@Autowired
	private IComercioRepo comercioRepo;
	@Override
	public List<Comercio> listar() {
		
		return comercioRepo.findAll();
	}

	@Override
	public void agregar(Comercio comercio) {
		
		comercioRepo.save(comercio);
	}

	@Override
	public void actualizar(Comercio comercio, Long id) {
		
		if (comercioRepo.existsById(id)) {
            comercio.setCuil(id);
            comercioRepo.save(comercio);
        }
	}

	@Override
	public Comercio buscar(Long id) {
		
		return comercioRepo.findById(id).orElse(null);
	}

	@Override
	public Optional<Comercio> buscarOptional(Long id) {
		return comercioRepo.findById(id);
	}

	@Override
	public void delete(Long id) {
		Comercio c;
		if (comercioRepo.existsById(id)) {
            c = buscar(id);
            c.setEstado(false);
            comercioRepo.save(c);
        }
	}
}
