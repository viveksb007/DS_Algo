package com.viveksb007.oop;

// https://www.baeldung.com/java-equals-hashcode-contracts : here equals method uses getClass() on object so it's okay, In blog post
// if (!(o instanceof Voucher))
//            return false;
// Above snippet was used which is wrong as child class is instance of parent class
public class EqualsViolationInheritance {

    public static void main(String[] args) {
        Animal animal = new Animal("abcd");
        Dog dog = new Dog("abcd");
        System.out.println(animal.equals(dog));
        System.out.println(dog.equals(animal));
        System.out.println(dog.getClass());
        System.out.println(animal.getClass());
        System.out.println((dog instanceof Animal));
        System.out.println((dog instanceof Dog));
        System.out.println((animal instanceof Animal));
        System.out.println((animal instanceof Dog));
    }

}
