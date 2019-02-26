package filters;

import twitter4j.Status;

import java.util.List;

public class OrFilter implements Filter {
    private Filter sub;
    private Filter right;

    public OrFilter(Filter sub, Filter right) {
        this.sub = sub;
        this.right = right;
    }

    @Override
    public boolean matches(Status s) {
        return sub.matches(s) || right.matches(s);
    }

    @Override
    public List<String> terms() {
        return sub.terms();
    }

    public String toString() { return "("+sub.toString()+" or "+right.toString()+")"; }
}
