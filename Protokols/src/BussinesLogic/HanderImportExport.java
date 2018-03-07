/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinesLogic;

import BussinesLogic.Protokol;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jirka
 */
public final class HanderImportExport {
    
    /**
     * Private constructor to unable create instance of this object and make it all static
     */
    private HanderImportExport(){}
    
    /**
     * Exports protocol into file with given name
     * @param filepath where to save the protocol
     * @param protokol to export protocols from
     * @return True if exported correctly
     */
    public static boolean exportProtocols(String filepath, Protokol protokol) throws IOException{
        List<String> lines = new ArrayList<>();
        lines.add(protokol.exportProtokol());
        
        
        Path file = Paths.get("Protokol-"+protokol.getName()+".txt");
        Files.write(file, lines, Charset.forName("UTF-8"));
        
        return true;
    }
    
}
