
Problem statement
-----------------

Thanks again for your interest in AeroFS. As the next step in our interview
process, we ask that you please show us a bit of your design and coding skills
with the following coding challenge.

You will find that the function shells provided below are written in C;
however, we will be happy to look at implementation in any language. Simply
adapt the provided shell as needed. The most important characteristic is
readable, maintainable and production-ready code. Please keep it short and
avoid duplication of code.

Your solution shouldn't take more than an hour or so to complete.

Please use simple linear search (not binary search).

Please implement the given function, include functional tests and a written
test plan for the function. The test plan should include functional testing and
go beyond it to other types of testing.


Implementation notes
--------------------

* API consistent with C example
    * Arrays in java hava a `.length` property which makes the `n_items` field redundant
    * `ascending` property would typically be a boolean
* No build tool (mvn, gradle etc) included
* Methods on `aerofs.search.Search` class don't practice defensive programming (e.g. checking length or order)
* #searchGreaterThan , #searchLessThan, #searchEquals in `aerofs.search.Search` may have been abstracted, however was deemed an overengineered solution.
* Was unsure if external libraries were allowed, tests so failing tests print and
throw exception. 


Building and running tests
--------------------------

    ./test.sh
