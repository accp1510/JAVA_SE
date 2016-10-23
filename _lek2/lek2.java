/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author �����_�
 */
public class TestApp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //����� � �������
        System.out.print("����� ������");
        //����� � �������, ����� ������ ������ ������������ �� ����� ������
        System.out.println("����� ������");
        System.out.println("����� ������ � ����� ������");


        //������� ������ ������ �� �������
        Scanner scaner = new Scanner(System.in);

        //������ ����� �� �������. ��������� ����� ������, ��������� � �������, �������� � ������
        //���� ����� ������, �� �������� ������� ����� �� �������
        String s = scaner.next();
        //������ �������� ����� �� ������
        s = scaner.next();
        //�������� �� ���������� ������ � ������
        boolean b = scaner.hasNext();

        //���� ��������� if (��������� ���������� �������)
        if (b) {
            //���� ������� ������, �� ����������� ������ �����
            System.out.println("���� ����� � ������");
        } else {
            //���� ������� �����, �� ����������� ������ �����
            System.out.println("����� ������");
        }

        //��������� ����� �� �������
        try {
            int i = scaner.nextInt();
            System.out.println("��������� ����� " + i);
        } catch (Exception e) {
            System.out.println("�� ����� ������ � ��� �� �����, ����! ");
        }

        //����������� ����. �������� �� ��� ��� ���� ������������ �� ���� �����
        while (true) {
            try {
                //��������� ������ �� �������
                String str = scaner.nextLine();
                //��������� ������ ������������ � �����
                int i = Integer.parseInt(str);
                System.out.println("��������� ����� " + i);
                break;
            } catch (Exception e) {
                System.out.println("�� ����� ������ � ��� �� �����, ��������� ����! ");
            }
        }

        do {
            System.out.println("���������� ���� �� ���� ���");
        } while (false);

        int sum = 0;
        //���� �� ��������� (�� 0 �� 10)
        for (int i = 0; i < 10; i++) {
            sum += i;
            System.out.println("����� " + i + " ��������� ����� " + sum);
            //�������� �������������� ��������� 
            switch (i) {
                case 1:
                    System.out.println("�����������");
                    break;
                case 2:
                    System.out.println("B������");
                    break;
                case 3:
                    System.out.println("�����");
                    break;
                case 4:
                    System.out.println("�������");
                    break;
                case 5:
                    System.out.println("�������");
                    break;
                case 6:
                    System.out.println("�������");
                    break;
                case 7:
                    System.out.println("�����������");
                    break;
                default:
                    System.out.println("��� " + i + " ��� ��� ��� ������");
            }
        }
//�������� ��������� ����� ������ ����� equals
        String s1 = "Hello";
        String s2 = "Hello";
        if (s1.equals(s2)) {
            System.out.println("������ �����");
        } else {
            System.out.println("������ �� �����");
        }
//  // ���������� ������, � s1 � s2 ���������� ������, ������� ����������� ����� "������ �����"
        if (s1 == s2) {
            System.out.println("������ �����");
        } else {
            System.out.println("������ �� �����");
        }

        String s3 = new String("Hello");
        // ���������� ������, � s1 � s3 ������ ������, ������� ����������� ����� "������ �� �����"
        if (s1 == s3) {
            System.out.println("������ �����");
        } else {
            System.out.println("������ �� �����");
        }

        //����� ������������� �����
        int count = 10;
        //�������� �������� �������� �� count ���������
        //��� ����� ������� ����������� ������
        //arr.length ���� � ������� ����������� ���������� ���������
        int[] arr = new int[count];

        for (int i = 0; i < arr.length; i++) {
            //��������������� ����� (��� � ��)
            //arr[i] ��������� � i-��� ��������
            System.out.println(String.format("[%d] = %d", i, arr[i]));
        }

        //���������� ��������� �������
        //����� Random ����� ������������ ����� ��������� �������
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            //���������� � i-�� ������ ������� arr ��������� �������� �� 0 �� 99
            arr[i] = rand.nextInt(100);
        }
        System.out.println("\n ���������� ���������� ���������� ������");
        for (int i = 0; i < arr.length; i++) {
            //��������������� ����� (��� � ��)
            //arr[i] ��������� � i-��� ��������
            System.out.println(String.format("[%d] = %d", i, arr[i]));
        }



    }
}
