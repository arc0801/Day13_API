package com.arc.n2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.arc.n2.member.Member;
import com.arc.n2.member.MemberService;
import com.arc.n2.network.Network;

public class Server3 {

	public static void main(String[] args) {
		//id, pw를 분리
		ServerSocket ss = null;
		Socket sc = null;
		MemberService ms = new MemberService();
		Network network = new Network();
		
		try {
			ms.init();//초기화
			ss = new ServerSocket(8282);
			System.out.println("클라이언트 접속 받을 준비 중");
			sc = ss.accept();
			String msg = network.receive(sc);//id, pw
			String [] info = msg.split(",");
			Member member = new Member();
			member.setId(info[0]);
			member.setPw(info[1]);
			
			member = ms.memberLogin(member);
			msg = "0";//로그인 실패
			if(member != null) {
				msg = "1";//로그인 성공
			}
			network.send(sc, msg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}//try
	}//main

}
