package com.novahabitat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(ProjectEmployeePK.class)
public class ProjectEmployee {
    @Id
    private Project project;

    @Id
    private Employee employee;

    /*static class ProjectEmployeePK implements Serializable{
        @ManyToOne
        private Project project;
        @ManyToOne
        private Employee employee;
    }*/
}
