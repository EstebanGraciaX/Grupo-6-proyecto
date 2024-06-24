package escucha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.FormaPago;
import persistencia.FormaPagoDAO;
import presentacion.FormaPagoFrame;

public class FormaPagoListener implements ActionListener {
    private final FormaPagoFrame frame;
    private final FormaPagoDAO formaPagoDAO;

    public FormaPagoListener(FormaPagoFrame frame) {
        this.frame = frame;
        this.formaPagoDAO = new FormaPagoDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FormaPago formaPago = new FormaPago();
        formaPago.setCodigo(frame.getCodigo());
        formaPago.setNombre(frame.getNombre());

        formaPagoDAO.saveFormaPago(formaPago);
        frame.loadData();
    }
}
