package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull() {

        // Case: Non-zero number of null objects
        assertAtleastOneNull((Object) null);
        assertAtleastOneNull((Object)null, (Object)null);
        assertAtleastOneNull(1, 2, (Object)null, "Non-null String");

        // Case: Zero null objects
        assertNoneAreNull(1, 2, "Non-null String");
        assertNoneAreNull(1);

        // Case: No objects passed
        assertNoneAreNull();

    }

    private void assertAtleastOneNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertNoneAreNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }
    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
