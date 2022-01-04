package com.tsi.training.aziz.mohammed.Cocktails.Glass;


import com.tsi.training.aziz.mohammed.Cocktails.repositories.GlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlassServices {

    public GlassServices(GlassRepository glassRepository) {this.glassRepository = glassRepository;}

    @Autowired
    private GlassRepository glassRepository;

}
