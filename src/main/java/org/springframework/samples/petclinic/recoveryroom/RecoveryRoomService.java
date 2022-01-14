package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	private RecoveryRoomRepository rrRepo;
	
	@Autowired
	public RecoveryRoomService(RecoveryRoomRepository rrRepo) {
		this.rrRepo = rrRepo;
	}
	
    public List<RecoveryRoom> getAll(){
        return this.rrRepo.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return this.rrRepo.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return this.rrRepo.getRecoveryRoomType(typeName);
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return this.rrRepo.findBySizeMoreThan(size);
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return this.rrRepo.save(p);       
    }

    
}
