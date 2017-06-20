package bolalob.develops.stud11314025.availaballs.model;

import java.util.ArrayList;

/**
 * Created by Okta on 19/06/2017.
 */

public class Lapangan {
    private Integer No;
    private String NamaLapangan;
    private String Lokasi;

    public Lapangan(Integer no, String namaLapangan, String lokasi) {
        No = no;
        NamaLapangan = namaLapangan;
        Lokasi = lokasi;
    }

    public Integer getNo() {
        return No;
    }

    public void setNo(Integer no) {
        No = no;
    }

    public String getNamaLapangan() {
        return NamaLapangan;
    }

    public void setNamaLapangan(String namaLapangan) {
        NamaLapangan = namaLapangan;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public void setLokasi(String lokasi) {
        Lokasi = lokasi;
    }

}
