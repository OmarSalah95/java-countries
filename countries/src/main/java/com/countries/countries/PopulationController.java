package com.countries.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{
	@GetMapping(value = "/{testPopulation}", produces = {"application/json"})
	public ResponseEntity<?> getFilteredCountriesByMaxPopulatiodn(@PathVariable long testPopulation)
	{
		ArrayList<Country> maxList = CountriesApplication.ourCountryList.countryList;
		maxList.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));
		if (testPopulation > 999999999)
			{
			return new ResponseEntity<>(maxList.get(0), HttpStatus.OK);
			}
		ArrayList<Country> rtnList = CountriesApplication.ourCountryList.findCountries(e -> e.getPopulation() >= testPopulation);
		rtnList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(rtnList, HttpStatus.OK);
	}

	@GetMapping(value = "/min", produces = {"application/json"})
	public ResponseEntity<?> getFilteredCountriesByMinPopulation()
	{
		ArrayList<Country> rtnList = CountriesApplication.ourCountryList.countryList;
		rtnList.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
		return new ResponseEntity<>(rtnList.get(0), HttpStatus.OK);
	}

	@GetMapping(value = "/max", produces = {"application/json"})
	public ResponseEntity<?> getFilteredCountriesByMaxPopulation()
	{
		ArrayList<Country> rtnList = CountriesApplication.ourCountryList.countryList;
		rtnList.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));
		return new ResponseEntity<>(rtnList.get(0), HttpStatus.OK);
	}
}

