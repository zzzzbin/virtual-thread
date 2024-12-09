package com.si.sec10;

public class S0061_SwitchWithRecords {
    record Dev(String name, int age){}

    public static void main(String[] args) {
        dispatch(new Dev("duke",12));
        dispatch("duke");
    }

    private static void dispatch(Object instance) {
        switch (instance){
            case Dev(var name, var age) -> System.out.println(name + age);
            case String messsage-> System.out.println("messsage = " + messsage);
            default -> System.out.println("unknown");
        }
    }
}
