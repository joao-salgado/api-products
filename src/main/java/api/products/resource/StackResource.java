package api.products.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.products.model.Stack;
import api.products.repository.StackRepository;

@RestController
@RequestMapping("/stacks")
public class StackResource {
	
	@Autowired
	private StackRepository stackRepository;
	
	@GetMapping
	public List<Stack> findAll() {
		return stackRepository.findAll();
	}
	
}
