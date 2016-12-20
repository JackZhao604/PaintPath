import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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
    public void generateFile2()throws IOException{
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

    public void generateFile()throws IOException{
        Tools tools = new Tools();
        String allines = tools.readfile(orgFilePath);
        System.out.println(allines);
        Map<String,List<String>> xss = new LinkedHashMap<>();
        Map<String,List<String>> yss = new LinkedHashMap<>();
        Map<String,List<String>> zss = new LinkedHashMap<>();
        Map<String,List<String>> sss = new LinkedHashMap<>();

        Map<String,List<String>> allliness = new LinkedHashMap<>();

        String [] liness = allines.split("\n");

        for(String line:liness){
            String floorId = line.split(" ")[1];
            if(!allliness.keySet().contains(floorId)){
                List<String> ls = new ArrayList<>();
                allliness.put(floorId,ls);
            }

            allliness.get(floorId).add(line);

        }

        for(String floor : allliness.keySet()){
            for(String line: allliness.get(floor)){
                String[] segment= line.split(" ");
                if(!xss.keySet().contains(segment[1]))
                {
                    List<String> ls = new ArrayList<>();
                    xss.put(segment[1],ls);
                    List<String> ls1 = new ArrayList<>();
                    yss.put(segment[1],ls1);
                    List<String> ls2 = new ArrayList<>();
                    zss.put(segment[1],ls2);
                    List<String> ls3 = new ArrayList<>();
                    sss.put(segment[1],ls3);

                }
                xss.get(segment[1]).add(segment[2]);
                yss.get(segment[1]).add(segment[3]);
                zss.get(segment[1]).add(segment[1].substring(segment[1].length()-4,segment[1].length()));
                StringBuilder stringBuilder = new StringBuilder();
                for(int i=4;i<segment.length-1;i++)
                {
                    stringBuilder.append(segment[i]+" ");
                }
                sss.get(segment[1]).add(stringBuilder.toString());
            }
        }
        for(String floor: allliness.keySet()){
            StringBuilder stringBuilder1 = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            List<String> lx = xss.get(floor);
            List<String> ly = yss.get(floor);
            List<String> lz = zss.get(floor);
            List<String> ls = sss.get(floor);
            for(int i=0;i<lx.size();i++){
                stringBuilder1.append(lx.get(i)+" "+ly.get(i)+" "+ lz.get(i)+"\n");
                stringBuilder2.append(ls.get(i)+"\n");
            }
            tools.writefile(genFilePath+floor,stringBuilder1.toString());
            tools.writefile(genFilePath+floor+".SignalVector",stringBuilder2.toString());
        }

    }

}
