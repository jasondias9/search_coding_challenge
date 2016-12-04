public class Result {

  private int index;
  private Search.SearchResult result;

  public Result(int index, Search.SearchResult result) {
    this.index = index;
    this.result = result;
  }

  public int getIndex() {
    return this.index;
  }

  public Search.SearchResult getResult() {
    return this.result;
  }

}
