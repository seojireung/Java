package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	public void practice1() {

		int[] arr = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
			if (i % 2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println();
		System.out.printf("짝수 번째 인덱스 합 : %d", sum);

	}

	public void practice2() {

		int[] arr = new int[9];
		int sum = 0;
		int x = 9;

			for (int i = 0; i<arr.length; i++) {
				arr[i] = x--;
				System.out.print(arr[i] + " ");
				if (i % 2 == 1) {
					sum += arr[i];
				}
		}
		System.out.println();
		System.out.printf("홀수 번째 인덱스 합 : %d", sum);

	}

	public void practice3() {

		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();

		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}

	}

	public void practice4() {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int index = 0;
		boolean flag = true;

		for (int i = 0; i < 5; i++) {
			System.out.printf("입력 %d : ", i);
			int input = sc.nextInt();
			arr[i] = input; // 입력 받음 [5 8 9 10 4]
		}
		System.out.print("검색할 값 : ");
		int search = sc.nextInt();
		for (int i = 0; i < 5; i++) {
			if (search == arr[i]) {
				index = i;
				flag = false;
				System.out.println("인덱스 : " + i);
				break;
			}
		}
		if (flag) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}

	public void practice5() { 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
	    String str = sc.next();
	    int count = 0;
	    
		System.out.print("문자 : ");
		char target = sc.next().charAt(0);
		
		System.out.printf("%s에 %s가 존재하는 위치(인덱스) : ", str, target);
		
		for(int i=0; i<str.length(); i++) {
			if(target==str.charAt(i)) {
				System.out.print(i + " ");
				count++;
			}
		}
	
		System.out.printf("\n%s 개수 : %d", target, count);
	 
	    
		

	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int sum = 0;

		int[] arr = new int[num];

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			int input = sc.nextInt();
			arr[i] = input;
			sum += input;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("총 합 : " + sum);

	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String pNum = sc.next();
		char[] arr = new char[pNum.length()];
		char[] copy = new char[pNum.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = pNum.charAt(i);
			if (i <= 7) {
				copy[i] = arr[i];
			} else {
				copy[i] = '*';
			}
			System.out.print(copy[i]);
		}
	}

	public void practice8() { // 마지막 , 빼는 방법..?
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("정수 : ");
			int input = sc.nextInt();
			if (input % 2 == 0 || input < 3) {
				System.out.println("다시 입력하세요");
			} else {
				int[] arr = new int[input];
				for (int i=0; i < input/2+1; i++) {
					arr[i] = i + 1;
					System.out.print(arr[i] + ", ");
				}
				for (int x=input/2+1; x>1; x--) {
					arr[x] = x-1;
					System.out.print(arr[x] + ", ");
				}
			} break;
		}
	}

	public void practice9() {
		int[] arr = new int[10];
		System.out.print("발생한 난수 : ");
		
		for(int i=0; i<10; i++) {
			arr[i] = (int)(Math.random()*10+1);
			System.out.print(arr[i] + " ");
		}
		

	}

	public void practice10() {
		int[] arr = new int[10];
		int max = 0;
		int min = 10;
		
		System.out.print("발생한 난수 : ");
		for(int i=0; i<10; i++) {
			arr[i] = (int)(Math.random()*10+1);
	     	System.out.print(arr[i] + " ");
	     	}
		
		for(int x=0; x<10; x++) {
     	if(arr[x]>max) {
     		max = arr[x];
     	} 
     	if(arr[x]<min) {
     		min = arr[x];
		}
		}
		System.out.println();
     	System.out.println("최대값 : " + max);
     	System.out.println("최소값 : " + min);
		
	}

	public void practice11() {
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = (int)(Math.random()*10+1);
			for(int x=0; x<i; x++) {
				if(arr[i]==arr[x]) {
					i--; //해당 인덱스 i 랜덤 다시 돌리기 위해.
				}
			}
		}
	    for (int p=0; p<arr.length; p++) {
	    	System.out.print(arr[p] + " ");
	    }

	}

	public void practice12() {
		int[] lotto = new int[6];
		
		for(int i=0; i<6; i++) {
			lotto[i] = (int)(Math.random()*45+1);
			for(int x=0; x<i; x++) {
				if(lotto[i]==lotto[x]) {
					i--;
				}
			}
		}
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));

	}

	public void practice13() {
/*	방법1) 문제점: 순서대로 비교라서 arraay로 하면 중복 확인 안됨
 *        해결 모색: 중복 문자 없는 배열을 새로 만들고 싶
 * 	Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
	    String str = sc.next();
	    int count = 0;
	    
	    System.out.print("문자열에 있는 문자 : ");
	    
	    for(int i=0; i<str.length(); i++) {
	       for(int x=0; x<i; x++) {
	    	if(str.charAt(i)==str.charAt(x)) {
	    		i++;
	    		continue;
	    	}
	       }
	       count++;
	       System.out.print(str.charAt(i));
	       if (i!=str.length()-1) {
	    	   System.out.print(", ");
	       }
	    }
	   System.out.println();
	   System.out.println("문자 개수 : " + count);
	
   이중 for문에 if문 쓰고, str.charAt(i)활용까진 했지만
  *중복 확인 시 i++로 건너뛰고 continue 시키는 것, 
  *중복 아닌 경우는 안쪽 for문 밖에 쓰는 것 생각 못함  */
		
		//방법2) 중복 문자 없는 배열 생성
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
	    String str = sc.next();
	    char[] noDup = str.toCharArray(); //.toCharArray() :문자열을 한글자씩 char타입 배열로.
	    int count = 0;
	    
	    String ans = "";  //여기서부터 다시보기
	    for(int i=0;i<noDup.length;i++) {
			if(ans.indexOf(noDup[i])==-1) {
				ans+=noDup[i]+", ";
				count++;
			}
		}
	    System.out.println("문자열에 있는 문자 : "+ans.substring(0, ans.length()-2));
	    System.out.println("문자 개수 : "+count);
	    
	    
	}
	public void practice14() {

	}

	public void practice15() {
		String[][] array = new String[3][3];
		
		for(int i=0;i<array.length;i++) {
			for(int x=0; x<array.length; x++) {
				array[i][x] = "(" + i + ", " + x + ")";
				System.out.print(array[i][x]);
			}
			System.out.println();
		}
	}

	public void practice16() {
		int[][] array = new int[4][4];
		int count = 1;
		
		for(int i=0; i<array.length; i++) {
			for(int x=0; x<array[i].length; x++) {
				array[i][x] = count++;
				System.out.printf("%3d", array[i][x]);
			} System.out.println();
		}

	}

	public void practice17() {
		int[][] array = new int[4][4];
		int count = 16;

		for(int i=0; i<array.length; i++) {
			for(int x=0; x<array[i].length; x++) {
				array[i][x] = count--;
				System.out.printf("%3d", array[i][x]);
			} System.out.println();
		}
	}

	public void practice18() {
/*		int[][] array = new int[4][4];
		int sum = 0;
		
		for(int i=0; i<array.length-1; i++) {
			for(int x=0; x<array.length-1; x++) {
				array[i][x] = (int)(Math.random()*10+1);
				array[i][3] += array[i][x];
				array[3][x] += array[i][x];
				System.out.printf("%3d", array[i][x]);
				sum += array[i][x];
			}System.out.printf("%3d", array[i][3]);
		     System.out.println();
		     
		} 
		array[3][3] = sum;
		System.out.println(Arrays.deepToString(array)); 
		오답 */
		
		int[][] arr=new int[4][4];
		
		for(int i=0;i<arr.length-1;i++)
			for(int j=0;j<arr[i].length-1;j++) {
				arr[i][j] = (int) (Math.random() * 10 + 1);
				arr[arr.length - 1][arr.length - 1] += arr[i][j];
			}
		
		for(int i=0;i<arr.length-1;i++)
			for(int j=0;j<arr.length-1;j++)
				arr[i][arr.length-1] += arr[i][j];
		
		for(int i=0;i<arr.length-1;i++)
			for(int j=0;j<arr.length-1;j++)
				arr[arr.length-1][i] += arr[j][i];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++)
				System.out.printf("%3d", arr[i][j]);
			System.out.println();
		}
	}

	public void practice19() {

	}

	public void practice20() {

	}

	public void practice21() {

	}

	public void practice22() {

	}

	public void practice23() {

	}

	public void practice24() {

	}

	public void practice25() {

	}

}
