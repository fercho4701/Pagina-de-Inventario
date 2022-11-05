/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "encargos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encargos.findAll", query = "SELECT e FROM Encargos e")
    , @NamedQuery(name = "Encargos.findByNombre", query = "SELECT e FROM Encargos e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Encargos.findByCedula", query = "SELECT e FROM Encargos e WHERE e.cedula = :cedula")
    , @NamedQuery(name = "Encargos.findByTelefono", query = "SELECT e FROM Encargos e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Encargos.findByDireccion", query = "SELECT e FROM Encargos e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Encargos.findByPedido", query = "SELECT e FROM Encargos e WHERE e.pedido = :pedido")
    , @NamedQuery(name = "Encargos.findByFecha", query = "SELECT e FROM Encargos e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Encargos.findById", query = "SELECT e FROM Encargos e WHERE e.id = :id")})
public class Encargos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private int cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pedido")
    private String pedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fecha")
    private String fecha;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Encargos() {
    }

    public Encargos(Integer id) {
        this.id = id;
    }

    public Encargos(Integer id, String nombre, int cedula, int telefono, String direccion, String pedido, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.pedido = pedido;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encargos)) {
            return false;
        }
        Encargos other = (Encargos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Encargos[ id=" + id + " ]";
    }
    
}
