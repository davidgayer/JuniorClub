package com.davidgayer.junior.controller;

import com.davidgayer.junior.service.ClubService;

import com.davidgayer.junior.dto.ClubDto;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/clubs")
public class ClubController {

    private final ClubService clubService;

    @GetMapping()
    public String ListOfClubs(Model model) {
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/new")
    public String createClubForm(Model model) {
        ClubDto clubDto = new ClubDto();
        model.addAttribute("club", clubDto);
        return "clubs-create";

    }
    

    
}
