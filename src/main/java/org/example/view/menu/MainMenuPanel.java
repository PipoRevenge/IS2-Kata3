package org.example.view.menu;

import org.example.view.frame.MainFrame;
import org.example.view.panel.GameAnalyzerPanel;
import org.example.view.panel.RecommendationAnalyzerPanel;
import org.example.view.panel.UserAnalyzerPanel;
import org.example.view.style.StyleFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JMenuBar {
    private JMenuItem gameAnalyzerMenuItem;
    private JMenuItem userAnalyzerMenuItem;
    private JMenuItem recommendationAnalyzerMenuItem;
    private JMenuItem exitMenuItem;

    public MainMenuPanel() {
        // Crear los elementos del menú directamente en la barra de menú
        gameAnalyzerMenuItem = createStyledMenuItem("Game Analyzer");
        userAnalyzerMenuItem = createStyledMenuItem("User Analyzer");
        recommendationAnalyzerMenuItem = createStyledMenuItem("Recommendation Analyzer");
        exitMenuItem = createStyledMenuItem("Exit");

        // Agregar los elementos a la barra de menú
        add(gameAnalyzerMenuItem);
        add(userAnalyzerMenuItem);
        add(recommendationAnalyzerMenuItem);
        add(exitMenuItem);

        // Configurar acciones de los elementos del menú
        gameAnalyzerMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(new GameAnalyzerPanel());
            }
        });

        userAnalyzerMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(new UserAnalyzerPanel());
            }
        });

        recommendationAnalyzerMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(new RecommendationAnalyzerPanel());
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitProgram();
            }
        });
    }

    private JMenuItem createStyledMenuItem(String text) {
        JMenuItem menuItem = new JMenuItem(text);
        StyleFactory.applyStyle(menuItem);
        return menuItem;
    }

    private void showPanel(JPanel panel) {
        // Obtener la instancia del MainFrame y llamar a su método showPanel
        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
        if (mainFrame != null) {
            mainFrame.showPanel(panel);
        }
    }

    private void exitProgram() {
        System.exit(0);
    }
}
