package org.example.view.panel;

import org.example.analyzers.RecommendationAnalyzer;
import org.example.models.Recommendation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Predicate;

public class RecommendationAnalyzerPanel extends JPanel {
    private JButton mostHelpfulButton;
    private JButton mostFunnyButton;
    private JButton filterRecommendationsButton;
    private JButton backButton;

    public RecommendationAnalyzerPanel() {
        setLayout(new GridLayout(4, 1)); // Establece el diseño del panel

        // Botón para obtener la recomendación más útil
        mostHelpfulButton = new JButton("Obtener la recomendación más útil");
        mostHelpfulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecommendationAnalyzer recommendationAnalyzer = RecommendationAnalyzer.getInstance();
                Recommendation mostHelpfulRecommendation = recommendationAnalyzer.getMostHelpfulRecommendation();
                showMessage("Recomendación más útil:\n" + mostHelpfulRecommendation);
            }
        });

        // Botón para obtener la recomendación más divertida
        mostFunnyButton = new JButton("Obtener la recomendación más divertida");
        mostFunnyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecommendationAnalyzer recommendationAnalyzer = RecommendationAnalyzer.getInstance();
                Recommendation mostFunnyRecommendation = recommendationAnalyzer.getMostFunnyRecommendation();
                showMessage("Recomendación más divertida:\n" + mostFunnyRecommendation);
            }
        });

        // Botón para filtrar recomendaciones
        filterRecommendationsButton = new JButton("Filtrar recomendaciones");
        filterRecommendationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecommendationAnalyzer recommendationAnalyzer = RecommendationAnalyzer.getInstance();
                List<Recommendation> filteredRecommendations = recommendationAnalyzer.filterRecommendations(
                        new Predicate<Recommendation>() {
                            @Override
                            public boolean test(Recommendation recommendation) {
                                // Aquí puedes definir tu lógica de filtrado
                                return recommendation.getHelpful() > 1000; // Ejemplo de filtro (cambia según tus necesidades)
                            }
                        }
                );
                showMessage("Recomendaciones filtradas:\n" + filteredRecommendations.subList(0,10));
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
        add(mostHelpfulButton);
        add(mostFunnyButton);
        add(filterRecommendationsButton);
        add(backButton);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
}
