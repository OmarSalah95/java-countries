package com.countries.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryController
{
	@GetMapping(value = "/all", produces = {"application/json"})
	public ResponseEntity<?> getAllCountriesSorted()
	{
		CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
	}

	@GetMapping(value = "/start/{letter}", produces = {"application/json"})
	public ResponseEntity<?> getFilteredCountries(@PathVariable Character letter)
	{
		ArrayList<Country> rtnList = CountriesApplication.ourCountryList.findCountries(e -> e.getName().toUpperCase().startsWith(letter.toString().toUpperCase()));
		rtnList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(rtnList, HttpStatus.OK);
	}

	@GetMapping(value = "/size/{testLength}", produces = {"application/json"})
	public ResponseEntity<?> getFilteredCountriesByNameLength(@PathVariable int testLength)
	{
		ArrayList<Country> rtnList = CountriesApplication.ourCountryList.findCountries(e -> e.getName().length() <= testLength);
		rtnList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(rtnList, HttpStatus.OK);
	}
}
