package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

	/*
     * 1. 入力画面（contactFormView.html）を表示する
     */
	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("contactForm", new ContactForm());
		return "contactFormView";
	}
	
	/*
     * 2. 送信されたデータを受け取り、確認画面（confirmView.html）を表示する
     */
	@PostMapping("/form")
	public String confirm(@Validated ContactForm contactForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "contactFormView";
		}
			
		return "confirmView";
	}


}
