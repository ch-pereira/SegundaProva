package SpringProva.ProvaApi.repository;

import SpringProva.ProvaApi.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
