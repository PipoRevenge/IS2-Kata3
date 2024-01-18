package org.example.view.panel;

import org.example.analyzers.GameAnalyzer;
import org.example.models.Game;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.List;

public class GameChartsPanel extends JPanel {

    public GameChartsPanel(String chartTitle) {
        setLayout(new BorderLayout());
        JFreeChart barChart = createBarChart(chartTitle);
        ChartPanel chartPanel = new ChartPanel(barChart);
        add(chartPanel, BorderLayout.CENTER);
    }

    private JFreeChart createBarChart(String chartTitle) {
        DefaultCategoryDataset dataset = createDataset();
        return ChartFactory.createBarChart(
                chartTitle,
                "Juego",
                "Calificación",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        addGameRatingsToDataset(dataset);
        return dataset;
    }

    private void addGameRatingsToDataset(DefaultCategoryDataset dataset) {
        GameAnalyzer gameAnalyzer = GameAnalyzer.getInstance();
        Map<String, List<Game>> gamesByRating = gameAnalyzer.groupGamesByRating();

        for (Map.Entry<String, List<Game>> entry : gamesByRating.entrySet()) {
            dataset.addValue(entry.getValue().size(), entry.getKey(), "");
        }
    }
}
