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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kabanapi.model.Cartao;
import br.com.kabanapi.repository.CartaoRepository;

@RestController
@RequestMapping("/cartao")
public class CartaoResource {

	@Autowired
	private CartaoRepository cartaoRepository;
	
	@GetMapping
	public List<Cartao> listarCartoes() {
		return cartaoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCartao(@PathVariable Long id) {
		
		Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);
		
		return cartaoOptional.isPresent() ?
				ResponseEntity.ok(cartaoOptional.get()):
				ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> salvarCartao(@RequestBody @Valid Cartao cartao) {
		
		Cartao cartaoSalvo = cartaoRepository.save(cartao);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cartaoSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterarCartao(@PathVariable Long id, @RequestBody @Valid Cartao cartao) {
		
		Cartao cartaoSalvo = findCartao(id);
		BeanUtils.copyProperties(cartao, cartaoSalvo);
		
		cartaoRepository.save(cartaoSalvo);
		
		return ResponseEntity.ok(cartaoSalvo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> removerCartao(@PathVariable Long id) {
		
		findCartao(id);
		
		cartaoRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	private Cartao findCartao(Long id) {
		return cartaoRepository.findById(id)
			.orElseThrow(() -> new EmptyResultDataAccessException(0));
	}
		
}
