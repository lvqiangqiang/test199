package com.kkgs.test.serializable;

import java.io.*;

/**
 * @auther: lvqiang
 * @date: 2020/11/04
 * @description:
 */
public class SerializableDemo {
    public static void main(String[] args) throws IOException {
        StudentSerializable studentSerializable = new StudentSerializable();
        studentSerializable.setAge(1000);
        studentSerializable.setName("KKGS");
        studentSerializable.setSno("111");
        String path = "C:\\Users\\KKGS\\Desktop\\student.txt";
        serializable(studentSerializable,path);
        Object deserializable = deserializable(path);
        System.out.println(deserializable);
    }

    private static void serializable(StudentSerializable studentSerializable,String path) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(path)));
        try {
            objectOutputStream.writeObject(studentSerializable);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            objectOutputStream.close();
        }
    }

    private static Object deserializable(String path) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(path)));
        Object object = null;
        try {
            object = objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            objectInputStream.close();
        }
        return object;
    }

}
