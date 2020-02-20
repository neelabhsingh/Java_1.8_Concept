package test.java;

import java.util.HashMap;
import java.util.Map;

public class CustomerID {
    private long crmId;
    private int naneSpace;

    public CustomerID(long crmId, int naneSpace) {
        super();
        this.crmId = crmId;
        this.naneSpace = naneSpace;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  CustomerID))
            return false;
        if( obj == this)
            return true;

        return this.crmId == ((CustomerID) obj).crmId && this.naneSpace == ((CustomerID) obj).naneSpace;
    }

    public static void main(String[] args) {
        Map m = new HashMap();
        m.put(new CustomerID(2345891234L, 0), "Jeff Smith");
        System.out.println(m.get(new CustomerID(2345891234L, 0)));
    }
}
