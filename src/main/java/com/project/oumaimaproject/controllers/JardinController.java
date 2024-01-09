package com.project.oumaimaproject.controllers;

import com.project.oumaimaproject.model.Departement;
import com.project.oumaimaproject.model.Jardin;
import com.project.oumaimaproject.model.Lieu;
import com.project.oumaimaproject.repositories.DepartementRepository;
import com.project.oumaimaproject.repositories.JardinRepository;
import com.project.oumaimaproject.repositories.LieuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class JardinController {

    LieuRepository lieuRepository ;
    JardinRepository jardinRepository ;

    @GetMapping("/user/jardins")
    public String jardins(Model model, @RequestParam(name="keyword",defaultValue = "") String keyword) {
        List<Jardin> jardins = jardinRepository.findJardinByNomDuJardinContaining(keyword) ;
        model.addAttribute("jardins",jardins) ;
        return "jardins" ;
    }



    @GetMapping("/admin/deleteJardin")
    public String deleteJardin(Long id) {
        jardinRepository.deleteById(id);
        return "redirect:/user/jardins";
    }

    @GetMapping("/admin/formJardin")
    public String formJardin(Model model, Jardin jardin) {
        jardin = new Jardin() ;
        List<Lieu> lieux = lieuRepository.findAll() ;
        model.addAttribute("jardin",jardin) ;
        model.addAttribute("lieux",lieux) ;
        return "formJardin" ;
    }



    @PostMapping("/admin/saveJardin")
    public String saveJardin(Jardin jardin){
        jardinRepository.save(jardin) ;
        return "redirect:/user/jardins?keyword="+jardin.getNomDuJardin();

    }
    @GetMapping("/admin/editJardin")
    public String editJardin(Model model, @RequestParam(name = "id") Long id){
        Jardin jardin = jardinRepository.findById(id).get() ;
        List<Lieu> lieux = lieuRepository.findAll() ;
        model.addAttribute("jardin",jardin) ;
        model.addAttribute("lieux",lieux) ;
        return "editJardin" ;

    }
}
