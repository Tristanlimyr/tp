package seedu.address.model.itinerary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalItineraries.AUSTRALIA_TRIP;
import static seedu.address.testutil.TypicalItineraries.BALI_TRIP;
import static seedu.address.testutil.TypicalItineraries.FRANCE_TRIP;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ItineraryMatchesPredicateTest {

    @Test
    public void equals() {
        List<Itinerary> firstPredicateItineraryList = List.of(FRANCE_TRIP);
        List<Itinerary> secondPredicateItineraryList = Arrays.asList(FRANCE_TRIP, BALI_TRIP);

        ItineraryMatchesPredicate firstPredicate = new ItineraryMatchesPredicate(firstPredicateItineraryList);
        ItineraryMatchesPredicate secondPredicate = new ItineraryMatchesPredicate(secondPredicateItineraryList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        ItineraryMatchesPredicate firstPredicateCopy = new ItineraryMatchesPredicate(
                firstPredicateItineraryList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different values -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_itineraryMatches_returnsTrue() {
        // One itinerary
        ItineraryMatchesPredicate predicate = new ItineraryMatchesPredicate(List.of(FRANCE_TRIP));
        assertTrue(predicate.test(FRANCE_TRIP));

        // Multiple itineraries
        predicate = new ItineraryMatchesPredicate(Arrays.asList(FRANCE_TRIP, BALI_TRIP, AUSTRALIA_TRIP));
        assertTrue(predicate.test(FRANCE_TRIP));
    }

    @Test
    public void test_nameDoesNotMatch_returnsFalse() {
        // Zero itineraries
        ItineraryMatchesPredicate predicate = new ItineraryMatchesPredicate(Collections.emptyList());
        assertFalse(predicate.test(FRANCE_TRIP));

        // Non-matching itineraries
        predicate = new ItineraryMatchesPredicate(Arrays.asList(BALI_TRIP, AUSTRALIA_TRIP));
        assertFalse(predicate.test(FRANCE_TRIP));
    }

    @Test
    public void toStringMethod() {
        List<Itinerary> itineraries = List.of(FRANCE_TRIP, BALI_TRIP, AUSTRALIA_TRIP);
        ItineraryMatchesPredicate predicate = new ItineraryMatchesPredicate(itineraries);

        String expected = ItineraryMatchesPredicate.class.getCanonicalName() + "{itineraries=" + itineraries + "}";
        assertEquals(expected, predicate.toString());
    }
}
