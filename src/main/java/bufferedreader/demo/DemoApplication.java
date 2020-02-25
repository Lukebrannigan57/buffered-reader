package bufferedreader.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

        BufferedReader br = null;
        BufferedReader br2 = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Luke.Brannigan\\newfile.txt"));

            System.out.println("Reading the file using readLine() method:");
            String contentLine = br.readLine();
            while (contentLine != null) {
                System.out.println(contentLine);
                contentLine = br.readLine();
            }

            br2 = new BufferedReader(new FileReader("C:\\Users\\Luke.Brannigan\\newfile2.txt"));
            System.out.println("Reading the file using read() method:");
            int num = 0;
            char ch;
            while((num = br2.read()) != -1) {
                ch = (char)num;
                System.out.println(ch);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            try {
                if (br != null){
                    br.close();
                }
                if (br2 != null) {
                    br2.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error in closing the BufferedReader");
            }
        }
    }

}
