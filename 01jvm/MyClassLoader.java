import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class clazz = myClassLoader.loadClass("/Users/xuhaikun/学习资料/Java进阶训练营/Hello.xlass");
        System.out.println(clazz.getName());
        Object object = clazz.newInstance();
        System.out.println(clazz.getMethod("hello").invoke(object));
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes = readClassFile(name);
        // Hello为加载的类名
        return defineClass("Hello", bytes, 0, bytes.length);
    }

    private byte[] readClassFile(String fileName) {

        File file = new File(fileName);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try (InputStream in = new FileInputStream(file)) {
            // 一次读一个字节
            int readByte;
            while ((readByte = in.read()) != -1) {
                outputStream.write(255 - readByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
