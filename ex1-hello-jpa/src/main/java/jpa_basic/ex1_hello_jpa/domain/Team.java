package jpa_basic.ex1_hello_jpa.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "TEAM")
public class Team {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
}
