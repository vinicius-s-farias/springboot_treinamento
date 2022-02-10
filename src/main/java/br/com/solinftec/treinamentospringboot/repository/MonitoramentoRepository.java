package br.com.solinftec.treinamentospringboot.repository;

import br.com.solinftec.treinamentospringboot.model.Monitoramento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoramentoRepository extends JpaRepository<Monitoramento, Long> {
}
