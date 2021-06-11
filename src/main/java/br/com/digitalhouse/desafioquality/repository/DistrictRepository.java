package br.com.digitalhouse.desafioquality.repository;

import br.com.digitalhouse.desafioquality.repository.entity.DistrictData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public interface DistrictRepository {

    static DistrictData findByName (String districtName) {
        File file = null;
        try{
            file = ResourceUtils.getFile("file:src/main/resources/districts.json");

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<DistrictData>> typeRef = new TypeReference<List<DistrictData>>() {};
            List<DistrictData> districtFile = null;

            districtFile = objectMapper.readValue(file,typeRef);

            List<DistrictData> districts = districtFile.stream().filter(d -> d.getName().equals(districtName)).collect(Collectors.toList());

            if(districts.isEmpty()) { throw new IllegalArgumentException();}

            return districts.stream().findFirst().get();

        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
