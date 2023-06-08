package com.example.classes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;

import javax.sql.rowset.serial.SerialBlob;

import com.example.entity.EmployeeInfo;

public class ConverterClass {

    public static Blob convertToBlob(EmployeeInfo source) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(source);
            oos.close();
            return new SerialBlob(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static EmployeeInfo convertToSource(Blob employeeInfo) {
        try {
            byte[] bytes = employeeInfo.getBytes(1, (int) employeeInfo.length());
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            EmployeeInfo source = (EmployeeInfo) ois.readObject();
            ois.close();
            return source;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
}

