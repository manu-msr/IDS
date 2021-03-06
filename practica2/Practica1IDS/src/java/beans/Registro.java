package beans;

//import controlador.UsuariosDAO;
//import controlador.ManejaUsuarios;
import controlador.LoginHelper;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import modelo.Usuario;

/**
 *
 * @author manu
 */
@ManagedBean
@RequestScoped
public class Registro {
    
    /* Correo electrónico. */
    private String correo;
    /* Contraseña. */
    private String contrasenia;
    /* Confirmación. */
    private String confirmacion;
    /* Obtiene información de todas las peticiones del correo. */
    private final HttpServletRequest httpServletRequest;
    /* Obtiene información de la aplicación. */
    private final FacesContext faceContext;
    /* Permite el envio de mensajes entre el bean y la vista. */
    private FacesMessage message;
    private static int ids = 0;
    private LoginHelper helper;
    /**
     * Constructor.
     */
    public Registro() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest)faceContext.getExternalContext().getRequest();
        helper = new LoginHelper();
    }
    
    /**
     * Realiza el registro y regresa a la pantalla de acceso.
     * @return Dirección a la pantalla de login.
     */
    public String registrar() {
        if (contrasenia.equals(confirmacion)) {
            Usuario us = new Usuario();
            try {
                helper.registraUsuario(ids++, correo, contrasenia);
                return "index";
            } catch (Exception e) {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar los datos", null);
            }
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contraseñas no coinciden", null);
            faceContext.addMessage(null, message);
            return "registro";
        }
        return "index";
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }
}
