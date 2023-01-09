package dev.saha.qrcodepractice.service;

import dev.saha.qrcodepractice.model.QRCode;
import org.springframework.ui.Model;

public interface QRCodeService {
    void downloadQRCodeImage(QRCode code);

    void getQRCode(Model model, String qrCodeImagePath);
    
    Optional<String> generateQRCodeByte(String content, int width, int height);
}
