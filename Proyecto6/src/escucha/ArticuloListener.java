package escucha;

import presentacion.ArticuloFrame;
import negocio.Articulo;
import persistencia.ArticuloDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArticuloListener implements ActionListener {
    private ArticuloFrame frame;
    private ArticuloDAO articuloDAO;

    public ArticuloListener(ArticuloFrame frame) {
        this.frame = frame;
        this.articuloDAO = new ArticuloDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Guardar")) {
            Articulo articulo = new Articulo();
            articulo.setCodigo(frame.getCodigo());
            articulo.setNombre(frame.getNombre());
            articulo.setPrecio(frame.getPrecio());
            articuloDAO.saveArticulo(articulo);
        }
    }
}
