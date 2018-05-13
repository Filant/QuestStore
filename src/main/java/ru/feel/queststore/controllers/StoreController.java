
package ru.feel.queststore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.feel.queststore.model.Store;
import ru.feel.queststore.service.StoreService;

/**
 *
 * @author Anton
 */
@Controller("/store")
public class StoreController {
	
	private StoreService storeService;
	
	@Autowired(required = true)
	@Qualifier(value = "storeService")
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	
	@RequestMapping(value = "/stores/add", method = RequestMethod.POST)
	public String addStore(@ModelAttribute("store") Store store){
		if(store.getId() == 0){
			this.storeService.addStore(store);
		}else{
			this.storeService.updateStore(store);
		}
		return "redirect:/stores";
	}
	
	@RequestMapping("/removeStore/{id}")
	public String removeStore(@PathVariable("id") int id){
		this.storeService.removeStore(id);
		
		return "redirect:/stores";
	}
	
	@RequestMapping("editStore/{id}")
	public String editStore(@PathVariable("id") int id, Model model){
		model.addAttribute("store", this.storeService.getStoreById(id));
		model.addAttribute("listStore", this.storeService.listStore());
		
		return "stores";
	}
	
	@RequestMapping("storedata/{id}")
	public String storeData(@PathVariable("id") int id, Model model){
		model.addAttribute("store", this.storeService.getStoreById(id));
		
		return "storedata";
	}
	
	@RequestMapping(value = "stores", method = RequestMethod.GET)
	public String listStores(Model model){
		model.addAttribute("store", new Store());
		model.addAttribute("listStore", this.storeService.listStore());
		
		return "stores";
	}
}
