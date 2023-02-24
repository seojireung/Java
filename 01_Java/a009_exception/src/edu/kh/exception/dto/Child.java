package edu.kh.exception.dto;

import java.io.EOFException;
import java.io.IOException;

public class Child extends Parent{
	

	@Override
	public void test() throws IOException{
		// 오버라이딩 시 예외처리는 같거나 좁은 범위
		
		System.out.println("자식 test()");
	}

}
