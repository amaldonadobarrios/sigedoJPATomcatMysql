package service;

import entity.Codeqr;
import entity.HojaTramite;

public interface HojaTramiteService {
	public int GrabarHT(HojaTramite obj);
	public int GrabarIdQR(Codeqr qr);
	public String GrabarImagenQR(Codeqr qr);
	public int ArchivarEstadoHT(int id_HT);
}
