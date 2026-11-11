package voanhKhoi25751321;

import java.util.List;

public class TestPhongHoc {

	static void inDS(List<PhongHoc> ds) {
		if (ds.isEmpty()) {
			System.out.println("Danh sach rong!");
			return;
		}
		for (PhongHoc p : ds) {
			System.out.println(p);
		}
	}

	public static void main(String[] args) {
		QuanLyPhongHoc ql = new QuanLyPhongHoc();

		ql.them(new PhongLyThuyet("LT01", "A", 50, 5, true));
		ql.them(new PhongLyThuyet("LT02", "B", 60, 4, false));
		ql.them(new PhongMayTinh("MT01", "C", 90, 9, 60));
		ql.them(new PhongMayTinh("MT02", "A", 40, 4, 30));
		ql.them(new PhongThiNghiem("TN01", "B", 70, 7, "Hoa", 30, true));
		ql.them(new PhongThiNghiem("TN02", "C", 80, 8, "Sinh", 25, false));

		System.out.println("Them trung ma LT01: " + ql.them(new PhongLyThuyet("LT01", "D", 30, 3, true)));

		System.out.println("\n--- Toan bo danh sach ---");
		inDS(ql.layTatCa());

		System.out.println("\n--- Tim phong MT01 ---");
		PhongHoc p = ql.timKiem("MT01");
		System.out.println(p == null ? "Khong tim thay!" : p);

		System.out.println("\n--- Cac phong dat chuan ---");
		inDS(ql.layPhongDatChuan());

		ql.sapXepTangTheoDayNha();
		System.out.println("\n--- Sap xep tang theo day nha ---");
		inDS(ql.layTatCa());

		ql.sapXepGiamTheoDienTich();
		System.out.println("\n--- Sap xep giam theo dien tich ---");
		inDS(ql.layTatCa());

		ql.sapXepTangTheoSoBongDen();
		System.out.println("\n--- Sap xep tang theo so bong den ---");
		inDS(ql.layTatCa());

		System.out.println("\n--- Cap nhat so may MT02 thanh 60 ---");
		System.out.println(ql.capNhatSoMay("MT02", 60) ? "Cap nhat thanh cong!" : "Khong tim thay phong may tinh!");

		System.out.println("\n--- Cac phong may co 60 may ---");
		inDS(ql.layPhongMay60May());

		System.out.println("\n--- Xoa phong LT02 ---");
		PhongHoc canXoa = ql.timKiem("LT02");
		if (canXoa != null) {
			System.out.println("Tim thay: " + canXoa);
			ql.xoa("LT02");
			System.out.println("Da xoa!");
		} else {
			System.out.println("Khong tim thay phong de xoa!");
		}

		System.out.println("\nTong so phong hoc: " + ql.tongSoPhong());
	}
}