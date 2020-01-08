package domain;

import java.util.Scanner;


public class Racing {
	private Car[] cars;
	private String[] data;
	private String inputName;
	private int inputNum;
	
	private void getName() {
		Scanner scan = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
		this.inputName = scan.nextLine();
		System.out.println("시도할 횟수는 몇회인가요?");
		this.inputNum = scan.nextInt();
		
	}
	
	private void splitString() {
		this.data = inputName.split(",");
	}
	
	private boolean nameCheck() {
		for(int i=0; i<data.length; i++) {
			if(data[i].length() >5) {
				System.out.println("이름이 5자가 넘는 자동차가 존재합니다.");
				return true;
			}
		}
		return false;
	}
	
	private void setCars() {
		cars = new Car[data.length];
		for(int i=0; i<data.length; i++) {
			cars[i] = new Car(data[i]);
		}
	}
	
	private int getMax() {
		int max=0;
		int index=-1;
		for(int i=0; i<data.length; i++) {
			if(max<cars[i].getPosition()) {
				max=cars[i].getPosition();
				index = i;
			}
		}
		return index;
	}
	
	private void winnerCheck() {
		int max = getMax();
		int winnerNum = 0;
		int[] winner = new int[data.length];
		for(int i=0; i<data.length; i++) {
			if(cars[max].getPosition()==cars[i].getPosition()) {
				winner[i] = 1;
				winnerNum++;
			}
		}
		winnerResult(winner, winnerNum);
	}
	
	private void winnerResult(int[] winner, int winnerNum) {
		int winnerCount = 0;
		for(int i=0; i<data.length; i++) {
			if(winner[i]==1) {
				System.out.print(cars[i].getName());
				winnerCount++;
			}
			if((winner[i]==1) && (winnerCount<winnerNum)){
				System.out.print(", ");
			}
		}
		System.out.print("가 최종 우승했습니다.");
	}
	
	private void race() {
		for(int i=0; i<data.length; i++) {
			cars[i].race();
		}
		System.out.println();
	}
	
	public void start() {
		do{
			getName();
			System.out.println();
			splitString();
		} while(nameCheck());
		setCars();
		
		System.out.println("실행 결과");
		for(int i=0; i<this.inputNum; i++) {
			race();
		}
		winnerCheck();
	}
	

}
