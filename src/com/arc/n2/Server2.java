package com.arc.n2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import com.arc.n2.food.MenuMaker;
import com.sun.glass.ui.Menu;

public class Server2 {

	public static void main(String[] args) {
		MenuMaker m = new MenuMaker();
		m.init();
		String menu = m.selectMenu("2");
		System.out.println(menu);
		
		
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;

		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;

		File file = null;
		FileReader fr = null;
		StringTokenizer st;
		ArrayList<String> ar;
		Random random = new Random();
		String str = null;
		boolean check = true;

		try {
			ss = new ServerSocket(8282);
			System.out.println("클라이언트 접속 받을 준비 중");
			sc = ss.accept();
			
			is = sc.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			str = br.readLine();
			System.out.println(str);


			
			
			os = sc.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			ar = new ArrayList<String>();


			if(str.equals("1")) {
				file = new File("C:\\test", "lunch.test.txt");
				fr = new FileReader(file);
				br = new BufferedReader(fr);

				while(check) {
					str = br.readLine();
					if(str==null) {
						break;
					}
					st = new StringTokenizer(str, "-");
					while(st.hasMoreTokens()) {
						ar.add(st.nextToken().trim());
					}
				}

				str = (String)(ar.get(random.nextInt(ar.size())));
				bw.write(str+"\r\n");
				bw.flush();
				System.out.println("클라이언트로 전송 완료");




			}else if(str.equals("2")) {
				file = new File("C:\\test", "dinner.test.txt");
				fr = new FileReader(file);
				br = new BufferedReader(fr);

				while(check) {
					str = br.readLine();
					if(str==null) {
						break;
					}
					st = new StringTokenizer(str, ",");
					while(st.hasMoreTokens()) {
						ar.add(st.nextToken().trim());
					}
				}

				str = (String)(ar.get(random.nextInt(ar.size())));
				bw.write(str);
				bw.flush();
				System.out.println("클라이언트로 전송 완료");

			}else {
				System.out.println("1번과 2번 중에 골라주세요");
			}//if

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
		}//try
		
		
	}//main
}
