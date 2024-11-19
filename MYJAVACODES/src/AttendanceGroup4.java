import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AttendanceGroup4 {
    private static final int rows = 8;
    private static final int columns = 6;
    private static final Color present = Color.GREEN;
    private static final Color absent = Color.RED;
    private static final Color excuse = Color.ORANGE;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Group 4 Attendance CODE from Clive Morales, Ella Sapaleida, Rhyzie Bagood");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 1000);

            JPanel gridPanel = new JPanel();
            gridPanel.setLayout(new GridLayout(rows, columns));
            String[][] names = {
                {"Ageas", "Andelab", "Bagood", "Ballares", "Borines", "Dinopol"},
                {"Ducusin", "Empeynado", "Esay", "Eso(Male)", "Eso(Female)", "Galvez"},
                {"Ignacio", "Langutan", "Ledama", "Lilibios", "Lindayao", "Lucrecia"},
                {"Malapangue", "Manlod", "Maraon", "Miag-ao", "Morales", "Nacus"},
                {"Narvaez", "Marzabal", "Neri", "Ordinaria", "Palma", "Pasinabo"},
                {"Quirante", "Rances", "Relos", "Saile", "Saldon", "Sapaleida"},
                {"Son", "Tabiliran(Female)", "Tabiliran(Male)", "Tanao", "Tangcay", "Tubat"},
                {"Villa", "Villarin", "Zozobrado", "---", "---", "---"},
            };

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    JButton button = new JButton(names[row][column]);
                    button.setBackground(Color.LIGHT_GRAY);
                    button.setOpaque(true);
                    button.setBorderPainted(false);
                    button.addMouseListener(new MouseAdapter() {
                        private long pressTime;

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (e.getClickCount() == 1) 						{ // Single click
                                button.setBackground(present);
                            } else if (e.getClickCount() == 2) 					{ // Double click
                                button.setBackground(absent);
                            }
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {
                            pressTime = System.currentTimeMillis();
                        }
                        

                        @Override
                        public void mouseReleased(MouseEvent e) {
                            long releaseTime = System.currentTimeMillis();
                            if (releaseTime - pressTime > 1000) 				{ // Long press
                                button.setBackground(excuse);
                            }
                        }
                    });
                    gridPanel.add(button);
                }
            }

            frame.add(gridPanel);
            frame.setVisible(true);
        });
    }
}