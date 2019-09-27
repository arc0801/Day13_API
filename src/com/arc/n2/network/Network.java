package com.arc.n2.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Network {
	
	public String receive(Socket sc) throws Exception{
		InputStream is = sc.getInputStream();
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		String str = br.readLine();
		return str;
	}//receive

	
	public void send(Socket sc, String str) throws Exception{
		OutputStream os = sc.getOutputStream();//byte
		OutputStreamWriter ow = new OutputStreamWriter(os);//char
		BufferedWriter bw = new BufferedWriter(ow);
		bw.write(str + "\r\n");
		bw.flush();
	}//send

}
