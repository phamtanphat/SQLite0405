package com.ptp.phamtanphat.sqlite0405;

public class Monan  {
    private Integer Id;
    private String Tenmonan;
    private Integer Giamonan;
    private String Diachi;

    public Monan(Integer id, String tenmonan, Integer giamonan, String Diachi) {
        Id = id;
        Tenmonan = tenmonan;
        Giamonan = giamonan;
        this.Diachi = Diachi;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTenmonan() {
        return Tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        Tenmonan = tenmonan;
    }

    public Integer getGiamonan() {
        return Giamonan;
    }

    public void setGiamonan(Integer giamonan) {
        Giamonan = giamonan;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }
}
