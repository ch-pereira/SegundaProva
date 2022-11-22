package SpringProva.ProvaApi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Pedido {

    @Id
    private Long id;
    private String endereco;
    private String cep;
    private Integer numero;
    private String formaPagamento;
    private Integer parcela;
    private Double valorTotal;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Itens> itens;

    public Pedido(){
    }

    public Pedido(String endereco, String cep, Integer numero, String formaPagamento, Integer parcela, Double valorTotal, List<Itens> itens) {
        this.endereco = endereco;
        this.cep = cep;
        this.numero = numero;
        this.formaPagamento = formaPagamento;
        this.parcela = parcela;
        this.valorTotal = valorTotal;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public Double getValorTotal(Double total) {
        return valorTotal;
    }

    public Double setValorTotal() {
        return valorTotal;
    }

    public List<Itens> getItens() {
        return itens;
    }

    public void setItens(List<Itens> itens) {
        this.itens = itens;
    }
}
