package com.joeyang;

public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }
    static void f2(Holder<?> holder) {
        // 做一些与 Holder 中与泛型类型无关的事，然后再调用 f1(holder)，
        // 将 Holder 中的类型给捕获
        f1(holder);
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f2(raw);
        Holder rawBasic = new Holder();
        rawBasic.set(new Object());
        f2(rawBasic);
        Holder<?> wildcarded = new Holder<Double>(1.0);
        f2(wildcarded);
    }

    static class Holder<T> {
        private T t;
        public Holder(){}
        public Holder(T t){}

        public void set(T t){
            this.t = t;
        }

        public T get() {
            return t;
        }
    }
}
