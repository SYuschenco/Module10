import java.io.*;


public class Runner {

//Реализовать сохранение/загрузку текстового сообщения в файл с предварительным шифрованием/расшифрованием.
    //сохранение/шифрованием - Runner: encodeAndWriteMessageToFile("MyMessageForEncodeAndWriteToFile_2.txt");
    //загрузку/расшифрованием - Runner: decodeAndReadMessageFromFile();
// Предусмотреть обработку различных ошибок ввода/вывода.
    //line 39,51

    public static void main(String[] args) throws IOException {

//  message for work transmitted in parameter of method encodeAndWriteMessageToFile("MyMessageForEncodeAndWriteToFile_2.txt");
        encodeAndWriteMessageToFile("MyMessageForEncodeAndWriteToFile_2.txt");
        decodeAndReadMessageFromFile();

    }
    public static void encodeAndWriteMessageToFile(String message) throws IOException {
        try {
            String textMessageToFile = message;
            FileOutputStream fileOutputStream = new FileOutputStream("D://2.txt");
            // Создание буферизированного потока вывода:
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            System.out.println("Message for encoding and writing to file: " + textMessageToFile);
            String encodeTextMessageToFile;
            encodeTextMessageToFile = EncodeCesar.encode(2, ' ', '~', textMessageToFile);
            bw.write(encodeTextMessageToFile);
            bw.flush();
            bw.close();
            // Обработка ошибки:
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден! " + e);
        }
    }

    public static void decodeAndReadMessageFromFile() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("D://2.txt");
            String textMessageInFile = readFullyByByte(fileInputStream);
            String decodeTextMessageToFile = DecodeCesar.decode(2, ' ', '~', textMessageInFile);
            fileInputStream.close();
            // Обработка ошибки:
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден! " + e);
        }

    }

    public static String readFullyByByte(InputStream in) throws IOException {
        int oneByte;
        String s="";
        while ((oneByte = in.read()) !=-1){
            s+=(char) oneByte;
            //System.out.print((char) oneByte);
        }
        return s;
    }
}
