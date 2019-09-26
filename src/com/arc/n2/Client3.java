package com.arc.n2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client3 {

	public static void main(String[] args) {
		//id 입력
		//pw 입력
		//서버로 전송
		Scanner scanner = new Scanner(System.in);
				
		try {
			Socket sc = new Socket("211.238.142.35", 8282);
			System.out.println("ID 입력");
			String yId = scanner.next();
			System.out.println("PW 입력");
			String yPw = scanner.next();
			
			OutputStream os = sc.getOutputStream();
			OutputStreamWriter ow = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(ow);
			bw.write(yId + yPw + "\r\n");
			bw.flush();
			
			
			InputStream is = sc.getInputStream();
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			String str = br.readLine();
			System.out.println(str);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			
		}//try
		

	}//main

}
