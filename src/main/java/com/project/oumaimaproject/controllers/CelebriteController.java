package com.project.oumaimaproject.controllers;

import com.project.oumaimaproject.model.Celebrite;
import com.project.oumaimaproject.repositories.CelebriteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class CelebriteController {

    private CelebriteRepository celebriteRepository ;


    @GetMapping("/user/celebrites")
    public String celebrites(Model model, @RequestParam(name="keyword",defaultValue = "") String keyword) {
        List<Celebrite> celebrites = celebriteRepository.findByNomContainingOrPrenomContaining(keyword,keyword) ;
        model.addAttribute("celebrites",celebrites) ;
        return "celebrites" ;
    }



    @GetMapping("/admin/deleteCelebrite")
    public String deleteCelebrite(String id) {
        celebriteRepository.deleteById(id);
        return "redirect:/user/celebrites";
    }

    @GetMapping("/admin/formCelebrites")
    public String formCelebrite(Model model, Celebrite celebrite) {
        celebrite = new Celebrite() ;
        model.addAttribute("celebrite",celebrite) ;
        return "formCelebrites" ;
    }



    @PostMapping("/admin/saveCelebrite")
    public String saveCelebrite(Celebrite celebrite){
        celebriteRepository.save(celebrite) ;
        return "redirect:/user/celebrites?keyword="+celebrite.getNom();

    }
    @GetMapping("/admin/editCelebrite")
    public String editCelebrite(Model model, @RequestParam(name = "id") String id){
        Celebrite celebrite = celebriteRepository.findById(id).get() ;
        model.addAttribute("celebrite", celebrite) ;
        return "editcelebrite" ;

    }





}
