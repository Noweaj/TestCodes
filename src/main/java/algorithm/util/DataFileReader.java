package algorithm.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader {

    public static String ReadFileToString(File dataFile){
        StringBuffer sb = new StringBuffer();
        try {
            FileReader fr = new FileReader(dataFile);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<String> ReadFileToList(File dataFile){
        List<String> result = new ArrayList<>();
        try{
            FileReader fr = new FileReader(dataFile);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                result.add(line);
            }
            fr.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
