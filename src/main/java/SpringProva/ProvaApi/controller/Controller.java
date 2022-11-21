package SpringProva.ProvaApi.controller;

import SpringProva.ProvaApi.entity.Pedido;
import SpringProva.ProvaApi.repository.PedidoRepository;
import org.aspectj.apache.bcel.Repository;
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
        Pedido pedidoSaved = pedidoRepository.save(pedido);
        return pedidoSaved;
    }

    @GetMapping("{id}")
    @ResponseBody
    public Optional<Pedido> getPedidoById(@PathVariable Long id){
        Optional<Pedido> pedidoReturned = pedidoRepository.findById(id);
        return pedidoReturned;
    }

    @GetMapping
    public List<Pedido> getAllPedido(){
        return pedidoRepository.findAll();
    }

    @DeleteMapping("{id}")
    public String deletePedidoById(@PathVariable Long id){
        Optional<Pedido> clienteOptional = pedidoRepository.findById(id);
        if (clienteOptional.isPresent()){
            pedidoRepository.deleteById(id);
            return "Cliente de id " + id + " foi deletado com sucesso!";
        }else {
            return "Cliente inexistente!";
        }
    }

    @PutMapping("update/{id}")
    public String updatePedidoById(@PathVariable Long id, String novoNome){
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()){
            Pedido p = pedidoOptional.get();
            pedidoRepository.save(p);
            return "Cliente de id "+ id + " salvo com sucesso!";
        }else {
            return "Cliente inexistente!";
        }
    }
}
