package com.viveksb007;

import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertSame;

public class JavaAPITest {

    @Test
    public void pqSout() {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(-1);
        pq.add(10);
        System.out.println(pq);
    }

    @Test
    public void setOfListTest() {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        set.add(list);
        set.add(new ArrayList<>(list));
        System.out.println(set.size());
        System.out.println(set.contains(new ArrayList<>(list)));
    }

    @Test
    public void doesHashMapDifferentiatesByDefault() {
        Employee e1 = new Employee(1, "abcd");
        Employee e2 = new Employee(1, "abcd");
        Map<Employee, Integer> map = new HashMap<>();
        map.put(e1, e1.empId);
        map.put(e2, e2.empId);
        System.out.println(map.size());
        System.out.println(map);
    }

    @Test
    public void testEqualsMethodAndOperator() {
        Employee e1 = new Employee(1, "abcd");
        Employee e2 = new Employee(1, "abcd");
        System.out.println(e1.equals(e2));
        System.out.println(e1 == e2);
    }

    @Test
    public void operatorReturnsTrueButEqualsFalse() {
        OperatorTest o = new OperatorTest(2);
        assertSame(o, o);
        assertNotEquals(o, o);
    }

    static class Employee {
        int empId;
        String name;

        Employee(int empId, String name) {
            this.empId = empId;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return empId == employee.empId &&
                    Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(empId, name);
        }
    }

    static class OperatorTest {
        int dummy;

        OperatorTest(int n) {
            dummy = n;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

}
