package br.com.dsm.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dsm.projeto.model.StickerInputs;
import br.com.dsm.projeto.StickersGerator;

@Controller
@RequestMapping("/stickers-gerator")

public class AppController {
    private final StickersGerator stickersGerator;

    public AppController(StickersGerator stickersGerator) {
        this.stickersGerator = stickersGerator;
    }

    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("stickers-gerator");
        modelAndView.addObject("sticker", new StickerInputs());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView gerate(StickerInputs sticker) {
        stickersGerator.generateStickers(sticker.getUrl(), sticker.getMessage(), sticker.getFileName() + ".png");
        return new ModelAndView("redirect:/stickers-gerator");
    }
}
