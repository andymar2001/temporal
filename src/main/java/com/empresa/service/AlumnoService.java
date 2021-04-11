package com.empresa.service;

import java.util.List;

import com.empresa.entity.Alumno;

public interface AlumnoService {

	public abstract Alumno insertaAlumno(Alumno obj);

	public abstract List<Alumno> listaAlumnoNombre(String nombre);

	public abstract List<Alumno> listaAlumnoDni(String dni);

	public abstract List<Alumno> listaAlumnoNombreYDni(String filtroNombre, String filtroDni);

}
