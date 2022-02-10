package br.com.solinftec.treinamentospringboot.repository;

import br.com.solinftec.treinamentospringboot.model.Fazendeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FazendeiroRepository extends JpaRepository<Fazendeiro, Long> {

}
