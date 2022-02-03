/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Advanced;

public class Student implements Comparable<Student>{
    private int age;
    private int classNumber;
    private String green;


    Student(int age, int classNumber, String green){
        this.age = age;
        this.classNumber = classNumber;
        this.green = green;
    }

    int getAge(){
        return this.age;
    }

    int getClassNumber(){
        return this.classNumber;
    }

    String getGreen(){
        return this.green;
    }

    @Override
    public int compareTo(Student o){
        return o.green.compareTo(this.green);   // 멤버변수의 이름을 이용하여 정렬의 기준을 변경
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", classNumber=" + classNumber +
                ", green='" + green + '\'' +
                '}';
    }
}
