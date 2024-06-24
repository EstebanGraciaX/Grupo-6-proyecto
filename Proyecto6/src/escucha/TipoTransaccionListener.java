package escucha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.TipoTransaccion;
import persistencia.TipoTransaccionDAO;
import presentacion.TipoTransaccionFrame;

public class TipoTransaccionListener implements ActionListener {
    private TipoTransaccionFrame frame;
    private TipoTransaccionDAO tipoTransaccionDAO;

    public TipoTransaccionListener(TipoTransaccionFrame frame) {
        this.frame = frame;
        this.tipoTransaccionDAO = new TipoTransaccionDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TipoTransaccion tipoTransaccion = new TipoTransaccion();
        tipoTransaccion.setCodigo(frame.getCodigo());
        tipoTransaccion.setNombre(frame.getNombre());
        tipoTransaccion.setSigno(frame.getSigno().charAt(0));

        tipoTransaccionDAO.saveTipoTransaccion(tipoTransaccion);
        frame.loadData();
    }
}
