package BaiTapTuGiai;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class XuLiFile {

	public static ArrayList<String> ThoiGianRa = new ArrayList<String>();
	public static ArrayList<String> TinhTrangLucRa = new ArrayList<String>();

	public void DocFileInput2() {
		try {
			FileInputStream fis = new FileInputStream("input2.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader brInput2 = new BufferedReader(isr);
			while (true) {
				String st = brInput2.readLine();
				if (st == "" || st == null)
					break;
				String[] ds = st.split("[;]");

				ThoiGianRa.add(ds[3]);
				TinhTrangLucRa.add(ds[4]);
			}
			brInput2.close();
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}

	public void GhiFileOutput1() {
		int i = 0;

		try {
			while (true) {
				// doc file input1
				FileInputStream fis = new FileInputStream("input1.txt");
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader brInput1 = new BufferedReader(isr);
				// ghi du lieu vao file output1
				FileOutputStream fos = new FileOutputStream("output3.txt");
				OutputStreamWriter ow = new OutputStreamWriter(fos);
				PrintWriter pwOutput1 = new PrintWriter(fos);
				String st = brInput1.readLine();

				if (st == "" || st == null)
					break;
				String[] ds = st.split("[;]");
				
				pwOutput1.println(ds[1]);
				i++;
			}
		} catch (Exception e) {
			System.out.println(e);

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

	public void GhiFileOutput() {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm dd/MM/yyyy");
		try {
			FileInputStream fis = new FileInputStream("output1.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader brOutput1 = new BufferedReader(isr);

			FileOutputStream fos = new FileOutputStream("output.txt");
			OutputStreamWriter ow = new OutputStreamWriter(fos);
			PrintWriter pwOutput = new PrintWriter(ow);

			while (true) {
				String st = brOutput1.readLine();
				if (st == "" || st == null)
					break;

				String[] ds = st.split("[;]");

				Date d1 = format.parse(ds[3]);
				Date d2 = format.parse(ds[4]);

				int MaXe = Integer.parseInt(ds[0]);
				// ham CheckTrangThai(strang trangthai) tra ve true neu trang
				// thai la "binh thuong" hoac "not available", nguoc lai tra ve
				// false
				if (MaXe == 4 && CheckTrangThai(ds[5])) {
					pwOutput.println(ds[0] + ";" + ds[1] + ";" + ds[2] + ";" + ds[3] + ";" + ds[4] + ";"
							+ TinhTienXeOto(d1, d2));
				} else if (MaXe == 2 && CheckTrangThai(ds[5])) {
					pwOutput.println(ds[0] + ";" + ds[1] + ";" + ds[2] + ";" + ds[3] + ";" + ds[4] + ";"
							+ TinhTienXeMay(d1, d2));
				} else if (MaXe == 0 && CheckTrangThai(ds[5])) {
					pwOutput.println(ds[0] + ";" + ds[1] + ";" + ds[2] + ";" + ds[3] + ";" + ds[4] + ";"
							+ TinhTienXeDap(d1, d2));
				} else
					pwOutput.println(ds[0] + ";" + ds[1] + ";" + ds[2] + ";" + ds[3] + ";" + ds[4]
							+ ";Chua xac dinh, dang xu ly boi thuong");
			}
			brOutput1.close();
			pwOutput.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
