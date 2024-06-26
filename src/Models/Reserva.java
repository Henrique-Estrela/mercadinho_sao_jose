package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reserva {

    private Integer num;
    private Integer idCliente;
    private Integer idAtendente;
    private Integer idQuarto;
    private Integer idFormaPagamento;
    private LocalDateTime dataCheckin;
    private LocalDateTime dataCheckout;
    private Integer numHospedes;
    private Double valorPagamento;
    private boolean pago;

    // Construtores
    public Reserva(Integer num, Integer idCliente, Integer idAtendente, Integer idQuarto, Integer idFormaPagamento, LocalDateTime dataCheckin, LocalDateTime dataCheckout, Integer numHospedes, Double valorPagamento, boolean pago) {
        this.num = num;
        this.idCliente = idCliente;
        this.idAtendente = idAtendente;
        this.idQuarto = idQuarto;
        this.idFormaPagamento = idFormaPagamento;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.numHospedes = numHospedes;
        this.valorPagamento = valorPagamento;
        this.pago = pago;
    }

    public Reserva(Integer num, Integer idCliente, Integer idAtendente, Integer idQuarto, Integer idFormaPagamento, LocalDateTime dataCheckin, LocalDateTime dataCheckout, Integer numHospedes, Double valorPagamento) {
        this.num = num;
        this.idCliente = idCliente;
        this.idAtendente = idAtendente;
        this.idQuarto = idQuarto;
        this.idFormaPagamento = idFormaPagamento;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.numHospedes = numHospedes;
        this.valorPagamento = valorPagamento;
    }

    public Reserva(Integer num, boolean pago) {
        this.num = num;
        this.pago = pago;
    }

    public Reserva(ResultSet rs) {
        try {
            this.num = rs.getInt("NUM_RESERVA");
            this.idCliente = rs.getInt("ID_CLIENTE");
            this.idAtendente = rs.getInt("ID_ATENDENTE");
            this.idQuarto = rs.getInt("ID_QUARTO");
            this.idFormaPagamento = rs.getInt("ID_PAGAMENTO");
            if (rs.getTimestamp("data_checkin") != null) {
                this.dataCheckin = rs.getTimestamp("data_checkin").toLocalDateTime();
            }
            if (rs.getTimestamp("data_checkout") != null) {
                this.dataCheckout = rs.getTimestamp("data_checkout").toLocalDateTime();
            }
            this.numHospedes = rs.getInt("NUM_HOSPEDES");
            this.valorPagamento = rs.getDouble("VALOR_PAGAMENTO");
            this.pago = rs.getBoolean("PAGO");
        } catch (SQLException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Getters
    public int getNum() {
        return this.num;
    }

    public Integer getIdCliente() {
        return this.idCliente;
    }

    public Integer getIdAtendente() {
        return this.idAtendente;
    }

    public Integer getIdQuarto() {
        return this.idQuarto;
    }

    public Integer getIdFormaPagamento() {
        return this.idFormaPagamento;
    }

    public LocalDateTime getDataCheckin() {
        return this.dataCheckin;
    }

    public LocalDateTime getDataCheckout() {
        return this.dataCheckout;
    }

    public Integer getNumHospedes() {
        return this.numHospedes;
    }

    public Double getValorPagamento() {
        return this.valorPagamento;
    }

    // Setters
    public void setNumHospedes(Integer novoNum) {
        this.numHospedes = novoNum;
    }

    public void setValorPagamento(Double novoValor) {
        this.valorPagamento = novoValor;
    }

    public void setStatusPago(boolean novoStatus) {
        this.pago = novoStatus;
    }

    // Métodos Adicionais
    public boolean estaPago() {
        return this.pago;
    }
}
