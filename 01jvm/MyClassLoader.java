import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    private byte[] readClassFile(String fileName) {

        File file = new File(fileName);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            // 一次读一个字节
            InputStream in = new FileInputStream(file);
            int readByte;
            while ((readByte = in.read()) != -1) {
                outputStream.write(255 - readByte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
