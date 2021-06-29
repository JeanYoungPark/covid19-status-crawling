package com.jeanyoung.covid19status.controllers;

import com.jeanyoung.covid19status.models.KoreaStatus;
import com.jeanyoung.covid19status.services.CovidDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {
    private final CovidDataService covidDataService;

    @GetMapping("/")
    public String covid(Model model) throws IOException {
        List<KoreaStatus> lists = covidDataService.getDatas();
        model.addAttribute("info",lists);
        return "covid";
    }
}
