package com.biradar.sidagond.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.biradar.sidagond.model.Holiday;

@Controller
public class HolidayController {
	/*
	 * @GetMapping("/holidays") public String
	 * displayHolidaysPage(@RequestParam(required = false)boolean festival,
	 * 
	 * @RequestParam(required = false)boolean federal, Model model) {
	 * 
	 * model.addAttribute("festival",festival);
	 * model.addAttribute("federal",federal);
	 * 
	 * List<Holiday> holidayList = Arrays.asList(new Holiday("Jan 14",
	 * "Makara Sankranthi", Holiday.Type.FESTIVAL), new Holiday("Feb 12",
	 * "Shivarathri", Holiday.Type.FESTIVAL), new Holiday("March 18", "Ugadi",
	 * Holiday.Type.FESTIVAL), new Holiday("May 1", "Labours Day",
	 * Holiday.Type.FEDERAL), new Holiday("Aug 15", "Independence Day",
	 * Holiday.Type.FEDERAL), new Holiday("Oct 2", "Gandhi Jayanthi",
	 * Holiday.Type.FEDERAL), new Holiday("Nov 8", "Deepavali",
	 * Holiday.Type.FESTIVAL), new Holiday("Dec 25", "Christmas",
	 * Holiday.Type.FESTIVAL));
	 * 
	 * Holiday.Type[] types = Holiday.Type.values(); for (Holiday.Type type : types)
	 * { model.addAttribute(type.toString(), (holidayList.stream().filter(holiday ->
	 * holiday.getType().equals(type)) .collect(Collectors.toList()))); }
	 * 
	 * 
	 * return "holidays.html"; }
	 * 
	 */

	@GetMapping("/holidays/{holidayType}")
	public String displayHolidaysPage(@PathVariable String holidayType, Model model) {

		if (holidayType != null && holidayType.equalsIgnoreCase("all")) {
			model.addAttribute("festival", true);
			model.addAttribute("federal", true);
		}else if(holidayType != null && holidayType.equalsIgnoreCase("festival")) {
			model.addAttribute("festival",true);
		}else if(holidayType != null && holidayType.equalsIgnoreCase("federal")) {
			model.addAttribute("federal",true);
		}

		List<Holiday> holidayList = Arrays.asList(new Holiday("Jan 14", "Makara Sankranthi", Holiday.Type.FESTIVAL),
				new Holiday("Feb 12", "Shivarathri", Holiday.Type.FESTIVAL),
				new Holiday("March 18", "Ugadi", Holiday.Type.FESTIVAL),
				new Holiday("May 1", "Labours Day", Holiday.Type.FEDERAL),
				new Holiday("Aug 15", "Independence Day", Holiday.Type.FEDERAL),
				new Holiday("Oct 2", "Gandhi Jayanthi", Holiday.Type.FEDERAL),
				new Holiday("Nov 8", "Deepavali", Holiday.Type.FESTIVAL),
				new Holiday("Dec 25", "Christmas", Holiday.Type.FESTIVAL));

		Holiday.Type[] types = Holiday.Type.values();
		for (Holiday.Type type : types) {
			model.addAttribute(type.toString(), (holidayList.stream().filter(holiday -> holiday.getType().equals(type))
					.collect(Collectors.toList())));
		}

		return "holidays.html";
	}
}
