package com.mycompany.laboratorio2_zhernandez;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReinicioClave extends JDialog {

    private JPasswordField txtContrasena;
    private JPasswordField txtConfirmar;
    private JButton btnGuardar;
    private JButton btnSalir;

    public ReinicioClave(JFrame parent) {
        super(parent, "Reiniciar clave", true); // modal = true
        initComponents();
        setSize(400, 260);
        setLocationRelativeTo(parent);
        setResizable(false);
    }

    private void initComponents() {
        // Panel principal con fondo verde claro
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBackground(new Color(200, 230, 200));
        panelPrincipal.setBorder(BorderFactory.createLineBorder(new Color(160, 200, 160), 2));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 12, 8, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel lblTitulo = new JLabel("Reiniciar clave", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelPrincipal.add(lblTitulo, gbc);

        // Etiqueta Contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(lblContrasena, gbc);

        // Campo Contraseña
        txtContrasena = new JPasswordField(20);
        gbc.gridx = 1; gbc.gridy = 1;
        panelPrincipal.add(txtContrasena, gbc);

        // Etiqueta Confirmar
        JLabel lblConfirmar = new JLabel("Confirmar Contraseña:");
        lblConfirmar.setFont(new Font("Arial", Font.PLAIN, 13));
        gbc.gridx = 0; gbc.gridy = 2;
        panelPrincipal.add(lblConfirmar, gbc);

        // Campo Confirmar
        txtConfirmar = new JPasswordField(20);
        gbc.gridx = 1; gbc.gridy = 2;
        panelPrincipal.add(txtConfirmar, gbc);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        panelBotones.setOpaque(false);

        btnGuardar = new JButton("Guardar");
        btnSalir = new JButton("Salir");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnSalir);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(panelBotones, gbc);

        add(panelPrincipal);

        // Acción Guardar
        btnGuardar.addActionListener(e -> guardarClave());

        // Acción Salir
        btnSalir.addActionListener(e -> dispose());
    }

    private void guardarClave() {
        String clave = new String(txtContrasena.getPassword());
        String confirmar = new String(txtConfirmar.getPassword());

        // Validar que no estén vacíos
        if (clave.isEmpty() || confirmar.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor complete todos los campos.",
                "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar longitud mínima
        if (clave.length() < 13) {
            JOptionPane.showMessageDialog(this,
                "La contraseña debe tener al menos 13 caracteres.",
                "Contraseña inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar al menos una mayúscula
        if (!clave.matches(".*[A-Z].*")) {
            JOptionPane.showMessageDialog(this,
                "La contraseña debe contener al menos una letra mayúscula.",
                "Contraseña inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar al menos un signo especial
        if (!clave.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            JOptionPane.showMessageDialog(this,
                "La contraseña debe contener al menos un carácter especial.",
                "Contraseña inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar coincidencia
        if (!clave.equals(confirmar)) {
            JOptionPane.showMessageDialog(this,
                "Las contraseñas no coinciden.",
                "Error de confirmación", JOptionPane.ERROR_MESSAGE);
            txtContrasena.setText("");
            txtConfirmar.setText("");
            txtContrasena.requestFocus();
            return;
        }

        // Todo válido
        JOptionPane.showMessageDialog(this,
            "Contraseña actualizada exitosamente.",
            "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    // Para pruebas independientes
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReinicioClave dialogo = new ReinicioClave(null);
            dialogo.setVisible(true);
        });
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("Reiniciar clave ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña: ");

        jButton1.setText("Salir");

        jButton2.setText("Guardar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addComponent(jLabel1))
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(14, 14, 14))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables

