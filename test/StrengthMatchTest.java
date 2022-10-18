import com.example.test.IMatchAlgo;
import com.example.test.Page;
import com.example.test.Query;
import com.example.test.StrengthMatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StrengthMatchTest {
    IMatchAlgo matchAlgo = new StrengthMatch();

    @Test
    void match() {
        List<Page> pages = new ArrayList<>();
        pages.add(new Page("P1","Ford Car Review", 8));
        pages.add(new Page("P2","Review Car", 8));
        pages.add(new Page("P3","Review Ford", 8));
        pages.add(new Page("P4","Toyota Car", 8));
        pages.add(new Page("P5","Honda Car", 8));
        pages.add(new Page("P6","Car", 8));
        List<Query> queries = new ArrayList<>();
        Query q = new Query("Q4","Ford Review", 8);
        Assertions.assertEquals(106,matchAlgo.match(pages.get(0),q));
        Assertions.assertEquals(56,matchAlgo.match(pages.get(1),q));
        Assertions.assertEquals(112,matchAlgo.match(pages.get(2),q));
        Assertions.assertEquals(0,matchAlgo.match(pages.get(3),q));
        Assertions.assertEquals(0,matchAlgo.match(pages.get(4),q));
        Assertions.assertEquals(0,matchAlgo.match(pages.get(5),q));
    }
}