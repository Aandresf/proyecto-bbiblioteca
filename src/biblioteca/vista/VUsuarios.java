/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package biblioteca.vista;

/**
 *
 * @author arnal
 */
public class VUsuarios extends javax.swing.JPanel {

    
    public VUsuarios() {

        initComponents();
        lblId.setVisible(false);
        lblEstado.setVisible(false);
        lblControl.setVisible(false);
        lblInfoCorreo.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameFormUsuarios = new javax.swing.JFrame();
        pnlFormUsuario = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblControl = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        lblCurso = new javax.swing.JLabel();
        cbxCarrera = new javax.swing.JComboBox<>();
        lblAddCurso = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        lblSemestre = new javax.swing.JLabel();
        txtSemestre = new javax.swing.JTextField();
        lblInfoCorreo = new javax.swing.JLabel();
        fromCreateCurso = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        txtCurso = new javax.swing.JTextField();
        lblTitleCurso = new javax.swing.JLabel();
        btnLimpiarCurso = new javax.swing.JLabel();
        btnAceptarCurso = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        btnEliminarCurso = new javax.swing.JLabel();
        pnlUsuarioHeader = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlUsuarioMain = new javax.swing.JPanel();
        pnlTbUsuarios = new javax.swing.JPanel();
        btnSearch = new javax.swing.JLabel();
        txfSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        btnCrearUsuario = new javax.swing.JButton();
        btnEditarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();

        frameFormUsuarios.setAlwaysOnTop(true);
        frameFormUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        frameFormUsuarios.setLocation(new java.awt.Point(1136, 240));
        frameFormUsuarios.setMinimumSize(new java.awt.Dimension(350, 702));
        frameFormUsuarios.setModalExclusionType(null);
        frameFormUsuarios.setUndecorated(true);
        frameFormUsuarios.setResizable(false);
        frameFormUsuarios.setSize(new java.awt.Dimension(363, 710));
        frameFormUsuarios.setType(java.awt.Window.Type.UTILITY);

        pnlFormUsuario.setBackground(new java.awt.Color(255, 255, 255));
        pnlFormUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 255), 4, true));
        pnlFormUsuario.setOpaque(false);

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Roboto Black", 3, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("USUARIOS");

        lblId.setBackground(new java.awt.Color(255, 255, 204));
        lblId.setForeground(new java.awt.Color(255, 255, 204));
        lblId.setText("0");
        lblId.setToolTipText("");
        lblId.setEnabled(false);
        lblId.setFocusable(false);

        lblEstado.setText("0");

        lblCedula.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblCedula.setText("CEDULA");

        txtCedula.setBackground(new java.awt.Color(255, 255, 204));
        txtCedula.setBorder(null);
        txtCedula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCedula.setOpaque(true);

        lblNombre.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblNombre.setText("NOMBRES");

        txtNombre.setBackground(new java.awt.Color(255, 255, 204));
        txtNombre.setBorder(null);
        txtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombre.setOpaque(true);

        lblApellido.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblApellido.setText("APELLIDOS");

        txtApellido.setBackground(new java.awt.Color(255, 255, 204));
        txtApellido.setBorder(null);
        txtApellido.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtApellido.setOpaque(true);

        lblTelefono.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblTelefono.setText("TELEFONO");

        txtTelefono.setBackground(new java.awt.Color(255, 255, 204));
        txtTelefono.setBorder(null);
        txtTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTelefono.setOpaque(true);

        lblCorreo.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblCorreo.setText("CORREO");

        txtCorreo.setBackground(new java.awt.Color(255, 255, 204));
        txtCorreo.setBorder(null);
        txtCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCorreo.setOpaque(true);

        lblCategoria.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblCategoria.setText("CATEGORIA");

        cbxCategoria.setBackground(new java.awt.Color(255, 255, 204));
        cbxCategoria.setEditable(true);
        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCategoria.setBorder(null);
        cbxCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblCurso.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblCurso.setText("CURSO");

        cbxCarrera.setBackground(new java.awt.Color(255, 255, 204));
        cbxCarrera.setEditable(true);
        cbxCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCarrera.setBorder(null);
        cbxCarrera.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        cbxCarrera.setKeySelectionManager(null);

        lblAddCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconAdd.png"))); // NOI18N
        lblAddCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAceptar.setBackground(new java.awt.Color(204, 255, 204));
        btnAceptar.setFont(new java.awt.Font("Roboto Medium", 2, 18)); // NOI18N
        btnAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAceptar.setText("ACEPTAR");
        btnAceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setOpaque(true);

        btnLimpiar.setFont(new java.awt.Font("Roboto Medium", 2, 18)); // NOI18N
        btnLimpiar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setOpaque(true);

        btnEliminar.setBackground(new java.awt.Color(102, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Roboto Medium", 2, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar.setText("CANCELAR");
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setOpaque(true);

        lblSemestre.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblSemestre.setText("SEMESTRE");

        txtSemestre.setBackground(new java.awt.Color(255, 255, 204));
        txtSemestre.setBorder(null);
        txtSemestre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSemestre.setOpaque(true);

        lblInfoCorreo.setForeground(new java.awt.Color(255, 0, 51));
        lblInfoCorreo.setText("* Correo Invalido");

        javax.swing.GroupLayout pnlFormUsuarioLayout = new javax.swing.GroupLayout(pnlFormUsuario);
        pnlFormUsuario.setLayout(pnlFormUsuarioLayout);
        pnlFormUsuarioLayout.setHorizontalGroup(
            pnlFormUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFormUsuarioLayout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCedula)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtTelefono)
                    .addComponent(txtCorreo)
                    .addGroup(pnlFormUsuarioLayout.createSequentialGroup()
                        .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42))
                    .addGroup(pnlFormUsuarioLayout.createSequentialGroup()
                        .addComponent(cbxCarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAddCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSemestre)
                    .addGroup(pnlFormUsuarioLayout.createSequentialGroup()
                        .addGroup(pnlFormUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlFormUsuarioLayout.createSequentialGroup()
                                .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblInfoCorreo)))
                        .addGap(0, 115, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormUsuarioLayout.createSequentialGroup()
                        .addGroup(pnlFormUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFormUsuarioLayout.createSequentialGroup()
                                .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblControl)))
                .addContainerGap())
        );
        pnlFormUsuarioLayout.setVerticalGroup(
            pnlFormUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblControl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFormUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEstado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(pnlFormUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(lblInfoCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAddCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSemestre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout frameFormUsuariosLayout = new javax.swing.GroupLayout(frameFormUsuarios.getContentPane());
        frameFormUsuarios.getContentPane().setLayout(frameFormUsuariosLayout);
        frameFormUsuariosLayout.setHorizontalGroup(
            frameFormUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
            .addGroup(frameFormUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(frameFormUsuariosLayout.createSequentialGroup()
                    .addComponent(pnlFormUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );
        frameFormUsuariosLayout.setVerticalGroup(
            frameFormUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
            .addGroup(frameFormUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(frameFormUsuariosLayout.createSequentialGroup()
                    .addComponent(pnlFormUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );

        fromCreateCurso.setAlwaysOnTop(true);
        fromCreateCurso.setLocation(new java.awt.Point(1147, 655));
        fromCreateCurso.setMaximumSize(new java.awt.Dimension(200, 200));
        fromCreateCurso.setMinimumSize(new java.awt.Dimension(200, 200));
        fromCreateCurso.setUndecorated(true);
        fromCreateCurso.setPreferredSize(new java.awt.Dimension(200, 200));
        fromCreateCurso.setSize(new java.awt.Dimension(200, 168));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(197, 165));
        jPanel1.setMinimumSize(new java.awt.Dimension(197, 165));

        txtCurso.setToolTipText("");

        lblTitleCurso.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitleCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleCurso.setText("NUEVO CURSO");

        btnLimpiarCurso.setFont(new java.awt.Font("Roboto Medium", 2, 18)); // NOI18N
        btnLimpiarCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLimpiarCurso.setText("LIMPIAR");
        btnLimpiarCurso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnLimpiarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiarCurso.setOpaque(true);

        btnAceptarCurso.setBackground(new java.awt.Color(204, 255, 204));
        btnAceptarCurso.setFont(new java.awt.Font("Roboto Medium", 2, 18)); // NOI18N
        btnAceptarCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAceptarCurso.setText("ACEPTAR");
        btnAceptarCurso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnAceptarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptarCurso.setOpaque(true);

        btnEliminarCurso.setBackground(new java.awt.Color(102, 0, 0));
        btnEliminarCurso.setFont(new java.awt.Font("Roboto Medium", 2, 18)); // NOI18N
        btnEliminarCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarCurso.setText("CANCELAR");
        btnEliminarCurso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnEliminarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCurso.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnLimpiarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEliminarCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnAceptarCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitleCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCurso)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator5))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitleCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fromCreateCursoLayout = new javax.swing.GroupLayout(fromCreateCurso.getContentPane());
        fromCreateCurso.getContentPane().setLayout(fromCreateCursoLayout);
        fromCreateCursoLayout.setHorizontalGroup(
            fromCreateCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        fromCreateCursoLayout.setVerticalGroup(
            fromCreateCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fromCreateCursoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        fromCreateCurso.getAccessibleContext().setAccessibleParent(frameFormUsuarios);

        setMinimumSize(new java.awt.Dimension(1000, 732));
        setPreferredSize(new java.awt.Dimension(1000, 732));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUsuarioHeader.setBackground(new java.awt.Color(71, 255, 163));
        pnlUsuarioHeader.setMinimumSize(new java.awt.Dimension(1000, 60));

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GESTIONAR USUARIOS");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout pnlUsuarioHeaderLayout = new javax.swing.GroupLayout(pnlUsuarioHeader);
        pnlUsuarioHeader.setLayout(pnlUsuarioHeaderLayout);
        pnlUsuarioHeaderLayout.setHorizontalGroup(
            pnlUsuarioHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(836, Short.MAX_VALUE))
        );
        pnlUsuarioHeaderLayout.setVerticalGroup(
            pnlUsuarioHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
        );

        add(pnlUsuarioHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 60));

        pnlUsuarioMain.setBackground(new java.awt.Color(153, 255, 204));
        pnlUsuarioMain.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        pnlUsuarioMain.setMinimumSize(new java.awt.Dimension(1000, 672));
        pnlUsuarioMain.setPreferredSize(new java.awt.Dimension(1000, 672));
        pnlUsuarioMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTbUsuarios.setMinimumSize(new java.awt.Dimension(980, 652));
        pnlTbUsuarios.setOpaque(false);
        pnlTbUsuarios.setPreferredSize(new java.awt.Dimension(980, 652));
        pnlTbUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearch.setBackground(new java.awt.Color(255, 255, 252));
        btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconSearch.png"))); // NOI18N
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setOpaque(true);
        pnlTbUsuarios.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 40, 40));

        txfSearch.setBackground(new java.awt.Color(255, 255, 252));
        txfSearch.setBorder(null);
        txfSearch.setMargin(new java.awt.Insets(0, 10, 0, 0));
        txfSearch.setOpaque(true);
        pnlTbUsuarios.add(txfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 280, 40));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setAutoscrolls(true);

        tblUsers.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblUsers.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tblUsers.setRowHeight(35);
        jScrollPane1.setViewportView(tblUsers);

        pnlTbUsuarios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 980, 530));

        btnCrearUsuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnCrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconAdd.png"))); // NOI18N
        btnCrearUsuario.setText("CREAR USUARIO");
        btnCrearUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCrearUsuario.setIconTextGap(10);
        btnCrearUsuario.setMargin(new java.awt.Insets(2, 1, 3, 14));
        pnlTbUsuarios.add(btnCrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, 40));

        btnEditarUsuario.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconEditPerson.png"))); // NOI18N
        btnEditarUsuario.setText("MODIFICAR");
        btnEditarUsuario.setToolTipText("");
        btnEditarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditarUsuario.setIconTextGap(10);
        btnEditarUsuario.setMargin(new java.awt.Insets(2, 1, 3, 14));
        btnEditarUsuario.setMaximumSize(new java.awt.Dimension(125, 35));
        btnEditarUsuario.setMinimumSize(new java.awt.Dimension(125, 35));
        btnEditarUsuario.setPreferredSize(new java.awt.Dimension(125, 35));
        pnlTbUsuarios.add(btnEditarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 160, 40));

        btnEliminarUsuario.setBackground(new java.awt.Color(102, 0, 0));
        btnEliminarUsuario.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnEliminarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarUsuario.setText("ELIMINAR");
        btnEliminarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEliminarUsuario.setIconTextGap(10);
        btnEliminarUsuario.setMargin(new java.awt.Insets(2, 1, 3, 14));
        pnlTbUsuarios.add(btnEliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 610, 160, 40));

        pnlUsuarioMain.add(pnlTbUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 980, 652));

        add(pnlUsuarioMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 672));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnAceptar;
    public javax.swing.JLabel btnAceptarCurso;
    public javax.swing.JButton btnCrearUsuario;
    public javax.swing.JButton btnEditarUsuario;
    public javax.swing.JLabel btnEliminar;
    public javax.swing.JLabel btnEliminarCurso;
    public javax.swing.JButton btnEliminarUsuario;
    public javax.swing.JLabel btnLimpiar;
    public javax.swing.JLabel btnLimpiarCurso;
    public javax.swing.JLabel btnSearch;
    public javax.swing.JComboBox<String> cbxCarrera;
    public javax.swing.JComboBox<String> cbxCategoria;
    public javax.swing.JFrame frameFormUsuarios;
    public javax.swing.JFrame fromCreateCurso;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JSeparator jSeparator5;
    public javax.swing.JLabel lblAddCurso;
    public javax.swing.JLabel lblApellido;
    public javax.swing.JLabel lblCategoria;
    public javax.swing.JLabel lblCedula;
    public javax.swing.JLabel lblControl;
    public javax.swing.JLabel lblCorreo;
    public javax.swing.JLabel lblCurso;
    public javax.swing.JLabel lblEstado;
    public javax.swing.JLabel lblId;
    public javax.swing.JLabel lblInfoCorreo;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblSemestre;
    public javax.swing.JLabel lblTelefono;
    public javax.swing.JLabel lblTitle;
    public javax.swing.JLabel lblTitleCurso;
    public javax.swing.JPanel pnlFormUsuario;
    private javax.swing.JPanel pnlTbUsuarios;
    protected javax.swing.JPanel pnlUsuarioHeader;
    public javax.swing.JPanel pnlUsuarioMain;
    public javax.swing.JTable tblUsers;
    public javax.swing.JTextField txfSearch;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtCedula;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtCurso;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtSemestre;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
