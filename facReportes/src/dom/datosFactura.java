/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom;

/**
 *
 * @author Abrahán
 */
public class datosFactura implements accederFactura{
     String fecha;
     String horaInicio;
     static String clientId;
     String personaAtendida;
     String otroAsesor;
     String tiempTrabajo;
     boolean poliza;
     String servicioRealizado;
     String observacionesMateriales;

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }


    /**
     * @return the personaAtendida
     */
    public String getPersonaAtendida() {
        return personaAtendida;
    }

    /**
     * @param personaAtendida the personaAtendida to set
     */
    public void setPersonaAtendida(String personaAtendida) {
        this.personaAtendida = personaAtendida;
    }

    /**
     * @return the otroAsesor
     */
    public String getOtroAsesor() {
        return otroAsesor;
    }

    /**
     * @param otroAsesor the otroAsesor to set
     */
    public void setOtroAsesor(String otroAsesor) {
        this.otroAsesor = otroAsesor;
    }

    /**
     * @return the tiempTrabajo
     */
    public String getTiempTrabajo() {
        return tiempTrabajo;
    }

    /**
     * @param tiempTrabajo the tiempTrabajo to set
     */
    public void setTiempTrabajo(String tiempTrabajo) {
        this.tiempTrabajo = tiempTrabajo;
    }

    /**
     * @return the poliza
     */
    public boolean isPoliza() {
        return poliza;
    }

    /**
     * @param poliza the poliza to set
     */
    public void setPoliza(boolean poliza) {
        this.poliza = poliza;
    }

    /**
     * @return the servicioRealizado
     */
    public String getServicioRealizado() {
        return servicioRealizado;
    }

    /**
     * @param servicioRealizado the servicioRealizado to set
     */
    public void setServicioRealizado(String servicioRealizado) {
        this.servicioRealizado = servicioRealizado;
    }

    /**
     * @return the observacionesMateriales
     */
    public String getObservacionesMateriales() {
        return observacionesMateriales;
    }

    /**
     * @param observacionesMateriales the observacionesMateriales to set
     */
    public void setObservacionesMateriales(String observacionesMateriales) {
        this.observacionesMateriales = observacionesMateriales;
    }

    @Override
    public void setIdCliente(String idCliente) {
        this.clientId=idCliente;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIdCliente() {
        return this.clientId;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpiar() {
        setIdCliente("");
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
