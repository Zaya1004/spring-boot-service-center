package mn.icode.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mn.icode.entity.Service;
import mn.icode.repository.ServiceRepository;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
	private final ServiceRepository serviceRepository;
	
	public ServiceController(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}
//	
//	public List<Service> getAll(@RequestParam (required = false) 
//	String name, @RequestParam(required = false) 
//	Long categoryId){
//		if (name != null) {
//			return serviceRepository.findByNameContainingIgnoreCase(name);
//		}
//		
//		if(categoryId != null) {
//			return serviceRepository.findByCategoryId(categoryId);
//		}
//		
//		return serviceRepository.findByActiveTrue();	}
	
	@GetMapping
	public List<Service> getServices(){
		return serviceRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Service> getService(@PathVariable Long id){
		return serviceRepository.findById(id).map(ResponseEntity::ok).orElseThrow();
	}
	
	public void delete(@PathVariable Long id) {
		serviceRepository.deleteById(id);
	}
	
}
