package org.example.semiproject.gallery.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.example.semiproject.gallery.service.GalleryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/gallery")
public class GalleryController {

    private final GalleryService galleryService;

    @Value("${recaptcha_sitekey}")
    private String sitekey;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("gals", galleryService.readGallery());

        return "gallery/list";
    }

    @GetMapping("/view/{ggno}")
    public String view(Model model, @PathVariable int ggno) {
        model.addAttribute("gal", galleryService.readOneGallery(ggno));
        model.addAttribute("galimgs", galleryService.readOneGalleryImg(ggno));

        return "gallery/view";
    }

    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("sitekey", sitekey);

        return "gallery/write";
    }

}