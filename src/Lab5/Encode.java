package Lab5;
public class Encode{

    public static void main(String[] args){
                
        FileIO reader = new FileIO();
 
        String[] inputs = reader.load("C://original.txt");    //Reading the File as a String array
        
        for(int i=0;i<inputs.length;i++){
            System.out.println(inputs[i]);
        }
        
        int[] array = new int[256];
        
        for(int i=0;i<256;i++){
            array[i]=i;
        }       
        
        for(int i=0;i<256;i++){
            if(i>31&&i<127){  //only swap printable characters
                int random=(int)(Math.random()*94)+32;
                int temp = array[i];
                array[i]=array[random];
                array[random]=temp;
            }
        }
   
        for(int i=0;i<inputs.length;i++){
            String cipher="";
            for(int j=0;j<inputs[i].length();j++){
                if((int)inputs[i].charAt(j)>31&&(int)inputs[i].charAt(j)<127){
                    cipher+=(char)array[(int)inputs[i].charAt(j)];
                }
            }
            inputs[i]=cipher;
            System.out.println(cipher);
            
        }
        
        try{        
            reader.save("C://encoded.txt",inputs);
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
}