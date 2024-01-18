package org.example.view.style;


import javax.swing.*;
import java.awt.*;

public class StyleFactory {
    private static final Color BUTTON_BACKGROUND_COLOR = new Color(52, 152, 219);
    private static final Color BUTTON_TEXT_COLOR = Color.WHITE;
    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 14);

    private static final Color MENU_BACKGROUND_COLOR = new Color(52, 152, 219);
    private static final Color MENU_TEXT_COLOR = Color.WHITE;
    private static final Font MENU_FONT = new Font("Arial", Font.PLAIN, 14);

    public static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(BUTTON_BACKGROUND_COLOR);
        button.setForeground(BUTTON_TEXT_COLOR);
        button.setFocusPainted(false);
        button.setFont(BUTTON_FONT);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }

    public static void applyStyle(JMenuItem menuItem) {
        menuItem.setBackground(MENU_BACKGROUND_COLOR);
        menuItem.setForeground(MENU_TEXT_COLOR);
        menuItem.setFont(MENU_FONT);
    }


}
