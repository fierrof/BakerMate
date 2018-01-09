package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewManager {

    private DefaultListModel dm = new DefaultListModel();

    private DBManager dbm = new DBManager();

    public void setTable(JTable table, String[] header) {

// add header of the table
        DefaultTableModel dtm = new DefaultTableModel();
// add header in table model     
        dtm.setColumnIdentifiers(header);
        //set model into the table object
        table.setModel(dtm);

        // add row dynamically into the table      
        for (int count = 1; count <= 10 + 1; count++) {
            dtm.addRow(new Object[]{});
        }
    }

    public void fillTable(JTable table, String sql) {
        try {
            ResultSet rs = dbm.SQLSelect(sql);

            //To remove previously added rows
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row);
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void fillCombobox(JComboBox combobox, String sql) {
        ResultSet rs = dbm.SQLSelect(sql);
        try {
            while (rs.next()) {
                combobox.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
