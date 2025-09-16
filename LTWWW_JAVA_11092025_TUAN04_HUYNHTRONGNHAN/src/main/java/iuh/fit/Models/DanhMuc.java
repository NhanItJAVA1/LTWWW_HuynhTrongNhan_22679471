package iuh.fit.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "danhmuc")
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDM;

    private String tenDanhMuc;
    private String nguoiQuanLy;
    private String ghiChu;

    public int getMaDM() { return maDM; }
    public void setMaDM(int maDM) { this.maDM = maDM; }
    public String getTenDanhMuc() { return tenDanhMuc; }
    public void setTenDanhMuc(String tenDanhMuc) { this.tenDanhMuc = tenDanhMuc; }
    public String getNguoiQuanLy() { return nguoiQuanLy; }
    public void setNguoiQuanLy(String nguoiQuanLy) { this.nguoiQuanLy = nguoiQuanLy; }
    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}
