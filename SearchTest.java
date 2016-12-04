public class SearchTest {

  private static final int[] ASC_INPUT = new int[]{0, 2, 4, 6, 8};
  private static final int[] DESC_INPUT = new int[]{8, 6, 4, 2, 0};
  private static final int[] NEG_DESC_INPUT = new int[]{2, 0, -2, -4, -6};
  private static final int[] NEG_ASC_INPUT = new int[]{-4, -2, 0, 2, 4};
  private static final int KEY_1 = 0;
  private static final int KEY_2 = 8;
  private static final int TRUE = 1;
  private static final int FALSE = 0;

  public SearchTest() {

  }

  public static void main(String[] args) {
    try {
      SearchTest test = new SearchTest();
      test.shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKey();
      test.shouldResultWhenItemsContainItemLessThanKey();
    } catch(TestFailedException e) {
      System.out.println("Test Failure");
    }
    System.out.println("Test Success");
  }

  public void shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKey() {
    //given
    Search lessThanSearch = new Search(ASC_INPUT, ASC_INPUT.length, TRUE, KEY_1, Search.SearchType.LESS_THAN);

    //when
    Result result = lessThanSearch.search();

    //then
    Result expectedResult = new Result(-1, Search.SearchResult.NOT_FOUND);
    if(!result.getResult().equals(expectedResult.getResult()) || result.getIndex() != expectedResult.getIndex()) {
      throw new TestFailedException(Search.SearchType.LESS_THAN, result, expectedResult);
    }
  }

  public void shouldResultWhenItemsContainItemLessThanKey() {
    //given
    Search lessThanSearch = new Search(ASC_INPUT, ASC_INPUT.length, TRUE, KEY_2, Search.SearchType.LESS_THAN);

    //when
    Result result = lessThanSearch.search();

    //then
    Result expectedResult = new Result(3, Search.SearchResult.FOUND_LESS);
    if(!result.getResult().equals(expectedResult.getResult()) && result.getIndex() != expectedResult.getIndex()) {
      throw new TestFailedException(Search.SearchType.LESS_THAN, result, expectedResult);
    }
  }

  public class TestFailedException extends RuntimeException {

    public Search.SearchType type;
    public Result result;
    public Result expectedResult;

    public TestFailedException() {
      super();
    }

    public TestFailedException(Search.SearchType type, Result result, Result expectedResult) {
      this.type = type;
      this.result = result;
      this.expectedResult = expectedResult;
    }
  }
}
