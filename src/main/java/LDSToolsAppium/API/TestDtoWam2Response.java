package LDSToolsAppium.API;

class TestDtoWam2Response {

    private String name = "";
    private String value = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            this.name = "";
        } else {
            this.name = name;
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (value == null) {
            this.value = "";
        } else {
            this.value = value;
        }
    }

    public String getCookie() {
        return name + "=" + value;
    }
}
