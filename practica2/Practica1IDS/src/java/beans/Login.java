package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import controlador.LoginHelper;

/**
 *
 * @author manu
 */
@ManagedBean
@RequestScoped
public class Login {
    
    /* Correo electrónico del correo. */
    private String correo;
    /* Contraseña del correo. */
    private String contrasenia;
    /* Obtiene información de todas las peticiones del correo. */
    private final HttpServletRequest httpServletRequest;
    /* Obtiene información de la aplicación. */
    private final FacesContext faceContext;
    /* Permite el envio de mensajes entre el bean y la vista. */
    private FacesMessage message;
    private LoginHelper helper;
    
    /**
     * Constructor para inicializar los valores de faceContext y 
     * httpServletRequest.
     */
    public Login() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest)faceContext.getExternalContext().getRequest();
        helper = new LoginHelper();
    }
    
    /**
     * Método que valida el inicio de sesión.
     * @return Nombre de la vista a responder.
     */
    public String login() {
        modelo.Usuario usuario = helper.getUsuarioPorCorreo(correo);
        if (usuario != null) {
            if (contrasenia.equals(usuario.getContraseniaUsuario())) {
                httpServletRequest.getSession().setAttribute("sessionUsuario", correo);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
                faceContext.addMessage(null, message);
                return "acceso";
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecto", null);
                faceContext.addMessage(null, message);
                return "index";
            }
        }
        return "index";
    }
    
    /**
     * Obtiene el correo.
     * @return El correo.
     */
    public String getCorreo() {
        return correo;
    }
    
    /**
     * Establece el correo.
     * @param correo El correo a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Regresa la contraseña del correo.
     * @return La contraseña del correo.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del correo.
     * @param contrasenia La contraseña del correo a establecer.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
