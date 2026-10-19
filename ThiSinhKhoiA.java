public class ThiSinhKhoiA extends ThiSinh {

    public ThiSinhKhoiA(String soBaoDanh, String hoTen,
                        String diaChi, String mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public String getKhoiThi() {
        return "A";
    }

    @Override
    public String getMonThi() {
        return "Toan, Ly, Hoa";
    }
}