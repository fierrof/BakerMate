package View;

import Controller.DBManager;
import Controller.ViewManager;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class frmHome extends javax.swing.JFrame {

    private ViewManager vm = new ViewManager();
    private DBManager dbm = new DBManager();
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    public frmHome() {
        initComponents();
        setDTP();
        setTables();
        setCombos();
        setEstadisticas();

    }

    private void setTables() {
        // set titulos
        vm.setTable(tblVenta, new String[]{"Fecha", "Cantidad", "Producto", "Total", "Usuario"});
        vm.setTable(tblMovimiento, new String[]{"Fecha", "Detalle", "Monto", "Tipo", "Usuario"});
        vm.setTable(tblMercaderia, new String[]{"ID", "Nombre", "Precio Compra", "Precio Venta", "Proveedor", "Stock"});
        vm.setTable(tblProveedor, new String[]{"Nombre", "E-Mail", "Telefono", "Direccion", "Deuda"});
        vm.setTable(tblCompra, new String[]{"Fecha", "Proveedor", "Cantidad", "Producto", "Precio Compra", "Total", "Vendedor", "Estado"});
        vm.setTable(tblGasto, new String[]{"Mes", "Detalle", "Monto", "Observaciones", "Tipo Gasto", "Estado"});
        //set contenido
        vm.fillTable(tblVenta, "SELECT venta.fecha, venta.cantidad, producto.nombre, venta.precio_vendido, venta.precio_vendido*venta.cantidad as Total, usuario.nombre FROM venta\n"
                + "INNER JOIN producto ON venta.id_producto = producto.id_producto\n"
                + "INNER JOIN usuario ON venta.id_usuario = usuario.id_usuario "
                + "WHERE venta.fecha = '" + formater.format(dtpCaja.getDate()) + "' "
                + "ORDER BY venta.fecha ");
        vm.fillTable(tblMovimiento, "SELECT movimiento.fecha,  movimiento.detalle, movimiento.monto, tipo_movimiento.nombre, usuario.nombre FROM movimiento\n"
                + "INNER JOIN usuario ON movimiento.id_usuario = usuario.id_usuario\n"
                + "INNER JOIN tipo_movimiento ON movimiento.id_tipo_movimiento = tipo_movimiento.id_tipo_movimiento\n"
                + "WHERE movimiento.fecha = '" + formater.format(dtpCaja.getDate()) + "' "
                + "ORDER BY movimiento.fecha");
        vm.fillTable(tblMercaderia, "SELECT producto.id_producto, producto.nombre, producto.precio_compra, producto.precio_venta, proveedor.nombre FROM producto\n"
                + "INNER JOIN proveedor on producto.id_proveedor = proveedor.id_proveedor\n"
                + "ORDER BY proveedor.nombre, producto.id_producto");
        vm.fillTable(tblProveedor, "SELECT proveedor.NOMBRE, proveedor.EMAIL, proveedor.TELEFONO, proveedor.DIRECCION, SUM(producto.PRECIO_COMPRA*compra.CANTIDAD*compra.id_estado_compra)\n"
                + "FROM compra\n"
                + "INNER JOIN producto ON compra.ID_PRODUCTO = producto.ID_PRODUCTO\n"
                + "INNER JOIN proveedor ON producto.ID_PROVEEDOR = proveedor.ID_PROVEEDOR\n"
                + "GROUP BY proveedor.NOMBRE, proveedor.EMAIL, proveedor.TELEFONO, proveedor.DIRECCION\n"
                + "");
        vm.fillTable(tblCompra, "SELECT compra.fecha, proveedor.nombre, compra.cantidad, producto.nombre, producto.precio_compra, producto.precio_compra * compra.cantidad , usuario.nombre, estado_compra.nombre\n"
                + "FROM producto\n"
                + "INNER JOIN compra ON producto.id_producto = compra.id_producto\n"
                + "INNER JOIN usuario ON compra.id_usuario = usuario.id_usuario\n"
                + "INNER JOIN proveedor ON producto.id_proveedor = proveedor.id_proveedor\n"
                + "INNER JOIN estado_compra ON compra.id_estado_compra = estado_compra.id_estado_compra\n"
                + "WHERE compra.fecha = '" + formater.format(dtpCompra.getDate()) + "' "
                + "ORDER BY compra.fecha\n"
                + "");
        vm.fillTable(tblGasto, "SELECT gasto.mes,gasto.detalle,gasto.monto,gasto.observacion,tipo_gasto.nombre,estado_gasto.nombre FROM gasto\n"
                + "INNER JOIN tipo_gasto ON gasto.ID_TIPO_GASTO = tipo_gasto.ID_TIPO_GASTO\n"
                + "INNER JOIN estado_gasto ON gasto.ID_ESTADO_GASTO = estado_gasto.ID_ESTADO_GASTO\n"
                + "ORDER BY gasto.mes");
        
    }

    private void setDTP() { //SETEA EN DEFAULT A LA FECHA DE HOY LOS DATEPICKERS
        dtpMovimiento.setDate(Date.valueOf(LocalDate.now()));
        dtpVenta.setDate(Date.valueOf(LocalDate.now()));
        dtpCaja.setDate(Date.valueOf(LocalDate.now()));
        dtpMercaderia.setDate(Date.valueOf(LocalDate.now()));
        dtpCompra.setDate(Date.valueOf(LocalDate.now()));
    }

    private void setCombos() {
        vm.fillCombobox(cboTipoMovimiento, "SELECT * FROM tipo_movimiento");
        vm.fillCombobox(cboProductoVenta, "SELECT * FROM producto");
        vm.fillCombobox(cboProveedorMercaderia, "SELECT * FROM proveedor");
        vm.fillCombobox(cboEstadoCompra, "SELECT*FROM estado_compra");
        vm.fillCombobox(cboProductoCompra, "SELECT*FROM producto");
    }

    private void setEstadisticas() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneHome = new javax.swing.JTabbedPane();
        paneCaja = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMovimiento = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtDetalleMovimiento = new javax.swing.JTextField();
        btnAceptarMovimiento = new javax.swing.JButton();
        dtpMovimiento = new org.jdesktop.swingx.JXDatePicker();
        txtMontoMovimiento = new javax.swing.JTextField();
        cboTipoMovimiento = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        txtCantidadVenta = new javax.swing.JTextField();
        btnAceptarVenta = new javax.swing.JButton();
        dtpVenta = new org.jdesktop.swingx.JXDatePicker();
        cboProductoVenta = new javax.swing.JComboBox<>();
        txtPrecioVendido = new javax.swing.JTextField();
        txtFiltroProductoVenta = new javax.swing.JTextField();
        dtpCaja = new org.jdesktop.swingx.JXDatePicker();
        paneMercaderia = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtNombreProducto = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        btnAceptarMercaderia = new javax.swing.JButton();
        txtPrecioCompra = new javax.swing.JTextField();
        cboProveedorMercaderia = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMercaderia = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        txtCantidadCompra = new javax.swing.JTextField();
        txtPrecioCompraCompra = new javax.swing.JTextField();
        bnAceptarCompra = new javax.swing.JButton();
        cboEstadoCompra = new javax.swing.JComboBox<>();
        dtpCompra = new org.jdesktop.swingx.JXDatePicker();
        cboProductoCompra = new javax.swing.JComboBox<>();
        dtpMercaderia = new org.jdesktop.swingx.JXDatePicker();
        paneProveedor = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txtNombreProveedor = new javax.swing.JTextField();
        txtEmailProveedor = new javax.swing.JTextField();
        btnAceptarProveedor = new javax.swing.JButton();
        txtApellidoProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        txtDireccionProveedor = new javax.swing.JTextField();
        paneGastos = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblGasto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paneHome.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        paneHome.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        paneHome.setPreferredSize(new java.awt.Dimension(500, 400));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimientos"));

        tblMovimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMovimiento);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ventas"));

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblVenta);

        txtDetalleMovimiento.setText("Detalle");

        btnAceptarMovimiento.setText("Aceptar");
        btnAceptarMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarMovimientoActionPerformed(evt);
            }
        });

        txtMontoMovimiento.setText("Monto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAceptarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dtpMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDetalleMovimiento)
                        .addComponent(txtMontoMovimiento, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cboTipoMovimiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dtpMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDetalleMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMontoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCantidadVenta.setText("Cantidad");

        btnAceptarVenta.setText("Aceptar");
        btnAceptarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarVentaActionPerformed(evt);
            }
        });

        txtPrecioVendido.setText("Precio Vendido");

        txtFiltroProductoVenta.setText("ID");
        txtFiltroProductoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroProductoVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dtpVenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAceptarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVendido, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidadVenta)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtFiltroProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboProductoVenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dtpVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltroProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioVendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dtpCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtpCajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneCajaLayout = new javax.swing.GroupLayout(paneCaja);
        paneCaja.setLayout(paneCajaLayout);
        paneCajaLayout.setHorizontalGroup(
            paneCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCajaLayout.createSequentialGroup()
                .addGroup(paneCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(paneCajaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dtpCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(809, Short.MAX_VALUE))
        );
        paneCajaLayout.setVerticalGroup(
            paneCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneCajaLayout.createSequentialGroup()
                .addGroup(paneCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneCajaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtpCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneHome.addTab("Caja", paneCaja);

        paneMercaderia.setPreferredSize(new java.awt.Dimension(500, 400));

        txtNombreProducto.setText("Producto");
        txtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoActionPerformed(evt);
            }
        });

        txtPrecioVenta.setText("Precio Venta");
        txtPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaActionPerformed(evt);
            }
        });

        btnAceptarMercaderia.setText("Aceptar");
        btnAceptarMercaderia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarMercaderiaActionPerformed(evt);
            }
        });

        txtPrecioCompra.setText("Precio Compra");

        cboProveedorMercaderia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProveedorMercaderiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cboProveedorMercaderia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptarMercaderia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboProveedorMercaderia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptarMercaderia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        tblMercaderia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblMercaderia);

        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder("Compras"));

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblCompra);

        txtCantidadCompra.setText("Cantidad");

        txtPrecioCompraCompra.setText("Precio Compra");
        txtPrecioCompraCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCompraCompraActionPerformed(evt);
            }
        });

        bnAceptarCompra.setText("Aceptar");
        bnAceptarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnAceptarCompraActionPerformed(evt);
            }
        });

        cboProductoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductoCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bnAceptarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboEstadoCompra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioCompraCompra)
                    .addComponent(cboProductoCompra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadCompra)
                    .addComponent(dtpCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dtpCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboProductoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioCompraCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnAceptarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboEstadoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dtpMercaderia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtpMercaderiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneMercaderiaLayout = new javax.swing.GroupLayout(paneMercaderia);
        paneMercaderia.setLayout(paneMercaderiaLayout);
        paneMercaderiaLayout.setHorizontalGroup(
            paneMercaderiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMercaderiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMercaderiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                    .addGroup(paneMercaderiaLayout.createSequentialGroup()
                        .addComponent(dtpMercaderia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneMercaderiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paneMercaderiaLayout.setVerticalGroup(
            paneMercaderiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMercaderiaLayout.createSequentialGroup()
                .addGroup(paneMercaderiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneMercaderiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneMercaderiaLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtpMercaderia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        paneHome.addTab("Mercaderia", paneMercaderia);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedores"));

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblProveedor);

        txtNombreProveedor.setText("Nombre");

        txtEmailProveedor.setText("Email");
        txtEmailProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailProveedorActionPerformed(evt);
            }
        });

        btnAceptarProveedor.setText("Aceptar");
        btnAceptarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarProveedorActionPerformed(evt);
            }
        });

        txtApellidoProveedor.setText("Apellido");

        txtTelefonoProveedor.setText("Telefono");
        txtTelefonoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoProveedorActionPerformed(evt);
            }
        });

        txtDireccionProveedor.setText("Direccion");
        txtDireccionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAceptarProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtApellidoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtEmailProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmailProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout paneProveedorLayout = new javax.swing.GroupLayout(paneProveedor);
        paneProveedor.setLayout(paneProveedorLayout);
        paneProveedorLayout.setHorizontalGroup(
            paneProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneProveedorLayout.setVerticalGroup(
            paneProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        paneHome.addTab("Proveedores", paneProveedor);

        jScrollPane6.setBorder(javax.swing.BorderFactory.createTitledBorder("Gastos"));

        tblGasto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblGasto);

        javax.swing.GroupLayout paneGastosLayout = new javax.swing.GroupLayout(paneGastos);
        paneGastos.setLayout(paneGastosLayout);
        paneGastosLayout.setHorizontalGroup(
            paneGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneGastosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addGap(155, 155, 155))
        );
        paneGastosLayout.setVerticalGroup(
            paneGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneGastosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        paneHome.addTab("Gastos", paneGastos);

        lblUsuario.setText("Usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblUsuario)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneHome, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneHome, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarMovimientoActionPerformed
        String sql = "INSERT INTO MOVIMIENTO (fecha, detalle, monto, id_tipo_movimiento, id_usuario) VALUES ('" + formater.format(dtpMovimiento.getDate()) + "', '" + txtDetalleMovimiento.getText() + "', " + Integer.valueOf(txtMontoMovimiento.getText()) + ", " + (cboTipoMovimiento.getSelectedIndex() + 1) + ",1)";
        //        System.out.println(sql);
        dbm.SQLInsert(sql);
        setTables();

    }//GEN-LAST:event_btnAceptarMovimientoActionPerformed

    private void btnAceptarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarVentaActionPerformed
        String sql = "INSERT INTO VENTA (fecha, cantidad, precio_vendido, id_producto, id_usuario, id_tipo_venta) VALUES ('" + formater.format(dtpVenta.getDate()) + "', " + txtCantidadVenta.getText() + ", " + txtPrecioVendido.getText() + ", " + (cboProductoVenta.getSelectedIndex() + 1) + ", " + 1 + ", " + 1 + ")";
        //        System.out.println(sql);
        dbm.SQLInsert(sql);
        setTables();
    }//GEN-LAST:event_btnAceptarVentaActionPerformed

    private void dtpCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtpCajaActionPerformed
        setTables();
    }//GEN-LAST:event_dtpCajaActionPerformed

    private void btnAceptarMercaderiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarMercaderiaActionPerformed
        String sql = "INSERT INTO producto (nombre, precio_compra, precio_venta, id_proveedor) VALUES ('" + txtNombreProducto.getText() + "'," + Double.valueOf(txtPrecioCompra.getText()) + "," + Double.valueOf(txtPrecioVenta.getText()) + ", " + (cboProveedorMercaderia.getSelectedIndex() + 1) + ")";
        //        System.out.println(sql);
        dbm.SQLInsert(sql);
        setTables();
    }//GEN-LAST:event_btnAceptarMercaderiaActionPerformed

    private void txtPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaActionPerformed

    private void txtEmailProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailProveedorActionPerformed

    private void btnAceptarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarProveedorActionPerformed
        String sql = "INSERT INTO PROVEEDOR (nombre, apellido, email, telefono, direccion) VALUES ('" + txtNombreProveedor.getText() + "', '" + txtApellidoProveedor.getText() + "','" + txtEmailProveedor.getText() + "','" + txtTelefonoProveedor.getText() + "', '" + txtDireccionProveedor.getText() + "')";
        //        System.out.println(sql);
        dbm.SQLInsert(sql);
        setTables();
    }//GEN-LAST:event_btnAceptarProveedorActionPerformed

    private void txtPrecioCompraCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioCompraCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCompraCompraActionPerformed

    private void bnAceptarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAceptarCompraActionPerformed
        String sql = "INSERT INTO COMPRA (fecha, cantidad, id_estado_compra, id_producto, id_usuario) VALUES ('" + formater.format(dtpCompra.getDate()) + "', " + Double.valueOf(txtCantidadCompra.getText()) + ", " + cboEstadoCompra.getSelectedIndex() + ", " + (cboProductoCompra.getSelectedIndex() + 1) + ", " + 1 + ")";
