package window.UI;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class Theme extends FlatDarkLaf {
    public static boolean setup() {
        return setup(new Theme());
    }

    public static void theme() {
        UIManager.put("Button.innerFocusWidth", 0);
        UIManager.put("Button.hoverBorderColor", Color.decode("#CE2038"));
        UIManager.put("Button.focusedBorderColor", Color.decode("#CE2038"));
        UIManager.put("Button.default.hoverBorderColor", Color.decode("#CE2038"));
        UIManager.put("Button.default.focusedBorderColor", Color.decode("#CE2038"));
        UIManager.put("Button.default.focusColor", Color.decode("#CE2038"));
        UIManager.put("Button.default.borderColor", Color.decode("#CE2038"));
        UIManager.put("Button.default.background", Color.decode("#CE2038"));

        UIManager.put("TextField.arc", 0);
        UIManager.put("Component.borderWidth", 0);
        UIManager.put("TextComponent.arc", 0);
        UIManager.put("CheckBox.icon.borderWidth", 1);
        UIManager.put("CheckBox.icon.borderColor", null);
        UIManager.put("CheckBox.icon.selectedBorderColor", null);
        UIManager.put("CheckBox.icon.checkmarkColor", null);
        UIManager.put("Component.focusColor", Color.decode("#32AB5E"));
        UIManager.put("ProgressBar.foreground", Color.decode("#32AB5E"));
        UIManager.put("TextField.selectionBackground", Color.decode("#32AB5E"));
        UIManager.put("List.selectionForeground", Color.decode("#FFFFFF"));
        UIManager.put("List.selectionBackground", Color.decode("#32AB5E"));
        UIManager.put("List.selectionInactiveForeground", Color.decode("#000000"));
        UIManager.put("List.selectionInactiveBackground", Color.decode("#83D078"));
        UIManager.put("Table.selectionForeground", Color.decode("#FFFFFF"));
        UIManager.put("Table.selectionBackground", Color.decode("#32AB5E"));
        UIManager.put("Table.selectionInactiveForeground", Color.decode("#000000"));
        UIManager.put("Table.selectionInactiveBackground", Color.decode("#83D078"));
        UIManager.put("ComboBox.selectionForeground", Color.decode("#FFFFFF"));
        UIManager.put("ComboBox.selectionBackground", Color.decode("#32AB5E"));
        UIManager.put("ComboBox.border", Color.decode("#000000"));
        UIManager.put("MenuItem.selectionBackground", Color.decode("#32AB5E"));
        /*
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setDefaultFont();
         */
    }

    public static Color getButtonColor() {
        return UIManager.getColor("Button.background");
    }

    public static Color getPanelColor() {
        return UIManager.getColor("Panel.background");
    }

    public static Color getLabelColor() {
        return UIManager.getColor("Label.foreground");
    }

    public static Font getFont() {
        return new javax.swing.plaf.FontUIResource("Helvetica", Font.BOLD, 16);
    }

    public static void setDefaultFont() {
        setUIFont(new javax.swing.plaf.FontUIResource("Helvetica", Font.BOLD, 16));
    }

    public static void setUIFont(javax.swing.plaf.FontUIResource f) {
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, f);
        }
    }

    @Override
    public String getName() {
        return "MyDarkerLaf";
    }

}