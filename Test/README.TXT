The file extension "kspn" is related to KRYO serializer and "sspn" is related to official java serializer.
Change log:
-Overhaul of the code and data design
    -Cases are grouped together and sampling is revised
    -All rows are tagged by ID, removing the bugs of missing transactions on output links related to an input link.
-Removing CSVReader, CSVReader has a severe bug in which generates temporary file in the OS temporary folder ("user/appdata/local/temp" for win). It generates a huge number of tiny files and doesn't clean them. ArffReader is used instead.
    Warning: Don't use the older version of this app, it will deteriorate OS performance in long run if the temp folder not cleaned.
-Implementing KRYO, KRYO serializer, which is a high performance serializer working approx 10 times faster than official java serializable, is incompatible with Weka.Instances class. Therefore, the source of Weka is editted and recompiled to omit the header of the classifier. Therefore, the header(Insatances) is saved as Text Arff and it is generated in runtime.
    Note: If you want to change the classifier of the nodes/events, you have to set the header of the classifer as "public", which is "protected" by default, and recompile the Weka.
-GUI section is isolated from algorithms. Therefore, the model can be generated in terminal.
-Redundant libraries are removed.
Known bugs:
-KRYO serializer ID is not set for all classes.
-kRYO fails to load classifier descriptions out of development environment(release binaries).
-There are redundant sections in Weka models which may store train data inside themselves and cause the model to get bigger in size as the train data gets larger. It needs to be checked.