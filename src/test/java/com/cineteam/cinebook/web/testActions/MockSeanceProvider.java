package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.model.entity.Seance;
import com.cineteam.cinebook.model.provider.seance.ISeanceProvider;
import java.util.ArrayList;
import java.util.List;

/** @author Berangere */
public class MockSeanceProvider implements ISeanceProvider
{
    public List<Seance> seances = new ArrayList<Seance>();
    
    public List<Seance> getSeancesPourUnCinema(String id) {
        Seance seance = new Seance();
        if(!id.isEmpty()){
            seance.setFormat("fmt");
            seances.add(seance);
        }
        return seances;
    }
    
}
