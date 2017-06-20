package BaiTapJava_Phan1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BaiTapMang {

	public String CreateRandomDate(String day1, String day2) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			Date d1 = format.parse(day1);
			Date d2 = format.parse(day2);

			Random r = new Random();

			while (true) {
				Long t = r.nextLong();

				if (t >= d1.getTime() && t <= d2.getTime()) {
					Date d = new Date(t);
					return format.format(d);
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
	public String TaoHoTen () {
		
		String [] ho 	= {"Tran", "Le", "Nguyen", "Phan"};
		String [] hodem = {"Quoc", "Van", "Thi", "Dinh"};
		String [] ten 	= {"Vu", "Luyen", "Nam", "Phung"};
		
		int ddho 	= ho.length;
		int ddhodem = hodem.length;
		int ddten 	= ten.length;
		Random r = new Random();
		
		String RandomHo = ho[r.nextInt(ddho - 1)];
		String RandomHoDem = hodem[r.nextInt(ddhodem - 1)];
		String RandomTen = ten[r.nextInt(ddten - 1)];
		
		return RandomHo + " " + RandomHoDem + " " + RandomTen;
	}
	public String TaoGioiTinh (String HoTen) {
		String ds[] = HoTen.split("[ ]");
		String hodem = ds[1];
		if (hodem.equalsIgnoreCase("Van")) {
			return "Nam";
		}
		if (hodem.equalsIgnoreCase("Thi")) {
			return "Nu";
		}
		
		String [] gioitinh	= {"Nam", "Nu"};
		int ddgt		= gioitinh.length;
		Random r 			= new Random();
		
		return gioitinh[r.nextInt(ddgt - 1)];
	}
	public Double TaoDTB () {
		Random r = new Random();		
		return r.nextDouble()*10;
	}
	
	public String XepLoai (double DTB) {
		if(DTB >= 8) 	return "Gioi";
		if(DTB >= 6.5) 	return "Kha";
		if(DTB >= 5) 	return "Trung Binh";
		if(DTB > 3)		return "Yeu";
		return "Kem";
	}
	public void HienThi (int n) {
		
		
		for (int i = 0; i < n; i++) {
			
			String rname 	= TaoHoTen();
			String rgt		= TaoGioiTinh(rname);
			String rdate	= CreateRandomDate("01/01/1990", "31/12/2000");		
			Double rDTB 		= TaoDTB();
			String xeploai	= XepLoai(rDTB);
			String ketqua 	= "";
			ketqua = (rDTB >= 5) ? "Dau" : "Rot";
			
			System.out.println(rname+";"+rgt+";"+rdate+";"+rDTB+";"+xeploai+";"+ketqua);
		}
	}
}
