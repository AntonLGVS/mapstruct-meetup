package com.example.mapstruct;

import com.example.mapstruct.dto.DTO;
import com.example.mapstruct.model.Model;
import com.example.mapstruct.model.Model2;
import com.example.mapstruct.mappers.ModelMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MapstructApplicationTests {

    @Autowired
    ModelMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    void mapperTest() {
        // given
        Model src = new Model("aaa", 5, new Model2());
        Map<String, String> anyContext = Map.of("key", "smth");

        // when
        DTO dto = mapper.toDTO(src, anyContext);

        // then
        assertEquals(src.getA(), dto.getA());
        assertEquals(src.getB().longValue(), dto.getBb());
    }

}
