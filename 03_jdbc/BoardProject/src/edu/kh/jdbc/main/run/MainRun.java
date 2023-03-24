package edu.kh.jdbc.main.run;

import edu.kh.jdbc.main.view.MainView;

public class MainRun {
	public static void main(String[] args) {
		
		// 객체를 1회만 사용할 때 작성하는 방식 (한번 호출 하고나서 사라짐)
		new MainView().mainMenu(); // MainView 객체 생성하고 mainMenu 메소드 호출
	}

}
