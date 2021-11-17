package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");

            programDriver.addClass("kindtrees", KindTrees.class,
                    "A map/reduce program that returns the distinct tree species (and the number of trees for each one) in the Remarkable Trees of Paris dataset.");
            programDriver.addClass("District", District.class,
                    "A map/reduce program that returns the distinct districts with trees in the Remarkable Trees of Paris dataset.");

            programDriver.addClass("species", Species.class,
                    "A map/reduce program that returns the distinct tree species in the Remarkable Trees of Paris dataset.");
            programDriver.addClass("maxHeight", MaxHeight.class,
                    "A map/reduce program that returns the highest height of trees per species in the Remarkable Trees of Paris dataset.");

            programDriver.addClass("SortHeight", SortHeight.class,
                    "A map/reduce program that returns all the trees in the Remarkable Trees of Paris dataset, sorted by height.");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
