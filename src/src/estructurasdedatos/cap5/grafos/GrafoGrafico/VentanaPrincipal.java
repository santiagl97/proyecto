/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap5.grafos.GrafoGrafico;

/**
 *
 * @author Santiago
 */
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame implements Serializable{
       
    /**
     * Creates new form VentanaPincipal
     */
   Algoritmo_Dijkstra DijkstraParaReporte;
   JFileChooser guardar;
   JFileChooser cargar;
   JFileChooser reporte;
   javax.swing.JDialog report;
   javax.swing.JDialog Load;
   javax.swing.JDialog save;
   String path="";
   Pintar pintar =new Pintar();
   Arboles arboles = new Arboles();    
   public static void R_repaint(int tope, Arboles arboles){//pinta lo q esta antes en el panel 
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {
                if(arboles.getmAdyacencia(j, k) == 1)
                     Pintar.pintarLinea(PrincipalWindow.getGraphics(),arboles.getCordeX(j),arboles.getCordeY(j), arboles.getCordeX(k), arboles.getCordeY(k),arboles.getmCoeficiente(j, k));
            }
        }
        for (int j = 0; j < tope; j++) 
            Pintar.pintarCirculo(PrincipalWindow.getGraphics(), arboles.getCordeX(j),arboles.getCordeY(j),String.valueOf(arboles.getNombre(j)));
                
   }
 
