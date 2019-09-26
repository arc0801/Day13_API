package com.arc.n2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {

	public static void main(String[] args) {
		//id, pw를 분리
		try {
			ServerSocket ss = new ServerSocket(8282);
			System.out.println("클라이언트 접속 받을 준비 중");
			Socket sc = ss.accept();
			
			InputStream is = sc.getInputStream();
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			String str = br.readLine();
			System.out.println(str);
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}//try
	}//main

}
