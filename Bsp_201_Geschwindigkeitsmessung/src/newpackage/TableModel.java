/*
#ProProgrammer
*/
package newpackage;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class TableModel extends AbstractTableModel{
    private ArrayList<Messung> messungen = new ArrayList();
    private static final String[] COLNAMES = {"Datum","Uhrzeit","Keinnzeichen","Gemessen","Erlaubt","Übertreten"};

    @Override
    public String getColumnName(int i) {
        return COLNAMES[i];
    }
    
    public void add(Messung m){
        messungen.add(m);
        fireTableRowsInserted(messungen.size()-1, messungen.size()-1);
    }

    @Override
    public int getRowCount() {
        return messungen.size();
    }

    @Override
    public int getColumnCount() {
        return COLNAMES.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Messung m = messungen.get(i);
        switch(i1){
                case 0: return m.getDate();
                case 1: return m.getTime();
                case 2: return m.getKennz();
                case 3: return m.getGemessen()+" km/h";
                case 4: return m.getErlaubt()+" km/h";
                case 5:return m.getÜbertretung()>0 ? m.getÜbertretung():"-";
                default: return "?";
            }
    }

    public void delete(int[] selected){
        ArrayList<Messung> del = new ArrayList<>();
        for (int i : selected) {
           del.add(messungen.get(i));
        }
        messungen.removeAll(del);
        fireTableDataChanged();
    }
    
    public String getDurch(){
        int count = 0;
        Double sum = 0.0;
        for (Messung m : messungen) {
            sum += m.getÜbertretung();
            count++;
        }
        return "Durchschnittliche Übertretung: "+sum/count+" km/h";
    }
    
}
