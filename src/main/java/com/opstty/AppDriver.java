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
                    "A map/reduce program that counts the different species in  tree.csv");
            programDriver.addClass("District", District.class,
                    "A map/reduce program that returns the distinct districts with trees  and the number of occurences in  tree.csv.");

            programDriver.addClass("species", Species.class,
                    "A map/reduce program that returns the distinct tree species in  tree.csv.");
            programDriver.addClass("maxHeight", MaxHeight.class,
                    "A map/reduce program that returns the highest height of trees per species in  tree.csv.");

            programDriver.addClass("SortHeight", SortHeight.class,
                    "A map/reduce program that returns all the trees in tree.csv, sorted by height.");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
