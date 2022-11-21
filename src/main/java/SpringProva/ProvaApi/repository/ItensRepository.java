package SpringProva.ProvaApi.repository;

import SpringProva.ProvaApi.entity.Itens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensRepository extends JpaRepository<Itens, Long> {
}
