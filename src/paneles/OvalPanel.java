package paneles;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class OvalPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // Los tamaños de los pixeles quedan en 32px
        int tamañoPantallaX = 1600; // 1600 (50 * 32px) //1650 (50 * 33px)
        int tamañoPantallay = 704; // 704 (22 * 32px)// 704 (22 * 33px)
        int width = 32;
        int height = 32;
        int posicionx = 160;//160 (32px)//135 (33px)
        int posiciony = 188;//188 (32px)//177 (33px)
      //  System.out.println("hola" + tamañoPantallaX + "adios" + tamañoPantallay);
        int contary = 0;
        int contarx = 0;

        ArrayList<Casilla> lista = new ArrayList();
        Scanner scM;
        try {
            String[] cadena;

            scM = new Scanner(new File("mapa1.txt"));
            while (scM.hasNext()) {
//                String hola=scM.nextLine();
                cadena = scM.nextLine().split("\\|");
//                System.out.println(hola);
                
                for (int i=0; i<cadena.length;i++) {
                    
                    lista.add(new Casilla(cadena[i]));
                }

            }

            scM.close();

//            b.close();
        } catch (IOException ex) {
            Logger.getLogger(OvalPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
BufferedImage imagen=null;
        try {
        imagen = ImageIO.read(new File("images/2.png"));
        } catch (IOException ex) {
            Logger.getLogger(OvalPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<Casilla> it = lista.iterator();
        while (it.hasNext()) {
            Casilla e=it.next();
            BufferedImage img = imagen.getSubimage(e.getTipo()[0], e.getTipo()[1], width, height);
            if (posicionx >= tamañoPantallaX+160) {
                System.out.println("num vueltas X " + contarx + "num vueltas y " + contary);
                posicionx = 160;
                posiciony += 32;
                contary += 1;
            }
            g.drawRect(posicionx, posiciony, width, height);
            //Dibuja Casilla
            g.drawImage(img, posicionx, posiciony, this);
            posicionx += 32;
            contarx += 1;

        }

//        try {
//           BufferedImage img = ImageIO.read(new File("images/2.png")).getSubimage(256, 32, 32, 32);
//            do {
//                if (posicionx > tamañoPantallaX) {
//                    posicionx = 0;
//                    posiciony += 32;
//                    contar += 1;
//                }
//
//                g.drawRect(posicionx, posiciony, width, height);
//                //Dibuja Casilla
//                g.drawImage(img, posicionx, posiciony, null);
//
//                posicionx += 32;
//
//            } while (posiciony <= tamañoPantallay);
//
//        } catch (IOException ex) {
//            Logger.getLogger(OvalPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//Image imagenInterna = new ImageIcon(getClass().getResource("/images/1.png")).getImage();
    }

// public void paintComponent(Graphics g) {
// int width = getWidth();
// int height = getHeight();
// g.setColor(Color.red);
// g.drawRect(0, 0, width, height);
// }
    public static void main(String args[]) {
        Runnable runner = () -> {
//            JFrame frame = new JFrame("Oval Sample");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setLayout(new GridLayout(2, 2));

//            for (int i = 0; i < 4; i++) {
//                
//// frame.add(panel);
//            }
//            frame.setSize(300, 200);
//            frame.setVisible(true);
        };
        EventQueue.invokeLater(runner);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
