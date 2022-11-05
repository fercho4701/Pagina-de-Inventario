/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador_data_base.ProductosFacade;
import entitys.Productos;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean

public class controladorProducto {

    private String nombre_producto, tipo_producto, marca_producto;

    private int cantidad_producto, precio_producto, id_producto;

    List<Productos> productos;
    Productos edit;
    @EJB

    ProductosFacade controlador_productos;

    public void crear_productos() {

        Productos obj3 = new Productos();

        obj3.setNombre(nombre_producto);
        obj3.setTipo(tipo_producto);
        obj3.setMarca(marca_producto);
        obj3.setCantidad(cantidad_producto);
        obj3.setPrecio(precio_producto);
        obj3.setId(id_producto);

        controlador_productos.create(obj3);

        consultar_productos();

    }

    public void consultar_productos() {
        
        
        setProductos(getControlador_productos().findAll());
        

    }
    
    
    public void eliminar_producto( Productos obj3){
        
        controlador_productos.remove(obj3);
        
        consultar_productos();
        
    }
    
    
    
    public String editar_producto(Productos obj3){
    
        
        setNombre_producto(obj3.getNombre());
        setTipo_producto(obj3.getTipo());
        setMarca_producto(obj3.getMarca());
        setCantidad_producto(obj3.getCantidad());
        setPrecio_producto(obj3.getPrecio());
        setId_producto(obj3.getId());
        
        
       consultar_productos(); 
        
        
        
        return "productos_de_tienda.xhtml";
    }
    
    
    
    public void actualizar_productos(){
    
    edit.setNombre(nombre_producto);
    edit.setTipo(tipo_producto);
    edit.setMarca(marca_producto);
    edit.setCantidad(cantidad_producto);
    edit.setPrecio(precio_producto);
    edit.setId(id_producto);
    
    controlador_productos.edit(edit);
    
    
          consultar_productos(); 
    
}
    
    public String ir_tabla_productos(){
        
        return "tabla _producto.xhtml";
    }
    
    
    
    
    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    public Productos getEdit() {
        return edit;
    }

    public void setEdit(Productos edit) {
        this.edit = edit;
    }

    public ProductosFacade getControlador_productos() {
        return controlador_productos;
    }

    public void setControlador_productos(ProductosFacade controlador_productos) {
        this.controlador_productos = controlador_productos;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

}
