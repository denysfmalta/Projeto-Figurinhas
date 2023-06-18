package br.com.dsm.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dsm.projeto.model.StickerInputs;
import br.com.dsm.projeto.StickerGenerator;

@Controller
@RequestMapping("/sticker-generator")
public class StickerController {
private final StickerGenerator stickerGenerator;
public StickerController(StickerGenerator stickerGenerator) {
    this.stickerGenerator = stickerGenerator;
}

@GetMapping
public ModelAndView showStickerGeneratorPage() {
    ModelAndView modelAndView = new ModelAndView("sticker-generator");
    modelAndView.addObject("stickerInputs", new StickerInputs());
    return modelAndView;
}

@PostMapping
public ModelAndView generateSticker(StickerInputs stickerInputs) {
    stickerGenerator.generateSticker(stickerInputs.getUrl(), stickerInputs.getMessage(), stickerInputs.getFileName() + ".png");
    return new ModelAndView("redirect:/sticker-generator");
}
}