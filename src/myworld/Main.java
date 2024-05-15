package myworld;

import javax.sound.sampled.AudioInputStream;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    static int size;

    public static void main(String[] args) {
        try {
            fileReaderWriter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void fileInputStream() {
        try (FileInputStream fis = new FileInputStream("src\\myworld\\source.txt")) {
       /*     size = fis.available();
            System.out.println("available: " + size);
            int n = size / 40;
            for (int i = 0; i < n; i++) {
                System.out.print((char) fis.read());
            }
            System.out.println();
            System.out.println("available: " + fis.available());

            byte[] b = new byte[n];
            if (fis.read(b) != n) System.out.println("cant read " + n + " bytes");
            */
            int c;
            while ((c = fis.read()) != -1) {
                System.out.print((char) c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fileOutputStream() {
        String source = "Now is the time for all good men\n" +
                " to come to the aid of their country\n" +
                " and рау their due taxes.";
        byte[] buf = source.getBytes();
        try (FileOutputStream f1 = new FileOutputStream("file1.txt");
             FileOutputStream f2 = new FileOutputStream("file2.txt");
             FileOutputStream f3 = new FileOutputStream("file3.txt")) {
            for (int i = 0; i < buf.length; i += 2) f1.write(buf[i]);
            f1.write(buf);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void bonus() {
        try (InputStream is = new FileInputStream("file1.txt");
             OutputStream os = new FileOutputStream("superfile1.txt")) {
            byte[] buf = new byte[4096];
            int r;
            while ((r = is.read(buf)) != -1) {
                os.write(buf, 0, r);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void byteArrayInputStreamExample() {
        String tmp = "abc";
        byte[] b = tmp.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(b);
        for (int i = 0; i < 2; i++) {
            int c;
            while ((c = inputStream.read()) != -1) {
                if (i == 0) {
                    System.out.print((char) c);
                } else {
                    System.out.print(Character.toUpperCase((char) c));
                }
            }
            System.out.println();
            inputStream.reset();
        }
    }

    static void byteArrayOutputStreamExample() {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "DataDatadatadata";
        byte[] buf = s.getBytes();
        try {
            f.write(buf);
        } catch (IOException е) {
            System.out.println("Owибкa записи в буфер");
            return;
        }

        System.out.println("Бyфep в виде символьной строки");
        System.out.println(f.toString());
        System.out.println("B массив");
        byte[] b = f.toByteArray();
        for (int i = 0; i < b.length; i++) System.out.print((char) b[i]);
        System.out.println("\nB поток вывода типа OutputStream() ");
        // использовать оператор try с ресурсами для управления
        // потоком ввода -вывода в файл
        try (FileOutputStream f2 = new FileOutputStream("test.txt")) {
            f.writeTo(f2);
        } catch (IOException е) {
            System.out.println("Oшибкa ввода-вывода : " + е);
            return;
        }
        System.out.println("Ycтaнoвкa в исходное состояние ");
        f.reset();
        for (int i = 0; i < 3; i++) f.write('X');
        System.out.println(f.toString());
    }

    static void bufferedInputStream() {
        String s = ("It is a sign of a copyright &copy; " +
                ", but &copy - is not.\n"
        );
        byte[] buf = s.getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        int c;
        boolean marked = false;

        try (BufferedInputStream bis = new BufferedInputStream(in)) {
            while ((c = bis.read()) != -1) {
                switch (c) {
                    case '&':
                        if (!marked) {
                            bis.mark(32);
                            marked = true;
                        } else {
                            marked = false;
                        }
                        break;
                    case ';':
                        if (marked) {
                            marked = false;
                            System.out.print((char) 169);
                        } else System.out.print((char) c);
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            bis.reset();
                            System.out.print("&");
                        } else System.out.print((char) c);
                        break;
                    default:
                        if (!marked)
                            System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // PushbackInputStream ne stal pisat
    // SequenceInputStram interesno no ne pisal

    public static void readerWriter() throws Exception {
        Reader r = new FileReader("test.txt");
        Writer w = new FileWriter("file3.txt");
        int c;
        char[] buf = new char[4096];
    /*    while ((c = r.read()) != -1){
            w.write(c);
        }*/

        while ((c = r.read(buf)) != -1) {
            w.write(buf, 0, c);
        }
        r.close();
        w.close();

    }

    static void encoder() throws Exception {
        InputStream fis = new FileInputStream("file3.txt"); // byte stream
        Reader fr = new InputStreamReader(fis, StandardCharsets.UTF_8); // char stream
        BufferedReader br = new BufferedReader(fr); // string stream

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
        fr.close();
        fis.close();

    }


    static void dataIO() {
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("file2.txt"))) {
            dout.writeInt(5);
            dout.writeChar(' ');
            dout.writeUTF("\n");
            dout.writeBoolean(true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (DataInputStream din = new DataInputStream(new FileInputStream("file2.txt"))) {
            int a = din.readInt();
            char b = din.readChar();
            String c = din.readUTF();
            boolean d = din.readBoolean();

            System.out.println(a + " " + b + " " + c + " " + d);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    static void fileReaderWriter() throws IOException {
        try (FileReader fr = new FileReader("test.txt");
             FileWriter fw = new FileWriter("file2.txt")) {

            int c;
            while ((c = fr.read()) != -1) {
                fw.write(c);
                System.out.print((char) c);
            }
        }
    }
}
