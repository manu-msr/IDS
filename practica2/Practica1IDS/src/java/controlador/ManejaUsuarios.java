/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tablas.Usuario;

/**
 *
 * @author manu
 */
public class ManejaUsuarios {
    
    public static SessionFactory factory;
    
    public Integer aregaUsuario(int id, String correo, String contrasenia) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer usuarioID = null;
        try {
            tx = session.beginTransaction();
            Usuario usuario = new Usuario(id, correo, contrasenia);
            usuarioID = (Integer)session.save(usuario);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return usuarioID;
    }
}
