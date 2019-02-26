package filters;

import twitter4j.Status;

import java.util.List;

public class AndFilter implements Filter {
    private Filter sub;
    private Filter right;

    public AndFilter(Filter sub, Filter right) {
        this.sub = sub;
        this.right = right;
    }

    @Override
    public boolean matches(Status s) {
        return sub.matches(s) && right.matches(s);
    }

    @Override
    public List<String> terms() {
        return sub.terms();
    }

    public String toString() { return "("+sub.toString()+" and "+right.toString()+")"; }
}
