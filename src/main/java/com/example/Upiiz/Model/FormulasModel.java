package com.example.Upiiz.Model;

import java.sql.Date;

public class FormulasModel {

    private Integer id_formulas;
    private String version;
    private Date fecha_registro;
    private String observaciones;
    private Integer perfumes_id_perfume;

    // Constructor vacío
    public FormulasModel() {}

    public FormulasModel(Integer id_formulas, String version, Date fecha_registro, String observaciones, Integer perfumes_id_perfume) {
        this.id_formulas = id_formulas;
        this.version = version;
        this.fecha_registro = fecha_registro;
        this.observaciones = observaciones;
        this.perfumes_id_perfume = perfumes_id_perfume;
    }


    public Integer getId_formulas() {
        return id_formulas;
    }

    public void setId_formulas(Integer id_formulas) {
        this.id_formulas = id_formulas;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getPerfumes_id_perfume() {
        return perfumes_id_perfume;
    }

    public void setPerfumes_id_perfume(Integer perfumes_id_perfume) {
        this.perfumes_id_perfume = perfumes_id_perfume;
    }
}
