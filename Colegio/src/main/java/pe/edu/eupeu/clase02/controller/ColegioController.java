package pe.edu.eupeu.clase02.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.eupeu.clase02.model.Colegio;
import pe.edu.eupeu.clase02.service.ColegioService;


@RestController
@RequestMapping("/api/colegio")
public class ColegioController {
	@Autowired
	private ColegioService colegioService;
		@PostMapping("/crear")
		public ResponseEntity<Colegio> save(@RequestBody Colegio Colegio) {
			try {
				Colegio u = colegioService.create(new Colegio(Colegio.getIdcolegio(), Colegio.getNombre(), Colegio.getDireccion()));
			    return new ResponseEntity<>(u,HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/listar")
		public ResponseEntity<List<Colegio>> getAllUsuario(@RequestParam(required = false) String nombre){
			try {
				List<Colegio> colegios = new ArrayList<Colegio>();
				colegios= colegioService.readAll();
				if(colegios.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					
				}
				return new ResponseEntity<>(colegios, HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/read/{id}")
		public ResponseEntity<Colegio> getUser(@PathVariable("id") long id){
			Colegio colegio = colegioService.read(id);
				if(colegio.getIdcolegio()>0) {
					return new ResponseEntity<>(colegio, HttpStatus.OK);
				}else {
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				} 
		}
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
			try {
				colegioService.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@PutMapping("/update/{id}")
		public ResponseEntity<Colegio> update(@RequestBody Colegio colegio, @PathVariable("id") long id){
			try {
				Colegio pp = colegioService.read(id);
				if(pp.getIdcolegio()>0) {
					pp.setNombre(colegio.getNombre());
					pp.setDireccion(colegio.getDireccion());
					
					return new ResponseEntity<>(colegioService.create(pp),HttpStatus.OK);
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}			

			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
