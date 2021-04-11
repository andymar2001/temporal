package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Alumno;
import com.empresa.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;

	@Override
	public Alumno insertaAlumno(Alumno obj) {
		return repository.save(obj);
	}

	@Override
	public List<Alumno> listaAlumnoNombre(String nombre) {
		return repository.findByNombreLike(nombre + "%");
	}

	@Override
	public List<Alumno> listaAlumnoDni(String dni) {
		return repository.findByDniLike(dni + "%");
	}

	@Override
	public List<Alumno> listaAlumnoNombreYDni(String filtroNombre, String filtroDni) {
		return repository.findByNombreLikeAndDniLike(filtroNombre + "%", filtroDni + "%");
	}

}