public static int ingresarNodoOrigen(String nodoOrige, String noExiste,int tope){
    int nodoOrigen = 0;
        try{
            nodoOrigen = Integer.parseInt(JOptionPane.showInputDialog(""+nodoOrige));   
            if(nodoOrigen>=tope){  
                  JOptionPane.showMessageDialog(null,""+noExiste+"\nDebe de ingresar  un Nodo existente");
                  nodoOrigen = ingresarNodoOrigen(nodoOrige,noExiste, tope);
            }
        }catch(Exception ex){
            nodoOrigen = ingresarNodoOrigen(nodoOrige,noExiste,tope);
        }
        return nodoOrigen;
}          
 public  int ingresarTamano(String tama){        
        int tamano = 0;
        try{
            tamano = Integer.parseInt(JOptionPane.showInputDialog(""+tama));
            if(tamano<1){ JOptionPane.showMessageDialog(null,"Debe Ingresar un Tamaño Aceptado..");
               tamano = ingresarTamano(tama);//no es nesario hacer esto
            }
        }catch(Exception ex){
            tamano = ingresarTamano(tama);
        }
        return tamano;
    }
 public boolean cicDerechoSobreNodo(int xxx,int yyy){ 
     for (int j = 0; j < tope; j++) {// consultamos si se ha sado  click sobre algun nodo 
            if((xxx+2) > arboles.getCordeX(j) && xxx < (arboles.getCordeX(j)+13) && (yyy+2) > arboles.getCordeY(j) && yyy<(arboles.getCordeY(j)+13) ) {
                                       
               if(n==0){
                   id = j;
                   R_repaint(tope,arboles);
                   Pintar.clickSobreNodo(PrincipalWindow.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), null,Color.orange);       
                   n++;                   
               }
               else{ 
                   id2=j;                   
                   n++;
                   Pintar.clickSobreNodo(PrincipalWindow.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), null,Color.orange);       
                   if(id==id2){// si id == id2 por q se volvio a dar click sobre el mismos nodo, se cancela el click anterio
                       n=0;
                       Pintar.pintarCirculo(PrincipalWindow.getGraphics(),arboles.getCordeX(id), arboles.getCordeY(id),String.valueOf(arboles.getNombre(id)));
                       id=-1;
                       id2=-1;
                   }
               } 
               nn=0;
                return true;              
            }
         }
     return false;
 }  
 public void clicIzqSobreNodo(int xxx, int yyy){
            for (int j = 0; j <tope; j++) {
              if((xxx+2) > arboles.getCordeX(j) && xxx < (arboles.getCordeX(j)+13) && (yyy+2) > arboles.getCordeY(j) && yyy<(arboles.getCordeY(j)+13) ) {
                if(nn==0){
                   permanente =j; 
                   R_repaint(tope, arboles);                   
               }
               else{ nodoFin = j;}
                nn++;
                n=0;
                id =-1;
                Pintar.clickSobreNodo(PrincipalWindow.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), null,Color.GREEN);  
                   break;
               }
           
            }
            
     
 }
 public void adactarImagen(File file){
  try{   
 
        BufferedImage read = ImageIO.read(file);
        Image scaledInstance = read.getScaledInstance(JMapa.getWidth(),JMapa.getHeight(), Image.SCALE_DEFAULT);
      
 JMapa.setIcon(new ImageIcon(scaledInstance));  
 }catch(Exception ex){
               JOptionPane.showMessageDialog(null,"Error al cargar la imagen");
       }
 }
         

    public VentanaPrincipal() { 
        initComponents();
        
        save = new javax.swing.JDialog();
        Load = new javax.swing.JDialog();
        report = new javax.swing.JDialog();
        save.setMinimumSize(new java.awt.Dimension(700, 450));
        save.setResizable(false);
        save.getContentPane().setLayout(null);
        
        guardar = new JFileChooser();
        cargar = new JFileChooser();
        
        Load.setMinimumSize(new java.awt.Dimension(700, 450));
        Load.setResizable(false);
        Load.getContentPane().setLayout(null);
        
        report.setMinimumSize(new java.awt.Dimension(700, 450));
        report.setResizable(false);
        report.getContentPane().setLayout(null);
      
        reporte = new JFileChooser();
        
        //guardar.setVisible(false);
        //cargar.setVisible(false);
        guardar.setMaximumSize(new java.awt.Dimension(21475, 21474));
        cargar.setMaximumSize(new java.awt.Dimension(21475, 21474));
        reporte.setMaximumSize(new java.awt.Dimension(21475, 21474));
        
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                cargarActionPerformed(evt);
            }
        });
        reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteActionPerformed(evt);
            }
        });
        save.getContentPane().add(guardar);
        Load.getContentPane().add(cargar);
        report.getContentPane().add(reporte);
        guardar.setBounds(10, 20, 670, 390);
        cargar.setBounds(10, 20, 670, 390);
        reporte.setBounds(10, 20, 670, 390);
        DijkstraParaReporte = new Algoritmo_Dijkstra(arboles,tope,permanente,nodoFin);
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jFileChooser2 = new javax.swing.JFileChooser();
        PrincipalWindow = new javax.swing.JPanel();
        JMapa = new javax.swing.JLabel();
        Repain = new javax.swing.JButton();
        Acumulado = new javax.swing.JPanel();
        jtacumulado = new javax.swing.JTextField();
        warp = new javax.swing.JButton();
        Menu = new javax.swing.JMenuBar();
        Archivos = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        CaminoMasCorto = new javax.swing.JMenuItem();
        Recubrir = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        NuevaArista = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMatrizCoeficiente = new javax.swing.JMenuItem();
        JMatrizAdyaciencia = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        Muestra = new javax.swing.JMenuItem();
        CargarMapa = new javax.swing.JMenuItem();
        NuevoProyecto = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        CargarB = new javax.swing.JMenuItem();
        GenerarReporte = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        EliminarJMenu = new javax.swing.JMenu();
        EliminarNodo = new javax.swing.JMenuItem();
        EliminarArista = new javax.swing.JMenuItem();
        EliminarTodasAristas = new javax.swing.JMenuItem();

        jDialog1.setMinimumSize(new java.awt.Dimension(700, 450));
        jDialog1.setResizable(false);
        jDialog1.getContentPane().setLayout(null);

        jFileChooser2.setMaximumSize(new java.awt.Dimension(21475, 21474));
        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jFileChooser2);
        jFileChooser2.setBounds(10, 20, 670, 390);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(":::::::::Grafos::::::::::");
        setResizable(false);
        getContentPane().setLayout(null);

        PrincipalWindow.setBackground(new java.awt.Color(141, 141, 141));
        PrincipalWindow.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 102, 102)));
        PrincipalWindow.setMinimumSize(new java.awt.Dimension(770, 522));
        PrincipalWindow.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PrincipalWindowMouseMoved(evt);
            }
        });
        PrincipalWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PrincipalWindowMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrincipalWindowMouseClicked(evt);
            }
        });
        PrincipalWindow.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrincipalWindowKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PrincipalWindowKeyReleased(evt);
            }
        });
        PrincipalWindow.setLayout(null);
        PrincipalWindow.add(JMapa);
        JMapa.setBounds(10, 10, 750, 500);

        getContentPane().add(PrincipalWindow);
        PrincipalWindow.setBounds(210, 10, 770, 520);

        Repain.setText("Repain");
        Repain.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Repain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepainActionPerformed(evt);
            }
        });
        getContentPane().add(Repain);
        Repain.setBounds(50, 410, 80, 50);

        Acumulado.setBorder(javax.swing.BorderFactory.createTitledBorder("Acumulado"));
        Acumulado.setLayout(null);

        jtacumulado.setEnabled(false);
        jtacumulado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtacumuladoActionPerformed(evt);
            }
        });
        Acumulado.add(jtacumulado);
        jtacumulado.setBounds(10, 20, 110, 30);

        getContentPane().add(Acumulado);
        Acumulado.setBounds(30, 470, 130, 60);

        warp.setText("WARP");
        warp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                warpMouseClicked(evt);
            }
        });
        warp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warpActionPerformed(evt);
            }
        });
        getContentPane().add(warp);
        warp.setBounds(30, 330, 120, 29);

        Archivos.setText("Archivos");
        Archivos.add(jSeparator1);

        CaminoMasCorto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        CaminoMasCorto.setText("Camino Más Corto");
        CaminoMasCorto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaminoMasCortoActionPerformed(evt);
            }
        });
        Archivos.add(CaminoMasCorto);

        Recubrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        Recubrir.setText("Recubrir");
        Recubrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecubrirActionPerformed(evt);
            }
        });
        Archivos.add(Recubrir);
        Archivos.add(jSeparator3);

        NuevaArista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        NuevaArista.setText("Nueva Arista");
        NuevaArista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaAristaActionPerformed(evt);
            }
        });
        Archivos.add(NuevaArista);
        Archivos.add(jSeparator2);

        JMatrizCoeficiente.setText("Matriz De coeficiente");
        JMatrizCoeficiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMatrizCoeficienteActionPerformed(evt);
            }
        });
        Archivos.add(JMatrizCoeficiente);

        JMatrizAdyaciencia.setText("Matiz De adyacencia");
        JMatrizAdyaciencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMatrizAdyacienciaActionPerformed(evt);
            }
        });
        Archivos.add(JMatrizAdyaciencia);
        Archivos.add(jSeparator4);

        Muestra.setText("Muestra ");
        Muestra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MuestraMousePressed(evt);
            }
        });
        Muestra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MuestraActionPerformed(evt);
            }
        });
        Archivos.add(Muestra);

        CargarMapa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        CargarMapa.setText("Cargar Mapa");
        CargarMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarMapaActionPerformed(evt);
            }
        });
        Archivos.add(CargarMapa);

        NuevoProyecto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        NuevoProyecto.setText("Nuevo Proyecto");
        NuevoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoProyectoActionPerformed(evt);
            }
        });
        Archivos.add(NuevoProyecto);
        Archivos.add(jSeparator5);

        CargarB.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        CargarB.setText("Cargar Bitacora");
        CargarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarBActionPerformed(evt);
            }
        });
        Archivos.add(CargarB);

        GenerarReporte.setText("Generar Reporte");
        GenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarReporteActionPerformed(evt);
            }
        });
        Archivos.add(GenerarReporte);

        Guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        Archivos.add(Guardar);

        Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Archivos.add(Salir);

        Menu.add(Archivos);

        EliminarJMenu.setText("Eliminar");

        EliminarNodo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        EliminarNodo.setText("Eliminar Nodo");
        EliminarNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarNodoActionPerformed(evt);
            }
        });
        EliminarJMenu.add(EliminarNodo);

        EliminarArista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        EliminarArista.setText("Eliminar Arista");
        EliminarArista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarAristaActionPerformed(evt);
            }
        });
        EliminarJMenu.add(EliminarArista);

        EliminarTodasAristas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        EliminarTodasAristas.setText("Eliminar Todas Las Arsitas ");
        EliminarTodasAristas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarTodasAristasActionPerformed(evt);
            }
        });
        EliminarJMenu.add(EliminarTodasAristas);

        Menu.add(EliminarJMenu);

        setJMenuBar(Menu);

        setSize(new java.awt.Dimension(1012, 623));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PrincipalWindowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrincipalWindowMousePressed
       int xxx, yyy;   
       xxx=evt.getX();
       yyy=evt.getY();
       if(evt.isMetaDown()){
           clicIzqSobreNodo(xxx, yyy );            
          if(nn==2){
              nn=0;
               Algoritmo_Dijkstra Dijkstra = new Algoritmo_Dijkstra(arboles,tope,permanente, nodoFin);
               Dijkstra.dijkstra();
               jtacumulado.setText(""+Dijkstra.getAcumulado());
               
           }
       }
       else{
       if(!cicDerechoSobreNodo(xxx,yyy)){// si  clik sobre  nodo es falso entra
          if(tope<50){
               arboles.setCordeX(tope,xxx);
               arboles.setCordeY(tope,yyy);
               arboles.setNombre(tope, tope);
             Pintar.pintarCirculo(PrincipalWindow.getGraphics(),arboles.getCordeX(tope), arboles.getCordeY(tope),String.valueOf(arboles.getNombre(tope)));
           tope++;          
          } 
         else JOptionPane.showMessageDialog(null,"Se ha llegado al Maximo de nodos..");
       } 
         if(n==2 ){
             n=0; 
             int  ta = ingresarTamano("Ingrese Tamaño");
             if(aristaMayor < ta) aristaMayor=ta;
             arboles.setmAdyacencia(id2, id, 1);
             arboles.setmAdyacencia(id, id2, 1);
             arboles.setmCoeficiente(id2, id,ta );
             arboles.setmCoeficiente(id, id2, ta);
             Pintar.pintarLinea(PrincipalWindow.getGraphics(),arboles.getCordeX(id), arboles.getCordeY(id), arboles.getCordeX(id2), arboles.getCordeY(id2), ta); 
             Pintar.pintarCirculo(PrincipalWindow.getGraphics(),arboles.getCordeX(id), arboles.getCordeY(id),String.valueOf(arboles.getNombre(id)));
             Pintar.pintarCirculo(PrincipalWindow.getGraphics(),arboles.getCordeX(id2), arboles.getCordeY(id2),String.valueOf(arboles.getNombre(id2)));
              id=-1;
              id2=-1;
         }
        }
    }//GEN-LAST:event_PrincipalWindowMousePressed

    private void MuestraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MuestraMousePressed

    }//GEN-LAST:event_MuestraMousePressed

    private void MuestraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MuestraActionPerformed
        //jMenuItem2.setEnabled(false);
        PrincipalWindow.paint(PrincipalWindow.getGraphics()); 
         n=0;
         id=-1;
         id2=-1;
            int Matriz[][]={{0,1,0,1,1,0,0,1},
                            {1,0,1,0,0,0,0,0},
                            {0,1,0,1,1,0,0,0},
                            {1,0,1,0,0,0,0,0},
                            {1,0,1,0,0,1,0,0},
                            {0,0,0,0,1,0,1,1},
                            {0,0,0,0,0,1,0,0},
                            {1,0,0,0,0,1,0,0}
                           };
          int coe[][]={{0,50,0,46,216,0,0,578}, 
               {50,0,59,0,0,0,0,0}, 
               {0,59,0,89,174,0,0,0},
               {46,0,89,0,0,0,0,0},
               {216,0,174,0,0,471,0,0} ,
               {0,0,0,0,471,0,194,398},  
               {0,0,0,0,0,194,0,0}, 
               {578,0,0,0,0,398,0,0},
  
  };
   int xx1[]={202,102,8,198,248,352,481,416};
  int yy1[]={12,74,165,113,233,300,368,177};
  int nom[]={0,1,2,3,4,5,6,7};          
        aristaMayor=600;       
        for (int j = 0; j < 8; j++) {
            arboles.setCordeX(j, xx1[j]);
            arboles.setCordeY(j, yy1[j]);
            arboles.setNombre(j, nom[j]);      
         
        }
        for (int j = 0; j < 8; j++) {            
            for (int k = 0; k < 8; k++) {
                arboles.setmAdyacencia(j,k, Matriz[j][k]);
                arboles.setmCoeficiente(j, k, coe[j][k]); 
            }
        }        
       tope=8;       
        R_repaint(tope,arboles);
    }//GEN-LAST:event_MuestraActionPerformed

    private void RecubrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecubrirActionPerformed
     if(tope<1)
        JOptionPane.showMessageDialog(null,"Aun no se ha creado Un nodo");     
     else{
         Algoritmo_Prim  Prim = new Algoritmo_Prim(arboles,tope, aristaMayor);
         Prim.prim();
         jtacumulado.setText(""+Prim.getCumulado());
     }         
    }//GEN-LAST:event_RecubrirActionPerformed

    private void JMatrizCoeficienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMatrizCoeficienteActionPerformed
        if(tope==0)
            JOptionPane.showMessageDialog(null,"Aun no se ha credo un nodo : ");
        
        else{
            this.setEnabled(false);
          new Matrices(tope,arboles,2,this).setVisible(true);
        }
    }//GEN-LAST:event_JMatrizCoeficienteActionPerformed

    private void JMatrizAdyacienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMatrizAdyacienciaActionPerformed
      if(tope==0)
            JOptionPane.showMessageDialog(null,"Aun no se ha credo un nodo : ");
      
      else{
          this.setEnabled(false);
        new Matrices(tope,arboles,1,this).setVisible(true);
      }
    }//GEN-LAST:event_JMatrizAdyacienciaActionPerformed

    private void NuevaAristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaAristaActionPerformed
       if(tope<=1)
            JOptionPane.showMessageDialog(null,"Cree nuevo nodo : ");
       
       else{
           this.setEnabled(false);
         new VentanaArista(arboles,pintar,tope,this).setVisible(true);
           PrincipalWindow.paint(PrincipalWindow.getGraphics());
           R_repaint(tope,arboles);        
       }
    }//GEN-LAST:event_NuevaAristaActionPerformed

    private void RepainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepainActionPerformed
        R_repaint(tope,arboles);  
    }//GEN-LAST:event_RepainActionPerformed

    private void PrincipalWindowKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrincipalWindowKeyPressed
     // TODO add your handling code here:
      
        
         
    }//GEN-LAST:event_PrincipalWindowKeyPressed

    private void PrincipalWindowKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrincipalWindowKeyReleased
     
    }//GEN-LAST:event_PrincipalWindowKeyReleased

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void NuevoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoProyectoActionPerformed
      
         
          for (int j = 0; j < tope; j++) {
              arboles.setCordeX(j,0);
              arboles.setCordeY(j,0);              
              arboles.setNombre(j,0);            
        }
         for (int j = 0; j < tope; j++) {
             for (int k = 0; k < tope; k++) {
                 arboles.setmAdyacencia(j, k, 0);
                 arboles.setmCoeficiente(j, k, 0);                 
             }            
        }
        tope=00;   
        PrincipalWindow.repaint(); 
       
    }//GEN-LAST:event_NuevoProyectoActionPerformed

    private void PrincipalWindowMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrincipalWindowMouseMoved
       // TODO add your handling code here:
    }//GEN-LAST:event_PrincipalWindowMouseMoved

    private void EliminarAristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarAristaActionPerformed
    if(tope>=2){
        this.setEnabled(false);
      new EliminarAristas(pintar,arboles,tope,this).setVisible(true);
      PrincipalWindow.paint(PrincipalWindow.getGraphics());
      R_repaint(tope,arboles); 
    }
    else  JOptionPane.showMessageDialog(null,"No Hay Nodos Enlazados... ");
    
    }//GEN-LAST:event_EliminarAristaActionPerformed

    private void EliminarNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarNodoActionPerformed
      int Eliminar= ingresarNodoOrigen("Ingrese Nodo a Eliminar ","Nodo No existe",tope); 
 if(Eliminar<=tope && Eliminar>=0 && tope>0){
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++){
                if(j==Eliminar ||k==Eliminar){
                    arboles.setmAdyacencia(j, k, -1);                    
                }
            }
        }
        for (int l = 0; l < tope-1; l++) {
                    for (int m = 0; m < tope; m++) {
                      if(arboles.getmAdyacencia(l, m)==-1){
                           arboles.setmAdyacencia(l, m,arboles.getmAdyacencia(l+1, m)); 
                           arboles.setmAdyacencia(l+1, m,-1);
                           arboles.setmCoeficiente(l, m,arboles.getmCoeficiente(l+1, m));
                      }
                  }
                }
                for (int l = 0; l < tope; l++) {
                    for (int m = 0; m < tope-1; m++) {
                
                     if(arboles.getmAdyacencia(l, m)==-1){
                           arboles.setmAdyacencia(l, m,arboles.getmAdyacencia(l, m+1)); 
                           arboles.setmAdyacencia(l, m+1,-1);
                           arboles.setmCoeficiente(l, m,arboles.getmCoeficiente(l, m+1));
                          
                     }
                    }
                }
                
                arboles.setCordeX(Eliminar,-10);
                arboles.setCordeY(Eliminar,-10);
                arboles.setNombre(Eliminar, -10);
                for (int j = 0; j < tope; j++) {
                    for (int k = 0; k < tope-1; k++) {
                        if(arboles.getCordeX(k)==-10){
                            arboles.setCordeX(k, arboles.getCordeX(k+1));
                            arboles.setCordeX(k+1, -10);
                            arboles.setCordeY(k, arboles.getCordeY(k+1));
                             arboles.setCordeY(k+1, -10);
                            arboles.setNombre(k, arboles.getNombre(k+1));
                            arboles.setNombre(k+1,-10);
                        }
                    }
               }
                for (int j = 0; j < tope; j++)                      
                arboles.setNombre(j,j);// renombramos             
                
                // eliminamos los -1 y  los -10 
                for (int j = 0; j < tope+1; j++) {
                    for (int k = 0; k < tope+1; k++) {
                       if( arboles.getmAdyacencia(j, k)!=-1)
                          arboles.setmAdyacencia(j, k, arboles.getmAdyacencia(j, k));
                       else 
                          arboles.setmAdyacencia(j, k, 0);                       
                       if(arboles.getmCoeficiente(j, k) !=-10)
                           arboles.setmCoeficiente(j, k, arboles.getmCoeficiente(j, k));
                       else
                           arboles.setmCoeficiente(j, k, 0);                        
                    }         
                }
                tope--;
                PrincipalWindow.paint(PrincipalWindow.getGraphics());
                R_repaint(tope,arboles);
       }    
    }//GEN-LAST:event_EliminarNodoActionPerformed

    private void EliminarTodasAristasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarTodasAristasActionPerformed
       for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {      
                    arboles.setmAdyacencia(j, k, 0);
                    arboles.setmAdyacencia(k, j, 0);
                    arboles.setmCoeficiente(j, k, 0);
                    arboles.setmCoeficiente(k, j, 0);
            }
        }
        PrincipalWindow.paint(PrincipalWindow.getGraphics());
        R_repaint(tope,arboles);
    }//GEN-LAST:event_EliminarTodasAristasActionPerformed

    private void CaminoMasCortoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaminoMasCortoActionPerformed
     if(tope>=2){
          permanente =  ingresarNodoOrigen("Ingrese Nodo Origen..","nodo Origen No existe",tope);// hacemos el llamano de la funcion         
          nodoFin =  ingresarNodoOrigen("Ingrese Nodo Fin..","nodo fin No existe",tope);
            Algoritmo_Dijkstra Dijkstra = new Algoritmo_Dijkstra(arboles,tope,permanente,nodoFin);
            Dijkstra.dijkstra();
            jtacumulado.setText(""+Dijkstra.getAcumulado());
            DijkstraParaReporte = Dijkstra;
        }
    else JOptionPane.showMessageDialog(null,"Se deben de crear mas nodos ... ");
    }//GEN-LAST:event_CaminoMasCortoActionPerformed

    private void PrincipalWindowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrincipalWindowMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PrincipalWindowMouseClicked

    private void jtacumuladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtacumuladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtacumuladoActionPerformed

    private void CargarMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarMapaActionPerformed
       jDialog1.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_CargarMapaActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt){
        guardar = (JFileChooser)evt.getSource();
        bits SaveFile = new bits();
        String comando = evt.getActionCommand();
        if(comando.equals(JFileChooser.APPROVE_SELECTION)){
            File archiSeleccionado = guardar.getSelectedFile();
            SaveFile.escribir(archiSeleccionado.getAbsolutePath());
            save.setVisible(false);
        }
    }
    
    private void cargarActionPerformed(java.awt.event.ActionEvent evt){
        cargar = (JFileChooser)evt.getSource();
        bits loadFile = new bits();
        String comando = evt.getActionCommand();
        if(comando.equals(JFileChooser.APPROVE_SELECTION)){
            File archiSeleccionado = cargar.getSelectedFile();
            loadFile.leer(archiSeleccionado.getAbsolutePath());
            Load.setVisible(false);
        } 
    }
    
    private void reporteActionPerformed(java.awt.event.ActionEvent evt){
        reporte = (JFileChooser)evt.getSource();
        String comando = evt.getActionCommand();
        //Algoritmo_Dijkstra d = new Algoritmo_Dijkstra(arboles,tope,permanente,nodoFin);
        if(comando.equals(JFileChooser.APPROVE_SELECTION)){
            File archiSeleccionado = reporte.getSelectedFile();
            DijkstraParaReporte.GenerarFichero(archiSeleccionado.getAbsolutePath());
            report.setVisible(false);
        }
    }
    
    private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser2ActionPerformed
 
        JFileChooser selectorArchios = (JFileChooser) evt.getSource();
        String comando = evt.getActionCommand();
        if(comando.equals(JFileChooser.APPROVE_SELECTION)){
            File archiSeleccionado = selectorArchios.getSelectedFile();
            adactarImagen(archiSeleccionado);
            jDialog1.setVisible(false);
            //JOptionPane.showMessageDialog(null, ""+archiSeleccionado+"  nOMBRE"+archiSeleccionado.getName());
        }// TODO add your handling code here:
    }//GEN-LAST:event_jFileChooser2ActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:
       save.setVisible(true); // TODO add your handling code here:
       // guardar.setVisible(true);
    }//GEN-LAST:event_GuardarActionPerformed

    private void CargarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarBActionPerformed
        // TODO add your handling code here:
       Load.setVisible(true); // TODO add your handling code here:
       //cargar.setVisible(true);
        //bits CargarBitacora = new bits();
       
    }//GEN-LAST:event_CargarBActionPerformed

    private void warpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_warpActionPerformed

    private void warpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_warpMouseClicked
        // TODO add your handling code here:
             if(tope>=2){
          permanente =  ingresarNodoOrigen("Ingrese Nodo Origen..","nodo Origen No existe",tope);// hacemos el llamano de la funcion         
          nodoFin =  ingresarNodoOrigen("Ingrese Nodo Fin..","nodo fin No existe",tope);
            Algoritmo_Dijkstra Dijkstra = new Algoritmo_Dijkstra(arboles,tope,permanente,nodoFin);
            Dijkstra.Warp();
                 for (int i = permanente; i < nodoFin; i++) {
                     
                 }
            jtacumulado.setText(""+Dijkstra.getAcumulado());
        }
    else JOptionPane.showMessageDialog(null,"Se deben de crear mas nodos ... ");
    }//GEN-LAST:event_warpMouseClicked

    private void GenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarReporteActionPerformed
        // TODO add your handling code here:
        report.setVisible(true);
    }//GEN-LAST:event_GenerarReporteActionPerformed

    public static void main(String args[]) {        
        
    }
    private int tope=0;// lleva el # de nodos creado 
    private int nodoFin;
    private int permanente;
    int n=0,nn=0,id,id2;// permite controlar que se halla dado click sobre un nodo
    private int aristaMayor;
 
   
 
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Acumulado;
    private javax.swing.JMenu Archivos;
    private javax.swing.JMenuItem CaminoMasCorto;
    private javax.swing.JMenuItem CargarB;
    private javax.swing.JMenuItem CargarMapa;
    private javax.swing.JMenuItem EliminarArista;
    private javax.swing.JMenu EliminarJMenu;
    private javax.swing.JMenuItem EliminarNodo;
    private javax.swing.JMenuItem EliminarTodasAristas;
    private javax.swing.JMenuItem GenerarReporte;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JLabel JMapa;
    private javax.swing.JMenuItem JMatrizAdyaciencia;
    private javax.swing.JMenuItem JMatrizCoeficiente;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem Muestra;
    private javax.swing.JMenuItem NuevaArista;
    private javax.swing.JMenuItem NuevoProyecto;
    public static javax.swing.JPanel PrincipalWindow;
    private javax.swing.JMenuItem Recubrir;
    private javax.swing.JButton Repain;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JTextField jtacumulado;
    private javax.swing.JButton warp;
    // End of variables declaration//GEN-END:variables
}

