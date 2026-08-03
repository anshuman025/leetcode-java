class Solution {

    void flip(int[] arr){
        int s = 0;
        int e = arr.length-1;

        while(s< e){
            int temp = arr[s];
            arr[s]= arr[e];
            arr[e]= temp;
            s++;
            e--;

        }
    }
    public int[][] flipAndInvertImage(int[][] image) {


        for(int i = 0; i < image.length; i++){
            flip(image[i]);
            for(int j = 0; j < image[i].length;j++){
                if(image[i][j]== 1){
                    image[i][j] = 0;
                }else  image[i][j] = 1;

            }
        }
        return image;
    }
}