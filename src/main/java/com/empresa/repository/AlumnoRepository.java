package com.empresa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	public abstract List<Alumno> findByNombreLike(String filtro);

	public abstract List<Alumno> findByDniLike(String filtro);

	public abstract List<Alumno> findByNombreLikeAndDniLike(String filtroNombre, String filtroDni);

}
