package domain;

import java.util.Random;

/* 
 * 이름 반환
 * 위치 반환
 * 0~9 랜덤 값으로 전진여부
 * */

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public int getPosition() {
    	return this.position;
    }
    
    private int getRandomNum() {
    	Random random = new Random();
    	return random.nextInt(10);
    }
    
    private void statusMove() {
    	System.out.print(this.name);
    	System.out.print(" : ");
    	for(int i=0; i< this.position; i++) {
    		System.out.print("-");
    	}
    	System.out.println();
    }
    
    private void moveCheck(int move) {
    	if(move>=4) {
    		this.position ++;
    	}
    }
    
    public void race() {
    	moveCheck(getRandomNum());
    	statusMove();
    }


}
