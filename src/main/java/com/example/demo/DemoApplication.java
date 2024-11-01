package com.example.demo;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import static java.lang.Integer.parseInt;

@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "pokemonNb", defaultValue = "0") String pokemonNb) {
        String pokemon = OuvrirJSONPokemon(pokemonNb);
        return String.format("Hello %s!", pokemon);
    }

    public static String OuvrirJSONPokemon(String pknb){
        try {
            int i = parseInt(pknb);
            FileReader pokeFile = new FileReader("assets/pokedexgenonecards.json");
            Object pokeObject = new JSONParser().parse(pokeFile); //pokeObject returns an Object : [{allPokémons}] due to .parse() from json.simple library
            JSONArray pokeJSONArray = (JSONArray) pokeObject; //returns an JSONArray from the parsed file typed Object : [{allPokémons}]
            Object thePokemonStats = pokeJSONArray.get(i); // returns the object at the index i
            return thePokemonStats.toString(); //returns information of the Pokémon at id : i in string format
        } catch (FileNotFoundException e) { //Exception threw by FileReader
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) { //Exception threw by .parse()
            System.err.println("I/O error occurred: " + e.getMessage());
        } catch (ParseException e) { //Exception threw by .parse()
            System.err.println("Parsing error: " + e.getMessage());
        }
        return null;
    }
}
//Coded with passion & love By Elodie GUYARD

