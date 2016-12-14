import java.io.IOException;

/**
 * Created by root on 16-12-14.
 */
public class CallMain {
    public static void main(String[] args)throws IOException{
        String orgFilePath = "/home/jack/PaintPath/OriginalFile/10100123.txt";
        String genFilePath = "/home/jack/PaintPath/GenerateFile/10100123";
        GenCoordinate genCoordinate = new GenCoordinate(orgFilePath,genFilePath);
        genCoordinate.generateFile();
    }
}
