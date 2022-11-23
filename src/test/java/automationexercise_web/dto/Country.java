package automationexercise_web.dto;

import lombok.Getter;

public enum Country {
  
  United_States("United States"),
  India("India"),
  Canada("Canada"),
  Australia("Australia"),
  Israel("Israel"),
  New_Zealand("New Zealand"),
  Singapore("Singapore");
  @Getter
    private final String name;
  Country(String name){
    this.name=name;
  }
  
}