import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinhMain {

    static ArrayList<ThiSinh> danhSach = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static ThiSinh timTheoSBD(String sbd) {
        for (ThiSinh ts : danhSach) {
            if (ts.getSoBaoDanh().equalsIgnoreCase(sbd)) {
                return ts;
            }
        }
        return null;
    }

    public static void themThiSinh() {
        System.out.println("\n=== THEM THI SINH ===");

        System.out.print("Nhap so bao danh: ");
        String sbd = sc.nextLine().trim();

        if (sbd.isEmpty() || timTheoSBD(sbd) != null) {
            System.out.println("SBD rong hoac da ton tai!");
            return;
        }

        System.out.print("Nhap ho ten: ");
        String hoTen = sc.nextLine();

        System.out.print("Nhap dia chi: ");
        String diaChi = sc.nextLine();

        System.out.print("Nhap muc uu tien: ");
        String uuTien = sc.nextLine();

        System.out.print("Nhap khoi thi (A/B/C): ");
        String khoi = sc.nextLine().trim().toUpperCase();

        ThiSinh ts;

        switch (khoi) {
            case "A":
                ts = new ThiSinhKhoiA(
                    sbd, hoTen, diaChi, uuTien);
                break;

            case "B":
                ts = new ThiSinhKhoiB(
                    sbd, hoTen, diaChi, uuTien);
                break;

            case "C":
                ts = new ThiSinhKhoiC(
                    sbd, hoTen, diaChi, uuTien);
                break;

            default:
                System.out.println("Khoi thi khong hop le!");
                return;
        }

        danhSach.add(ts);
        System.out.println("Them thi sinh thanh cong!");
    }

    public static void hienThiDanhSach() {
        System.out.println("\n=== DANH SACH THI SINH ===");

        if (danhSach.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        for (ThiSinh ts : danhSach) {
            ts.hienThi();
            System.out.println("----------------------");
        }
    }

    public static void timKiemThiSinh() {
        System.out.println("\n=== TIM KIEM THI SINH ===");

        System.out.print("Nhap so bao danh can tim: ");
        String sbd = sc.nextLine().trim();

        ThiSinh ts = timTheoSBD(sbd);

        if (ts != null) {
            System.out.println("Tim thay thi sinh:");
            ts.hienThi();
        } else {
            System.out.println("Khong tim thay thi sinh!");
        }
    }

    public static void main(String[] args) {
        String luaChon;

        do {
            System.out.println("\n===== QUAN LY THI SINH =====");
            System.out.println("1. Them moi thi sinh");
            System.out.println("2. Hien thi danh sach thi sinh");
            System.out.println("3. Tim kiem theo so bao danh");
            System.out.println("4. Thoat");
System.out.print("Nhap lua chon: ");

            luaChon = sc.nextLine().trim();

            switch (luaChon) {
                case "1":
                    themThiSinh();
                    break;

                case "2":
                    hienThiDanhSach();
                    break;

                case "3":
                    timKiemThiSinh();
                    break;

                case "4":
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (!luaChon.equals("4"));

        sc.close();
    }
}
