package ThirdChapter;


import java.io.*;

/**
 * Created by ddsss on 2017/1/30.
 */
public class ReDriectStd {

    public static void ReStdInFile(String thefile) throws FileNotFoundException {
        File newfile = new File(thefile);
        FileInputStream newinput =  new FileInputStream(newfile);
        System.setIn(newinput);
        System.out.println("ReStdInFile Success!");
    }

    public static void ReStdInString(String theString){
        System.setIn(new ByteArrayInputStream(theString.getBytes()));
        System.out.println("ReStdInStr Success!");
    }
}
