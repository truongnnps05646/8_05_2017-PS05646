package bean;

public class Student {

    public Student() {
    }

    public Student(int manv, String hoten, String diachi, boolean gioitinh) {
        this.manv = manv;
        this.hoten = hoten;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }
 
    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }



    private int manv;
    private String hoten;
    private String diachi;
    private boolean gioitinh;

  
        
}
