package pe.edu.eupeu.clase02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.eupeu.clase02.dao.ColegioRepository;
import pe.edu.eupeu.clase02.model.Colegio;


@Service
public class ColegioService implements SColegio {
	@Autowired
	private ColegioRepository colegioRepository;

	@Override
	public Colegio create(Colegio u) {
		// TODO Auto-generated method stub
		return colegioRepository.save(u);
	}

	@Override
	public Colegio update(Colegio u) {
		// TODO Auto-generated method stub
		return colegioRepository.save(u);
	}

	@Override
	public void delete(long id) {
		colegioRepository.deleteById(id);
		
		
	}

	@Override
	public List<Colegio> readAll() {
		// TODO Auto-generated method stub
		return colegioRepository.findAll();
	}

	@Override
	public Colegio read(long id) {
		// TODO Auto-generated method stub
		return colegioRepository.findById(id).get();
	}
	
}
