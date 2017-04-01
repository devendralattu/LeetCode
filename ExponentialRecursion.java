// Calculating n^e through recursion

static public double exponential(double n, double e){
        if(e > 0)
        {
            return n * exponential(n,e - 1);
        }
        else if(e < 0){
        	return (1 / n) * exponential(n,e + 1);
        }
		return 1.0;
}
