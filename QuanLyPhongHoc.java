package voanhKhoi25751321;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuanLyPhongHoc {
	private List<PhongHoc> ds;

	public QuanLyPhongHoc() {
		ds = new ArrayList<PhongHoc>();
	}
	public boolean them(PhongHoc p) {
		if (timKiem(p.getMaPhong()) != null) {
			return false;
		}
		ds.add(p);
		return true;
	}

	public PhongHoc timKiem(String maPhong) {
		for (PhongHoc p : ds) {
			if (p.getMaPhong().equalsIgnoreCase(maPhong)) {
				return p;
			}
		}
		return null;
	}

	public List<PhongHoc> layTatCa() {
		return ds;
	}

	public List<PhongHoc> layPhongDatChuan() {
		List<PhongHoc> kq = new ArrayList<PhongHoc>();
		for (PhongHoc p : ds) {
			if (p.datChuan()) {
				kq.add(p);
			}
		}
		return kq;
	}

	public void sapXepTangTheoDayNha() {
		ds.sort(Comparator.comparing(PhongHoc::getDayNha));
	}

	public void sapXepGiamTheoDienTich() {
		ds.sort((a, b) -> Double.compare(b.getDienTich(), a.getDienTich()));
	}

	public void sapXepTangTheoSoBongDen() {
		ds.sort(Comparator.comparingInt(PhongHoc::getSoBongDen));
	}

	public boolean capNhatSoMay(String maPhong, int soMayMoi) {
		PhongHoc p = timKiem(maPhong);
		if (p instanceof PhongMayTinh) {
			((PhongMayTinh) p).setSoMay(soMayMoi);
			return true;
		}
		return false;
	}

	public boolean xoa(String maPhong) {
		PhongHoc p = timKiem(maPhong);
		if (p == null) {
			return false;
		}
		ds.remove(p);
		return true;
	}

	public int tongSoPhong() {
		return ds.size();
	}

	public List<PhongHoc> layPhongMay60May() {
		List<PhongHoc> kq = new ArrayList<PhongHoc>();
		for (PhongHoc p : ds) {
			if (p instanceof PhongMayTinh && ((PhongMayTinh) p).getSoMay() == 60) {
				kq.add(p);
			}
		}
		return kq;
	}
}