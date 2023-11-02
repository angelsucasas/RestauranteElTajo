/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Controladora;
import Modelo.Combo;
import Modelo.Comida;
import Modelo.Empleado;
import Modelo.Pedido;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Scarlet
 */
public class GenerarOrden extends javax.swing.JFrame {
    Controladora micontrol;
    
    private Hashtable<Comida, Integer> comidas_pedidas_y_su_cantidad = new Hashtable<Comida, Integer>();
    private Hashtable<Combo, Integer> combos_pedidos_y_su_cantidad = new Hashtable<Combo, Integer>();
    
    String[] nombres = {};
    List<Integer> codigos = new ArrayList<>();
    
    Set <Pedido> pedidos;

    List<Empleado> meseros;
    List<String> nombre_meseros;
    
    List<String> mesasDisponiblesEnSistema;

    List<String> nombre_menus;
    List<Integer> codigo_menus;
    
    List<String> nombre_comidas;
    List<Integer> codigo_comidas;
    
    List<String> nombre_individual_de_cada_combo_de_los_menus;
    List<Integer> codigo_combos;
    
    List<Combo> combos_de_los_menus;
    List<String> comida_de_los_menus;
    
    List<String> comidas_por_cada_menu;
    
    List<String> nombre_individual_de_cada_comida_de_los_menus;
    List<Integer> codigo_comidas_por_cada_menu;
        
    List<Integer> codigo_combos_por_cada_menu;
    
    List<Integer> unidad_de_combos_que_pidio_el_cliente_en_la_orden = new ArrayList<>();            
    List<Integer> unidad_de_platos_que_pidio_el_cliente_en_la_orden = new ArrayList<>();
    
    /**
     * Creates new form GenerarOrden
     */
    public GenerarOrden() {
        initComponents();
    }
    
    public void cargarOrdenes(){
        pedidos = micontrol.getPedidos();
                
        DefaultTableModel modelT = (DefaultTableModel) listadoDeOrdenes.getModel();
        modelT.setRowCount(0);
        
        codigos = new ArrayList<>();
        
        for(Pedido pedido:pedidos){
            if(!pedido.getOrdenCobrada()){
                codigos.add(pedido.getCodigo());
                modelT.addRow(new Object[]{pedido.getCodigo(), pedido.getMesa(), pedido.getMesero().conseguirNombreCompleto(), LocalDateTime.now()});
            }
        }
        
        mesasDisponiblesEnSistema = micontrol.getMesasDisponibles();  
        
        mesasDisponibles.removeAllItems();
        mesasDisponibles.setModel(new DefaultComboBoxModel<>(mesasDisponiblesEnSistema.toArray(nombres)));
        
        cargarDatosRestaurante();
    }

