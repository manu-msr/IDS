package controlador;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tablas.Usuario;

/**
 *
 * @author manu
 */
public class UsuariosDAO {
    
    private Session sesion;
    private Transaction tx;
    
    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.getTransaction();
    }
    
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error");
    }
    
    public void guardaUsuario(Usuario usuario) {
        try {
            iniciarOperacion();
            sesion.save(usuario);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }
}
