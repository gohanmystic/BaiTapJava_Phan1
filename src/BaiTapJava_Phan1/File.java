package BaiTapJava_Phan1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class File {

	public static void main(String[] args) {
		FileInputStream fis;
		try {
			fis = new FileInputStream("SinhVien.txt");
			InputStreamReader isr 	= new InputStreamReader(fis);
			BufferedReader br 		= new BufferedReader(isr);
			
			BaiTapFile btf = new BaiTapFile();
			
			//btf.TaoDanhSach(50); // chay 1 lan dau tien. lan sau thi comment no lai
			//btf.XuatDanhSach(br);
			ArrayList<String> HoTen = new ArrayList<String>();
			HoTen = btf.TimKiem(br, "Phung");
			
			for (int i = 0; i < HoTen.size(); i++) {
				System.out.println(HoTen.get(i));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
