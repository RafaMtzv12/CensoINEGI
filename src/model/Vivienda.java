package model;

public class Vivienda {
    private int id;
    private int tipo_id;
    private int municipio_id;
    private int localidad_id;

    public int getTipoId() {
        return tipo_id;
    }

    public void setTipoId(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    public int getMunicipioId() {
        return municipio_id;
    }

    public void setMunicipioId(int municipio_id) {
        this.municipio_id = municipio_id;
    }

    public int getLocalidadId() {
        return localidad_id;
    }

    public void setLocalidadId(int localidad_id) {
        this.localidad_id = localidad_id;
    }
}