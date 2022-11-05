/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador_data_base;

import entitys.Empleados;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Admin
 */
@Stateless
public class EmpleadosFacade extends AbstractFacade<Empleados> {

    @PersistenceContext(unitName = "Tienda_de_electronicos_xdPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadosFacade() {
        super(Empleados.class);
    }
    
    
    public List<Empleados> validar_secion(String correo, String clave){
        
        
       Query cons= em.createNativeQuery("SELECT * FROM EMPLEADOS WHERE correo = '"+correo+"' AND clave= '"+clave+"'", Empleados.class);
      
       
       return cons.getResultList();
       
    }
    
    
    
}
