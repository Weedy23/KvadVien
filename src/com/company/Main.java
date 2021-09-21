package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
    String vien;
    System.out.println("Ievadi kvadrat vienadojumu");
    vien = scanner.nextLine() + " ";

    double[] abc = new double[3];
    abc = getABC(vien);

    System.out.println(abc[0]);
    System.out.println(abc[1]);
    System.out.println(abc[2]);

    double D;
    D = discriminant(abc);
    switch (discriminantCheck(D)) {
        case 0:
            System.out.println("Saknu nav");
            break;
        case 1:
            System.out.println("Sakne ir " + sakne1(abc[0], abc[2], D));
            break;
        case 2:
            System.out.println("1 sakne ir " + sakne1(abc[0], abc[2], D) + " . 2 sakne ir " + sakne2(abc[0], abc[2], D));
    }
    }

    public static double[] getABC(String vien) {
        double[] abc = new double[3];
        String skaitlis = "";
        int i;
        for (i = 0; vien.charAt(i) != '='; i++) {
            if (vien.charAt(i) != ' ') {
                if (vien.charAt(i) == '+' || vien.charAt(i) == '-' || vien.charAt(i) != 'x') {
                    skaitlis += vien.charAt(i);
                } else if (vien.charAt(i) == 'x') {
                    if (vien.charAt(i + 1) == 'x' || vien.charAt(i + 1) == '^') {
                        if (skaitlis != "") {
                            if (skaitlis.charAt(0) == '-' && skaitlis.length() == 1) {
                                abc[0] = -1;
                            } else {
                                abc[0] = Integer.parseInt(skaitlis);
                            }
                        } else {
                            abc[0] = 1;
                        }
                        if (vien.charAt(i + 1) == '^') {
                            i++;
                        }
                        i++;

                        skaitlis = "";
                    } else {
                        if (skaitlis != "") {
                            if (skaitlis != "-") {
                                abc[1] = Integer.parseInt(skaitlis);
                            } else {
                                abc[1] = -1;
                            }
                        } else {
                            abc[1] = 1;
                        }

                        skaitlis = "";
                    }
                }
            }
        }
        if (skaitlis != "") {
            abc[2] = Integer.parseInt(skaitlis);
        }
        skaitlis = "";

        for (i++; i < vien.length(); i++) {
            if (vien.charAt(i) != ' ') {
                if (vien.charAt(i) == '+' || vien.charAt(i) == '-' || vien.charAt(i) != 'x') {
                    skaitlis += vien.charAt(i);
                } else if (vien.charAt(i) == 'x') {
                    if (vien.charAt(i + 1) == 'x' || vien.charAt(i + 1) == '^') {
                        if (skaitlis != "") {
                            System.out.println(skaitlis);
                            if (skaitlis == "-") {
                                abc[0] -= -1;
                            } else {
                                abc[0] -= Integer.parseInt(skaitlis);
                            }
                        } else {
                            abc[0] -= 1;
                        }
                        if (vien.charAt(i + 1) == '^') {
                            i++;
                        }
                        i++;

                        skaitlis = "";
                    } else {
                        if (skaitlis != "") {
                            if (skaitlis != "-") {
                                abc[1] -= Integer.parseInt(skaitlis);
                            } else {
                                abc[1] -= -1;
                            }
                        } else {
                            abc[1] -= 1;
                        }

                        skaitlis = "";
                    }
                }
            }
        }

        if (skaitlis != "") {
            abc[2] -= Integer.parseInt(skaitlis);
        }

        return abc;
    }

    static public double discriminant(double[] abc) {
        return (abc[1] * abc[2]) - 4 * abc[0] * abc[2];
    }

    static public int discriminantCheck(double D) {
        if (D > 0.0) {
            return 2;
        } else if (D == 0.0) {
            return 1;
        } else {
            return 0;
        }
    }

    static public double sakne1(double a, double b, double D) {
        return (-b - Math.sqrt(D)) / 2 * a;
    }

    static public double sakne2(double a, double b, double D) {
        return (-b + Math.sqrt(D)) / 2 * a;
    }
}
