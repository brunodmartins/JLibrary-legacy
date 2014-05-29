package GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * @author Damasceno MArtins
 */
public class Sobre {
    
    /**
     * Mostra as informções do programa
     * 
     * @since 26/12/2013
     */
    public static void main(String[] args) {
        BufferedReader ler;
        try {
            ler = new BufferedReader(new FileReader("Sobre.txt"));
            String msg = ler.readLine() + "\n";
            msg = msg.concat(ler.readLine()) + "\n";
            msg = msg.concat(ler.readLine()) + "\n";
            msg = msg.concat(ler.readLine()) + "\n";
            msg = msg.concat(ler.readLine()) + "\n";
            JOptionPane.showMessageDialog(null, msg);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
        
    }
    
}
