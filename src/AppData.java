import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AppData {

    private String[] header;
    private Integer[][] data;

    public String[] getHeader() {
        return header;
    }

    public Integer[][] getData() {
        return data;
    }


    public void readFile(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ArrayList<Integer[]> readData = new ArrayList<>();
            header = (reader.readLine().split(";"));
            String result;
            while ((result = reader.readLine()) != null) {
                String[] header = result.split(";");
                Integer[] data = new Integer[header.length];
                for (int i = 0; i < header.length; i++) {
                    data[i] = Integer.parseInt(header[i]);
                }
                readData.add(data);
            }
            data = readData.toArray(new Integer[][]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(String file) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));

            StringBuffer oneLine = new StringBuffer();
            for (int i = 0; i < header.length; i++) {
                oneLine.append(header[i]);
                oneLine.append(";");
            }
            writer.write(oneLine.toString());
            writer.newLine();

            for (int i = 0; i < data.length; i++) {
                Integer[] rowData = data[i];
                oneLine.delete(0, oneLine.length());
                for (int j = 0; j < rowData.length; j++) {
                    oneLine.append(rowData[j]);
                    oneLine.append(";");
                }
                writer.write(oneLine.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
