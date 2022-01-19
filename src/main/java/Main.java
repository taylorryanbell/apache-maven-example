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

        // create pipeline options object
        PipelineOptions options = PipelineOptionsFactory.create();

        // create pipeline object
        Pipeline pipeline = Pipeline.create(options);

        final List<String> input = Arrays.asList("pie", "cake", "donut");

        pipeline
                .apply(Create.of(input))  // define the input variable
                .apply(TextIO.write()  // call the TextIO.write() PTransform
                        .to("output/file")  // define output file
                        .withSuffix(".txt")  // define filetype extension
                        .withoutSharding());  // define number of shards


        // run pipeline
        pipeline.run();


    }
}
