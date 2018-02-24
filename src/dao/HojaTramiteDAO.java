package dao;

import entity.Codeqr;
import entity.HojaTramite;

public interface HojaTramiteDAO {
public int GrabarHT(HojaTramite obj);
public int GrabarIdQR(Codeqr qr);
public String GrabarImagenQR(Codeqr qr);
}
