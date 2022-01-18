# Apache Maven Example

---

### Goal
The goal of this project is to demonstrate a very basic project outline for Apache Maven. From here, we will do the following:

---
### Steps

1. Add Apache Beam Dependencies including apache beam runner.
- beam-sdks-java-core
- beam-runners-direct-java

2. Set up a Basic Apache Beam Pipeline
- Import necessary utilities
- Create PipelineOptions object
- Create Pipeline using that PipelineOptions object as its options parameter
- Create a list of Strings to be printed out to a text file
- Use a TextIO PTransform to write that list out to an output file (apache-example/output/file.txt)
    - Will requie using .withSuffix() and .withNumShards() to specify the type of file, and amount of files.
- Look at the output file to see if it worked.

3. Run the program in Maven using the following commands:
`mvn clean compile`
`mvn compile exec:java -Dexec.mainClass=Main`