package com.novahabitat.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class ProjectEmployeePK {
    @ManyToOne
    @JoinColumn(name = "id_project", foreignKey = @ForeignKey(name="FK_PROJECT_EMPLOYEE_P"))
    private Project project;

    @ManyToOne
    @JoinColumn(name = "id_employee", foreignKey = @ForeignKey(name="FK_PROJECT_EMPLOYEE_E"))
    private Employee employee;
}
