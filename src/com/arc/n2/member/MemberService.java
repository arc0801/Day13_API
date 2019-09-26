package com.arc.n2.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MemberService {

	//init 메서드
	//파일의 내용을 읽어서 파싱 작업

	public void init() {
		try {
			File file = new File("C:\\test", "member.test.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<Member> ar = new ArrayList<Member>();

			boolean check = true;
			while(check) {
				String str = br.readLine();
				if(str==null) {
					break;
				}//if

				StringTokenizer st = new StringTokenizer(str, ",");
				
				
				while(st.hasMoreTokens()) {
					Member m = new Member();
					m.setId(st.nextToken());
					m.setPw(st.nextToken());
					ar.add(m);
				}
			}//while
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//init
	
	
	
	//memberLogin 메서드
	//id, pw를 매개변수로 받아서 로그인 유무를 검증..

	public void memberLogin(String yId, String yPw) {
		
		
		
		
		
	}//memberLogin


}
