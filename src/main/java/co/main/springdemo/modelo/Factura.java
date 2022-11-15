package co.main.springdemo.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "FACTURAS")
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROWID_CODE")
    private Long id;

    @Column(name = "COD_FACTURA")
    private String codigoFactura;

    private LocalDate fecha;
    @Column(name = "VALOR_NET")
    private double valorNet;

    @Column(name = "VALOR_BRT")
    private double valorBrt;

    @Column(name = "VALOR_IMP")
    private double valorImp;

    @ManyToOne()
    @JoinColumn(name = "ID_CLIENTE",updatable = false,insertable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL)
    List<FacturaItem> productoItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getValorNet() {
        return valorNet;
    }

    public void setValorNet(double valorNet) {
        this.valorNet = valorNet;
    }

    public double getValorBrt() {
        return valorBrt;
    }

    public void setValorBrt(double valorBrt) {
        this.valorBrt = valorBrt;
    }

    public double getValorImp() {
        return valorImp;
    }

    public void setValorImp(double valorImp) {
        this.valorImp = valorImp;
    }

    public List<FacturaItem> getProductoItems() {
        return productoItems;
    }

    public void setProductoItems(List<FacturaItem> productoItems) {
        this.productoItems = productoItems;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", codigoFactura='" + codigoFactura + '\'' +
                ", fecha=" + fecha +
                ", valorNet=" + valorNet +
                ", valorBrt=" + valorBrt +
                ", valorImp=" + valorImp +
                ", productoItems=" + productoItems +
                '}';
    }
}
