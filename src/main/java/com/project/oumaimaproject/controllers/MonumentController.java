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

    private static final double EARTH_RADIUS = 6371 ;

    private MonumentRepository monumentRepository ;
    private LieuRepository lieuRepository ;
    private AccountService accountService ;
//
//    @GetMapping("/signin")
//    public String login(){
//        return "login" ;
//    }
    @GetMapping("/")
    public String index() {
        return "Acceuil" ;
    }
//
//    @PostMapping("/signup")
//    public String signup(String username, String password, String confirmPWD){
//        accountService.addNewUser(username,password,confirmPWD) ;
//        return "redirect:/login" ;
//    }
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
    public String saveMonument(Monument monument){
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

    @GetMapping("/user/calculerDistance")
    public String calculer(Model model){
        List<Monument> monuments = monumentRepository.findAll() ;
        model.addAttribute("monuments", monuments);
        return  "calculerDistance" ;

    }

    @PostMapping("/user/calculerDistance")
    public String calculerDistane(Model model, String id1, String id2){
        System.out.println(id1);
        List<Monument> monuments = monumentRepository.findAll() ;
        Monument monument1 = monumentRepository.findById(id1).get() ;
        Monument monument2 = monumentRepository.findById(id2).get() ;
        double distance = 0 ;
        double dLat = Math.toRadians(monument2.getLatitude() - monument1.getLatitude());
        double dLon = Math.toRadians(monument2.getLongitude() - monument1.getLongitude());

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(monument1.getLatitude())) * Math.cos(Math.toRadians(monument2.getLatitude())) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        distance = EARTH_RADIUS * c;
        model.addAttribute("distance",Math.round(distance*1000)+" m");
        model.addAttribute("m1",monument1) ;
        model.addAttribute("m2",monument2) ;
        model.addAttribute("monuments", monuments);
        return  "calculerDistance" ;

    }

}
