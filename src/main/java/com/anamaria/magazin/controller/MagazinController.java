package com.anamaria.magazin.controller;

import com.anamaria.magazin.repository.ProduseRepository;
import com.anamaria.magazin.services.ProduseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Float.parseFloat;


@RestController
@CrossOrigin
public class MagazinController {


	@Autowired
	ProduseServices produseServices;

	// pentru accesarea adresei /
	@GetMapping("/")
	public Object home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("layout.html");
		modelAndView.addObject("produse", produseServices.findAll());
		return modelAndView;
	}

	// pentru procesarea cererii de adaugare pe adresa /adauga
	@RequestMapping(value = "/adauga", method = RequestMethod.POST, consumes="application/json")
	public Object adaugaProdus(@RequestBody Map<String, Object> payload) {
		String denumire = payload.get("denumire").toString();
		int cantitate = (int) payload.get("cantitate");
		String pret_d = (String) payload.get("pret");
		float pret = parseFloat(pret_d);

		produseServices.adaugaProdus(denumire, cantitate, pret);

		Map<String, Object> object = new HashMap<>();
		object.put("status", true);
		object.put("message", "Produsul a fost adaugat cu succes");
		return object;
	}
	// pentru procesarea cererii de editare prin adresa /edit
	@RequestMapping(value = "/edit", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public Object editareProdus(@RequestBody Map<String, Object> payload) {
		String denumire = payload.get("denumire").toString();
		int cantitate = (int) payload.get("cantitate");
		Double pret_d = (Double) payload.get("pret");
		float pret = pret_d.floatValue();;
		long id = (int) payload.get("id");

		produseServices.updateProdus((int) id, denumire, cantitate, pret);

		Map<String, Object> object = new HashMap<>();
		object.put("status", true);
		object.put("message", "Produsul a fost actualizat cu succes");
		return object;
	}

	// pentru procesarea cererii de stergere prin adresa /delete
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public Object stergereProdus(@RequestBody Map<String, Object> payload) {
		int id = (int) payload.get("id");
		produseServices.deleteProdus(id);

		Map<String, Object> object = new HashMap<>();
		object.put("status", true);
		object.put("message", "Produsul a fost eliminat cu succes");
		return object;
	}
}
