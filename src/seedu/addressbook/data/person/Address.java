package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, some unit, some postal code";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_SPLIT_REGEX = ",";
    public static final int BLOCK_ADDRESS_INDEX = 0;
    public static final int STREET_ADDRESS_INDEX = 1;
    public static final int UNIT_ADDRESS_INDEX = 2;
    public static final int POSTAL_CODE_ADDRESS_INDEX = 3;

    public final String value;
    private boolean isPrivate;
    Block block;
    Street street;
    Unit unit;
    PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.value = new String(trimmedAddress);
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] addressInParts = splitAddressIntoParts(trimmedAddress);
        block = new Block(getBlockFromAddress(addressInParts));
        street = new Street(getStreetFromAddress(addressInParts));
        unit = new Unit(getUnitFromAddress(addressInParts));
        postalCode = new PostalCode(getPostalCodeFromAddress(addressInParts));
    }

    /**
     * Returns the postal code from address
     *
     * @param addressInParts
     */
    private String getPostalCodeFromAddress(String[] addressInParts){
        return addressInParts[POSTAL_CODE_ADDRESS_INDEX];
    }

    /**
     * Returns the street from address
     *
     * @param addressInParts
     */
    private String getStreetFromAddress(String[] addressInParts){
        return addressInParts[STREET_ADDRESS_INDEX];
    }

    /**
     * Returns the unit from address
     *
     * @param addressInParts
     */
    private String getUnitFromAddress(String[] addressInParts){
        return addressInParts[UNIT_ADDRESS_INDEX];
    }

    /**
     * Returns the block from address
     *
     * @param addressInParts
     */
    private String getBlockFromAddress(String[] addressInParts){
        return addressInParts[BLOCK_ADDRESS_INDEX];
    }

    /**
     * Splits address into component strings.
     *
     * @param trimmedAddress
     * @return
     */
    private String[] splitAddressIntoParts(String trimmedAddress) {
        String[] addressInParts = trimmedAddress.split(ADDRESS_SPLIT_REGEX);
        return addressInParts;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
