package br.com.solinftec.treinamentospringboot.repository;

import br.com.solinftec.treinamentospringboot.model.Tipo_Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEquipamentoRepository extends JpaRepository<Tipo_Equipamento, Long> {
}
