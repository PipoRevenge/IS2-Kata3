package org.example.view.frame;

import org.example.view.menu.MainMenuPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final int FRAME_WIDTH = 1300;
    private static final int FRAME_HEIGHT = 900;
    private JPanel contentPanel;

    public MainFrame() {
        // Establecer el título de la ventana
        setTitle("Main Frame");

        // Crear una instancia del MainMenuPanel
        MainMenuPanel mainMenuPanel = new MainMenuPanel();

        // Configurar el BorderLayout para el frame
        setLayout(new BorderLayout());

        // Agregar el MainMenuPanel en la posición norte
        add(mainMenuPanel, BorderLayout.NORTH);

        // Crear un JPanel para el contenido central con un BorderLayout
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT - 50)); // Altura menos la altura del menú

        // Agregar el contentPanel en la posición central
        add(contentPanel, BorderLayout.CENTER);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Asegurarse de que la aplicación se cierre correctamente al hacer clic en el botón de cierre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer visible la ventana
        setSize(FRAME_WIDTH, FRAME_HEIGHT); // Establecer el tamaño de la ventana
        setMinimumSize(new Dimension(FRAME_WIDTH, 50)); // Establecer el tamaño mínimo con altura fija de 50
        setResizable(false); // Evitar que la ventana sea redimensionable
        setVisible(true);

    }

    public static void main(String[] args) {
        // Crear una instancia del MainFrame
        new MainFrame();
    }

    // Método para mostrar un panel en el contentPanel
    public void showPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
