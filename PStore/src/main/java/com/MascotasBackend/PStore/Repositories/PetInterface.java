package com.MascotasBackend.PStore.Repositories;
import com.MascotasBackend.PStore.Model.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetInterface extends JpaRepository<PetModel, Long> {


}
