package org.example.view.panel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAnalyzerPanel extends JPanel {
    private JButton mostProductsButton;
    private JButton mostReviewsButton;
    private JButton filterUsersButton;
    private JButton backButton;

    public UserAnalyzerPanel() {
        setLayout(new GridLayout(4, 1)); // Establece el diseño del panel

        // Botón para obtener el usuario con más productos
        mostProductsButton = new JButton("Obtener el usuario con más productos");
        mostProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para obtener el usuario con más productos
                showMessage("Obtener el usuario con más productos");
            }
        });

        // Botón para obtener el usuario con más reseñas
        mostReviewsButton = new JButton("Obtener el usuario con más reseñas");
        mostReviewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para obtener el usuario con más reseñas
                showMessage("Obtener el usuario con más reseñas");
            }
        });

        // Botón para filtrar usuarios
        filterUsersButton = new JButton("Filtrar usuarios");
        filterUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para filtrar usuarios
                showMessage("Filtrar usuarios");
            }
        });

        // Botón para volver al menú principal
        backButton = new JButton("Volver al menú principal");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para volver al menú principal
                showMessage("Volviendo al menú principal...");
            }
        });

        // Agregar los botones al panel
        add(mostProductsButton);
        add(mostReviewsButton);
        add(filterUsersButton);
        add(backButton);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
}
