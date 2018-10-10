/*
#ProProgrammer
 */
package newpackage;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;

public class TableCellRenderer implements javax.swing.table.TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1) {
        JLabel lab = new JLabel(o.toString());
        lab.setOpaque(true);
        if (selected) {
            lab.setBackground(new Color(130, 200, 240, 123));
        }

        if (o instanceof Double) {
            Double gemessen = (Double) o;
            if (gemessen > 30.0) {
                lab.setBackground(Color.red);
            } else if (gemessen > 20) {
                lab.setBackground(Color.orange);
            } else if (gemessen > 10) {
                lab.setBackground(Color.yellow);
            } else {
                lab.setBackground(Color.cyan);
            }
        }
        return lab;
    }

}
