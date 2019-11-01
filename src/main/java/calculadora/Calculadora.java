package calculadora;

public class Calculadora {


    private int ans;

    public Calculadora(){
        this.ans = 0;
    }

    public int dividir(int a, int b) throws ArithmeticException{
        this.ans = a / b;
        return this.ans;
    }

    public int add(int a, int b){
        this.ans = a + b;
        return this.ans;
    }

    public int sub(int a, int b){
        this.ans = a-b;
        return this.ans;
    }

    public int add(int v){
        this.ans += v;
        return this.ans;
    }

    public int sub(int v){
        this.ans -= v;
        return this.ans;
    }

    public int ans(){
        return this.ans;
    }
}