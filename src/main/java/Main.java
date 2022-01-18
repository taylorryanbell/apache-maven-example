import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("  Simple Apache Maven & Beam Example  ");
        System.out.println("--------------------------------------");

        // create the PipelineOptions object (called 'options')
        PipelineOptions options = PipelineOptionsFactory.create();

        // create a pipeline
        Pipeline pipeline = Pipeline.create(options);

        // creating a local variable to write out
        final List<String> input = Arrays.asList("one", "two", "three");

        // use the TextIO.write() PTransform to write the contents of the input variable to a file
        pipeline
                .apply(Create.of(input))  // define the input variable
                .apply(TextIO.write()  // call the TextIO.write() PTransform
                        .to("output/file")  // define output file
                        .withSuffix(".txt")  // define filetype extension
                        .withoutSharding());  // define number of shards

        // run the pipeline
        pipeline.run().waitUntilFinish();
        System.out.print("Finished pipeline.");
    }
}
