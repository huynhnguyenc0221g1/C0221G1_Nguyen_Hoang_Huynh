package ss01_java_introduction.bai_tap;

import java.util.Scanner;

public class Ung_dung_doc_so_thanh_chu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a number:");
        int num;
        num = scanner.nextInt();
        String input = "" + num;
        String output = "";
        if (num < 0 || num > 999) {
            System.out.println("Invalid input!");
        } else {
            if (num < 20) {
                switch (num) {
                    case 0:
                        output += "Zero";
                        break;
                    case 1:
                        output += "One";
                        break;
                    case 2:
                        output += "Two";
                        break;
                    case 3:
                        output += "Three";
                        break;
                    case 4:
                        output += "Four";
                        break;
                    case 5:
                        output += "Five";
                        break;
                    case 6:
                        output += "Six";
                        break;
                    case 7:
                        output += "Seven";
                        break;
                    case 8:
                        output += "Eight";
                        break;
                    case 9:
                        output += "Nine";
                        break;
                    case 10:
                        output += "Ten";
                        break;
                    case 11:
                        output += "Eleven";
                        break;
                    case 12:
                        output += "Twelve";
                        break;
                    case 13:
                        output += "Thirteen";
                        break;
                    case 14:
                        output += "Fourteen";
                        break;
                    case 15:
                        output += "Fifteen";
                        break;
                    case 16:
                        output += "Sixteen";
                        break;
                    case 17:
                        output += "Seventeen";
                        break;
                    case 18:
                        output += "Eighteen";
                        break;
                    case 19:
                        output += "Nineteen";
                        break;
                }
            } else if (num < 100) {
                switch (input.charAt(0)) {
                    case '2':
                        output += "Twenty ";
                        break;
                    case '3':
                        output += "Thirty ";
                        break;
                    case '4':
                        output += "Forty ";
                        break;
                    case '5':
                        output += "Fifty ";
                        break;
                    case '6':
                        output += "Sixty ";
                        break;
                    case '7':
                        output += "Seventy ";
                        break;
                    case '8':
                        output += "Eighty ";
                        break;
                    case '9':
                        output += "Ninety ";
                        break;
                }
                switch (input.charAt(1)) {
                    case '1':
                        output += "one";
                        break;
                    case '2':
                        output += "two";
                        break;
                    case '3':
                        output += "three";
                        break;
                    case '4':
                        output += "four";
                        break;
                    case '5':
                        output += "five";
                        break;
                    case '6':
                        output += "six";
                        break;
                    case '7':
                        output += "seven";
                        break;
                    case '8':
                        output += "eight";
                        break;
                    case '9':
                        output += "nine";
                        break;
                }
            } else {
                switch (input.charAt(0)) {
                    case '1':
                        output += "A hundred and ";
                        break;
                    case '2':
                        output += "Two hundred and ";
                        break;
                    case '3':
                        output += "Three hundred and ";
                        break;
                    case '4':
                        output += "Four hundred and ";
                        break;
                    case '5':
                        output += "Five hundred and ";
                        break;
                    case '6':
                        output += "Six hundred and ";
                        break;
                    case '7':
                        output += "Seven hundred and ";
                        break;
                    case '8':
                        output += "Eight hundred and ";
                        break;
                    case '9':
                        output += "Nine hundred and ";
                        break;
                }
                switch (input.charAt(1)) {
                    case '1':
                        switch (input.charAt(2)) {
                            case '0':
                                output += "ten";
                                break;
                            case '1':
                                output += "eleven";
                                break;
                            case '2':
                                output += "twelve";
                                break;
                            case '3':
                                output += "thirteen";
                                break;
                            case '4':
                                output += "fourteen";
                                break;
                            case '5':
                                output += "fifteen";
                                break;
                            case '6':
                                output += "sixteen";
                                break;
                            case '7':
                                output += "seventeen";
                                break;
                            case '8':
                                output += "eighteen";
                                break;
                            case '9':
                                output += "nineteen";
                                break;
                        }
                        break;
                    case '2':
                        output += "twenty ";
                        break;
                    case '3':
                        output += "thirty ";
                        break;
                    case '4':
                        output += "forty ";
                        break;
                    case '5':
                        output += "fifty ";
                        break;
                    case '6':
                        output += "sixty ";
                        break;
                    case '7':
                        output += "seventy ";
                        break;
                    case '8':
                        output += "eighty ";
                        break;
                    case '9':
                        output += "ninety ";
                        break;
                }
                if (input.charAt(1) != '1') {
                    switch (input.charAt(2)) {
                        case '1':
                            output += "one";
                            break;
                        case '2':
                            output += "two";
                            break;
                        case '3':
                            output += "three";
                            break;
                        case '4':
                            output += "four";
                            break;
                        case '5':
                            output += "five";
                            break;
                        case '6':
                            output += "six";
                            break;
                        case '7':
                            output += "seven";
                            break;
                        case '8':
                            output += "eight";
                            break;
                        case '9':
                            output += "nine";
                            break;
                    }
                }
            }
            System.out.print(num + " to words: " + output);
        }
    }
}
