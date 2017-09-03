/*
    Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
    However, flowers cannot be planted in adjacent plots.
    
    Example 1:
    Input: flowerbed = [1,0,0,0,1], n = 1
    Output: True

    Example 2:
    Input: flowerbed = [1,0,0,0,1], n = 2
    Output: False
*/

public boolean canPlaceFlowers(int[] flowerbed, int n) {

    int i = 0;
    while(i < flowerbed.length) {

        if(flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
            flowerbed[i] = 1;
            n--;
        }
        if(n <= 0) {
            return true;
        }
        i++;
    }
    return false;
}
