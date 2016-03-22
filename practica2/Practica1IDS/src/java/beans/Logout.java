package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author manu
 */
@ManagedBean
@RequestScoped
public class Logout {
    
    /* Correo del correo. */
    private String correo;
    /* Obtiene la información de todas las peticiones de usuario. */
    private final HttpServletRequest httpServletRequest;
    /* Obtiene información de la aplicación. */
    private final FacesContext faceContext;
    /* Permite el envío de mensajes entre el bean y la vista. */
    private FacesMessage message;
    
    /**
     * Constructor para inicializar los valores de faceContext y 
     * httpServletRequest, además de la sesión de usuario.
     */
    public Logout() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest)faceContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null)
            correo = httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
    }
    
    /**
     * Método encargado de cerrar la sesión de la aplicaicón.
     * @return El nombre de la vista que va a responder.
     */
    public String cerrarSesion() {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesión cerrada.", null);
        faceContext.addMessage(null, message);
        return "index";
    }
    
    /**
     * Regresa el correo.
     * @return El correo.
     */
    public String getCorreo() {
        return correo;
    }
    
    /**
     * Establece el nombre de usuario.
     * @param correo El nombre de correo a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
