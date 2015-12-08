package javatest;  

import java.io.IOException;
/*    */ import java.util.StringTokenizer;
/*    */ import org.apache.hadoop.conf.Configuration;
/*    */ import org.apache.hadoop.fs.Path;
/*    */ import org.apache.hadoop.io.IntWritable;
    import org.apache.hadoop.io.Text;
/*    */ import org.apache.hadoop.mapreduce.Job;
/*    */ import org.apache.hadoop.mapreduce.Mapper;
/*    */ import org.apache.hadoop.mapreduce.Reducer;
/*    */ import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
/*    */ import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
/*    */ import org.apache.hadoop.util.GenericOptionsParser;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WordCount
/*    */ {
/*    */   public static class TokenizerMapper
/*    */     extends Mapper<Object, Text, Text, IntWritable>
/*    */   {
/* 39 */     private static final IntWritable one = new IntWritable(1);
/* 40 */     private Text word = new Text();
/*    */     
/*    */     public void map(Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException
/*    */     {
/* 44 */       StringTokenizer itr = new StringTokenizer(value.toString());
/* 45 */       while (itr.hasMoreTokens()) {
/* 46 */         word.set(itr.nextToken());
/* 47 */         context.write(word, one);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable>
/*    */   {
/* 54 */     private IntWritable result = new IntWritable();
/*    */     
/*    */     public void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context)
/*    */       throws IOException, InterruptedException
/*    */     {
/* 59 */       int sum = 0;
/* 60 */       for (IntWritable val : values) {
/* 61 */         sum += val.get();
/*    */       }
/* 63 */       result.set(sum);
/* 64 */       context.write(key, result);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void main(String[] args) throws Exception {
/* 69 */     Configuration conf = new Configuration();
/* 70 */     String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
/* 71 */     if (otherArgs.length < 2) {
/* 72 */       System.err.println("Usage: wordcount <in> [<in>...] <out>");
/* 73 */       System.exit(2);
/*    */     }
/* 75 */     Job job = new Job(conf, "word count");
/* 76 */     job.setJarByClass(WordCount.class);
/* 77 */     job.setMapperClass(TokenizerMapper.class);
/* 78 */     job.setCombinerClass(IntSumReducer.class);
/* 79 */     job.setReducerClass(IntSumReducer.class);
/* 80 */     job.setOutputKeyClass(Text.class);
/* 81 */     job.setOutputValueClass(IntWritable.class);
/* 82 */     for (int i = 0; i < otherArgs.length - 1; i++) {
/* 83 */       FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
/*    */     }
/* 85 */     FileOutputFormat.setOutputPath(job, new Path(otherArgs[(otherArgs.length - 1)]));
/*    */     
/* 87 */     System.exit(job.waitForCompletion(true) ? 0 : 1);
/*    */   }
/*    */ }

/* Location:           /home/yuess/下载/hadoop-2.6.0/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.6.0.jar
 * Qualified Name:     org.apache.hadoop.examples.WordCount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */