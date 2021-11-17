package com.opstty.reducer;
import java.io.IOException;
import java.util.stream.StreamSupport;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class MaxHeightReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {
    public void reduce(Text key, Iterable<FloatWritable> values, Context context)
            throws IOException, InterruptedException {
        context.write(key, new FloatWritable(StreamSupport.stream(values.spliterator(), false)
                .map((c) -> { return c.get(); })
                .max(Float::compare).get()));
    }
}
