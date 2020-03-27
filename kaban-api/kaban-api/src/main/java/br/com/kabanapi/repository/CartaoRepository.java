package br.com.kabanapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kabanapi.model.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

}
