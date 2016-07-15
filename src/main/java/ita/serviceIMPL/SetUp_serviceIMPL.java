package ita.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ita.domain.Naselje;
import ita.domain.Opstina;
import ita.model.NaseljeM;
import ita.model.OpstinaM;
import java.util.ArrayList;
import java.util.List;
import ita.dao.SetUp_dao;
import ita.service.SetUp_service;

@Service
public class SetUp_serviceIMPL implements SetUp_service {

    @Autowired
    SetUp_dao dao;

    @Override
    public List<OpstinaM> setUp() {

        List<Opstina> opstine = dao.setUp();

        List<OpstinaM> opstineM = repackOpstinaList(opstine);

        return opstineM;
    }

    private List<OpstinaM> repackOpstinaList(List<Opstina> opstine) {

        List<OpstinaM> opstineM = new ArrayList<>();
        OpstinaM opstinaM = new OpstinaM();

        for (Opstina o : opstine) {
            opstinaM = repackOpstina(o);
            opstineM.add(opstinaM);
        }

        return opstineM;
    }

    private OpstinaM repackOpstina(Opstina opstina) {

        OpstinaM opstinaM = new OpstinaM();

        opstinaM.setIme(opstina.getIme());
        opstinaM.setOpstinaId(opstina.getOpstinaId());
        opstinaM.setNaselja(repackNaseljeList(opstina.getNaselja()));

        return opstinaM;
    }

    private List<NaseljeM> repackNaseljeList(List<Naselje> naselja) {

        List<NaseljeM> naseljaM = new ArrayList<>();
        NaseljeM naseljeM = new NaseljeM();

        for (Naselje n : naselja) {
            naseljeM = repackNaselje(n);
            naseljaM.add(naseljeM);
        }
        return naseljaM;
    }

    private NaseljeM repackNaselje(Naselje naselje) {

        NaseljeM naseljeM = new NaseljeM();

        naseljeM.setIme(naselje.getIme());
        naseljeM.setNaseljeId(naselje.getId());

        return naseljeM;
    }
}
