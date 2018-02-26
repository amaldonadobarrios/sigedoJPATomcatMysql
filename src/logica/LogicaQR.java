package logica;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import entity.Codeqr;
import service.HojaTramiteService;
import service.impl.HojaTramiteServiceImpl;

public class LogicaQR {
	// PATRON SINGLETON INI
	private static LogicaQR instance = null;

	public static synchronized LogicaQR getInstance() {
		if (instance == null) {
			instance = new LogicaQR();
		}
		return instance;
	}

	private LogicaQR() {
	}
	// PATRON SINGLETON FIN

	public String GrabarCodeQr(Codeqr qr) {
		String imagenQr = null;
		HojaTramiteService serv = new HojaTramiteServiceImpl();
		int id = serv.GrabarIdQR(qr);
		if (id > 0) {
			try {
				imagenQr = generateQR(String.valueOf(id), 300, 300);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return imagenQr;
	}

	private String generateQR(String id_Qr, int h, int w) throws Exception {
		String codeB64 = null;
		byte[] bytes;
		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix matrix = writer.encode(id_Qr, com.google.zxing.BarcodeFormat.QR_CODE, w, h);
		BufferedImage image = new BufferedImage(matrix.getWidth(), matrix.getHeight(), BufferedImage.TYPE_INT_RGB);
		image.createGraphics();
		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrix.getWidth(), matrix.getHeight());
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrix.getWidth(); i++) {
			for (int j = 0; j < matrix.getHeight(); j++) {
				if (matrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}

		try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
            ImageIO.write(image, "png", out);
			bytes= out.toByteArray();
			Codeqr qr = new Codeqr();
			qr.setId_codigoQr(Integer.parseInt(id_Qr));
			qr.setCodeQr(bytes);
			HojaTramiteService serv = new HojaTramiteServiceImpl();
			serv.GrabarImagenQR(qr);
			Base64.Encoder code = Base64.getEncoder();
			codeB64 = code.encodeToString(bytes);	
        }catch (Exception e) {
			System.out.println("Error en QR");
		}
		return codeB64;
	}

}
