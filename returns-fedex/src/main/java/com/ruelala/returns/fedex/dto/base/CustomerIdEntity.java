/**
 * 
 */
package com.ruelala.returns.fedex.dto.base;

/**
 * @author jonathan.williams
 *
 *         Some FedEx API requests require a customer ID to be sent. This ID is the customer ID assigned to RueLaLa, as
 *         opposed to anything associated with a @Customer.
 *         
 *         This ID needs to be presented in the form:
 *         <pre>
 *         "entity": {
 *           "customer": {
 *            "id": "10453"
 *           },
 *           ...
 *         }
 *         </pre>
 */
public abstract class CustomerIdEntity {
    private CustomerId customer;

    public CustomerIdEntity() {
    }

    public CustomerIdEntity(CustomerId customer) {
        this.customer = customer;
    }

    public CustomerId getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerId customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("CustomerIdEntity [customer=").append(customer).append("]");
        return builder.toString();
    }
}
