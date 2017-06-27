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

	public void GhiFileOutput1() {
		try {
			// 3 dòng khai báo để đọc file input1.txt, biến brInput1 ở dòng cuối để đọc dữ liệu trong file
			FileInputStream fis = new FileInputStream("input1.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader brInput1 = new BufferedReader(isr);

			// 3 dòng khai báo để ghi dữ liệu vào file output1.txt, biến PWOutput1 ở dòng cuối để ghi dữ liệu
			FileOutputStream FOS = new FileOutputStream("output1.txt");
			OutputStreamWriter OSW = new OutputStreamWriter(FOS);
			PrintWriter PWOutput1 = new PrintWriter(OSW);
			while (true) {  // vòng lặp vô hạn để đọc file, đọc đến khi cuối file thì break
				String st1 = brInput1.readLine(); // brInput1.readLine: đọc dữ liệu từng dòng trong file lưu vào biến st1
				if (st1 == "" || st1 == null || st1.isEmpty()) //cuối file <=> st1 = "" hoặc st1=null hoặc st1.isEmpty
					break;
				String[] ds1 = st1.split("[;]");  //cắt dữ liệu st1 phân cách nhau bởi dấu ; cho vào mảng ds1
				//ví dụ st1 chưa '4;37A-365.12;Not Available;11:30 07/11/2015;Binh thuong'
				//thì ds1[0]=4; ds1[1]=37A-365.12; ds1[2]=Not Available; ds1[3]=11:30 07/11/2015; ds1[4]=Binh thuong
				
				PWOutput1.print((ds1[0] + ";" + ds1[1] + ";" + ds1[2] + ";" + ds1[3])); //ghi dữ liệu vào file Output1
				// khai báo để đọc file input2.txt
				FileInputStream fis2 = new FileInputStream("input2.txt");
				InputStreamReader isr2 = new InputStreamReader(fis2);
				BufferedReader brInput2 = new BufferedReader(isr2);
				while (true) {
					String st2 = brInput2.readLine();
					if (st2 == "" || st2 == null || st2.isEmpty())
						break;
					String[] ds2 = st2.split("[;]"); // cắt dữ liệu cho vào mảng ds2
					// đọc hàm CheckTrangTHai ở phía dưới, hàm trả về true nếu ds[1] = "available", ngc lại trả về false
					// và kiểm tra nếu ds[1] == ds2[1] thì in vào file Output1
					if (!CheckTrangThai(ds1[1]) && (ds1[1].equalsIgnoreCase(ds2[1]))) { 
						PWOutput1.println(";" + ds2[3] + ";" + ds2[4]);
					} else if (CheckTrangThai(ds1[1]) && ds1[2].equalsIgnoreCase(ds2[2])) {
						PWOutput1.println(";" + ds2[3] + ";" + ds2[4]);
					}
				}
				brInput2.close(); // đóng file input2.txt
			}
			brInput1.close(); //đóng file input2.txt
			PWOutput1.close();//đòng file output1.txt
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	// t =3.1
	// Math.ceil (t) -> 4
	Double LamTronOto(Double gio) {
		if (gio % 0.5 == 0) {
			return gio;		
		} else if (gio - 0.5 > (double) gio.intValue()) { //vi du: gio = 2.6 thi 2.6 - 0.5 = 2.1 > (int)gio = 2 thi tra ve 3
			return (double) gio.intValue() + 1; // tra ve (int) gio + 1 => 2.6		 
		} else
			//nguoc lai, vi du gio = 2.4 thi 2.4 - 0.5  = 1.9 < (int)gio = 2 => return ve (int)gio = 2 + 0.5 = 2.5
			return (double) gio.intValue() + 0.5; 
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
