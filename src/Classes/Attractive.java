
package Classes;

/**
 *
 * @author Steve and Marcos
 */
public class Attractive {
    
    private String attractive_code;
    private String name;

    public Attractive(String attractive_code, String name) {
        this.attractive_code = attractive_code;
        this.name = name;
    }

    public String getAttractive_code() {
        return attractive_code;
    }

    public void setAttractive_code(String attractive_code) {
        this.attractive_code = attractive_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}