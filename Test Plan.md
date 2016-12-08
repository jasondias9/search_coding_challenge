Assumptions
-----------
Given the following assumptions,

*  The items are sorted
*  Items will be non-NULL
*  There are no duplicate items
*  n_items will be > 0

The above edge cases were therefore not included in any tests.

Test cases
----------
*For all search types*

* Test mixed positive negative input
* Ascending & Descending
* Test length 1 array
* Check for correct Result return on successful find and NotFound result when search param
was not included in items

Cross Functional Testing
------------------------
Whilst the functional tests above are descriptive of what the system should do,
We will also define some cross functional tests (how the system should behave).
The following additional tests would be added:
* Performance Testing (response time)
* Scalability
* Capacity
* Reliability

Whilst this is not an exhaustive list, these would be the first cross - functional tests I
would implement.
