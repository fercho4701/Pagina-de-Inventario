/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador_data_base.ClientesFacade;
import entitys.Clientes;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean

public class controlador_clientes {

    private String nombre_clientes, direcion_clientes, correo_clientes, compras_clientes, fecha_clientes;
    private int telefono_clientes, cantidad_clientes, cedula_clientes, id_clientes;
    private List<Clientes> clientes;
    Clientes edit;
    @EJB
    private ClientesFacade controlador_clientes;

    public void crear_cliente() {

        Clientes obj1 = new Clientes();

        obj1.setNombre(nombre_clientes);
        obj1.setDireccion(direcion_clientes);
        obj1.setCorreo(correo_clientes);
        obj1.setCompras(compras_clientes);
        obj1.setFecha(fecha_clientes);
        obj1.setTelefono(telefono_clientes);
        obj1.setCantidad(cantidad_clientes);
        obj1.setCedula(cedula_clientes);
        obj1.setId(id_clientes);
        
        controlador_clientes.create(obj1);
        
        consultar_clientes();

    }

          public void consultar_clientes(){
              
              setClientes(getControlador_clientes().findAll());
              
          }
    
    
          
          public void eliminar_clientes(Clientes obj1){
              
              
              controlador_clientes.remove(obj1);
              consultar_clientes();
        
          
          
          
          
          
          }
    
    public String editar_clientes(Clientes obj1){
        
        setNombre_clientes(obj1.getNombre());
        setDirecion_clientes(obj1.getDireccion());
        setCorreo_clientes(obj1.getCorreo());
        setCompras_clientes(obj1.getCompras());
        setFecha_clientes(obj1.getFecha());
        setTelefono_clientes(obj1.getTelefono());
        setCantidad_clientes(obj1.getCantidad());
        setCedula_clientes(obj1.getCedula());
        setId_clientes(obj1.getId());
        
        consultar_clientes();
        
        return "clientes.xhtml";
    }
          
         
    
    public void actualizar_clientes(){
        
        edit.setNombre(nombre_clientes);
        edit.setDireccion(direcion_clientes);
        edit.setCorreo(correo_clientes);
        edit.setCompras(compras_clientes);
        edit.setFecha(fecha_clientes);
        edit.setTelefono(telefono_clientes);
        edit.setCantidad(cantidad_clientes);
        edit.setCedula(cedula_clientes);
        edit.setId(id_clientes);
        
        controlador_clientes.edit(edit);
        consultar_clientes();
        
    }
          
         public String cliente_a_tabla(){
             return "tabla_clientes.xhtml";
             
         } 
          
          
          
    public int getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(int id_clientes) {
        this.id_clientes = id_clientes;
    }

    public Clientes getEdit() {
        return edit;
    }

    public void setEdit(Clientes edit) {
        this.edit = edit;
    }

    public ClientesFacade getControlador_clientes() {
        return controlador_clientes;
    }

    public void setControlador_clientes(ClientesFacade controlador_clientes) {
        this.controlador_clientes = controlador_clientes;
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }

    public String getNombre_clientes() {
        return nombre_clientes;
    }

    public void setNombre_clientes(String nombre_clientes) {
        this.nombre_clientes = nombre_clientes;
    }

    public String getDirecion_clientes() {
        return direcion_clientes;
    }

    public void setDirecion_clientes(String direcion_clientes) {
        this.direcion_clientes = direcion_clientes;
    }

    public String getCorreo_clientes() {
        return correo_clientes;
    }

    public void setCorreo_clientes(String correo_clientes) {
        this.correo_clientes = correo_clientes;
    }

    public String getCompras_clientes() {
        return compras_clientes;
    }

    public void setCompras_clientes(String compras_clientes) {
        this.compras_clientes = compras_clientes;
    }

    public String getFecha_clientes() {
        return fecha_clientes;
    }

    public void setFecha_clientes(String fecha_clientes) {
        this.fecha_clientes = fecha_clientes;
    }

    public int getTelefono_clientes() {
        return telefono_clientes;
    }

    public void setTelefono_clientes(int telefono_clientes) {
        this.telefono_clientes = telefono_clientes;
    }

    public int getCantidad_clientes() {
        return cantidad_clientes;
    }

    public void setCantidad_clientes(int cantidad_clientes) {
        this.cantidad_clientes = cantidad_clientes;
    }

    public int getCedula_clientes() {
        return cedula_clientes;
    }

    public void setCedula_clientes(int cedula_clientes) {
        this.cedula_clientes = cedula_clientes;
    }

}
