package com.project.oumaimaproject.controllers;

import com.project.oumaimaproject.model.Celebrite;
import com.project.oumaimaproject.model.Lieu;
import com.project.oumaimaproject.model.Monument;
import com.project.oumaimaproject.repositories.LieuRepository;
import com.project.oumaimaproject.repositories.MonumentRepository;
import com.project.oumaimaproject.security.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class MonumentController {

    private MonumentRepository monumentRepository ;
    private LieuRepository lieuRepository ;
    private AccountService accountService ;

    @GetMapping("/signin")
    public String login(){
        return "login" ;
    }
    @GetMapping("/acceuil")
    public String index() {
        return "Acceuil" ;
    }

    @PostMapping("/signup")
    public String signup(String username, String password, String confirmPWD){
        accountService.addNewUser(username,password,confirmPWD) ;
        return "redirect:/login" ;
    }
    @GetMapping("/user/monuments")
    public String monuments(Model model, @RequestParam(name="page",defaultValue = "0") int p , @RequestParam(name="size",defaultValue = "4") int s , @RequestParam(name="keyword",defaultValue = "") String keyword ) {
        Page<Monument> monuments = monumentRepository.findByNomContains(keyword,PageRequest.of(p,s)) ;
        model.addAttribute("pages", new int[monuments.getTotalPages()] ) ;
        model.addAttribute("monuments",monuments.getContent()) ;
        model.addAttribute("currentPage",p);
        model.addAttribute("keyword",keyword) ;
        return "monuments" ;
    }



    @GetMapping("/admin/delete")
    public String delete(String id, String keyword, int page) {
        monumentRepository.deleteById(id);
        return "redirect:/user/monuments?page="+page+"&keyword="+keyword ;
    }

    @GetMapping("/admin/formMonuments")
    public String formMonument(Model model) {
        List<Lieu> lieux = lieuRepository.findAll() ;
        model.addAttribute("lieux", lieux);
        return "formMonuments" ;
    }



    @PostMapping("/admin/saveMonument")
    public String saveMonumrnt(Monument monument){
        monumentRepository.save(monument) ;
        return "redirect:/user/monuments?keyword="+monument.getNom();

    }
    @GetMapping("/admin/editmonument")
    public String edit(Model model, @RequestParam(name = "id") String id){
        Monument monument = monumentRepository.findById(id).get() ;
        List<Lieu> lieux = lieuRepository.findAll() ;
        model.addAttribute("monument", monument) ;
        model.addAttribute("lieux", lieux);
        return "editmonument" ;

    }

    @GetMapping("/user/monument/celebrities")
    public List<Celebrite> monumCelebrites(String id) {
        List<Celebrite> celebrites = monumentRepository.findCelebritiesByMonumentGeohash(id) ;
        return celebrites ;


    }


}
