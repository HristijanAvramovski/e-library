package com.example.demo.model.enumeration;

public enum Category {

   THRILER ("THRILER"),
   HISTORY ("HISTORY"),
   FANTASY ("FANTASY"),
   BIOGRAPHY ("BIOGRAPHY"),
   CLASSICS ("CLASSICS"),
   DRAMA ("DRAMA"),
   NOVEL ("NOVEL");
   private final String category;

   Category (String category){

      this.category = category;

   }

   public String getCategory() {

      return this.category;
   }
}

