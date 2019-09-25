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
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		//ServerSocket
		//Socket
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;

		Scanner ssc = new Scanner(System.in);
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		String str = null;
		
		try {
			boolean check = true;
			ss = new ServerSocket(8282);
			while(check) {
				System.out.println("클라이언트 접속 받을 준비 중");
				sc =ss.accept();
				is = sc.getInputStream(); //byte
				ir = new InputStreamReader(is); //char
				br = new BufferedReader(ir); //String
				str = br.readLine();

				if(str.equals("q")) {
					break;
				}
				System.out.println(str);

				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				System.out.println("클라이언트에 보낼 메세지 입력");
				str = ssc.next();
				bw.write(str + "\r\n");
				bw.flush();
				System.out.println("클라이언트로 전송 완료");

				if(str.equals("q")) {
					break;
				}
			}//while
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
				ss.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



	}

}
