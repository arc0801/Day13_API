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
import java.util.ArrayList;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) {
		//1. 점심메뉴
		//2. 저녁메뉴
		Scanner scanner = new Scanner(System.in);
		Socket sc = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;

		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		try {//localhost, 172.0.0.1  => 내 컴퓨터 주소
			sc = new Socket("211.238.142.35", 8282);
			System.out.println("1. 점심메뉴 추천");
			System.out.println("2. 저녁메뉴 추천");
			String str = scanner.next();
			os = sc.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			bw.write(str + "\r\n");
			bw.flush();


			is = sc.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			str = br.readLine();
			System.out.println("추천메뉴 : " +str);

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
		}//try
	}//main
}
