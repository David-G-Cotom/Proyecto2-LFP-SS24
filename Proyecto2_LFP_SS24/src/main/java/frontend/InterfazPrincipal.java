/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import java.io.IOException;
import java.io.StringReader;
import javax.swing.table.DefaultTableModel;
import jflex.AnalizadorLexico;

/**
 *
 * @author Carlos Cotom
 */
public class InterfazPrincipal extends javax.swing.JFrame {

    private final DefaultTableModel modelTableErroresLexicos;
    private final DefaultTableModel modelTableErroresSintacticos;
    private final DefaultTableModel modelTableTablasEncontradas;
    private final DefaultTableModel modelTableTablasModificadas;

    /**
     * Creates new form InterfazPrincipal
     */
    public InterfazPrincipal() {
        this.modelTableErroresLexicos = new DefaultTableModel();
        this.modelTableErroresSintacticos = new DefaultTableModel();
        this.modelTableTablasEncontradas = new DefaultTableModel();
        this.modelTableTablasModificadas = new DefaultTableModel();
        initComponents();
        this.iniciarTableros();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        dlgReporteErrorLexico = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblErroresLexicos = new javax.swing.JTable();
        dlgReporteErrorSintactico = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblErroresSintacticos = new javax.swing.JTable();
        dlgReporteTablasEncontradas = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTablasEncontradas = new javax.swing.JTable();
        dlgReporteTablasModificadas = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTablasModificadas = new javax.swing.JTable();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txaCodigo = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuCarga = new javax.swing.JMenuItem();
        mnuGuardar = new javax.swing.JMenuItem();
        mnuGuardarComo = new javax.swing.JMenuItem();
        mnuGrafico = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        mnuErrorLexico = new javax.swing.JMenuItem();
        mnuErrorSintactico = new javax.swing.JMenuItem();
        mnuTablasEncontradas = new javax.swing.JMenuItem();
        mnuTablasModificadas = new javax.swing.JMenuItem();

        tblErroresLexicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Token", "Linea", "Columna", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblErroresLexicos);

        javax.swing.GroupLayout dlgReporteErrorLexicoLayout = new javax.swing.GroupLayout(dlgReporteErrorLexico.getContentPane());
        dlgReporteErrorLexico.getContentPane().setLayout(dlgReporteErrorLexicoLayout);
        dlgReporteErrorLexicoLayout.setHorizontalGroup(
            dlgReporteErrorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteErrorLexicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
        dlgReporteErrorLexicoLayout.setVerticalGroup(
            dlgReporteErrorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteErrorLexicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblErroresSintacticos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Token", "Tipo Token", "Linea", "Columna", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblErroresSintacticos);

        javax.swing.GroupLayout dlgReporteErrorSintacticoLayout = new javax.swing.GroupLayout(dlgReporteErrorSintactico.getContentPane());
        dlgReporteErrorSintactico.getContentPane().setLayout(dlgReporteErrorSintacticoLayout);
        dlgReporteErrorSintacticoLayout.setHorizontalGroup(
            dlgReporteErrorSintacticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteErrorSintacticoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        dlgReporteErrorSintacticoLayout.setVerticalGroup(
            dlgReporteErrorSintacticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteErrorSintacticoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblTablasEncontradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Token", "Linea", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblTablasEncontradas);

        javax.swing.GroupLayout dlgReporteTablasEncontradasLayout = new javax.swing.GroupLayout(dlgReporteTablasEncontradas.getContentPane());
        dlgReporteTablasEncontradas.getContentPane().setLayout(dlgReporteTablasEncontradasLayout);
        dlgReporteTablasEncontradasLayout.setHorizontalGroup(
            dlgReporteTablasEncontradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteTablasEncontradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        dlgReporteTablasEncontradasLayout.setVerticalGroup(
            dlgReporteTablasEncontradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteTablasEncontradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblTablasModificadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Token", "Linea", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblTablasModificadas);

        javax.swing.GroupLayout dlgReporteTablasModificadasLayout = new javax.swing.GroupLayout(dlgReporteTablasModificadas.getContentPane());
        dlgReporteTablasModificadas.getContentPane().setLayout(dlgReporteTablasModificadasLayout);
        dlgReporteTablasModificadasLayout.setHorizontalGroup(
            dlgReporteTablasModificadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteTablasModificadasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        dlgReporteTablasModificadasLayout.setVerticalGroup(
            dlgReporteTablasModificadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteTablasModificadasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WorkBench");
        setMinimumSize(new java.awt.Dimension(1000, 600));

        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        jScrollPane6.setViewportView(txaCodigo);

        jMenu1.setText("Archivo");

        mnuCarga.setText("Cargar");
        jMenu1.add(mnuCarga);

        mnuGuardar.setText("Guardar");
        jMenu1.add(mnuGuardar);

        mnuGuardarComo.setText("Guardar como");
        jMenu1.add(mnuGuardarComo);

        jMenuBar1.add(jMenu1);

        mnuGrafico.setText("Grafico");
        jMenuBar1.add(mnuGrafico);

        jMenu3.setText("Reporte");

        mnuErrorLexico.setText("Error Lexico");
        jMenu3.add(mnuErrorLexico);

        mnuErrorSintactico.setText("Error Sintacticos");
        jMenu3.add(mnuErrorSintactico);

        mnuTablasEncontradas.setText("Tablas Encontradas");
        jMenu3.add(mnuTablasEncontradas);

        mnuTablasModificadas.setText("Tablas Modificadas");
        jMenu3.add(mnuTablasModificadas);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnalizar)
                        .addGap(0, 922, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnAnalizar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        try {
            AnalizadorLexico analizador = new AnalizadorLexico(new StringReader(this.txaCodigo.getText()));
            analizador.pintor.establecerEstilo(this.txaCodigo.getText());
            this.txaCodigo.setDocument(analizador.pintor.textPane.getDocument());
            while (!analizador.yyatEOF()) {
                System.out.println(analizador.yylex().toString());
            }
            System.out.println("");
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    /**
     * Metodo que le da a las Tablas de Reportes en la interfaz el modelo
     * adecuado para su visualizacion
     */
    private void iniciarTableros() {
        this.tblErroresLexicos.setModel(modelTableErroresLexicos);
        this.modelTableErroresLexicos.addColumn("Token");
        this.modelTableErroresLexicos.addColumn("Linea");
        this.modelTableErroresLexicos.addColumn("Columna");
        this.modelTableErroresLexicos.addColumn("Descripcion");

        this.tblErroresSintacticos.setModel(modelTableErroresSintacticos);
        this.modelTableErroresSintacticos.addColumn("Token");
        this.modelTableErroresSintacticos.addColumn("Tipo TOken");
        this.modelTableErroresSintacticos.addColumn("Linea");
        this.modelTableErroresSintacticos.addColumn("Columna");
        this.modelTableErroresSintacticos.addColumn("Descripcion");

        this.tblTablasEncontradas.setModel(modelTableTablasEncontradas);
        this.modelTableTablasEncontradas.addColumn("Token");
        this.modelTableTablasEncontradas.addColumn("Linea");
        this.modelTableTablasEncontradas.addColumn("Columna");

        this.tblTablasModificadas.setModel(modelTableTablasModificadas);
        this.modelTableTablasModificadas.addColumn("Token");
        this.modelTableTablasModificadas.addColumn("Linea");
        this.modelTableTablasModificadas.addColumn("Columna");
    }

    /**
     * Metodo que limpia la Tabla de Reporte en la Interfaz para no tener
     * problemas de colapsos
     */
    private void vaciarTablaErroresLexicos() {
        this.tblErroresLexicos.removeAll();
        int filasTabla = this.modelTableErroresLexicos.getRowCount();
        if (filasTabla != 0) {
            for (int i = 0; i < filasTabla; i++) {
                this.modelTableErroresLexicos.removeRow(0);
            }
        }
    }

    /**
     * Metodo que limpia la Tabla de Reporte en la Interfaz para no tener
     * problemas de colapsos
     */
    private void vaciarTablaErroresSintacticos() {
        this.tblErroresSintacticos.removeAll();
        int filasTabla = this.modelTableErroresSintacticos.getRowCount();
        if (filasTabla != 0) {
            for (int i = 0; i < filasTabla; i++) {
                this.modelTableErroresSintacticos.removeRow(0);
            }
        }
    }

    /**
     * Metodo que limpia la Tabla de Reporte en la Interfaz para no tener
     * problemas de colapsos
     */
    private void vaciarTableTablasEncontradas() {
        this.tblTablasEncontradas.removeAll();
        int filasTabla = this.modelTableTablasEncontradas.getRowCount();
        if (filasTabla != 0) {
            for (int i = 0; i < filasTabla; i++) {
                this.modelTableTablasEncontradas.removeRow(0);
            }
        }
    }

    /**
     * Metodo que limpia la Tabla de Reporte en la Interfaz para no tener
     * problemas de colapsos
     */
    private void vaciarTableTablasModificadas() {
        this.tblTablasModificadas.removeAll();
        int filasTabla = this.modelTableTablasModificadas.getRowCount();
        if (filasTabla != 0) {
            for (int i = 0; i < filasTabla; i++) {
                this.modelTableTablasModificadas.removeRow(0);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JDialog dlgReporteErrorLexico;
    private javax.swing.JDialog dlgReporteErrorSintactico;
    private javax.swing.JDialog dlgReporteTablasEncontradas;
    private javax.swing.JDialog dlgReporteTablasModificadas;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JMenuItem mnuCarga;
    private javax.swing.JMenuItem mnuErrorLexico;
    private javax.swing.JMenuItem mnuErrorSintactico;
    private javax.swing.JMenu mnuGrafico;
    private javax.swing.JMenuItem mnuGuardar;
    private javax.swing.JMenuItem mnuGuardarComo;
    private javax.swing.JMenuItem mnuTablasEncontradas;
    private javax.swing.JMenuItem mnuTablasModificadas;
    private javax.swing.JTable tblErroresLexicos;
    private javax.swing.JTable tblErroresSintacticos;
    private javax.swing.JTable tblTablasEncontradas;
    private javax.swing.JTable tblTablasModificadas;
    private javax.swing.JTextPane txaCodigo;
    // End of variables declaration//GEN-END:variables
}
