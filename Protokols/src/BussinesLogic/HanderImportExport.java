/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinesLogic;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Jirka
 */
public final class HanderImportExport {

    /**
     * Private constructor to unable create instance of this object and make it
     * all static
     */
    private HanderImportExport() {
    }

    /**
     * Exports protocol into file with given name
     *
     * @param filepath where to save the protocol
     * @param protokol to export protocols from
     * @param teamName team name to protokol be recognized
     * @return True if exported correctly
     */
    public static boolean exportProtocols(String filepath, Protokol protokol, String teamName) {
        List<String> lines = new ArrayList<>();
        lines.add(protokol.exportProtokol(teamName));

        try {
            if (!Files.exists(Paths.get("./Protokols"))) {
                Files.createDirectory(Paths.get("./Protokols"));
            }

            Path file = Paths.get("./Protokols/Protokol-" + teamName + ".txt");
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static boolean importProtocols(HandlerGame handlerGame) {

        if (!Files.exists(Paths.get("./Protokols"))) {
            System.out.println("No folder Protokols");
            return false;
        }
        try (Stream<Path> paths = Files.walk(Paths.get("./Protokols"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach( f -> {
                        try{
                            String allLines = "";
                            for(String line : Files.readAllLines(Paths.get("./Protokols", f.getFileName().toString()))){
                                allLines += line;
                                allLines += "\n";
                            }
                            allLines = allLines.substring(0, allLines.length()-1);
                            
                            handlerGame.addProtokol(Protokol.importProtokol(allLines));
                            
                        }catch(IOException e){
                            System.out.println("Unable to read from file "+ f.getFileName());
                        }
                    });
        } catch (IOException e) {
            return false;
        }

        return true;
    }

}
