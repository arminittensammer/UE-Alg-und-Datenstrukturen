//UE04 Aufgabe (Alg. & Datenstr.)
//Datum:     27.04.2021
//Autor:    Armin Ittensammer

package ue04;

public class aufgabe02 {
    public static void main(String[] args) {
        //generate new Set ...
        Set Data = new Set();

        System.out.println("Testing");
        System.out.println("---hinzuf. von 3 Elem.");
        Data.add(new SensorData("adsf",2123,"12.12.31"));
        Data.add(new SensorData("sdfg",234,"12.12.31"));
        Data.add(new SensorData("adsfgag",345,"12.12.31"));

        System.out.println("---Größe der Datenmenge nach hinzufügen---");
        System.out.println(Data.size());

        System.out.println("---hinzuf. von 2 Elem.");
        Data.add(new SensorData("ghahrt",24563,"12.12.31"));
        Data.add(new SensorData("werw",41,"12.12.31"));

        System.out.println("---Größe der Datenmenge nach hinzufügen---");
        System.out.println(Data.size());

        System.out.println("--Ausgabe der enthaltenen Elemente");
        for (int i = 0; i < Data.size(); i++) {
            System.out.println(Data.get(i));
        }

    }
}

class Set {
    private SensorData array[];
    private int count;
    private int sizeofarray;

    public Set() {
        array = new SensorData[1];
        count = 0;
        sizeofarray = 1;
    }

    int size(){
        return sizeofarray;
    }

    boolean add(SensorData a) {
        if(check(a) == true){       //if elem already in list
            return false;
        }
        if (count == sizeofarray) {
            growSize();
        }
        array[count] = a;
        count++;
        return true;
    }
    SensorData get(int x){
        return array[x];
    }

    private boolean check(SensorData a){
        boolean flag = false;
        if(sizeofarray == 1){
            return flag;
        }
        for (int i = 0; i < sizeofarray; i++) {
            if(array[i].equals(a)){flag = true;}
        }
        return flag;
    }

    private void growSize() {
        SensorData help[] = null;
        if (count == sizeofarray) {
            help = new SensorData[sizeofarray + 1];

            for (int i = 0; i < sizeofarray; i++) {
                help[i] = array[i];
            }

        }
        array = help;
        sizeofarray++;
    }
}


