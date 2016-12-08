package aerofs.search;

import static aerofs.search.Search.SearchResult.FOUND_LESS;
import static aerofs.search.Search.SearchResult.NOT_FOUND;
import static aerofs.search.Search.SearchType.LESS_THAN;
import static aerofs.search.Search.SearchType.EQUALS;
import static aerofs.search.Search.SearchType.GREATER_THAN;
import static aerofs.search.Search.SearchType.LESS_THAN_EQUALS;
import static aerofs.search.Search.SearchType.GREATER_THAN_EQUALS;

public class SearchTest {

    private static final int[] DESCENDING_INPUT = new int[]{4, 2, 0, -2, -4};
    private static final int[] ASCENDING_INPUT = new int[]{-4, -2, 0, 2, 4};

    private static final int ASCENDING = 1;
    private static final int DESCENDING = 0;

    public static void main(String[] args) {
        try {
            shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKeyInputsAscending();
            shouldReturnResultWhenItemsContainItemLessThanKeyInputsAscending();
            shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKeyInputsDescending();
            shouldReturnResultWhenItemsContainItemLessThanKeyInputsDescending();
        } catch (TestFailedException e) {
            System.exit(1);
        }

        System.out.println("Done, all tests passed.");
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

    /* Exact */
    private static void shouldReturnNotFoundWhenItemsDoesNotContainExactItemInputsAscending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, -4, EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainExactItemInputsAscending() {
        Result expectedResult = new Result(2, FOUND_LESS);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, 2, EQUALS),
                expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainExactItemInputsDescending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, -4, EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainExactItemInputsDescending() {
        Result expectedResult = new Result(2, FOUND_LESS);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, 2, EQUALS),
                expectedResult);
    }

    /* Greater Than */
    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemGreaterThanKeyInputsAscending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, -4, GREATER_THAN),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemGreaterThanKeyInputsAscending() {
        Result expectedResult = new Result(2, FOUND_LESS);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, 2, GREATER_THAN),
                expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemGreaterThanKeyInputsDescending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, -4, GREATER_THAN),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemGreaterThanKeyInputsDescending() {
        Result expectedResult = new Result(2, FOUND_LESS);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, 2, GREATER_THAN),
                expectedResult);
    }

    /* Less Than Equals */
    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanEqualsKeyInputsAscending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, -4, LESS_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemLessThanEqualsKeyInputsAscending() {
        Result expectedResult = new Result(2, FOUND_LESS);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, 2, LESS_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanEqualsKeyInputsDescending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, -4, LESS_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemLessThanEqualsKeyInputsDescending() {
        Result expectedResult = new Result(2, FOUND_LESS);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, 2, LESS_THAN_EQUALS),
                expectedResult);
    }

    /* Greater Than Equals */
    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemGreaterThanEqualsKeyInputsAscending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, -4, GREATER_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemGreaterThanEqualsKeyInputsAscending() {
        Result expectedResult = new Result(2, FOUND_LESS);
        runTest(new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, 2, GREATER_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemGreaterThanEqualsKeyInputsDescending() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, -4, GREATER_THAN_EQUALS),
                expectedResult);
    }

    private static void shouldReturnResultWhenItemsContainItemGreaterThanEqualsKeyInputsDescending() {
        Result expectedResult = new Result(2, FOUND_LESS);
        runTest(new Search(DESCENDING_INPUT, DESCENDING_INPUT.length, DESCENDING, 2, GREATER_THAN_EQUALS),
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
