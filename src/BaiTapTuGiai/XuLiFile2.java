package BaiTapTuGiai;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class XuLiFile2 {
	public ArrayList<String> input1 = new ArrayList<String>();
	public ArrayList<String> input2 = new ArrayList<String>();
	public ArrayList<String> output = new ArrayList<String>();

	public void DocFileInput1() {
		try {
			FileInputStream FIS = new FileInputStream("input1.txt");
			InputStreamReader ISR = new InputStreamReader(FIS);
			BufferedReader BR = new BufferedReader(ISR);

			while (true) {
				String st = BR.readLine();
				if (st == "" || st == null)
					break;

				input1.add(st);
			}
			BR.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DocFileInput2() {
		try {
			FileInputStream FIS = new FileInputStream("input2.txt");
			InputStreamReader ISR = new InputStreamReader(FIS);
			BufferedReader BR = new BufferedReader(ISR);

			while (true) {
				String st = BR.readLine();
				if (st == "" || st == null)
					break;

				input2.add(st);
			}
			BR.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Double LamTronOto(Double gio) {
		if (gio % 0.5 == 0) {
			return gio;
		} else if (gio - 0.5 > (double) gio.intValue()) { // vi du: gio = 2.6
															// thi 2.6 - 0.5 =
															// 2.1 > (int)gio =
															// 2.........
			return (double) gio.intValue() + 1; // tra ve (int) gio + 1 => 2.6
												// thi tra ve 3
		} else
			return (double) gio.intValue() + 0.5; // nguoc lai, vi du gio = 2.4
													// thi 2.4 - 0.5 < = 1.9 <
													// (int)gio = 2
													// => return ve (int)gio = 2
	}

	Double LamTronXeMay(Double ngay) {
		if (ngay % 1 == 0) {
			return ngay;
		} else
			return (double) ngay.intValue() + 1;
	}

	Double TinhTienXeOto(Date d1, Date d2) {
		Double tiengio = 0.0;
		double hieungay = d2.getTime() - d1.getTime();
		double gio = hieungay / 3600000;

		tiengio = LamTronOto(gio) * 10000;
		return tiengio;
	}

	Double TinhTienXeMay(Date d1, Date d2) {

		double hieungay = d2.getTime() - d1.getTime();
		double ngay = hieungay / 86400000;

		return LamTronXeMay(ngay) * 3000;
	}

	Double TinhTienXeDap(Date d1, Date d2) {
		double hieungay = d2.getTime() - d1.getTime();
		double ngay = hieungay / 86400000;

		return LamTronXeMay(ngay) * 1000;
	}

	boolean CheckTrangThai(String trangthai) {
		return (trangthai.equalsIgnoreCase("binh thuong") || trangthai.equalsIgnoreCase("not available"));
	}
	
	public void GhiFileOutput(){
		try {
			FileOutputStream FOS = new FileOutputStream("output.txt");
			OutputStreamWriter OSW = new OutputStreamWriter(FOS);
			PrintWriter PW = new PrintWriter(OSW);

			for(String  data : input1) {
				String[] ds = data.split(";");
				System.out.println(ds[2]);
			}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			for(String  data : input1) {
				String[] ds = data.split(";");
				System.out.println(ds[2]);
			}
		}
		
		
		
	}
}
