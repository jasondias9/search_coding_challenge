package search;

import static search.Search.SearchResult.FOUND_LESS;
import static search.Search.SearchResult.NOT_FOUND;
import static search.Search.SearchResult.FOUND_EXACT;
import static search.Search.SearchResult.FOUND_GREATER;

import static search.Search.SearchType.LESS_THAN;
import static search.Search.SearchType.EQUALS;
import static search.Search.SearchType.GREATER_THAN;
import static search.Search.SearchType.LESS_THAN_EQUALS;
import static search.Search.SearchType.GREATER_THAN_EQUALS;

public class SearchTest {

    private static final int[] DESCENDING_INPUT = new int[]{4, 2, 0, -2, -4};
    private static final int[] ASCENDING_INPUT = new int[]{-4, -2, 0, 2, 4};
    private static final int[] SINGLE = new int[]{0};

    private static final int ASCENDING = 1;
    private static final int DESCENDING = 0;

    public static void main(String[] args) {
        try {
            shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKeyInputsAscending();
            shouldReturnResultWhenItemsContainItemLessThanKeyInputsAscending();
            shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKeyInputsDescending();
            shouldReturnResultWhenItemsContainItemLessThanKeyInputsDescending();
            shouldReturnNotFoundWhenItemsDoesNotContainExactItemInputsAscending();
            shouldReturnResultWhenItemsContainExactItemInputsAscending();
            shouldReturnNotFoundWhenItemsDoesNotContainExactItemInputsDescending();
            shouldReturnResultWhenItemsContainExactItemInputsDescending();
            shouldReturnNotFoundWhenItemsDoesNotContainItemGreaterThanKeyInputsAscending();
            shouldReturnResultWhenItemsContainItemGreaterThanKeyInputsAscending();
            shouldReturnNotFoundWhenItemsDoesNotContainItemGreaterThanKeyInputsDescending();
            shouldReturnResultWhenItemsContainItemGreaterThanKeyInputsDescending();
            shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanEqualsKeyInputsAscending();
            shouldReturnResultWhenItemsContainItemLessThanEqualsKeyInputsAscending();
            shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanEqualsKeyInputsDescending();
            shouldReturnResultWhenItemsContainItemLessThanEqualsKeyInputsDescending();
            shouldReturnNotFoundWhenItemsDoesNotContainItemGreaterThanEqualsKeyInputsAscending();
            shouldReturnResultWhenItemsContainItemGreaterThanEqualsKeyInputsAscending();
            shouldReturnResultWhenItemsContainItemGreaterThanEqualsKeyInputsDescending();
            shouldReturnNotFoundWhenItemsDoesNotContainItemGreaterThanEqualsKeyInputsDescending();
            shouldReturnResultWhenItemsContainsSingleItemLessThan();
            shouldReturnResultWhenItemsContainsSingleExactItem();
            shouldReturnResultWhenItemsContainsSingleItemGreaterThan();
            shouldReturnResultWhenItemsContainsSingleItemLessThanEquals();
            shouldReturnNotFoundWhenItemsDoesNotContainSingleItemLessThan();
            shouldReturnNotFoundWhenItemsDoesNotContainSingleExactItem();
            shouldReturnNotFoundWhenItemsDoesNotContainSingleItemGreaterThan();
            shouldReturnNotFoundWhenItemsDoesNotContainSingleItemLessThanEquals();
            shouldReturnNotFoundWhenItemsDoesNotContainSingleItemGreaterThanEquals();

        } catch (TestFailedException e) {
            System.exit(1);
        }

        System.out.println("Completed, all tests passed.");
    }

