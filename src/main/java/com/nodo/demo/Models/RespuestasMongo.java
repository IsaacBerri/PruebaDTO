package com.nodo.demo.Models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "respuestas")
public class RespuestasMongo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String _id;
    private String typeDestiny;
    private String weather;
    private String activity;
    private String hosting;
    private String duration;
    private String age;
    private Destinity destinationAmerica;
    private Destinity destinationEuropa;

    @JsonSerialize
    public static class Destinity {
        private String site;
        private String country;

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

}
