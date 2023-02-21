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

		for (int i = 0; i < arr.length; i++) {
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

		for (int i = 0; i < str.length(); i++) {
			if (target == str.charAt(i)) {
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
				for (int i = 0; i < input / 2 + 1; i++) {
					arr[i] = i + 1;
					System.out.print(arr[i] + ", ");
				}
				for (int x = input / 2 + 1; x > 1; x--) {
					arr[x] = x - 1;
					System.out.print(arr[x] + ", ");
				}
			}
			break;
		}
	}

	public void practice9() {
		int[] arr = new int[10];
		System.out.print("발생한 난수 : ");

		for (int i = 0; i < 10; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}

	}

	public void practice10() {
		int[] arr = new int[10];
		int max = 0;
		int min = 10;

		System.out.print("발생한 난수 : ");
		for (int i = 0; i < 10; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}

		for (int x = 0; x < 10; x++) {
			if (arr[x] > max) {
				max = arr[x];
			}
			if (arr[x] < min) {
				min = arr[x];
			}
		}
		System.out.println();
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);

	}

	public void practice11() {
		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);
			for (int x = 0; x < i; x++) {
				if (arr[i] == arr[x]) {
					i--; // 해당 인덱스 i 랜덤 다시 돌리기 위해.
				}
			}
		}
		for (int p = 0; p < arr.length; p++) {
			System.out.print(arr[p] + " ");
		}

	}

	public void practice12() {
		int[] lotto = new int[6];

		for (int i = 0; i < 6; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
			for (int x = 0; x < i; x++) {
				if (lotto[i] == lotto[x]) {
					i--;
				}
			}
		}
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));

	}

	public void practice13() {
		/*
		 * 방법1) 문제점: 순서대로 비교라서 arraay로 하면 중복 확인 안됨 해결 모색: 중복 문자 없는 배열을 새로 만들고 싶 Scanner
		 * sc = new Scanner(System.in); System.out.print("문자열 : "); String str =
		 * sc.next(); int count = 0;
		 * 
		 * System.out.print("문자열에 있는 문자 : ");
		 * 
		 * for(int i=0; i<str.length(); i++) { for(int x=0; x<i; x++) {
		 * if(str.charAt(i)==str.charAt(x)) { i++; continue; } } count++;
		 * System.out.print(str.charAt(i)); if (i!=str.length()-1) {
		 * System.out.print(", "); } } System.out.println();
		 * System.out.println("문자 개수 : " + count);
		 * 
		 * 이중 for문에 if문 쓰고, str.charAt(i)활용까진 했지만 중복 확인 시 i++로 건너뛰고 continue 시키는 것, 중복
		 * 아닌 경우는 안쪽 for문 밖에 쓰는 것 생각 못함
		 */

		// 방법2) 중복 문자 없는 배열 생성

		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.next();
		char[] noDup = str.toCharArray(); // .toCharArray() :문자열을 한글자씩 char타입 배열로.
		int count = 0;

		String ans = ""; // 여기서부터 다시보기
		for (int i = 0; i < noDup.length; i++) {
			if (ans.indexOf(noDup[i]) == -1) {
				ans += noDup[i] + ", ";
				count++;
			}
		}
		System.out.println("문자열에 있는 문자 : " + ans.substring(0, ans.length() - 2));
		System.out.println("문자 개수 : " + count);

	}

	public void practice14() {////////////////*****************다시!!!!!!
//		사용자가 입력한 배열의 길이만큼의 String 배열을 선언 및 할당하고
//		배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화 하세요.
//		단, 사용자에게 배열에 값을 더 넣을지 물어보고 몇 개를 더 입력할 건지,
//		늘린 곳에 어떤 데이터를 넣을 것인지 받으세요.
//		사용자가 더 이상 입력하지 않겠다고 하면 배열 전체 값을 출력하세요.
//		(배열의 얕은 복사, 깊은 복사를 이용하는 문제)
//
//		얕은 복사 : 배열의 시작 주소만을 복사하여 두 참조 변수가 하나의 배열을 참조.
//		깊은 복사 : 원본 배열이 가지고 있는 데이터를 그대로 복사한 새로운 배열 (복제)
//
//		→ tip : 깊은 복사를 위한 새로운 배열은 꼭 원본 배열과 같은 크기일 필요는 없다!
//		[실행 화면]
//				배열의 크기를 입력하세요 : 3
//				1번째 문자열 : 자바의 정석
//				2번째 문자열 : 알고리즘
//				3번째 문자열 : C프로그래밍
//				더 값을 입력하시겠습니까?(Y/N) : y
//				더 입력하고 싶은 개수 : 2
//				4번째 문자열 : 인간관계
//				5번째 문자열 : 자기계발
//				더 값을 입력하시겠습니까?(Y/N) : y
//				더 입력하고 싶은 개수 : 1
//				6번째 문자열 : 영단어600
//				더 값을 입력하시겠습니까?(Y/N) : n
//				[자바의 정석, 알고리즘, C프로그래밍, 인간관계, 자기계발, 영단어600]
		Scanner sc = new Scanner(System.in);
		
		// 1) next() : 한 단어 (띄어쓰기, 엔터를 만나면 입력 종료)
		//    nextLine() : 한 문장 (엔터를 만나면 입력 종료)
		// 2) 스캐너 입력 버퍼와 nextXXX의 의미
		//    입력 -> 입력 버퍼(담을 바구니)에 저장 -> nextXXX() 통해 버퍼 내용을 읽어옴
		//                   입력 버퍼              nextXXX()          후처리
		//    nextLine() : hello world(엔터) -> hello world(엔터) -> (엔터 제거)
		//    
		//    nextInt()  :     100(엔터)     ->    100 (n이 남아있음)
		//   (다음 정수)
		//  ** next, nextDouble(), nextInt() 등
		//     모두 입력 버퍼에서 (엔터)를 제외 하고 내용만 읽어옴 **
		
/*		// 테스트
		 System.out.print("------------------------");
		 
		 System.out.print("nextInt() : "); // 입력버퍼 : [ 100(엔터) ]
         int a = sc.nextInt();
         // 100     입력버퍼 : [ (엔터) ]  // 버퍼에 enter가 남아있다 
         
         System.out.println("nextLine() : "); // 입력버퍼 : [ a b c(엔터)
         // a b c    // 입력버퍼 : [ (엔터) ]
         
         System.out.println("종료");
         // next()  이후 입력 버퍼에 남아잇는 (엔터) 때문에
         // 다음 nextLine() 수행 시 버퍼에 남아있는 (엔터)를 읽어버리기 때문에
         // 추가적인 입력을 시도하지 못하고 다음 코드로 넘어가는 문제 발생.
         
         // [해결방법]
         // 입력을 위한 nextLine() 수행 전
         // 입력 버퍼에서 (엔터)를 제거
         // -> 빈 공간에 nextLine() 구문을 한번 작성하면 (엔터가) 제거됨  */
         
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		sc.nextLine(); // 입력 버퍼에 남은 개행문자(엔터 제거)
		
		
		String[] arr = new String[size];

		// 3. 첫 배열에 저장할 문자열 입력 받기
		for(int i=0;i<arr.length;i++) {
			System.out.printf("%d번째 문자열 : ",i+1);
			arr[i] = sc.nextLine();
		}
	
		while(true) {
			System.out.print("더 값을 입력하시겠습니까?(Y/N): ");
			String sel = sc.next();
			if (sel.equals("y")||sel.equals("Y")) {
				System.out.print("더 입력하고 싶은 개수 : ");
				int input = sc.nextInt();
				sc.nextLine(); //
				size += input; //더 입력할 만큼 깊은 복사 할 배열의 크기 설정 
				String[] copy = new String[size]; //깊은 복사를 위한 새로운 배열 
				for (int i = 0; i < copy.length; i++) { //배열 깊은 복사 
					if (arr.length > i) // 원래 길이만큼은 내용 복붙 
						copy[i] = arr[i]; //배열 깊은 복사 
					else {
						System.out.printf("%d번째 문자열 : ", i + 1); //인덱스 추가로 내용도 추
						copy[i] = sc.nextLine();
					}
				}
				arr=copy; // *쌤 설명 9번****for문 반복될 때 copy배열 사라지지 않도록 arr배열 얕은 복사(참조)
			} else if(sel.equals("n")||sel.equals("N")){
				break;
			} else {
				System.err.println("Y/N으로 대답하세요");
				return; //돌아가라 
			}
		}
		System.out.println(Arrays.toString(arr));

	}

	public void practice15() {
		String[][] array = new String[3][3];

		for (int i = 0; i < array.length; i++) {
			for (int x = 0; x < array.length; x++) {
				array[i][x] = "(" + i + ", " + x + ")";
				System.out.print(array[i][x]);
			}
			System.out.println();
		}
	}

	public void practice16() {
		int[][] array = new int[4][4];
		int count = 1;

		for (int i = 0; i < array.length; i++) {
			for (int x = 0; x < array[i].length; x++) {
				array[i][x] = count++;
				System.out.printf("%3d", array[i][x]);
			}
			System.out.println();
		}

	}

	public void practice17() {
		int[][] array = new int[4][4];
		int count = 16;

		for (int i = 0; i < array.length; i++) {
			for (int x = 0; x < array[i].length; x++) {
				array[i][x] = count--;
				System.out.printf("%3d", array[i][x]);
			}
			System.out.println();
		}
	}

	public void practice18() {
		/*
		 * int[][] array = new int[4][4]; int sum = 0;
		 * 
		 * for(int i=0; i<array.length-1; i++) { for(int x=0; x<array.length-1; x++) {
		 * array[i][x] = (int)(Math.random()*10+1); array[i][3] += array[i][x];
		 * array[3][x] += array[i][x]; System.out.printf("%3d", array[i][x]); sum +=
		 * array[i][x]; }System.out.printf("%3d", array[i][3]); System.out.println();
		 * 
		 * } array[3][3] = sum; System.out.println(Arrays.deepToString(array)); 오답
		 */

		int[][] arr = new int[4][4];

		for (int i = 0; i < arr.length - 1; i++)
			for (int j = 0; j < arr[i].length - 1; j++) {
				arr[i][j] = (int) (Math.random() * 10 + 1);
				arr[arr.length - 1][arr.length - 1] += arr[i][j];
			}

		for (int i = 0; i < arr.length - 1; i++)
			for (int j = 0; j < arr.length - 1; j++)
				arr[i][arr.length - 1] += arr[i][j];

		for (int i = 0; i < arr.length - 1; i++)
			for (int j = 0; j < arr.length - 1; j++)
				arr[arr.length - 1][i] += arr[j][i];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++)
				System.out.printf("%3d", arr[i][j]);
			System.out.println();
		}
	}

	public void practice19() {
		Scanner sc = new Scanner(System.in);
		int row;
		int col;

		while (true) {
			System.out.print("행 크기 : ");
			row = sc.nextInt();
			System.out.print("열 크기 : ");
			col = sc.nextInt();
			if (row >= 1 && row <= 10 && col >= 1 && col <= 10)
				break;
			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
		}
		char[][] array = new char[row][col];

		for (int i = 0; i < array.length; i++) {
			for (int x = 0; x < array[i].length; x++) {
				array[i][x] = (char) (Math.random() * 26 + 65);
				System.out.print(array[i][x] + " ");
			}
			System.out.println();
		}
	}

	public void practice20() {
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 크기 : ");
		int row = sc.nextInt();
		char[][] array = new char[row][];
		char alphabet = 'a';

		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d열의 크기 : ", i);
			array[i] = new char[sc.nextInt()];
		}
		for (int i = 0; i < array.length; i++) {
			for (int x = 0; x < array[i].length; x++) {
				array[i][x] = alphabet++;
			    System.out.print(array[i][x] + " ");
			}
			System.out.println();
		}

	}

	public void practice21() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];
	    int index=0;
		
	    System.out.println("== 1분단 ==");
		for(int i=0; i<arr1.length; i++) {
			for(int x=0; x<arr1[i].length; x++) {
				arr1[i][x]=students[index];
				System.out.print(arr1[i][x] + "  ");
				index++;
			}System.out.println();
		}
		System.out.println("== 2분단 ==");
		for(int i=0; i<arr2.length; i++) {
			for(int x=0; x<arr2[i].length; x++) {
				arr2[i][x]=students[index];
				System.out.print(arr2[i][x] + "  ");
				index++;
			}System.out.println();
		}
	}

	public void practice22() {
		Scanner sc = new Scanner(System.in);
		
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] array1 = new String[3][2];
		String[][] array2 = new String[3][2];
		
		int index = 0;
		String studentName;
		String leftOrRight = "";
		int bundan=0;
		int row=0;
		
		System.out.println("== 1분단 ==");
		
		for(int i=0; i<array1.length; i++) {
			for(int j=0; j<array1[i].length; j++) {
				array1[i][j] = students[index];
				System.out.print(array1[i][j] + " ");
				index++;
			}
			System.out.println();
		}
		
		
		System.out.println("== 2분단 ==");
		
		for(int i=0; i<array2.length; i++) {
			for(int j=0; j<array2[i].length; j++) {
				array2[i][j] = students[index];
				System.out.print(array2[i][j] + " ");
				index++;
			}
			System.out.println();
		}
		
		System.out.println("======================================");
		System.out.print("검색할 학생의 이름을 입력하세요 : ");
		studentName = sc.next();
		
		for(int i=0; i<array1.length; i++) {
			for(int j=0; j<array1[i].length; j++) {
				if(studentName.equals(array1[i][j])) {
					bundan = 1;
					row = i+1;
					leftOrRight = j==0 ? "왼쪽" : "오른쪽";
				}
			}
		}
		
		for(int i=0; i<array2.length; i++) {
			for(int j=0; j<array2[i].length; j++) {
				if(studentName.equals(array2[i][j])) {
					bundan = 2;
					row = i+1;
					leftOrRight = j==0 ? "왼쪽" : "오른쪽";
				}
			}
		}
		
		System.out.printf("검색하신 %s 학생은 %d분단 %d번째 줄 %s에 있습니다.",
				studentName, bundan, row, leftOrRight);
		

	}

	public void practice23() {
		Scanner sc = new Scanner(System.in);
		
		String[][] array = new String[6][6];
		int index1=0;
		int index2=0;
		int rowIndex;
		int colIndex;
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				
				if(i==0 && j>0) {
					array[i][j] = Integer.toString(index1++);
				}else if(j==0 && i>0) {
					array[i][j] = Integer.toString(index2++);
				}else {
					array[i][j] = " ";
				}
			}
		}
		
		System.out.print("행 인덱스 입력 : ");
		rowIndex = sc.nextInt();
		
		System.out.print("열 인덱스 입력 : ");
		colIndex = sc.nextInt();
		
		array[rowIndex+1][colIndex+1] = "X";
		
		for(String[] i : array) {
			for(String j : i) {
				System.out.printf(" %s ", j);
			}
			System.out.println();
		}

	}

	public void practice24() {
		Scanner sc = new Scanner(System.in);
		
		String[][] array = new String[6][6];
		int index1=0;
		int index2=0;
		int rowIndex;
		int colIndex;
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				
				if(i==0 && j>0) {
					array[i][j] = Integer.toString(index1++);
				}else if(j==0 && i>0) {
					array[i][j] = Integer.toString(index2++);
				}else {
					array[i][j] = " ";
				}
			}
		}
		
		while(true) {
			
			System.out.print("행 인덱스 입력 : ");
			rowIndex = sc.nextInt();
			
			if(rowIndex==99) {
				System.out.println("프로그램 종료");
				break;
			}
			
			System.out.print("열 인덱스 입력 : ");
			colIndex = sc.nextInt();
			
			array[rowIndex+1][colIndex+1] = "X";
			
			for(String[] i : array) {
				for(String j : i) {
					System.out.printf(" %s ", j);
				}
				System.out.println();
			}
		}
	}

	
	public void practice25() {

	}

}
