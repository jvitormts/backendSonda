package br.com.testesonda.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testesonda.api.model.Aeronave;

public interface AeronaveRepository extends JpaRepository<Aeronave, Long> {

	List<Aeronave> findByMarca(String nomeMarca);

}
