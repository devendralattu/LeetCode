// Implement pow(x, n). 

public double myPow(double x, int n) {
    if(x == 0) {
        return 0.0;
    }
    if(n == 0) {
        return 1.0;
    }
    if(n < 0) {
        return 1.0 / power(x, -n);
    }
    return power(x, n);
}

private double power(double x, int n) {
    if(n == 0) {
        return 1;
    }
    if((n & 1) == 0) {
        return power(x * x, n / 2);   
    }
    return x * power(x * x, n / 2);
}
