package SpringProva.ProvaApi.controller;

import SpringProva.ProvaApi.entity.Itens;
import SpringProva.ProvaApi.entity.Pedido;
import SpringProva.ProvaApi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pedido/v1/")

public class Controller {
    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    @ResponseBody
    public Pedido create(@RequestBody Pedido pedido){
        for (Itens i : pedido.getItens()){
            i.setPrecoTotal(i.getPrecoIndividual()* i.getQuantidade());
        }

        Pedido pedidoSaved = pedidoRepository.save(pedido);
        return pedidoSaved;
    }

    @GetMapping("{id}")
    @ResponseBody
    public Optional<Pedido> getPedidoById(@PathVariable Long id){
        Optional<Pedido> pedidoReturned = pedidoRepository.findById(id);
        return pedidoReturned;
    }

    @GetMapping("todos")
    public List<Pedido> getAllPedido(){
        return pedidoRepository.findAll();
    }

    @DeleteMapping("{id}")
    public String deletePedidoById(@PathVariable Long id){
        Optional<Pedido> clienteOptional = pedidoRepository.findById(id);
        if (clienteOptional.isPresent()){
            pedidoRepository.deleteById(id);
            return "O pedido de id " + id + " foi cancelado com sucesso!";
        }else {
            return "Pedido inexistente!";
        }
    }

    @PutMapping("update/{parcela}/{id}")
    public String updatePedidoById(@PathVariable Long id, String novoNome){
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()){
            Pedido p = pedidoOptional.get();
            pedidoRepository.save(p);
            return "A parcela de id "+ id + " foi alterado com sucesso! Assim o valor total é de";
        }else {
            return "Parcela inexistente!";
        }
    }
}
