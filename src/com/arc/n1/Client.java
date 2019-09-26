package com.arc.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		//1단계
		Socket sc = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner ssc = new Scanner(System.in);


		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;

		try {
			boolean check = true;
			sc = new Socket("211.238.142.34", 8282);
			while(check) {
				System.out.println("서버로 전송할 메세지를 입력하세요");
				String str = ssc.next();
				os = sc.getOutputStream(); //byte
				ow = new OutputStreamWriter(os);; //char
				bw = new BufferedWriter(ow);
				bw.write(str + "\r\n");
				bw.flush();

				if(str.toLowerCase().equals("q")) {
					break;
				}
				System.out.println("서버로 전송 완료");
				
				
				System.out.println("클라이언트 메세지 받을 준비");
				is = sc.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				str = br.readLine();

				if(str.toLowerCase().equals("q")) {
					break;
				}
				System.out.println(str);
			}//while
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
				sc.close();
				br.close();
				ir.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
