package kr.co.basic.di;

public class A {
    private B b;
    //private boolean condition;

    public void setB(B b) {
        this.b = b;
    }

//    public A(B b) {
//        this.b = b;
//    }

//    public A(boolean condition) {
//        b = new B(condition);
//    }

    public void print(){
        System.out.println(b.cacl());
    }
}
