package dev.saha.qrcodepractice.service;

import com.google.zxing.WriterException;
import dev.saha.qrcodepractice.config.QRCodeGenerator;
import dev.saha.qrcodepractice.model.QRCode;
import dev.saha.qrcodepractice.service.QRCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.Base64;

@Service
@Slf4j
public class QRCodeServiceImpl implements QRCodeService {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";



    @Override
    public void downloadQRCodeImage(QRCode code) {
        try {
            QRCodeGenerator.generateQRCodeImage(code.getContent(),
                    code.getWidth(),code.getHeight(),code.getPath());
        } catch (WriterException | IOException e) {
            log.error("Exception occurred in QR CODE Image generation {}", e.getMessage());
        }

    }

    @Override
    public void getQRCode(Model model, String qrCodeImagePath) {
        String medium="Practice";
        String github="https://github.com/chukwudozie";

        byte[] image = new byte[0];
        try {

            // Generate and Return Qr Code in Byte Array
            image = QRCodeGenerator.getQRCodeImage(medium,170,170);

            // Generate and Save Qr Code Image in static/image folder
            QRCodeGenerator.generateQRCodeImage(github,170,170,QR_CODE_IMAGE_PATH);

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        String qrcode = Base64.getEncoder().encodeToString(image);

        model.addAttribute("medium",medium);
        model.addAttribute("github",github);
        model.addAttribute("qrcode",qrcode);
    }
}
