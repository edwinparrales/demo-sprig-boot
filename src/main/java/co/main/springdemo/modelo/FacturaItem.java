package co.main.springdemo.modelo;

import javax.persistence.*;

@Entity
@Table(name = "FACTURA_ITEMS")
public class FacturaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROWID_CODE")
    private Long id;

    @Column(name = "SERIALES")
    private  String seriales;

    @Column(name = "CANTIDAD")
    private Long cantidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PRODUCTO",updatable = false,insertable = false)
    private  Producto producto;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_FACTURA", updatable = false,insertable = false)
    private Factura factura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeriales() {
        return seriales;
    }

    public void setSeriales(String seriales) {
        this.seriales = seriales;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "FacturaItem{" +
                "id=" + id +
                ", seriales='" + seriales + '\'' +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                ", factura=" + factura +
                '}';
    }
}
