/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador_data_base.EncargosFacade;
import entitys.Encargos;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import org.primefaces.component.editor.Editor;



@SessionScoped
@ManagedBean
public class controlador_encargos {
   
    private String nombre_encargos,direccion_encargos,pedido_encargos,fecha_encargos;
    private int cedula_encargos,telefono_encargos,id_encargos;
    private List<Encargos> encargos;
    Encargos edit;
    @EJB
    private EncargosFacade controlador_encargos;
    

    public void crear_encargos(){
        
        Encargos obj2 = new Encargos();
        
        obj2.setNombre(nombre_encargos);
        obj2.setDireccion(direccion_encargos);
        obj2.setPedido(pedido_encargos);
        obj2.setFecha(fecha_encargos);
        obj2.setCedula(cedula_encargos);
        obj2.setTelefono(telefono_encargos);
        obj2.setId(id_encargos);
        
        
         controlador_encargos.create(obj2);
        consultar_encargos();

        
      
        
    }
    
    public void consultar_encargos(){
        
        setEncargos(getControlador_encargos().findAll());
        
        
        
    }
    
    
    
    public void eliminar_encargo(Encargos obj2){
        
        controlador_encargos.remove(obj2);
        
        consultar_encargos();
    }
    

    
   public String editar_encargo(Encargos obj2){
       
       setNombre_encargos(obj2.getNombre());
       setDireccion_encargos(obj2.getDireccion());
       setPedido_encargos(obj2.getPedido());
       setFecha_encargos(obj2.getFecha());
       setCedula_encargos(obj2.getCedula());
       setTelefono_encargos(obj2.getTelefono());
       setId_encargos(obj2.getId());
       
       consultar_encargos();
       
       return "encargos.xhtml";
       
   } 
    
    
    public void actualizar_encargos(){
        
        edit.setNombre(nombre_encargos);
        edit.setDireccion(direccion_encargos);
        edit.setPedido(pedido_encargos);
        edit.setFecha(fecha_encargos);
        edit.setCedula(cedula_encargos);
        edit.setTelefono(telefono_encargos);
        edit.setId(id_encargos);
        
        controlador_encargos.edit(edit);
        
        consultar_encargos();
        
        
    }
    
    public String encargos_a_tabla(){
        
        
        
        return "tabla_encargos";
    }
    
    public String encargos_xd (){
        
        return "encargos.xhtml";
        
        
    }

    public List<Encargos> getEncargos() {
        return encargos;
    }

    public void setEncargos(List<Encargos> encargos) {
        this.encargos = encargos;
    }

    public Encargos getEdit() {
        return edit;
    }

    public void setEdit(Encargos edit) {
        this.edit = edit;
    }

    public EncargosFacade getControlador_encargos() {
        return controlador_encargos;
    }

    public void setControlador_encargos(EncargosFacade controlador_encargos) {
        this.controlador_encargos = controlador_encargos;
    }
    
    
    
    

    public String getNombre_encargos() {
        return nombre_encargos;
    }

    public void setNombre_encargos(String nombre_encargos) {
        this.nombre_encargos = nombre_encargos;
    }

    public String getDireccion_encargos() {
        return direccion_encargos;
    }

    public void setDireccion_encargos(String direccion_encargos) {
        this.direccion_encargos = direccion_encargos;
    }

    public String getPedido_encargos() {
        return pedido_encargos;
    }

    public void setPedido_encargos(String pedido_encargos) {
        this.pedido_encargos = pedido_encargos;
    }

    public String getFecha_encargos() {
        return fecha_encargos;
    }

    public void setFecha_encargos(String fecha_encargos) {
        this.fecha_encargos = fecha_encargos;
    }

    public int getCedula_encargos() {
        return cedula_encargos;
    }

    public void setCedula_encargos(int cedula_encargos) {
        this.cedula_encargos = cedula_encargos;
    }

    public int getTelefono_encargos() {
        return telefono_encargos;
    }

    public void setTelefono_encargos(int telefono_encargos) {
        this.telefono_encargos = telefono_encargos;
    }

    public int getId_encargos() {
        return id_encargos;
    }

    public void setId_encargos(int id_encargos) {
        this.id_encargos = id_encargos;
    }
    
    
    
}
