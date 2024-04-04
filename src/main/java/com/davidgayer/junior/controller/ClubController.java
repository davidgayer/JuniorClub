package com.davidgayer.junior.controller;

import com.davidgayer.junior.service.ClubService;

import jakarta.validation.Valid;

import com.davidgayer.junior.dto.ClubDto;
import com.davidgayer.junior.dto.EventDto;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/clubs")
public class ClubController {

    private final ClubService clubService;

    @GetMapping()
    public String listOfClubs(Model model) {
        List<ClubDto> clubsDto = clubService.findAllClubs();
        model.addAttribute("clubs", clubsDto);
        return "clubs/clubs-list";
    }

    @GetMapping("/{clubId}/detail")
    public String clubDetail(@PathVariable("clubId") Long clubId, Model model) {
        ClubDto clubDto = clubService.getClubDetail(clubId);
        List<EventDto> clubEvents = clubService.findAllClubEvents(clubId);
        model.addAttribute("club", clubDto);
        model.addAttribute("clubEvents", clubEvents);
        return "clubs/clubs-detail";
    }

    @GetMapping("/search")
    public String searchClub(@RequestParam("query") String query, Model model) {
        List<ClubDto> clubsDto = clubService.searchClub(query);
        model.addAttribute("clubs", clubsDto);
        return "clubs/clubs-list";
    }

    @GetMapping("/new")
    public String createClubForm(Model model) {
        ClubDto clubDto = new ClubDto();
        model.addAttribute("club", clubDto);
        return "clubs/clubs-create";
    }

    @PostMapping("/saveClub")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto, 
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clubs/clubs-create";
        }
        clubService.saveNewClub(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("/{clubId}/edit")
    public String editClubForm(Model model, @PathVariable Long clubId) {
        ClubDto clubDto = clubService.getClubDetail(clubId);
        model.addAttribute("club", clubDto);
        return "clubs/clubs-edit";
    }

    @PostMapping("/{clubId}/edit")
    public String postMethodName(@PathVariable Long clubId, 
                                 @Valid @ModelAttribute("club") ClubDto clubDto,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clubs/clubs-edit";
        }
        clubDto.setId(clubId);
        clubService.saveEditedClub(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("/{clubId}/delete")
    public String deleteClub(@PathVariable Long clubId) {
        clubService.deleteClubById(clubId);
        return "redirect:/clubs";
    }
    

}
