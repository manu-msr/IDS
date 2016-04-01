package controlador;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import modelo.Usuario;

/**
 *
 * @author manu
 */
public class LoginHelper {

    private final Session session;

    public LoginHelper() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Usuario getUsuarioPorCorreo(String correo) {
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("BuscaPorContrasenia").setString("correoUsuario", correo);
            return (Usuario) q.uniqueResult();
        } catch (Exception e) {
        }
        return null;
    }
    
    public void registraUsuario(int id, String correo, String contrasenia) {
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("AgregaUsuario");
        } catch (Exception e) {
        }
    }
}
