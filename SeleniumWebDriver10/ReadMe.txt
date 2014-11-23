# Run tests and generate .xml reports
mvn test

# Convert .xml reports into .html report, but without the CSS or images
mvn surefire-report:report-only

# Put the CSS and images where they need to be without the rest of the
# time-consuming stuff
mvn site -DgenerateReports=false


hamcrest
http://www.objectpartners.com/2013/09/18/the-benefits-of-using-assertthat-over-other-assert-methods-in-unit-tests/
http://edgibbs.com/junit-4-with-hamcrest/
http://tutorials.jenkov.com/java-unit-testing/matchers.html
https://code.google.com/p/hamcrest/w/list
http://intensetesting.wordpress.com/2013/12/18/assertion-using-hamcrest-core-matchers/


https://code.google.com/p/xml-matchers/