package domain;

import java.util.Scanner;


public class Racing {
	private Car[] cars;
	private String[] data;
	private String inputName;
	private int inputNum;
	
	private void getName() {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,)�������� ����)");
		this.inputName = scan.nextLine();
		System.out.println("�õ��� Ƚ���� ��ȸ�ΰ���?");
		this.inputNum = scan.nextInt();
		
	}
	
	private void splitString() {
		this.data = inputName.split(",");
	}
	
	private boolean nameCheck() {
		for(int i=0; i<data.length; i++) {
			if(data[i].length() >5) {
				System.out.println("�̸��� 5�ڰ� �Ѵ� �ڵ����� �����մϴ�.");
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
		System.out.print("�� ���� ����߽��ϴ�.");
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
		
		System.out.println("���� ���");
		for(int i=0; i<this.inputNum; i++) {
			race();
		}
		winnerCheck();
	}
	

}
