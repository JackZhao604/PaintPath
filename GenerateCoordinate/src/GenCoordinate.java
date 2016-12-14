import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 16-12-14.
 */
public class GenCoordinate {

    public String orgFilePath = new String();
    public String genFilePath = new String();
    public GenCoordinate(String orgFilePath,String genFilePath){
        this.orgFilePath=orgFilePath;
        this.genFilePath=genFilePath;
    }
    public void generateFile()throws IOException{
        Tools tools = new Tools();
        String alllines = tools.readfile(orgFilePath);
        System.out.println(alllines);
        List<String> xs = new ArrayList<>();
        List<String> ys = new ArrayList<>();
        List<String> zs = new ArrayList<>();
        String buildID = new String();
        List<String> floorID = new ArrayList<>();

        String lines[] = alllines.split("\n");
        for(String line:lines){
            String segment[]=line.split(" ");
            if(buildID==null){
                buildID=segment[0];
            }
            if(!floorID.contains(segment[1])){
                floorID.add(segment[1]);
            }
            xs.add(segment[2]);
            ys.add(segment[3]);
            zs.add(segment[1].substring(segment[1].length()-4,segment[1].length()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<xs.size();i++){
            stringBuilder.append(xs.get(i)+" "+ys.get(i)+" "+zs.get(i)+"\n");
        }
        tools.writefile(genFilePath,stringBuilder.toString());
    }

}
