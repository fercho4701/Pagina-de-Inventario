/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador_data_base.EmpleadosFacade;
import entitys.Empleados;

import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@SessionScoped
@ManagedBean
public class controlador_index {

    private String nombre, correo, clave, cargo, direccion;
    private int cedula, telefono, id;
    List<Empleados> empleados;
    Empleados edit;

    @EJB
    private EmpleadosFacade controlador_empleados;

    public void crear() {

        Empleados obj = new Empleados();

        obj.setNombre(nombre);
        obj.setCorreo(correo);
        obj.setClave(clave);
        obj.setCargo(cargo);
        obj.setDireccion(direccion);
        obj.setCedula(cedula);
        obj.setTelefono(telefono);
        obj.setId(id);

        controlador_empleados.create(obj);

        consultar();

    }

    public void consultar() {

        setEmpleados(getControlador_empleados().findAll());

    }

    public String ir() {

        return "Tabla_trabajadores.xhtml";
    }

    public String registro() {
        return "index.xhtml";

    }

    public void eliminar(Empleados obj) {

        controlador_empleados.remove(obj);
        consultar();

    }

    public String editar(Empleados obj) {
        
        setNombre(obj.getNombre());
        setCorreo(obj.getCorreo());
        setClave(obj.getClave());
        setCargo(obj.getCargo());
        setDireccion(obj.getDireccion());
        setCedula(obj.getCedula());
        setTelefono(obj.getTelefono());
        setId(obj.getId());


        consultar();
//         consultar_por_id(obj);
//        edit = controlador_empleados.find(obj.getId());
        return "index.xhtml";

    }

//    
//    public void consultar_por_id(Empleados obj){
//    edit =  controlador_empleados.find(obj.getId());
//        
//        
//    }
//   
    
    
    
    
    
    public void actualizar() {

        edit.setNombre(nombre);
        edit.setCorreo(correo);
        edit.setClave(clave);
        edit.setCargo(cargo);
        edit.setDireccion(direccion);
        edit.setCedula(cedula);
        edit.setTelefono(telefono);
        edit.setId(id);
        controlador_empleados.edit(edit);
        consultar();

    }

    
    public String iniciar_seccion(){
        
       List<Empleados> lista= controlador_empleados.validar_secion(correo, clave);
       
       if(lista.isEmpty()){
           return "iniciar_secion.xhtml";
       }
       
       
       else{
           return "Comienso.xhtml";
       }
       
        
        
    }
    
    
    public String bienvenida(){
        
        return "Bienvenida.xhtml";
        
    }
    
    public String ir_a_comienso(){
        
        return "Comienso.xhtml";
        
        
    }
    
    
    public String clientes(){
        
        
        return "clientes.xhtml";
    }
    
    public String productos(){
        
        return "productos_de_tienda.xhtml";
        
    }
    
    public String control_cuenta(){
        
        
        return "iniciar_secion.xhtml";
        
    }
    
    
    public void crear_crear_mensaje() throws MessagingException{
        
        String smtp = "smtp.gmail.com";
        int port=587;
        String username ="gonzalesmolina4701@gmail.com";
        String pasword = "k j e z d k f p v k r w s h e m";
        String mensaje="!Necesito ayuda  por favor dame tu tutoria!";
        String asunto ="java";
        String paraQuien ="molinagonzales4701@gmail.com";
        
        Properties props = null;
        Session session = null;
        MimeMessage message =null;
        Address fomAddress= null;
        Address toAddress= null;
        
        props= new Properties();
        
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtp);
        props.put("mail.smtp.port", port);
        
        session =Session.getInstance(props, new javax.mail.Authenticator() {
            
            
            @Override
            
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username, pasword);
            } 
            
            
            
});
        
        message = new MimeMessage(session);
       
        
       try{
    
    
    message.setContent(mensaje,"text/plain");
    message.setSubject(asunto);
     fomAddress =new InternetAddress(username);
    
    message.setFrom(fomAddress);
    
    toAddress = new InternetAddress(paraQuien);
    message.setRecipient(Message.RecipientType.TO, toAddress);
    message.saveChanges();
    
           Transport transport = session.getTransport("smtp");
          transport.connect(smtp, port, username, pasword);
          
          if(!transport.isConnected()){
              System.out.println("emailFail");
          }
          
          transport.sendMessage(message, message.getAllRecipients());
          transport.close();
           System.out.println("Envio exitoso");
    
} catch(MessagingException me){
    
           System.out.println("Error"+me);
    
    
}

    } 
    
//    public void  imprimir(){
//        
//        
//        try{
//            List<Empleados> data= controlador_empleados.findAll();
//            String jasperParth = "/Resources/PrimerReporyte.jasper";
//            imprimirJasper(null,jasperParth,data, "Titulo.pdf");
//            
//            
//            
//        }catch (JRException ex){
//            
//            
//            Looger.getLooger(controlador_index.class.getName()).log(Level.SEVERE,null,ex);
//            
//        }catch(IOExeption ex){
//            
//            Lopger.getLooger(controlador_index.class.getName()).log(Level.SEVERE,null, ex);
//            
//        }
//        
//        
//        
//    }
    
    public void imprimirJasper(){
        
    }
    
    
    
    
    
    
    
    public Empleados getEdit() {
        return edit;
    }

    public void setEdit(Empleados edit) {
        this.edit = edit;
    }

    public List<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleados> empleados) {
        this.empleados = empleados;
    }

    public EmpleadosFacade getControlador_empleados() {
        return controlador_empleados;
    }

    public void setControlador_empleados(EmpleadosFacade controlador_empleados) {
        this.controlador_empleados = controlador_empleados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

}
