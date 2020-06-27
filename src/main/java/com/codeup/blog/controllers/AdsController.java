package com.codeup.blog.controllers;

import com.codeup.blog.daos.AdsRepository;
import com.codeup.blog.models.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdsController {

    //dependency injection

    private AdsRepository adsDao;

    public AdsController(AdsRepository adsRepository) {
        adsDao = adsRepository;
    }

    @GetMapping("/ads")
    public String index(Model model) {

        Ad firstAds = adsDao.findFirstByTitle("psvista");
        List<Ad> adsList = adsDao.findAll();
        model.addAttribute("noAdsFound", adsList.size() == 0);
        model.addAttribute("ads", adsList);
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    @ResponseBody
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("adId", id);
        model.addAttribute("ad", new Ad("PS1", "Used"));
        return "/ads/show";
    }

    @GetMapping("/ads/create")
    @ResponseBody
    public String showForm() {
        return "view the form for creating an ad";
    }

    @PostMapping("/ads/create")
    @ResponseBody
    public String save() {
        Ad newAd = new Ad("XBOX X","brand new");
        adsDao.save(newAd);
        return "create a new ad";
    }

    @GetMapping("/ads/{id}/edit")
    public String showEditForm(Model model, @PathVariable long id) {
        //find an ad
        Ad adToEdit = adsDao.getOne(id);
        model.addAttribute("ad", adToEdit);
        return "ads/edit";
    }

    @PostMapping("/ads/{id}/edit")
    @ResponseBody
    public String update(@PathVariable long id,
                         @RequestParam(name = "title") String title, @RequestParam(name = "description") String desc) {
        //find an ad
        Ad foundAd = adsDao.getOne(id); // i.e. select * from ads where id = ?
        //edit the ad
        foundAd.setTitle(title);
        foundAd.setDescription(desc);
        //save changes
        adsDao.save(foundAd); // i.e. update ads set title = ? where id = ?
        return "ad updated";
    }

    @PostMapping("/ads/{id}/delete")
    @ResponseBody
    public String destroy(@PathVariable long id){
        adsDao.deleteById(id);
        return "ad deleted";
    }

    @GetMapping("/search")
    public String searchResults(Model model, @RequestParam(name = "term") String term){
        List<Ad> ads = adsDao.searchByTitle(term);
        model.addAttribute("ads", ads);
        return "ads/index";
    }
}
