package BaiTapJava_Phan1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class BaiTapArrayList {
	public ArrayList<String> ListHoTen = new ArrayList<String>();
	public ArrayList<Double> ListDTB = new ArrayList<Double>();

	public void TaoDanhSach(BufferedReader br) {
		String[] ds;
		try {
			while (true) {

				String st = br.readLine();
				if (st == "" || st == null)
					break;
				ds = st.split("[;]");
				ListHoTen.add(ds[1]);
				ListDTB.add(Double.parseDouble(ds[4]));
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void XuatDanhSach() {
		for (int i = 0; i < ListHoTen.size(); i++) {
			System.out.println(ListHoTen.get(i) + " : " + ListDTB.get(i));
		}
	}

	public void TimKiem(String ten) {
		for (int i = 0; i < ListHoTen.size(); i++) {
			if (ListHoTen.get(i).endsWith(ten)) {
				System.out.println(ListHoTen.get(i));
			}
		}
	}

	public void DauRot() {
		int Dau = 0; int Rot = 0; int Sai = 0; double DTB;
		for (int i = 0; i < ListDTB.size(); i++) {
			DTB = ListDTB.get(i);
			if(DTB > 0 && DTB < 5) {
				Rot++;
			} else if (DTB >= 5 && DTB <= 10) {
				Dau++;
			} else {
				Sai++;
			}
		}
		System.out.println("So sv dau: " + Dau);
		System.out.println("So sv dau: " + Rot);
		System.out.println("So sv sai diem: " + Sai);
	}
	
	public double TBC () {
		double Tong = 0; double DTB;
		for (int i = 0; i < ListDTB.size(); i++) {
			DTB = ListDTB.get(i);
			if (DTB >= 0 && DTB <= 10) {
				Tong += DTB;
			}		
		}
		return Tong/ListDTB.size();
	}
}
