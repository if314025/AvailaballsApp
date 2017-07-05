package bolalob.develops.stud11314025.availaballs.Service;

import java.util.List;

import bolalob.develops.stud11314025.availaballs.Model.LapanganResponse;

/**
 * Created by Voldarex on 7/4/2017.
 */

public interface LapanganViewInterface {
    void completed();

    void onError(String message);

    void onLapangan(List<LapanganResponse> lapanganResponseList);
}
