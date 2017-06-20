package BaiTapJava_Phan1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class ArrayList {

	public static void main(String[] args) {
		try {
			FileInputStream fis		= new FileInputStream("SinhVien.txt");
			InputStreamReader isr 	= new InputStreamReader(fis);
			BufferedReader br 		= new BufferedReader(isr);
			
			BaiTapArrayList arraylist = new BaiTapArrayList();
			arraylist.TaoDanhSach(br);
			//arraylist.XuatDanhSach();
			arraylist.TimKiem("Phung");
			arraylist.DauRot();
			System.out.println(arraylist.TBC());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
