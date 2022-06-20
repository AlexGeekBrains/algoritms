package ru.alex.java.algoritm.less8;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Cat {
    private int age;

    public Cat(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" + age + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age;
    }
}