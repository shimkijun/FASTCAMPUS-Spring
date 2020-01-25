package kr.co.basic.di;

public class B {

    boolean condition;

    public B(boolean condition) {
        this.condition = condition;
    }

    public int cacl(){
        if(condition){
            return 1;
        }else{
            return 0;
        }
    }
}
