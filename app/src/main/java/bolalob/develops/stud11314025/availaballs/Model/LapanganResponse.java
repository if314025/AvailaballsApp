package bolalob.develops.stud11314025.availaballs.Model;

import com.google.gson.annotations.Expose;

/**
 * Created by Voldarex on 7/4/2017.
 */

public class LapanganResponse {

    @Expose
    private String NamaLapangan;
    @Expose
    private String Lokasi;
    @Expose
    private int No;

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

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }
}
