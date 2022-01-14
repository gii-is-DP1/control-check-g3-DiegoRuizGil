package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    
	@Autowired
	private RecoveryRoomService rrService;
	
	@GetMapping("/create")
	public String initCreateForm(ModelMap modelMap) {
		RecoveryRoom rr = new RecoveryRoom();
		List<RecoveryRoomType> rrTypeList = rrService.getAllRecoveryRoomTypes();
		
		modelMap.addAttribute("recoveryRoom",rr);
		modelMap.addAttribute("types",rrTypeList);
		
		return "recoveryroom/createOrUpdateRecoveryRoomForm";
	}
	
	@PostMapping("/create")
	public String processCreationForm(@Valid RecoveryRoom rr, BindingResult result) {
		
		if(result.hasErrors())
			return "recoveryroom/createOrUpdateRecoveryRoomForm";
		
		rrService.save(rr);
		
		return "welcome";
	}
}
