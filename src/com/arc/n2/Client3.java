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

import com.arc.n2.network.Network;

public class Client3 {

	public static void main(String[] args) {
		//id 입력
		//pw 입력
		//서버로 전송
		Network network = new Network();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("ID 입력");
		String id = scanner.next();
		System.out.println("PW 입력");
		String pw = scanner.next();
		
		String msg = id + "," + pw;
		Socket sk = null;
		
		try {
			sk = new Socket("211.238.142.35", 8282);
			network.send(sk, msg);
			
			msg = network.receive(sk);
			if(msg.equals("1")) {
				System.out.println(id+"님 환영합니다\\^_^/");
			}else {
				System.out.println("로그인 실패");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//main

}
