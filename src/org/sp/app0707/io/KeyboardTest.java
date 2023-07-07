package org.sp.app0707.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/* IT 분야에서의 입력 도구는 다양하지만, 그중 표준입력 도구인 키보드로부터 데이터를 읽어보자.
 * 주의) FileInputStream : 파일을 대상으로 한 입력스트림.
 * 		  KeyboardInputStream(X) -> InputStream으로 처리해야 한다. 미래에 어떤 디바이스가 나올지 알 수 없으므로.
*/
public class KeyboardTest{
	
	public static void main(String[] args) {
		//디바이스, 파일 등 다양한 매체로부터 입력을 받기 위한 입력스트림 객체를 사용해야 하고
		//이 클래스는 추상 클래스로 지원된다. 따라서 new 불가
		InputStream is=System.in; //윈도우가 이미 이용중인 입력스트림을 얻어오는 방식
		
		//한글이 깨지지 않기 위해 Reader를 이용하자 -Reader
		InputStreamReader reader=null;
		reader = new InputStreamReader(is); 
		
		BufferedReader buffr=null;
		buffr = new BufferedReader(reader); //3단 빨대. is ⊂ reader ⊂ buffr
		
		
		try {
			//int data=-1;
			String msg = null;
			//read() 메서드는 데이터를 읽을 때까지 대기상태에 빠진다. 데이터를 읽어들여 공백 문자(\n)를 만나고 입력받는 순간 코드 끝남. 코드를 계속해서 수행상태에 놓기 위해서 while 반복문을 함께 쓴다.
			while (true) {
				msg=buffr.readLine();
				System.out.print(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PrintStream out=System.out; //윈도우가 이미 이용중인 출력 스트림을 얻어오는 방식
		
		//이미 OS가 얻어다 놓은 출력 스트림을 이용하여, 모니터 출력하는 메서드
		//System.out.println();
	}
}
