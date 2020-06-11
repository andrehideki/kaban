package br.com.kabanapi.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kabanapi.model.Etapa;
import br.com.kabanapi.repository.EtapaRepository;

@RestController
@RequestMapping("/etapa")
public class EtapaResource {

	@Autowired
	private EtapaRepository etapaRepository;
	
	@GetMapping
	public List<Etapa> listarEtapas() {
		return etapaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEtapa(@PathVariable Long id) {
		
		Optional<Etapa> etapaOptional = etapaRepository.findById(id);
		
		return etapaOptional.isPresent() ?
				ResponseEntity.ok(etapaOptional.get()):
				ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> salvarEtapa(@RequestBody @Valid Etapa etapa) {
		
		Etapa etapaSalva = etapaRepository.save(etapa);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(etapaSalva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterarEtapa(@PathVariable Long id, @RequestBody @Valid Etapa etapa) {
		
		Etapa etapaSalva = findEtapa(id);
		BeanUtils.copyProperties(etapa, etapaSalva, "id");
		
		
		etapaRepository.save(etapaSalva);
		
		return ResponseEntity.ok(etapaSalva);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> removerEtapa(@PathVariable Long id) {
		
		findEtapa(id);
		
		etapaRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping
	public void teste() {
		Etapa etapa = new Etapa();
		etapa.setNome("Teste");
		etapa.setPosicao(1);
		
		
		Etapa etapaSalva = etapaRepository.save(etapa);
		
		System.out.println(etapaSalva);
	}
	
	private Etapa findEtapa(Long id) {
		return etapaRepository.findById(id)
			.orElseThrow(() -> new EmptyResultDataAccessException(0));
	}
}
