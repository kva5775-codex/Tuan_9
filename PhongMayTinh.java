package voanhKhoi25751321;

public class PhongMayTinh extends PhongHoc {
	private int soMay;

	public PhongMayTinh() {
	}

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMay) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soMay = soMay;
	}

	public int getSoMay() {
		return soMay;
	}

	public void setSoMay(int soMay) {
		this.soMay = soMay;
	}

	@Override
	public boolean datChuan() {
		return duAnhSang() && soMay > 0 && dienTich / soMay >= 1.5;
	}

	@Override
	public String toString() {
		return "Phong may tinh [" + super.toString() + ", soMay=" + soMay + ", datChuan=" + datChuan() + "]";
	}
}