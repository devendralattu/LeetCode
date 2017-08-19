/*
"4.1.1", "4.1.1.0.0.0.1" return -1
"4.1.1.0.0.0.1", "4.1.1" return 1
"4.1.1", "4.1.1" return 0
"5.1.1", "4.1.1" return 1
*/

public int compareVersion(String version1, String version2) {
    int result = 1;

    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");

    int minlen = Math.min(v1.length, v2.length);
    int maxlen = Math.max(v1.length, v2.length);

    for(int i = 0; i < minlen; i++) {
        if(Integer.parseInt(v1[i]) == Integer.parseInt(v2[i])) {
            continue;
        } else if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
            return 1;
        } else {
            return -1;
        }
    }

    if(minlen == maxlen) {
        return 0;
    }

    if(v1.length < v2.length) {
        v1 = v2;
        result = -1;
    }
    for(int i = minlen; i < maxlen; i++) {
        if(Integer.parseInt(v1[i]) > 0) {
            return result;
        }
    }

    return 0;
}
