package dev.saha.qrcodepractice.controller;

import dev.saha.qrcodepractice.service.QRCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class MainController {

    private  final QRCodeService qrCodeService;

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";

    @GetMapping("/")
    public String getQRCode(Model model){
        qrCodeService.getQRCode(model,QR_CODE_IMAGE_PATH);
        return "qrcode";

    }
}