package br.com.kabanapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Cartao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Column(name = "data_insercao")
	@NotNull
	private Date dataInsercao;
	
	@Column(name = "data_atualizacao")
	@NotNull
	private Date dataAtualizacao;
	
	private Integer prioridade = 0;
	
	@Enumerated(EnumType.STRING)
	private Cor cor = Cor.BRANCO;
	
}
