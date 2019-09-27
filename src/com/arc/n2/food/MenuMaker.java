package com.arc.n2.food;

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

public class MenuMaker {
	private ArrayList<String> lunchs;
	private ArrayList<String> dinners;

	public String selectMenu(String select) {
		Random random = new Random();
		String menu = null;

		if(select.equals("1")) {
			menu = lunchs.get(random.nextInt(lunchs.size()));
		}else {
			menu = dinners.get(random.nextInt(dinners.size()));
		}//if
		return menu;
	}//selectMenu


	public void init() {
		this.lunchs = this.makeMenu("lunch.test.txt", "-");
		this.dinners = this.makeMenu("dinner.test.txt", ",");
	}//init


	private ArrayList<String> makeMenu(String fileName, String delim) {
		File file = new File("C:\\test", fileName);
		FileReader fr = null;
		BufferedReader br = null;
		boolean check = true;
		ArrayList<String> ar = new ArrayList<String>();

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			while(check) {
				String str = br.readLine();
				if(str==null) {
					break;
				}//if

				StringTokenizer st = new StringTokenizer(str, delim);

				while(st.hasMoreTokens()) {
					ar.add(st.nextToken().trim());
				}//while
			}//while
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//try

		return ar;
	}//makeMenu
}