//               System.out.println(sql);
        dbm.SQLInsert(sql);
        setTables();
    }//GEN-LAST:event_bnAceptarCompraActionPerformed

    private void txtTelefonoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoProveedorActionPerformed

    private void txtDireccionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionProveedorActionPerformed

    private void dtpMercaderiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtpMercaderiaActionPerformed
        setTables();
    }//GEN-LAST:event_dtpMercaderiaActionPerformed

    private void cboProveedorMercaderiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProveedorMercaderiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboProveedorMercaderiaActionPerformed

    private void cboProductoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductoCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboProductoCompraActionPerformed

    private void txtNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductoActionPerformed
        vm.fillTable(tblMercaderia, "SELECT producto.id_producto, producto.nombre, producto.precio_compra, producto.precio_venta, proveedor.nombre FROM producto\n"
                + "INNER JOIN proveedor on producto.id_proveedor = proveedor.id_proveedor\n"
                + "WHERE producto.nombre = '" + txtNombreProducto.getText() + "' \n"
                + "ORDER BY proveedor.nombre, producto.id_producto");
    }//GEN-LAST:event_txtNombreProductoActionPerformed

    private void txtFiltroProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroProductoVentaActionPerformed

        try {
            int id = Integer.valueOf(txtFiltroProductoVenta.getText()) - 1;
            cboProductoVenta.setSelectedIndex(id);
        } catch (Exception e) {
            System.err.print(e);
        }


    }//GEN-LAST:event_txtFiltroProductoVentaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAceptarCompra;
    private javax.swing.JButton btnAceptarMercaderia;
    private javax.swing.JButton btnAceptarMovimiento;
    private javax.swing.JButton btnAceptarProveedor;
    private javax.swing.JButton btnAceptarVenta;
    private javax.swing.JComboBox<String> cboEstadoCompra;
    private javax.swing.JComboBox<String> cboProductoCompra;
    private javax.swing.JComboBox<String> cboProductoVenta;
    private javax.swing.JComboBox<String> cboProveedorMercaderia;
    private javax.swing.JComboBox<String> cboTipoMovimiento;
    private org.jdesktop.swingx.JXDatePicker dtpCaja;
    private org.jdesktop.swingx.JXDatePicker dtpCompra;
    private org.jdesktop.swingx.JXDatePicker dtpMercaderia;
    private org.jdesktop.swingx.JXDatePicker dtpMovimiento;
    private org.jdesktop.swingx.JXDatePicker dtpVenta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel paneCaja;
    private javax.swing.JPanel paneGastos;
    private javax.swing.JTabbedPane paneHome;
    private javax.swing.JPanel paneMercaderia;
    private javax.swing.JPanel paneProveedor;
    private javax.swing.JTable tblCompra;
    private javax.swing.JTable tblGasto;
    private javax.swing.JTable tblMercaderia;
    private javax.swing.JTable tblMovimiento;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTable tblVenta;
    private javax.swing.JTextField txtApellidoProveedor;
    private javax.swing.JTextField txtCantidadCompra;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtDetalleMovimiento;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtEmailProveedor;
    private javax.swing.JTextField txtFiltroProductoVenta;
    private javax.swing.JTextField txtMontoMovimiento;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioCompraCompra;
    private javax.swing.JTextField txtPrecioVendido;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtTelefonoProveedor;
    // End of variables declaration//GEN-END:variables
}
