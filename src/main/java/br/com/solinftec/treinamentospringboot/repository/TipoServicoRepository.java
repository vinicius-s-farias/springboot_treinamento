package br.com.solinftec.treinamentospringboot.repository;

import br.com.solinftec.treinamentospringboot.model.Tipo_Equipamento;
import br.com.solinftec.treinamentospringboot.model.Tipo_Servico;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoServicoRepository extends JpaRepository<Tipo_Servico, Long> {
}
