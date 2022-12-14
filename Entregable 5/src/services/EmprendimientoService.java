package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Emprendimiento;
import repositorys.EmprendimientoRepository;


@Service
@Transactional
public class EmprendimientoService {

	@Autowired
	private EmprendimientoRepository emprendimientoRepository;


	
	
	public Emprendimiento recuperarEmprendimiento(int idEmprendimiento) {
		return emprendimientoRepository.findById(idEmprendimiento);
	}
	
	public boolean eliminarEmprendimiento(int idEmprendimiento) {
		Emprendimiento empre = emprendimientoRepository.findById(idEmprendimiento);
		if (empre != null) {
			emprendimientoRepository.delete(empre);
			return true;
		}
		return false;
	}
	
	public void actualizarDatosEmprendimiento(Emprendimiento empre) {
		emprendimientoRepository.save(empre);
}


}
