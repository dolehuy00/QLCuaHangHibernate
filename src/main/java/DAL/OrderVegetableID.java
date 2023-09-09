
package DAL;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Embeddable
public class OrderVegetableID implements Serializable { 
    private order order;
    private vegetable vegetable;
 
    @ManyToOne(cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    public order getOrder() {
        return order;
    }
 
    public void setOrder(order order) {
        this.order = order;
    }
 
    @ManyToOne(cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    @NotFound(action =  NotFoundAction.IGNORE)
    public vegetable getVegetable() {
        return vegetable;
    }
 
    public void setVegetable(vegetable vegetable) {
        this.vegetable = vegetable;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((order == null) ? 0 : order.hashCode());
        result = prime * result
                + ((vegetable == null) ? 0 : vegetable.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderVegetableID other = (OrderVegetableID) obj;
        return Objects.equals(getOrder(), other.getOrder()) && Objects.equals(getVegetable(), other.getVegetable());
    }

}
