public class SearchTest {

  private static final int[] INPUT_1 = new int[]{0, 2, 4, 6, 8};
  private static final int KEY_1 = -1;
  private static final int TRUE = 1;
  private static final int FALSE = 0;

  public static void main(String[] args) {
    try {

    } catch(TestFailedException e) {

    }
  }

  public void shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKey() {
    //given
    Search lessThanSearch = new Search(INPUT_1, INPUT_1.length, TRUE, KEY_1, Search.SearchType.LESS_THAN);

    //when
    Result result = lessThanSearch.search();

    //then
    Result expectedResult = new Result(-1, Search.SearchResult.NOT_FOUND);
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
