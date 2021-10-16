package br.com.testesonda.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.testesonda.api.controller.dto.AeronaveDto;
import br.com.testesonda.api.controller.dto.DetalhesAeronaveDto;
import br.com.testesonda.api.controller.form.AeronaveForm;
import br.com.testesonda.api.controller.form.AtualizacaoAeronaveForm;
import br.com.testesonda.api.model.Aeronave;
import br.com.testesonda.api.repository.AeronaveRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/aeronaves")
public class AeronaveController {
	
	@Autowired
	private AeronaveRepository aeronaveRepository;
	
	/**
	 * Endpoint que lista todas aeronaves cadastradas.
	 * @param nomeMarca
	 * @author jvmartins
	 */
	@GetMapping
	public List<AeronaveDto> lista(){
		
		List<Aeronave> aeronaves = aeronaveRepository.findAll();
		return AeronaveDto.converter(aeronaves);	
	}
	
	/**
	 * Endpoint que retorna uma busca com filtrada ao passar o nome da Marca.
	 * @param nomeMarca
	 * @author jvmartins
	 */
	@GetMapping("/find")
	public List<AeronaveDto> listafiltrada(String nomeMarca ){
		if(nomeMarca == null){
			List<Aeronave> aeronaves = aeronaveRepository.findAll();
			return AeronaveDto.converter(aeronaves);
		}else {
			
			List<Aeronave> aeronaves = aeronaveRepository.findByMarca(nomeMarca);
			return AeronaveDto.converter(aeronaves);
		}
	}
	
	/**
	 * Endpoint que cadastra uma nova aeronave.
	 * @return Retorna 201(created) e a URL da objeto recém criado
	 * @author jvmartins
	 */
	@PostMapping
	@Transactional
	// Para diferenciar DTO usamos Form, especificando dados que CHEGAM  para API;
	public ResponseEntity<AeronaveDto> cadastrar(@RequestBody @Valid AeronaveForm form, UriComponentsBuilder uriBuilder) {
		
		//Convertendo o form para aeronave
		Aeronave aeronave = form.converter();
		aeronaveRepository.save(aeronave);
		
		URI uri = uriBuilder.path("/aeronaves/{id}").buildAndExpand(aeronave.getId()).toUri();
		//Quando algo foi criado no servidor retornamos não 200 e sim 201(created),  e a semantica do 201 implica em retornos especificos no cabeçalho;
		return ResponseEntity.created(uri).body(new AeronaveDto(aeronave));
	}
	
	/**
	 * Endpoint que detalha  uma  aeronave.
	 * @return Retorna detalhes da aeronave conforme o ID passado como parametro
	 * @author jvmartins
	 */
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesAeronaveDto> detalhar(@PathVariable Long id) {
		
		//Verificando se o ID buscado existe na base de dados, usando o findById // Optional<> = Pode ou não ter objeto
		Optional<Aeronave> aeronave = aeronaveRepository.findById(id);
		if(aeronave.isPresent()) {
			return ResponseEntity.ok(new DetalhesAeronaveDto(aeronave.get()));
		}
		return ResponseEntity.notFound().build();	
	}
	
	
	/**
	 * Endpoint que atualiza uma  aeronave.
	 * @return Retorna 200 e o objeto recem atualizado
	 * @author jvmartins
	 */
	@PutMapping("/{id}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@Transactional
	public ResponseEntity<AeronaveDto> atualizar(@PathVariable Long id,@RequestBody @Valid AtualizacaoAeronaveForm form) {
		
		Optional<Aeronave> optional = aeronaveRepository.findById(id);
		
		if(optional.isPresent()) {
			Aeronave aeronave = form.atualizar(id, aeronaveRepository);
			return ResponseEntity.ok(new AeronaveDto(aeronave));
		}
		return ResponseEntity.notFound().build();	
	}
	
	/**
	 * Endpoint que exclui uma  aeronave.
	 * @return 
	 * @author jvmartins
	 */
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		
		Optional<Aeronave> optional = aeronaveRepository.findById(id);
		if(optional.isPresent()) {
			aeronaveRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	

}
