package aerofs.search;

import aerofs.search.Search.SearchResult;

public class Result {

    private final int index;
    private final SearchResult result;

    public Result(int index, SearchResult result) {
        this.index = index;
        this.result = result;
    }

    public int getIndex() {
        return this.index;
    }

    public SearchResult getResult() {
        return this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result1 = (Result) o;

        return index == result1.index && result == result1.result;
    }

    @Override
    public int hashCode() {
        int result1 = index;
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "Result{" +
                "index=" + index +
                ", result=" + result +
                '}';
    }
}
