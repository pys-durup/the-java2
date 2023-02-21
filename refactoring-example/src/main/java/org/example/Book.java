package org.example;

public class Book {

    private String a;

    private static String B = "BOOK";

    private static final String C = "BOOK";

    public String d = "d";

    protected String e = "e";

    public Book() {

    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("g");
    }

    public int h() {
        return 100;
    }

    public int i(int i, int j) {
        return i + j;
    }


}
