public class Search {

  private static int[] items;
  private static int n_items;
  private static int ascending;
  private static int key;
  private static SearchType type;
  public static enum SearchType {
    LESS_THAN,
    LESS_THAN_EQUALS,
    EQUALS,
    GREAT_THAN_EQUALS,
    GREATER_THAN
  };

  public static enum SearchResult {
    NOT_FOUND,
    FOUND_EXACT,
    FOUND_GREATER,
    FOUND_LESS
  };

  public Search(int[] items, int n_items, int ascending, int key, SearchType type) {
      this.items = items;
      this.n_items = n_items;
      this.ascending = ascending;
      this.key = key;
      this.type = type;
  }

  public static Result search() {

      switch(type) {
        default :
          return searchLessThan();

      }

  }

  public static Result searchLessThan() {
      if(n_items == 1 && items[0] < key) {
        return new Result(0, SearchResult.FOUND_LESS);
      }
      for(int i = 0; i < n_items; i++) {
        if(items[i] < key && ascending == 0) {
          return new Result(i, SearchResult.FOUND_LESS);
        } else if(items[i] >= key && ascending == 1) {
          if(i-1 > 0) {
            return new Result(i-1, SearchResult.FOUND_LESS);
          }
          return new Result(-1, SearchResult.NOT_FOUND);
        }
      }
      return new Result(-1, SearchResult.NOT_FOUND);
  }

}
