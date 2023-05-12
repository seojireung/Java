package edu.kh.project.board.model.exception;

// 사용자 정의 예외 : 예외 상속
public class ImageDeleteException extends RuntimeException{
	
	public ImageDeleteException() {
		super("이미지 삭제 실패");
	}

	public ImageDeleteException(String message) { // 필요없으면 안적어도 됨
		super(message); 
	}
}
