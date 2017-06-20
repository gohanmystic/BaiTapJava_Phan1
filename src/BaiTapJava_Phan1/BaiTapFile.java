package BaiTapJava_Phan1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return KetQua;
	}
	
}
