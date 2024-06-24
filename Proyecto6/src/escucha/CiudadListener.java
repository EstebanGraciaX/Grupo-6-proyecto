package escucha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.Ciudad;
import persistencia.CiudadDAO;
import presentacion.CiudadFrame;

public class CiudadListener implements ActionListener {
    private CiudadFrame frame;
    private CiudadDAO ciudadDAO;

    public CiudadListener(CiudadFrame frame) {
        this.frame = frame;
        this.ciudadDAO = new CiudadDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Ciudad ciudad = new Ciudad();
        ciudad.setCodigo(frame.getCodigo());
        ciudad.setNombre(frame.getNombre());

        ciudadDAO.saveCiudad(ciudad);
        frame.loadData();
    }
}
