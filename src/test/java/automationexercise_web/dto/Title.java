package automationexercise_web.dto;

import lombok.Getter;

public enum Title {
    Mr("Mr."),
    Mrs("Mrs.");
    @Getter
    private String name;
    Title(String name){
        this.name=name;
    }
    
}