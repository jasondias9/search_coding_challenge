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

}
