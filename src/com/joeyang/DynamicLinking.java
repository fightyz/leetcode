package com.joeyang;

public class DynamicLinking {
    public static class Base {
        public void fun1() {
            System.out.println("Base fun1");
        }
    }

    public static class Derived extends Base {
        @Override
        public void fun1() {
            System.out.println("Derived fun1");
        }
    }

    public static void main(String[] args) {
        Base base = new Derived();
        base.fun1();
    }
}
