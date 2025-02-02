import config.PropertiesReader;
import gui.GFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GFrame frame = new GFrame();
        });

    }
}
