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

import com.arc.n2.network.Network;

public class Client2 {

	public static void main(String[] args) {
		//1. 점심메뉴
		//2. 저녁메뉴
		Scanner scanner = new Scanner(System.in);
		Network network = new Network();

		try {//localhost, 172.0.0.1  => 내 컴퓨터 주소
			Socket sc = new Socket("211.238.142.35", 8282);
			System.out.println("1. 점심메뉴 추천");
			System.out.println("2. 저녁메뉴 추천");
			String str = scanner.next();
			network.send(sc, str);

			str = network.receive(sc);
			System.out.println("추천메뉴 : " +str);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//try
	}//main
}
