package iuh.fit.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tintuc")
public class TinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTT;

    private String tieuDe;

    @Column(length = 255)
    private String noiDungTT;

    private String lienKet;

    @ManyToOne
    @JoinColumn(name = "maDM", nullable = false)
    private DanhMuc danhMuc;

    public int getMaTT() { return maTT; }
    public void setMaTT(int maTT) { this.maTT = maTT; }
    public String getTieuDe() { return tieuDe; }
    public void setTieuDe(String tieuDe) { this.tieuDe = tieuDe; }
    public String getNoiDungTT() { return noiDungTT; }
    public void setNoiDungTT(String noiDungTT) { this.noiDungTT = noiDungTT; }
    public String getLienKet() { return lienKet; }
    public void setLienKet(String lienKet) { this.lienKet = lienKet; }
    public DanhMuc getDanhMuc() { return danhMuc; }
    public void setDanhMuc(DanhMuc danhMuc) { this.danhMuc = danhMuc; }
}
