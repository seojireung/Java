package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {
	
	
	public void practice1 () {
		
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
			if (i%2==0) {
				sum += arr[i];
			}
		} 
		System.out.println();
		System.out.printf("짝수 번째 인덱스 합 : %d", sum);
		
	}
	
	public void practice2 () { //********************
		
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			for(int x=9; x>0; x--) {
				arr[i]=x;
				System.out.print(arr[i] + " ");
				if(i%2==1) {
				sum += arr[i];
				} 
			}
		} System.out.println();
		  System.out.printf("홀수 번째 인덱스 합 : %d", sum);
		
	}
	
	public void practice3 () {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();
		
	    int[] arr = new int[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public void practice4 () { //ex7
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
/*		for(i=0; i<5; i++) {
			System.out.printf("입력 %d : ",i);
			int num = sc.nextInt();
			arr[i] = num;
			
		}  */
		
	}
	
	public void practice5 () {
		
		
	}
	
	public void practice6 () {
		
		
	}
	
	public void practice7 () {
		
		
	}
	
	public void practice8 () {
		
		
	}
	
	public void practice9 () {
		
		
	}
	
	public void practice10 () {
		
		
	}
	
	public void practice11 () {
		
		
	}
	
	public void practice12 () {
		
		
	}
	
	public void practice13 () {
		
		
	}
	
	public void practice14 () {
		
		
	}
	
	public void practice15 () {
		
		
	}
	
	public void practice16 () {
		
		
	}
	
	public void practice17 () {
		
		
	}
	
	public void practice18 () {
		
		
	}
	
	public void practice19 () {
		
		
	}
	
	public void practice20 () {
		
		
	}
	
	public void practice21 () {
		
		
	}
	
	public void practice22 () {
		
		
	}
	
	public void practice23 () {
		
		
	}
	
	public void practice24 () {
		
		
	}
	
	public void practice25 () {
		
		
	}
	
	
	

}
