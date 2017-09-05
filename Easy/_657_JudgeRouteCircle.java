/*
    Given a sequence of its moves, judge if the robot makes a circle, which means it moves back to the original place.
    The move sequence is represented by a string. And each move is represent by a character. 
    The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
    The output should be true or false representing whether the robot makes a circle.

    Example 1:
    Input: "UD"
    Output: true

    Example 2:
    Input: "LL"
    Output: false

*/


public boolean judgeCircle(String moves) {
    if(moves == null) {
        return true;
    }

    int[] dir = new int[2];
    for(char c : moves.toCharArray()) {
        switch(c) {
            case 'U': dir[0]++; break;
            case 'D': dir[0]--; break;
            case 'L': dir[1]++; break;
            case 'R': dir[1]--; break;
        }
    }

    if(dir[0] == 0 && dir[1] == 0) {
        return true;
    }
    return false;
}
