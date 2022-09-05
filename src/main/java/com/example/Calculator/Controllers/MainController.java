package com.example.Calculator.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @GetMapping("/")
    public String Home() {
        return "home";
    }

    @GetMapping("/result")
    public  String GetResult(
            @RequestParam(value = "number1")double number1,
            @RequestParam(value = "number2")double number2,
            @RequestParam("sign") String sign,
            Model model) {
          double result = switch (sign) {
              case "+" -> number1 + number2;
              case "-" -> number1 - number2;
              case "*" -> number1 * number2;
              case "/" -> number1 / number2;
              default -> 0;
          };
        model.addAttribute("result", result);
        return "result";
    }

    @PostMapping("/result")
    public  String PostResult(
            @RequestParam(value = "number1")double number1,
            @RequestParam(value = "number2")double number2,
            @RequestParam("sign") String sign,
            Model model)
    {
        double result = switch (sign) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            case "/" -> number1 / number2;
            default -> 0;
        };
        model.addAttribute("result", result);
        return "result";
    }


}
