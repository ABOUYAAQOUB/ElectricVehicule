package com.ElecVehicule.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ElecVehicule.demo.model.DateDim;

public interface DateDimRepository extends JpaRepository<DateDim, Long> {

}
