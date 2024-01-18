package org.example.view.panel;

import org.example.analyzers.GameAnalyzer;
import org.example.models.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GameAnalyzerPanel extends JPanel {
    private JButton mostPositiveReviewsButton;
    private JButton mostNegativeReviewsButton;
    private JButton groupByRatingButton;
    private JButton filterGamesButton;
    private JButton backButton;

    public GameAnalyzerPanel() {
        setLayout(new GridLayout(4, 1)); // Establece el diseño del panel

        // Initialize buttons
        mostPositiveReviewsButton = new JButton("Obtener el juego con más reseñas positivas");
        mostNegativeReviewsButton = new JButton("Obtener el juego con más reseñas negativas");
        groupByRatingButton = new JButton("Agrupar juegos por calificación");
        filterGamesButton = new JButton("Filtrar juegos");

        // Botón para obtener el juego con más reseñas positivas
        mostPositiveReviewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameAnalyzer gameAnalyzer = GameAnalyzer.getInstance();
                Game mostPositiveGame = gameAnalyzer.getGameWithMostPositiveReviews();
                showMessage("Juego con más reseñas positivas:\n" + mostPositiveGame);
            }
        });

        // Botón para obtener el juego con más reseñas negativas
        mostNegativeReviewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameAnalyzer gameAnalyzer = GameAnalyzer.getInstance();
                Game mostNegativeGame = gameAnalyzer.getGameWithMostNegativeReviews();
                showMessage("Juego con más reseñas negativas:\n" + mostNegativeGame);
            }
        });

        // Botón para agrupar juegos por calificación
        groupByRatingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameChartsPanel chartPanel = new GameChartsPanel("Calificación de Juegos");
                showChartPopup(chartPanel, "Gráfico de Calificaciones");

            }
        });


        // Botón para filtrar juegos
        filterGamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameAnalyzer gameAnalyzer = GameAnalyzer.getInstance();

                List<String> filteredGames = new ArrayList<>();
                Predicate<Game> matureFilter = game -> "Very positive".equals(game.getRating());
                gameAnalyzer.filterGames(matureFilter).forEach(
                        game -> {
                            filteredGames.add(game.getTitle());
                        }
                );

                showMessage("Juegos filtrados por calificación 'Mature':\n" + filteredGames);
            }
        });


        // Agregar los botones al panel
        add(mostPositiveReviewsButton);
        add(mostNegativeReviewsButton);
        add(groupByRatingButton);
        add(filterGamesButton);
        add(backButton);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    // Método para mostrar el gráfico en un popup
    private void showChartPopup(JPanel chartPanel, String title) {
        JDialog chartDialog = new JDialog();
        chartDialog.setTitle(title);
        chartDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        chartDialog.getContentPane().add(chartPanel);
        chartDialog.pack();
        chartDialog.setLocationRelativeTo(null);
        chartDialog.setVisible(true);
    }
}
