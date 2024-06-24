package escucha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.Cobrador;
import persistencia.CobradorDAO;
import presentacion.CobradorFrame;

public class CobradorListener implements ActionListener {
    private final CobradorFrame frame;
    private final CobradorDAO cobradorDAO;

    public CobradorListener(CobradorFrame frame) {
        this.frame = frame;
        this.cobradorDAO = new CobradorDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cobrador cobrador = new Cobrador();
        cobrador.setCedula(frame.getCedula());
        cobrador.setNombre(frame.getNombre());
        cobrador.setDireccion(frame.getDireccion());

        cobradorDAO.saveCobrador(cobrador);
        frame.loadData();
    }
}
