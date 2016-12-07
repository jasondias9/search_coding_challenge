package aerofs.search;

import static aerofs.search.Search.SearchResult.FOUND_LESS;
import static aerofs.search.Search.SearchResult.NOT_FOUND;
import static aerofs.search.Search.SearchType.LESS_THAN;

public class SearchTest {

    private static final int[] POSITIVE_ASCENDING_INPUT = new int[]{0, 2, 4, 6, 8};
    private static final int[] POSITIVE_DESCENDING_INPUT = new int[]{8, 6, 4, 2, 0};

    private static final int[] DESCENDING_INPUT = new int[]{4, 2, 0, -2, -4};
    private static final int[] ASCENDING_INPUT = new int[]{-4, -2, 0, 2, 4};

    private static final int ASCENDING = 1;
    private static final int DESCENDING = 0;

    public static void main(String[] args) {
        try {
            shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKeyAndAllInputsArePositive();
            shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKeyAndInputContainsNegatives();
            shouldResultWhenItemsContainItemLessThanKey();
        } catch (TestFailedException e) {
            System.exit(1);
        }

        System.out.println("Done, all tests passed.");
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKeyAndAllInputsArePositive() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(
                new Search(POSITIVE_ASCENDING_INPUT, POSITIVE_ASCENDING_INPUT.length, ASCENDING, 0, LESS_THAN),
                expectedResult);
    }

    private static void shouldReturnNotFoundWhenItemsDoesNotContainItemLessThanKeyAndInputContainsNegatives() {
        Result expectedResult = new Result(-1, NOT_FOUND);
        runTest(
                new Search(ASCENDING_INPUT, ASCENDING_INPUT.length, ASCENDING, -4, LESS_THAN),
                expectedResult);
    }

    private static void shouldResultWhenItemsContainItemLessThanKey() {
        Result expectedResult = new Result(3, FOUND_LESS);
        runTest(
                new Search(POSITIVE_ASCENDING_INPUT, POSITIVE_ASCENDING_INPUT.length, ASCENDING, 8, LESS_THAN),
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
