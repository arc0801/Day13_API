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

import com.sun.glass.ui.Menu;

public class Server2 {

	public static void main(String[] args) {
		MenuMaker m = new MenuMaker();
		m.init();
	}//main
}
