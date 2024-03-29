package se.emanuel.guessnumber;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//Emanuel sleyman
// 2024-03-16
@Controller
public class GuessNnumberController {

    @Autowired
    GuessNumberService service;


    @GetMapping("/welcome")
    public String resetGame(Model model) {
        service.resetGame();
        model.addAttribute("welcome"," ");
        return "resultpage";
    }

    @PostMapping("/guess")
    public String guessN(@RequestParam(name = "guessnumber") int guess, Model m) {
        String result =  service.guessNumber(guess);
        m.addAttribute("answer",result);
        return "resultpage";
    }


}
