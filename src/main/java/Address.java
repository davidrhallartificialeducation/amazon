import lombok.Getter;

@Getter
public class Address {

    private final String street;
    private final Integer zipCode;

    public Address(String street, Integer zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

}
