import java.io.*;

/**
 * Created by root on 16-12-14.
 */
public class Tools {

    public String readfile(String filePath)throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        StringBuilder stringBuilder = new StringBuilder();
        for(String line=bufferedReader.readLine();line!=null;line=bufferedReader.readLine()){
            stringBuilder.append(line+"\n");
        }
        return stringBuilder.toString();
    }

    public void writefile(String filepath,String contents) throws IOException{
        FileWriter fileWriter = new FileWriter(filepath);
        fileWriter.write(contents);
        fileWriter.close();
    }
}