    public void cargarDatosRestaurante(){
        //meseros
        meseros = micontrol.getTodosLosMeseros();
        nombre_meseros = micontrol.getTodosLosLosMeseros();        
        
        //mesas
        mesasDisponiblesEnSistema = micontrol.getMesasDisponibles();        
        
        //para las ordenes solo se usaran los combos y comidas que esten en el menu activo
        nombre_menus = micontrol.filtrarMenuPorNombre();
        codigo_menus = micontrol.getMenuPorCodigo();       
        
        //combos
        combos_de_los_menus = micontrol.getCombosDelMenu();        
        nombre_individual_de_cada_combo_de_los_menus = micontrol.getStringIndividualDeCadaCombosDelMenu();        
        codigo_combos_por_cada_menu = micontrol.getCodigoIndividualDeCadaCombosDelMenu();
        
        //comida o plato
        comida_de_los_menus = micontrol.getComidasDelMenu();
        
        nombre_individual_de_cada_comida_de_los_menus = micontrol.getStringIndividualDeCadaComidaDelMenu();
        
        comidas_por_cada_menu = micontrol.getComidasDelMenu();
        codigo_comidas_por_cada_menu = micontrol.getIntegerIndividualDeCadaComidaDelMenu();
        
        nombre_comidas = micontrol.filtrarComidasPorNombre();
        codigo_comidas = micontrol.getComidasPorCodigo();                                       
                
        meserosDisponibles.removeAllItems();
        meserosDisponibles.setModel(new DefaultComboBoxModel<>(nombre_meseros.toArray(nombres)));
        
        mesasDisponibles.removeAllItems();
        mesasDisponibles.setModel(new DefaultComboBoxModel<>(mesasDisponiblesEnSistema.toArray(nombres)));
        
        listaCombosDisponibles.removeAllItems();
        listaCombosDisponibles.setModel(new DefaultComboBoxModel<>(nombre_individual_de_cada_combo_de_los_menus.toArray(nombres)));               
        
        listaPlatoDisponibles.removeAllItems();
        listaPlatoDisponibles.setModel(new DefaultComboBoxModel<>(nombre_individual_de_cada_comida_de_los_menus.toArray(nombres)));        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        salirMenuGenerarOrden = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        meserosDisponibles = new javax.swing.JComboBox<>();
        mesasDisponibles = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        listaCombosAgregados = new javax.swing.JComboBox<>();
        unidadesDelComboPedidas = new javax.swing.JTextField();
        listaCombosDisponibles = new javax.swing.JComboBox<>();
        AgregarCombo3 = new javax.swing.JButton();
        RemoverCombo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        unidadesDelComboAPedir = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        listaPlatoAgregados = new javax.swing.JComboBox<>();
        RemoverPlato = new javax.swing.JButton();
        unidadesDelPlatoAPedir = new javax.swing.JTextField();
        listaPlatoDisponibles = new javax.swing.JComboBox<>();
        unidadesDelPlatoPedidas = new javax.swing.JTextField();
        AgregarPlato = new javax.swing.JButton();
        agregarProducto = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listadoDeOrdenes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("El Tajo");

        salirMenuGenerarOrden.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        salirMenuGenerarOrden.setText("SALIR");
        salirMenuGenerarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuGenerarOrdenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(salirMenuGenerarOrden)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addGap(190, 190, 190)
                .addComponent(salirMenuGenerarOrden)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("MESERO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Generar Orden");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel3)
                .addContainerGap(698, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 102, 0));

        jLabel8.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        jLabel8.setText("ORDENES PENDIENTES");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(108, 108, 108))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mesero asignado:");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mesa que pide la orden :");

        meserosDisponibles.setName(""); // NOI18N
        meserosDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meserosDisponiblesActionPerformed(evt);
            }
        });

        mesasDisponibles.setName(""); // NOI18N
        mesasDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesasDisponiblesActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Mesero y mesa");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9))
                        .addGap(248, 248, 248)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mesasDisponibles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(meserosDisponibles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(meserosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(mesasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Contenido de la orden del cliente");

        jPanel10.setBackground(new java.awt.Color(255, 153, 51));

        listaCombosAgregados.setName(""); // NOI18N
        listaCombosAgregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaCombosAgregadosActionPerformed(evt);
            }
        });

        unidadesDelComboPedidas.setEditable(false);

        listaCombosDisponibles.setName(""); // NOI18N
        listaCombosDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaCombosDisponiblesActionPerformed(evt);
            }
        });

        AgregarCombo3.setText("agregar combo");
        AgregarCombo3.setToolTipText("");
        AgregarCombo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarCombo3ActionPerformed(evt);
            }
        });

        RemoverCombo.setText("remover combo");
        RemoverCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverComboActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Combos Agregados al menu :");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Unidades del combo que pide el cliente:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Combos Disponible :");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Combos");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Unidades del combo pedidas por el cliente:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7)
                            .addComponent(jLabel20))
                        .addGap(160, 160, 160)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(listaCombosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(unidadesDelComboPedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(listaCombosAgregados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(RemoverCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(AgregarCombo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(unidadesDelComboAPedir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listaCombosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgregarCombo3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unidadesDelComboAPedir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listaCombosAgregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RemoverCombo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unidadesDelComboPedidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 153, 51));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Platos");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Platos disponibles :");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cuantas unidades del plato que pidio el cliente:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Plastos agregados al menu :");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Unidades del combo pedidas por el cliente:");

        listaPlatoAgregados.setName(""); // NOI18N
        listaPlatoAgregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPlatoAgregadosActionPerformed(evt);
            }
        });

        RemoverPlato.setText("remover plato");
        RemoverPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverPlatoActionPerformed(evt);
            }
        });

        listaPlatoDisponibles.setName(""); // NOI18N
        listaPlatoDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPlatoDisponiblesActionPerformed(evt);
            }
        });

        unidadesDelPlatoPedidas.setEditable(false);

        AgregarPlato.setText("agregar plato");
        AgregarPlato.setToolTipText("");
        AgregarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPlatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel21)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGap(138, 138, 138)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(unidadesDelPlatoAPedir)
                                    .addComponent(listaPlatoDisponibles, 0, 128, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgregarPlato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(unidadesDelPlatoPedidas)
                                    .addComponent(listaPlatoAgregados, 0, 130, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RemoverPlato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listaPlatoDisponibles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgregarPlato))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unidadesDelPlatoAPedir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listaPlatoAgregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RemoverPlato))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(unidadesDelPlatoPedidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        agregarProducto.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        agregarProducto.setText("AGREGAR ORDEN");
        agregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel17))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(agregarProducto)
                .addGap(165, 165, 165))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(agregarProducto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listadoDeOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Orden", "Mesa", "Mesero", "Fecha"
            }
        ));
        listadoDeOrdenes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listadoDeOrdenesFocusGained(evt);
            }
        });
        listadoDeOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listadoDeOrdenesMouseClicked(evt);
            }
        });
        listadoDeOrdenes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listadoDeOrdenesKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(listadoDeOrdenes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirMenuGenerarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuGenerarOrdenActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_salirMenuGenerarOrdenActionPerformed

    private void listaCombosDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaCombosDisponiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaCombosDisponiblesActionPerformed

    private void listaCombosAgregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaCombosAgregadosActionPerformed
        // TODO add your handling code here:
        if(listaCombosAgregados.getSelectedIndex() != -1 && unidad_de_combos_que_pidio_el_cliente_en_la_orden.size() == listaCombosAgregados.getItemCount()){           
            unidadesDelComboPedidas.setText( unidad_de_combos_que_pidio_el_cliente_en_la_orden.get(listaCombosAgregados.getSelectedIndex()).toString());
        }
    }//GEN-LAST:event_listaCombosAgregadosActionPerformed

    private void listaPlatoDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPlatoDisponiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaPlatoDisponiblesActionPerformed

    private void listaPlatoAgregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPlatoAgregadosActionPerformed
        // TODO add your handling code here:
        if(listaPlatoAgregados.getSelectedIndex() != -1 && unidad_de_platos_que_pidio_el_cliente_en_la_orden.size() == listaPlatoAgregados.getItemCount()){            
            unidadesDelPlatoPedidas.setText(this.unidad_de_platos_que_pidio_el_cliente_en_la_orden.get(listaPlatoAgregados.getSelectedIndex()).toString());
        }
    }//GEN-LAST:event_listaPlatoAgregadosActionPerformed

    private void mesasDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesasDisponiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesasDisponiblesActionPerformed

    private void meserosDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meserosDisponiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meserosDisponiblesActionPerformed

    private void AgregarCombo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarCombo3ActionPerformed
        // TODO add your handling code here:
        if(listaCombosDisponibles.getItemCount()!= 0 && !unidadesDelComboAPedir.getText().isBlank() && !unidadesDelComboAPedir.getText().isEmpty()){
            listaCombosAgregados.addItem(listaCombosDisponibles.getSelectedItem().toString());            
            listaCombosAgregados.setSelectedIndex(listaCombosAgregados.getItemCount()-1);
            unidad_de_combos_que_pidio_el_cliente_en_la_orden.add(Integer.parseInt(unidadesDelComboAPedir.getText())); 
            unidadesDelComboPedidas.setText( unidadesDelComboAPedir.getText());
        }
    }//GEN-LAST:event_AgregarCombo3ActionPerformed

    private void AgregarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPlatoActionPerformed
        // TODO add your handling code here:
        if(listaPlatoDisponibles.getItemCount()!= 0 && !unidadesDelPlatoAPedir.getText().isBlank() && !unidadesDelPlatoAPedir.getText().isEmpty()){
            listaPlatoAgregados.addItem(listaPlatoDisponibles.getSelectedItem().toString());
            listaPlatoAgregados.setSelectedIndex(listaPlatoAgregados.getItemCount()-1);
            unidad_de_platos_que_pidio_el_cliente_en_la_orden.add(Integer.parseInt(unidadesDelPlatoAPedir.getText())); 
            unidadesDelPlatoPedidas.setText(unidadesDelPlatoAPedir.getText());
        }
    }//GEN-LAST:event_AgregarPlatoActionPerformed

    private void RemoverComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverComboActionPerformed
        // TODO add your handling code here:
        if(listaCombosAgregados.getItemCount()!= 0){
            unidad_de_combos_que_pidio_el_cliente_en_la_orden.remove(unidad_de_combos_que_pidio_el_cliente_en_la_orden.get(listaCombosAgregados.getSelectedIndex()));
            listaCombosAgregados.removeItemAt(listaCombosAgregados.getSelectedIndex());
            unidadesDelComboPedidas.setText("");
        }
    }//GEN-LAST:event_RemoverComboActionPerformed

    private void RemoverPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverPlatoActionPerformed
        // TODO add your handling code here:
        if(listaPlatoAgregados.getItemCount()!= 0){
            unidad_de_platos_que_pidio_el_cliente_en_la_orden.remove(unidad_de_platos_que_pidio_el_cliente_en_la_orden.get(listaPlatoAgregados.getSelectedIndex()));
            listaPlatoAgregados.removeItemAt(listaPlatoAgregados.getSelectedIndex());
            unidadesDelPlatoPedidas.setText("");
        }
    }//GEN-LAST:event_RemoverPlatoActionPerformed

    private void agregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProductoActionPerformed
        // TODO add your handling code here:
        if(
            meserosDisponibles.getSelectedIndex() != -1 &&
            mesasDisponibles.getSelectedIndex() != -1 &&
            ((listaCombosAgregados.getSelectedIndex() != -1 && !unidadesDelComboPedidas.getText().isBlank() ) || (listaPlatoAgregados.getSelectedIndex() != -1 && !unidadesDelPlatoPedidas.getText().isBlank()))
        ){
            List<Comida> comidas = new ArrayList<>();
            List<Combo> combos = new ArrayList<>();
            
            //private Hashtable<Comida, Integer> comidas_pedidas_y_su_cantidad;
            //private Hashtable<Combo, Integer> combos_pedidos_y_su_cantidad;
            if(listaCombosAgregados.getItemCount() != 0){
                for (int indexCombosAAgregar = 0; indexCombosAAgregar < listaCombosAgregados.getItemCount() ; indexCombosAAgregar++) {
                    int  codigo_combo_a_registrar = codigo_combos_por_cada_menu.get(nombre_individual_de_cada_combo_de_los_menus.indexOf(listaCombosAgregados.getItemAt(indexCombosAAgregar)));
                    combos_pedidos_y_su_cantidad.put(
                            (Combo)micontrol.filtrarComboPorCodigo(micontrol.getCombos(), codigo_combo_a_registrar),
                            unidad_de_combos_que_pidio_el_cliente_en_la_orden.get(indexCombosAAgregar)
                    );
                }                
            }
            
            if(listaPlatoAgregados.getItemCount() != 0){
                for (int indexPlatosAAgregar = 0; indexPlatosAAgregar < listaPlatoAgregados.getItemCount() ; indexPlatosAAgregar++) {                    
                    int  codigo_comida_a_registrar = codigo_comidas_por_cada_menu.get(nombre_comidas.indexOf(listaPlatoAgregados.getItemAt(indexPlatosAAgregar)));
                    comidas_pedidas_y_su_cantidad.put(
                            (Comida)micontrol.filtrarComidaPorCodigo( codigo_comida_a_registrar),
                            unidad_de_platos_que_pidio_el_cliente_en_la_orden.get(indexPlatosAAgregar)
                    );
                }
            }
                                    
            micontrol.crearPedido(comidas_pedidas_y_su_cantidad, combos_pedidos_y_su_cantidad, mesasDisponibles.getSelectedItem().toString() /*, LocalDateTime.now()*/, meseros.get(meserosDisponibles.getSelectedIndex()));
            cargarOrdenes();
        }else{
            if(meserosDisponibles.getSelectedIndex() == -1) JOptionPane.showMessageDialog(rootPane, "debe registrar algun mesero antes de crear una orden ");
            if(mesasDisponibles.getSelectedIndex() == -1) JOptionPane.showMessageDialog(rootPane, "no hay mesas disponibles, desocupe mesas para poder ordenar. verifique la lista de ordenes activas para verificar que mesas estan asignadas");
            if((listaCombosAgregados.getSelectedIndex() == -1 || unidadesDelComboPedidas.getText().isBlank() )) JOptionPane.showMessageDialog(rootPane, "Si va a agregar algun combo a la orden, debe indicar cuantas unidades de dicho combo pidio el cliente ");
            if((listaPlatoAgregados.getSelectedIndex() == -1 || unidadesDelPlatoPedidas.getText().isBlank())) JOptionPane.showMessageDialog(rootPane, "Si va a agregar alguna plato a la orden, debe indicar cuantas unidades de dicho plato pidio el cliente");            
        }
    }//GEN-LAST:event_agregarProductoActionPerformed

    private void listadoDeOrdenesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listadoDeOrdenesFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_listadoDeOrdenesFocusGained

    private void listadoDeOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoDeOrdenesMouseClicked
        // TODO add your handling code here:        
    }//GEN-LAST:event_listadoDeOrdenesMouseClicked

    private void listadoDeOrdenesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listadoDeOrdenesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_listadoDeOrdenesKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GenerarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarOrden().setVisible(true);
            }
        });
    }
    
     public void setMicontrol(Controladora micontrol) {
        this.micontrol = micontrol;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarCombo3;
    private javax.swing.JButton AgregarPlato;
    private javax.swing.JButton RemoverCombo;
    private javax.swing.JButton RemoverPlato;
    private javax.swing.JButton agregarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox<String> listaCombosAgregados;
    private javax.swing.JComboBox<String> listaCombosDisponibles;
    private javax.swing.JComboBox<String> listaPlatoAgregados;
    private javax.swing.JComboBox<String> listaPlatoDisponibles;
    private javax.swing.JTable listadoDeOrdenes;
    private javax.swing.JComboBox<String> mesasDisponibles;
    private javax.swing.JComboBox<String> meserosDisponibles;
    private javax.swing.JButton salirMenuGenerarOrden;
    private javax.swing.JTextField unidadesDelComboAPedir;
    private javax.swing.JTextField unidadesDelComboPedidas;
    private javax.swing.JTextField unidadesDelPlatoAPedir;
    private javax.swing.JTextField unidadesDelPlatoPedidas;
    // End of variables declaration//GEN-END:variables
}
