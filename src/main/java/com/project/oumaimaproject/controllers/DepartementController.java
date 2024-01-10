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
public class DepartementController {

    DepartementRepository departementRepository  ;
    LieuRepository lieuRepository ;

    @GetMapping("/user/departements")
    public String departements(Model model, @RequestParam(name="keyword",defaultValue = "") String keyword) {
        List<Departement> departements = departementRepository.findByNomDepContaining(keyword) ;
        model.addAttribute("departements",departements) ;
        return "departements" ;
    }



    @GetMapping("/admin/deleteDept")
    public String deleteDept(String id) {
        departementRepository.deleteById(id);
        return "redirect:/user/departements";
    }

    @GetMapping("/admin/formDept")
    public String formDept(Model model, Departement dept) {
        dept = new Departement() ;
        dept.setDep(UUID.randomUUID().toString().substring(0,5)) ;
        List<Lieu> lieux = lieuRepository.findAll() ;
        model.addAttribute("departement",dept) ;
        model.addAttribute("lieux",lieux) ;
        return "formDept" ;
    }



    @PostMapping("/admin/saveDept")
    public String saveDept(Departement departement){
        departementRepository.save(departement) ;
        return "redirect:/user/departements?keyword="+departement.getNomDep();

    }
    @GetMapping("/admin/editDept")
    public String editDept(Model model, @RequestParam(name = "id") String id){
        Departement dept = departementRepository.findById(id).get() ;
        List<Lieu> lieux = lieuRepository.findAll() ;
        System.out.println(lieux.get(0).getNomCom());
        model.addAttribute("departement",dept) ;
        model.addAttribute("lieux",lieux) ;
        return "editdept" ;

    }






}
