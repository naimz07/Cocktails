package com.tsi.training.aziz.mohammed.Cocktails.repositories;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Instruction;
import org.springframework.data.repository.CrudRepository;

public interface InstructionsRepository extends CrudRepository <Instruction, Integer> {
}
