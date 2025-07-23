package fromMultiThreading;



import java.io.*;

public class Task20_FileIO {
    public static void main(String args[]) {
        try {
            FileInputStream infile = new FileInputStream("FileName01.txt");
            FileOutputStream outfile = new FileOutputStream("NewFile05.txt");

            int byteread;
            while ((byteread = infile.read()) != -1) {
                outfile.write(byteread);
            }

            infile.close();
            outfile.close();

            System.out.println("Byte copied from NewFile04.txt to NewFile05.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Sorry..!! File Not Found...!!!");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}



