package br.com.kabanapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kabanapi.model.Etapa;

@Repository
public interface EtapaRepository extends JpaRepository<Etapa, Long>{

}
