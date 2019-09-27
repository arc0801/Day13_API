package com.arc.n2.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class MemberService {

	private HashMap<String, Member> map;



	public static void main(String[] args) {
		MemberService ms = new MemberService();
		try {
			ms.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//test용 메인 메서드

	//init 메서드
	//파일의 내용을 읽어서 파싱 작업

	public void init() throws Exception{
		this.map = new HashMap<String, Member>();
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
				m.setId(st.nextToken().trim());//ID
				m.setPw(st.nextToken().trim());//PW
				map.put(m.getId(), m);
			}
		}//while

		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String k = it.next();
			Member m = map.get(k);
			System.out.println(m.getId());
			System.out.println(m.getPw());
		}

	}//init



	//memberLogin 메서드
	//id, pw를 매개변수로 받아서 로그인 유무를 검증..
	//로그인 실패 => null
	public Member memberLogin(Member member) {
		Member m = map.get(member.getId());
		if(m != null) {
			if(m.getPw().equals(member.getPw())) {
				///////추가 정보 대입
			}else {
				m = null;
			}
		}

		return m;

	}//memberLogin


}
