package br.com.solinftec.treinamentospringboot.repository;

import br.com.solinftec.treinamentospringboot.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
}
