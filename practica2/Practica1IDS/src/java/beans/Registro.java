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
    
    /**
     * Constructor.
     */
    public Registro() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest)faceContext.getExternalContext().getRequest();
    }
    
    /**
     * Realiza el registro y regresa a la pantalla de acceso.
     * @return Dirección a la pantalla de login.
     */
    public String registrar() {
        if (correo.equals(confirmacion))
            return "index";
        else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contraseñas no coinciden", null);
            faceContext.addMessage(null, message);
            return "registro";
        }
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
