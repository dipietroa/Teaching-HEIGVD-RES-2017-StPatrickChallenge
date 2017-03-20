/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.res.stpatrick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class ARemoverDecoractorController implements IStreamDecoratorController {
    @Override
    public Reader decorateReader(Reader inputReader){
        String str = inputReader.toString();
        str = str.replace("A", "");
        str = str.replace("a", "");
        
        try{
            inputReader.reset();
            inputReader.read(str.toCharArray());
        }catch(IOException ex){
            Logger.getLogger(ARemoverDecoractorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return inputReader;
    }
    
    @Override
    public Writer decorateWriter(Writer outputWriter){
        String str = outputWriter.toString();
        
        str = str.replace("A", "");
        str = str.replace("a", "");
        
        System.out.println(str);
        
        try {
            outputWriter.write(str);
            outputWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(ARemoverDecoractorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return outputWriter;
    }
}
