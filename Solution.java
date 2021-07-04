import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Serializable;
import java.io.*;
class DungeonGame implements Serializable{
   public  int x=3;
    transient long y=4;
    private Short z=5;
    Short getz(){
        return z;
    }
    int getx(){
        return x;
    }
    long gety(){
        return y;
    }
}
class DungeonTest{
    public static void main(String[] args) {
        DungeonGame d=new DungeonGame();
        System.out.println(d.getx()+d.gety()+d.getz());
        try{
            FileOutputStream ofs=new FileOutputStream("foo.ser");
            ObjectOutputStream oos=new ObjectOutputStream(ofs);
            oos.writeObject(d);
            oos.close();
            FileInputStream ifs=new FileInputStream("foo.ser");
            ObjectInputStream iis=new ObjectInputStream(ifs);
            d=(DungeonGame)iis.readObject();
            iis.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println(d.getx()+d.gety()+d.getz());
    }
}