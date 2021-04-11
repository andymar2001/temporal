package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

@Controller
public class AlumnoController {

	@Autowired
	private AlumnoService service;

	@RequestMapping("/verRegistraAlumno")
	public String verRegistra() {
		return "registraAlumno";
	}

	@RequestMapping("/verConsultaAlumnoNombre")
	public String verConsultaNombre() {
		return "consultaAlumnoPorNombre";
	}

	@RequestMapping("/verConsultaAlumnoDNI")
	public String verConsultaDNI() {
		return "consultaAlumnoPorDNI";
	}

	@RequestMapping("/verConsultaAlumnoPorNombreYDni")
	public String verConsultaNombreYDNI() {
		return "consultaAlumnoPorNombreYDni";
	}

	@RequestMapping("/registraAlumno")
	@ResponseBody
	public Map<String, Object> registra(Alumno obj) {

		Map<String, Object> salida = new HashMap<>();

		Alumno objSalida = service.insertaAlumno(obj);

		if (objSalida == null) {
			salida.put("MENSAJE", "Registro erróneo");
		} else {
			salida.put("MENSAJE", "Registro exitoso");
		}

		return salida;

	}

	@RequestMapping("/listaAlumnoPorNombre")
	@ResponseBody
	public List<Alumno> listaPorNombre(String filtro) {
		return service.listaAlumnoNombre(filtro);
	}

	@RequestMapping("/listaAlumnoPorDni")
	@ResponseBody
	public List<Alumno> listaPorDni(String filtro) {
		return service.listaAlumnoDni(filtro);
	}

	@RequestMapping("/listaAlumnoPorNombreYDni")
	@ResponseBody
	public List<Alumno> listaPorNombreYDni(String filtroNombre, String filtroDni) {
		return service.listaAlumnoNombreYDni(filtroNombre, filtroDni);
	}

}
