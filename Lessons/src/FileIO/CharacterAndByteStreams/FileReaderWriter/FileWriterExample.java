package FileIO.CharacterAndByteStreams.FileReaderWriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

    public static void main(String[] args) {
        String rubai = "Много лет размышляю я над жизнью земной," +
                "Непонятного нет для меня под луной,"+
                "Мне известно, что мне ничего неизвестно!"+
                "Вот последняя правда, открытая мной.";

        FileWriter writer;
        try {
            writer = new FileWriter("/Users/commander/Desktop/Test/Test.pages");
            for (int i = 0; i < rubai.length(); i++){
                writer.write(rubai.charAt(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
// /Users/commander/Desktop/Test/Test.pages