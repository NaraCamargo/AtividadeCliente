package br.com.etec.nara.AtividadeCliente.repository.Dtos;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ContasReceberDtos {

    private Integer id;
    private LocalDate dataconta;
    private BigDecimal valorconta;

    private String nomecliente;

    public ContasReceberDtos(Integer id, LocalDate dataconta, BigDecimal valorconta, String nomecliente) {
        this.id = id;
        this.dataconta = dataconta;
        this.valorconta = valorconta;
        this.nomecliente = nomecliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataconta() {
        return dataconta;
    }

    public void setDataconta(LocalDate dataconta) {
        this.dataconta = dataconta;
    }

    public BigDecimal getValorconta() {
        return valorconta;
    }

    public void setValorconta(BigDecimal valorconta) {
        this.valorconta = valorconta;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }
}