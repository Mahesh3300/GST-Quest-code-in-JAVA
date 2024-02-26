package com.gst.invoice.service;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class GstInvoiceQRCodeGenaratorService {
	public static void main(String[] args) throws WriterException, IOException {
		String qrCodeText = "SellerGstin: 29AEGPG1699M000,\r\n" + 
				"BuyerGstin: 28AAACG0569P1Z3,\r\n" + 
				"DocNo: 50596,\r\n" + 
				"DocTyp: INV,\r\n" + 
				"DocDt: 2019-05-12,\r\n" + 
				"TotInvVal: 630,\r\n" + 
				"ItemCnt: 2,\r\n" + 
				"MainHsnCode: 1001,\r\n" + 
				"Irn: 197859555ac2437a21e84dd054d5dd0be36ffedc0db197c69f6ab33167063ae9";
		
		qrCodeText="eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNyc2Etc2hhMjU2Iiwia2lkIjoiRTc4MDhFNkZGMDNFMTMyODUzMzBCMDQxQjN FMEEzQUVDNDc4MTMyMCIsInR5cCI6IkpXVCIsIng1dCI6IjU0Q09iX0EtRXloVE1MQkJzLUNqcnNSNEV5QSJ9.eyJkYXRhIjoie1wiU2VsbGVyR3N0aW5cIjpcIjI5QUFHUEI4Njc4TDFaMVwiLFwi QnV5ZXJHc3RpblwiOlwiMjlBQUdQQjg2NzhMMVoxXCIsXCJEb2NOb1wiOlwiZG9jL3Rlc3QxXCIsXCJEb2NUeXBcIjpcIklOVlwiLFwiRG9jRHRcIjpcIjIwMTktMTEtMjhcIixcIlRvdEludlZhbF wiOjAsXCJJdGVtQ250XCI6MSxcIk1haW5Ic25Db2RlXCI6XCIxMDAxXCIsXCJJcm5cIjpcImQwNTZhNTdjYzdjZmNjNmM5MjMwYWEwMDE0ZTQzOTI1OWQwZGM1N2NmYTRlZWEyMzI2MjUzMDExZmQ1 M2VhN2VcIn0iLCJpc3MiOiJOSUMifQ.UbnWZAI_lq9s9JK8_MovcmjpMPIJnv2-4qGkiXegggQbry_0fJxjwaR8fwCjK_-HVeMujnw8C7F3ITrxKIg5RsdDMzAvLrCNE0K3QkNHGczbvyxhJ02VRFl 1wrQoArxSW1RiyGssLSbH_4tdQ6vke0nSUajXRXvXX2yUeI01CyLsbf2FDNIq46MrDmka5RPNGp0dCx4uX2gkmsCx0Yb0CKjqFI176sTbxOQDHQtRCAfJ0I6dwwggVkfnC3p2F-x6GhEls_7GVsFg1 Z6k4A_aB89c3N6CaWfe8DOQEJTjWaPggMUa2-1hDE1ODTBcIlLcOwB-8jT971hZWgtBubUzFg";
		String filePath = "JD.png";
		int size = 125;
		String fileType = "png";
		File qrFile = new File(filePath);
		createQRImage(qrFile, qrCodeText, size, fileType);
		System.out.println("DONE");
	}

	public static void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
			throws WriterException, IOException {
		// Create the ByteMatrix for the QR-Code that encodes the given String
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}
	private static byte[] appKey=null;
	public static byte[] createAESKey() {
		   appKey = null;
		      try {
		          KeyGenerator gen = KeyGenerator.getInstance("AES");
		          gen.init(256);
		          SecretKey secret = gen.generateKey();
		          appKey = secret.getEncoded();
		          } catch (NoSuchAlgorithmException ex) {
		          //Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
		        }
		    return appKey;
		 } 
}
