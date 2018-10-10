/*
#ProProgrammer
*/
package newpackage;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    
    public void save() throws Exception{
        try {
            File file = choose();

            FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject((ArrayList)messungen);
            oos.flush();
            fos.close();
        } catch (HeadlessException | IOException e) {
            throw e;
        }
        
    }
    
    public void load() throws Exception{
        messungen.removeAll(messungen);
        try {
            File file = choose();
            
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fis);
            messungen = (ArrayList<Messung>)ois.readObject();
            fis.close();
            fireTableDataChanged();
        } catch (Exception e) {
            throw e;
        }
    }
    
    private File choose()throws Exception{
        try {
            JFileChooser chooser = new JFileChooser(".");
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("*.ser", "ser"));
            
            File file = null;
            int result = chooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
            }
            return file;
        } catch (Exception e) {
            throw e;
        }
    }
}
