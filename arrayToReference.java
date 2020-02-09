class arrayToReference{
    public static void main(String[] args){
        int j[],k[];
        j = new int[6];
        k = j;
        for(int i=0; i<6; i++){
            k[i] = i;
        }
        for(int i=0; i<6; i++)
            System.out.println(k[i]);
     }
}