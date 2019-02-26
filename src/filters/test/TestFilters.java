package filters.test;

import filters.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import twitter4j.*;

import java.util.Date;

import static filters.test.Utils.makeStatus;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestFilters {


    @Test
    public void testBasic() {
        Filter f = new BasicFilter("fred");
        assertTrue(f.matches(makeStatus("Fred Flintstone")));
        assertTrue(f.matches(makeStatus("fred Flintstone")));
        assertFalse(f.matches(makeStatus("Red Skelton")));
        assertFalse(f.matches(makeStatus("red Skelton")));
    }

    @Test
    public void testNot() {
        Filter f = new NotFilter(new BasicFilter("fred"));
        assertFalse(f.matches(makeStatus("Fred Flintstone")));
        assertFalse(f.matches(makeStatus("fred Flintstone")));
        assertTrue(f.matches(makeStatus("Red Skelton")));
        assertTrue(f.matches(makeStatus("red Skelton")));
    }

    @Test
    public void testAndFilter() {
        Filter f = new AndFilter(new BasicFilter("blue"), new BasicFilter("green"));
        assertFalse(f.matches(makeStatus("purple shirt")));
        assertTrue(f.matches(makeStatus("blue flag with green spots")));
        assertFalse(f.matches(makeStatus("green pants")));
        assertTrue(f.matches(makeStatus("green and blue pants")));
        assertTrue(f.toString().equals("(blue and green)"));
    }

    @Test
    public void testOrFilter() {
        Filter f = new OrFilter(new BasicFilter("America"), new BasicFilter("Canada"));
        assertTrue(f.matches(makeStatus("America and Canada are in North America.")));
        assertTrue(f.matches(makeStatus("Canada is far north")));
        assertTrue(f.matches(makeStatus("America has 50 states")));
        assertFalse(f.matches(makeStatus("Europe is across the ocean.")));
        assertFalse(f.matches(makeStatus("green and blue")));
        assertTrue(f.toString().equals("(America or Canada)"));
    }
}
