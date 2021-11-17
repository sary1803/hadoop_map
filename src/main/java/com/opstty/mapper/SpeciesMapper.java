package com.opstty.mapper;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class SpeciesMapper extends Mapper<Object, Text, Text, NullWritable> {
    public int current_line = 0;

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (current_line != 0) {
            Text tree= new Text(value.toString().split(";")[3]);
            context.write(tree, NullWritable.get());
        }
        current_line++;
    }
}