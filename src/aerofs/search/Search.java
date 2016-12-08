package aerofs.search;

import java.util.Arrays;

public class Search {

    private final int[] items;
    private final boolean isAscending;
    private final int key;
    private final SearchType type;

    public enum SearchType {
        LESS_THAN,
        LESS_THAN_EQUALS,
        EQUALS,
        GREATER_THAN_EQUALS,
        GREATER_THAN
    }

    public enum SearchResult {
        NOT_FOUND,
        FOUND_EXACT,
        FOUND_GREATER,
        FOUND_LESS
    }

    public Search(int[] items, int n_items, int ascending, int key, SearchType type) {
        this.items = items;
        this.isAscending = ascending == 1;
        this.key = key;
        this.type = type;
    }

    public Result search() {

        switch (type) {
            case LESS_THAN:
                return searchLessThan();
            case LESS_THAN_EQUALS:
                return searchLessThanEqauls();
            case EQUALS:
                return searchEquals();
            case GREATER_THAN_EQUALS:
                return searchGreaterThanEquals();
            case GREATER_THAN:
                return searchGreaterThan();
            default:
                throw new IllegalArgumentException("Unknown search type");
        }

    }

    public Result searchGreaterThanEquals() {
      Result exact =  searchEquals();
      return exact.getResult().equals(SearchResult.FOUND_EXACT) ? exact : searchGreaterThan();
    }

    public Result searchLessThanEqauls() {
      Result exact = searchEquals();
      return exact.getResult().equals(SearchResult.FOUND_EXACT) ? exact : searchLessThan();
    }

    public Result searchEquals() {
      for(int i = 0; i < items.length; i++) {
        if(items[i] == key) {
          return new Result(i, SearchResult.FOUND_EXACT);
        }
      }
      return new Result(-1, SearchResult.NOT_FOUND);
    }

    public Result searchGreaterThan() {
      if(items.length == 1 && items[0] > key) {
        return new Result(0, SearchResult.FOUND_GREATER);
      }
      for(int i = 0; i < items.length; i++) {
        if(items[i] > key && isAscending) {
          return new Result(i, SearchResult.FOUND_GREATER);
        } else if(items[i] <= key && !isAscending) {
          if (i - 1 >= 0) {
            return new Result(i-1, SearchResult.FOUND_GREATER);
          }
          return new Result(-1, SearchResult.NOT_FOUND);
        }
      }
      return new Result(-1, SearchResult.NOT_FOUND);
    }

    public Result searchLessThan() {
        if (items.length == 1 && items[0] < key) {
            return new Result(0, SearchResult.FOUND_LESS);
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i] < key && !isAscending) {
                return new Result(i, SearchResult.FOUND_LESS);
            } else if (items[i] >= key && isAscending) {
                if (i - 1 >= 0) {
                    return new Result(i - 1, SearchResult.FOUND_LESS);
                }
                return new Result(-1, SearchResult.NOT_FOUND);
            }
        }
        return new Result(-1, SearchResult.NOT_FOUND);
    }

    @Override
    public String toString() {
        return "Search{" +
                "items=" + Arrays.toString(items) +
                ", ascending=" + isAscending +
                ", key=" + key +
                ", type=" + type +
                '}';
    }
}
