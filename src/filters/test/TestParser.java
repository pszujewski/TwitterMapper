package filters.test;

import filters.*;
import org.junit.jupiter.api.Test;

import static filters.test.Utils.makeStatus;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test the parser.
 */
public class TestParser {
    @Test
    public void testBasic() throws SyntaxError {
        Filter f = new Parser("trump").parse();
        assertTrue(f instanceof BasicFilter);
        assertTrue(((BasicFilter)f).getWord().equals("trump"));
    }

    @Test
    public void testHairy() throws SyntaxError {
        Filter x = new Parser("trump and (evil or blue) and red or green and not not purple").parse();
        assertTrue(x.toString().equals("(((trump and (evil or blue)) and red) or (green and not not purple))"));
        assertTrue(x.matches(makeStatus("trump is a blue and red person.")));
        assertFalse(x.matches(makeStatus("obama is a blue and red person.")));
        assertTrue(x.matches(makeStatus("green and purple campfire marshmellos probably should not be eaten.")));
        assertFalse(x.matches(makeStatus("Trump is a green president.")));
        assertTrue(x.matches(makeStatus("Obama is a green and purple president.")));
    }
}
