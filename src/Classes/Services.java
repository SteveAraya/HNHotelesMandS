
package Classes;

/**
 *
 * @author Steve and Marcos
 */
public class Services {
    
    private String service_code;
    private String name;

    public Services(String service_code, String name) {
        this.service_code = service_code;
        this.name = name;
    }

    public String getService_code() {
        return service_code;
    }

    public void setService_code(String service_code) {
        this.service_code = service_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}