package Assignment7;

import java.io.*;

public class FileReaderAndWriter {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter the input file name: ");
            String inputFileName = reader.readLine();
            System.out.print("Enter the output file name: ");
            String outputFileName = reader.readLine();
            FileInputStream input = new FileInputStream(inputFileName);
            FileOutputStream output = new FileOutputStream(outputFileName);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            input.close();
            output.close();

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }
}
