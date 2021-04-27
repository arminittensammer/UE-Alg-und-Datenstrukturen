//UE04 Aufgabe (Alg. & Datenstr.)
//Datum:     27.04.2021
//Autor:    Armin Ittensammer

package ue04;
import java.util.ArrayList;
import java.util.List;

public class aufgabe01 {
    public static void main(String[] args) {

        System.out.println("---Erstellen einer neuen Liste---len = 5");
        ProzessData Data = new ProzessData(5);

        System.out.println("---Set size = 10---");
        Data.setSize(10);       //update list length

        System.out.println("---hinzufügen von 7 Sensoren---");
        Data.sentData("Sensor0231",10,"10.20.134");
        Data.sentData("Sensor0341",34,"10.20.23423");
        Data.sentData("Sensor0451",23,"10.20.234");
        Data.sentData("Sensor0231",54,"10.20.456");
        Data.sentData("Sensor0341",43,"10.20.23423");
        Data.sentData("Sensor0451",76,"10.20.234");
        Data.sentData("Sensor0231",87,"10.20.456");
        Data.printAllData();

        System.out.println("---Set Size = 4---");
        Data.setSize(4);
        Data.printAllData();

        System.out.println("---reset---");
        Data.reset();
        Data.printAllData();

        System.out.println("---erneutes hinzufügen---");
        Data.sentData("Sensor0231",10,"10.20.134");
        Data.sentData("Sensor0341",34,"10.20.23423");
        Data.sentData("Sensor0451",23,"10.20.234");
        Data.sentData("Sensor0231",54,"10.20.456");
        Data.printAllData();

        System.out.println("---get Data");
        SensorData test = Data.getData();
        System.out.println(test);
    }
}

class ProzessData {

    int data_len = 0;
    int current_len = 0;

    List<SensorData> list = new ArrayList<SensorData>();

    ProzessData(int len){
        this.data_len = len;
    }

    void setSize(int size){
        data_len = size;
        if (data_len < current_len) {
            for (int i = 0; i < current_len-size-1; i++) {
                list.remove(size+i);
            }
            current_len = size;
        }
    }
    SensorData sentData(String name, double value, String timestamp){
        if(current_len < data_len || list.isEmpty()) {
            list.add(0,new SensorData(name,value,timestamp));
            current_len++;
            return null;
        } else {
            SensorData help = list.get(current_len-1);
            list.remove(current_len);
            list.add(0,new SensorData(name,value,timestamp));
            return help;
        }
    }

    SensorData getData(){
        SensorData help = list.get(current_len-1);
        list.remove(current_len-1);
        return help;
    }
    void printAllData(){
        if(list.isEmpty()){
            System.out.println("Liste leer");
        } else {
            for (int i = 0; i < current_len; i++) {
                print(i);
            }
        }
    }
    void print(int x){
        System.out.print(list.get(x).getName());
        System.out.print(", Value: ");
        System.out.print(list.get(x).getValue());
        System.out.print(", Timestamp: ");
        System.out.println(list.get(x).getTimestamp());
    }
    void reset(){
        list.clear();
        current_len = 0;
    }
}

class SensorData {
    String name;
    double value;
    String timestamp;

    SensorData(String s, double v, String z){
        this.name = s;
        this.value = v;
        this.timestamp = z;
    }

    String getName(){return name;}
    double getValue(){return value;}
    String getTimestamp(){return timestamp;}

    boolean equal(SensorData a){
        if(a.getName() == name || a.getValue()==value || getTimestamp() == timestamp){
            return true;
        }
        return false;
    }
}
