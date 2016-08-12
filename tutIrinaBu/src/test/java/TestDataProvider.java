import org.testng.annotations.DataProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by irina.bushinskaya on 8/11/2016.
 */

public class TestDataProvider {
    @DataProvider(name = "mydata2")
    public static Iterator<Object[]> createData (){
        List<Object[]> list = new ArrayList<Object[]>();

        // Change path to txt file

        File file=new File ("D:\\tutIrinaBu\\testData.txt");
        BufferedReader br;
        try{
            br = new BufferedReader(new FileReader(file));
            String s = br.readLine();

            while (s!=null){
                String[] parts = s.split(";");
                TestData tr = new TestData (parts);
                list.add(new Object[]{tr});
                s = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();
    }
}
