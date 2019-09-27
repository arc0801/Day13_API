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
import com.arc.n2.network.Network;
import com.sun.glass.ui.Menu;

public class Server2 {

	public static void main(String[] args) {
		Network network = new Network();
		MenuMaker m = new MenuMaker();
		m.init();

		try {
			ServerSocket ss = new ServerSocket(8282);
			System.out.println("클라이언트 접속 받을 준비 중");
			Socket sc = ss.accept();

			String str = network.receive(sc);
			String menu = m.selectMenu(str);

			network.send(sc, menu);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//try
	}//main
}
