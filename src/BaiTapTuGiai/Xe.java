package BaiTapTuGiai;

public abstract class Xe {
	protected String  CMND;
	protected String HoTen;
	protected int	GioiTinh;
	protected String MaSoCanHo;
	protected String MauSon;
	protected String TimeVaoBai;
	protected String TimeRaBai;
	
}
abstract class Xe2Banh extends Xe {
	
}
abstract class Xe4Banh extends Xe {
	
}
class XeDap extends Xe2Banh {
	
}
class XeMay extends Xe2Banh {
	private String BienSoXe;
	private String HangSanXuat;
}
class XeOTo extends Xe4Banh {
	
}