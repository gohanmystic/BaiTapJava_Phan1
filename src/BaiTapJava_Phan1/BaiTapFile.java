package BaiTapJava_Phan1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BaiTapFile {
	public void TaoDanhSach (int n) {		
		try {
			//tao file
			FileOutputStream fis	= new FileOutputStream("SinhVien.txt");
			OutputStreamWriter osw	= new OutputStreamWriter(fis);
			PrintWriter pw 			= new PrintWriter(osw);
			
			BaiTapMang m = new BaiTapMang();
			
			for (int i = 0; i < n; i++) {
				//pw.println("SV"+i+";"+m.TaoHoTen()+";"+m.CreateRandomDate("01/01/1990", "31/12/2000")+";"+m.TaoDTB());
				pw.print("SV"+i+";");
				m.GhiFile(pw);
			}			
			pw.close();
			System.out.println("Tao xong!");
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void XuatDanhSach (BufferedReader br) {
		try {			
			while (true) {
				String st = br.readLine();
				if (st == "" || st == null) break;
				
				String[] ds = st.split("[;]");
				
				System.out.println(ds[0]+"\n"+ds[1]+"\n"+ds[2]+"\n"+ds[3]+"\n"+ds[4]+"\n"+ds[5]+"\n"+ds[6]+"\n\n");
			}
			
			br.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public ArrayList<String> TimKiem (BufferedReader br, String ten) {
		ArrayList<String> KetQua = new ArrayList<String>();
		try {
			while (true) {
				String st = br.readLine();
				if(st == "" || st == null) break;
				
				String[] ds 	= st.split("[;]");
				String HoTen	= ds[1];
				
				if (HoTen.endsWith(ten)) {
					KetQua.add(HoTen);
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return KetQua;
	}
	
	public void DemDauRot (BufferedReader br) {
		int Dau = 0;
		int Rot = 0;
		try {
			while (true) {
				String st = br.readLine();
				if (st == "" || st == null) break;
				String[] ds = st.split("[;]");
				if (ds[6].compareTo("Dau") == 0) {
					Dau++;
				} else {
					Rot++;
				}		
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("So sv dau: " + Dau);
		System.out.println("So sv rot: " + Rot);
	}
	
	public Double TBC (BufferedReader br) {
		double Tong = 0;
		int dem = 0;
		try{
			while (true) {
				String st  	= br.readLine();
				if(st == "" || st == null) break;
				String[] ds = st.split("[;]");
				
				Tong += Double.parseDouble(ds[4]);
				dem++;			
			}
			br.close();
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return Tong/dem;
	}
	
	public void validate (BufferedReader br) {
		try {
			while (true) {
				String st = br.readLine();
				if (st == "" || st == "null") break;
				
				String[] ds = st.split("[;]");
				
				String d = ds[3].replace("/", "-"); //ds[3] dang co dang dd/mm/yyyy, can chuyen qua dang dd-mm-yyyy
				
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				Date date = format.parse(d);
				String dcheck = "00:00:00 " + d; // chuan hoa chuoi ngay theo return cua ham toLocaleString
				
				if(dcheck.compareTo(date.toLocaleString()) != 0){  //toLocaleString tra ve ngay dang 00:00:00 dd-MM-yyyy
					System.out.println(ds[0] + " : " + " dinh dang ngay sinh khong hop le! (" + ds[3] + ")");
				}
				
				/*String d =  ds[3];
				String[] date = d.split("[/]");
				int day = Integer.parseInt(date[0]);
				int month = Integer.parseInt(date[1]);
				int year = Integer.parseInt(date[2]);
			
				if (day > 31 || month > 12 || year < 1900) {
					System.out.println(ds[0] + " : " + " dinh dang ngay sinh khong hop le! (" + ds[3] + ")");
				}*/
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
