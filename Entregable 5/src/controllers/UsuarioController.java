package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Donacion;
import model.Emprendimiento;
import model.Usuario;
import repositorys.EmprendimientoRepository;
import repositorys.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;


	 
	 @PostMapping("/registrarUsuario")
	 public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usu) {
		 if (!usuarioRepository.existByUsuario(usu.getNombre()))
			 usuarioRepository.save(usu);
		 return new ResponseEntity<Usuario>(HttpStatus.CREATED);
	 }
		
	 @PutMapping("/NewPassword")
	 public ResponseEntity<Usuario> setNewPassword(@RequestBody Usuario usu) {
		 usuarioRepository.save(usu);
		 return new ResponseEntity<Usuario>(HttpStatus.OK);
		 }
	 
	 @GetMapping
	 public ResponseEntity<Usuario> prueba(){
		 return new ResponseEntity<Usuario>(HttpStatus.OK);
	 }
	 
	 @PostMapping("/login")
	 public ResponseEntity<Usuario> loginUsuario(@RequestBody Usuario usuario) {
		 String mensaje = "";
		 Usuario usu = usuarioRepository.findByUsuario(usuario.getNombre());
		 if ((usu != null) && (usu.getContraseña() == usuario.getContraseña())) {
			  mensaje	= "Usuario logeado correctamente"; 
			 return new ResponseEntity( mensaje, HttpStatus.OK);
		 }
		 mensaje = "El usuario o la contraseña no son correctos"; 
		 return new ResponseEntity(mensaje,HttpStatus.NOT_ACCEPTABLE);
	 }
	 
	 @PutMapping
	 public ResponseEntity<Usuario> donarManguitos(@RequestBody Donacion donacion, String nombre, Usuario usu){
		 EmprendimientoRepository empreRepo = null;
		 Emprendimiento empre = empreRepo.findByNombre(nombre);
		 empre.agregarDonacion(donacion);
		 empreRepo.save(empre);
		 usu.donarManguitos(donacion);
		 usuarioRepository.save(usu);
		 return new ResponseEntity<Usuario>(HttpStatus.OK);
	 }
}
