package seedu.address.model.person;

import static java.util.Objects.*;
import static seedu.address.commons.util.AppUtil.*;

public class Role {
    public static final String DEFAULT_ROLE = "client";
    public static final String MESSAGE_CONSTRAINTS =
            "Role should be either client or vendor";

    public static final String VALIDATION_REGEX = "(?i)client|vendor";

    public final String value;

    public Role(String role) {
        requireNonNull(role);
        checkArgument(isValidRole(role), MESSAGE_CONSTRAINTS);
        value = role.trim().toLowerCase();
    }

    /**
     * Returns true if a given string is a valid role.
     */
    public static boolean isValidRole(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Role)) {
            return false;
        }

        Role otherRole = (Role) other;
        return value.equals(otherRole.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
