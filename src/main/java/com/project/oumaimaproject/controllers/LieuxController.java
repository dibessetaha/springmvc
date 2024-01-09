package com.project.oumaimaproject.controllers;

import com.project.oumaimaproject.model.Celebrite;
import com.project.oumaimaproject.model.Departement;
import com.project.oumaimaproject.model.Lieu;
import com.project.oumaimaproject.model.Monument;
import com.project.oumaimaproject.repositories.DepartementRepository;
import com.project.oumaimaproject.repositories.LieuRepository;
import com.project.oumaimaproject.repositories.MonumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class LieuxController {

    DepartementRepository departementRepository  ;
    LieuRepository lieuRepository ;

    @GetMapping("/user/lieux")
    public String lieux(Model model, @RequestParam(name="keyword",defaultValue = "") String keyword) {
        List<Lieu> lieux = lieuRepository.findByNomComContainingOrCodeInseeContaining(keyword,keyword) ;
        model.addAttribute("lieux",lieux) ;
        model.addAttribute("keyword",keyword) ;
        return "lieux" ;
    }



    @GetMapping("/admin/deleteLieu")
    public String deleteLieu(String id, String keyword) {
        lieuRepository.deleteById(id);
        return "redirect:/user/lieux?keyword="+keyword;
    }

    @GetMapping("/admin/formLieu")
    public String formLieu(Model model, Lieu lieu) {
        lieu = new Lieu() ;
        lieu.setCodeInsee(UUID.randomUUID().toString().substring(0,5)); ;
        List<Departement> departements = departementRepository.findAll() ;
        model.addAttribute("departements",departements) ;
        model.addAttribute("lieu",lieu) ;
        return "formLieux" ;
    }



    @PostMapping("/admin/saveLieu")
    public String saveLieu(Lieu lieu){
        lieuRepository.save(lieu) ;
        return "redirect:/user/lieux?keyword="+lieu.getNomCom();

    }
    @GetMapping("/admin/editLieu")
    public String editDept(Model model, @RequestParam(name = "id") String id){
        Lieu lieu = lieuRepository.findById(id).get() ;
        List<Departement> depts = departementRepository.findAll() ;
        model.addAttribute("lieu",lieu) ;
        model.addAttribute("departements",depts) ;
        return "editlieu" ;

    }



}
