package pe.edu.eupeu.clase02.service;

import java.util.List;

import pe.edu.eupeu.clase02.model.Colegio;



public interface SColegio {
	Colegio create(Colegio u);
	Colegio update(Colegio u);
	void delete(long id);
	List<Colegio> readAll();
	Colegio read(long id);
}