    /* Less Than */
    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKeyInputsAscending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, -4, LESS_THAN),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemLessThanKeyInputsAscending() {
        Result expectedResult = new Result(2, FOUND_LESS);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, 2, LESS_THAN),
                expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKeyInputsDescending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, -4, LESS_THAN),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemLessThanKeyInputsDescending() {
        Result expectedResult = new Result(2, FOUND_LESS);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, 2, LESS_THAN),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainsSingleItemLessThan() {
      Result expectedResult = new Result(0, FOUND_LESS);
      runTest(new Search(SINGLE, SINGLE.length, ASCENDING, 2, LESS_THAN),
              expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainSingleItemLessThan() {
      Result expectedResult = new Result(-1, NOT_FOUND);
      runTest(new Search(SINGLE, SINGLE.length, ASCENDING, -2, LESS_THAN),
              expectedResult);
    }

    /* Exact */
    private static void shouldReturnNotFoundWhenItemsDoesNotContainExactItemInputsAscending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, 1, EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainExactItemInputsAscending() {
        Result expectedResult = new Result(3, FOUND_EXACT);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, 2, EQUALS),
                expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainExactItemInputsDescending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, 3, EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainExactItemInputsDescending() {
        Result expectedResult = new Result(0, FOUND_EXACT);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, 4, EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainsSingleExactItem() {
      Result expectedResult = new Result(0, FOUND_EXACT);
      runTest(new Search(SINGLE, SINGLE.length, ASCENDING, 0, EQUALS),
              expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainSingleExactItem() {
      Result expectedResult = new Result(-1, NOT_FOUND);
      runTest(new Search(SINGLE, SINGLE.length, ASCENDING, 1, EQUALS),
              expectedResult);
    }

    /* Greater Than */
    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemGreaterThanKeyInputsAscending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, 4, GREATER_THAN),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemGreaterThanKeyInputsAscending() {
        Result expectedResult = new Result(4, FOUND_GREATER);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, 2, GREATER_THAN),
                expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemGreaterThanKeyInputsDescending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, 4, GREATER_THAN),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemGreaterThanKeyInputsDescending() {
        Result expectedResult = new Result(0, FOUND_GREATER);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, 3, GREATER_THAN),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainsSingleItemGreaterThan() {
      Result expectedResult = new Result(0, FOUND_GREATER);
      runTest(new Search(SINGLE, SINGLE.length, ASCENDING, -2, GREATER_THAN),
              expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainSingleItemGreaterThan() {
      Result expectedResult = new Result(-1, NOT_FOUND);
      runTest(new Search(SINGLE, SINGLE.length, ASCENDING, 0, GREATER_THAN),
              expectedResult);
    }

    /* Less Than Equals */
    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanEqualsKeyInputsAscending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, -5, LESS_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemLessThanEqualsKeyInputsAscending() {
        Result expectedResult = new Result(3, FOUND_EXACT);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, 2, LESS_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanEqualsKeyInputsDescending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, -5, LESS_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemLessThanEqualsKeyInputsDescending() {
        Result expectedResult = new Result(1, FOUND_LESS);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, 3, LESS_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainsSingleItemLessThanEquals() {
      Result expectedResult = new Result(0, FOUND_LESS);
      runTest(new Search(SINGLE, SINGLE.length, ASCENDING, 1, LESS_THAN_EQUALS),
              expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainSingleItemLessThanEquals() {
      Result expectedResult = new Result(-1, NOT_FOUND);
      runTest(new Search(SINGLE, SINGLE.length, ASCENDING, -1, LESS_THAN_EQUALS),
              expectedResult);
    }

    /* Greater Than Equals */
    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemGreaterThanEqualsKeyInputsAscending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, 5, GREATER_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemGreaterThanEqualsKeyInputsAscending() {
        Result expectedResult = new Result(4, FOUND_EXACT);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, 4, GREATER_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemGreaterThanEqualsKeyInputsDescending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, 8, GREATER_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemGreaterThanEqualsKeyInputsDescending() {
        Result expectedResult = new Result(0, FOUND_GREATER);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, 3, GREATER_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainsSingleItem() {
      Result expectedResult = new Result(0, FOUND_EXACT);
      runTest(new Search(SINGLE, SINGLE.length, ASCENDING, 0, EQUALS),
              expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainSingleItemGreaterThanEquals() {
      Result expectedResult = new Result(-1, NOT_FOUND);
      runTest(new Search(SINGLE, SINGLE.length, ASCENDING, 1, GREATER_THAN_EQUALS),
              expectedResult);
    }

    private static void runTest(Search search, Result expectedResult) {

        Result result = search.search();
        if (!expectedResult.equals(result)) {

            System.err.println("Test failure.");
            System.err.println("    Input:      " + search);
            System.err.println("    Expected:   " + expectedResult);
            System.err.println("    Actual:     " + result);

            throw new TestFailedException();
        }
    }

    private static class TestFailedException extends RuntimeException {
    }
}
