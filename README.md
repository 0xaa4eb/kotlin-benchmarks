Build:
```
mvn clean package
```

Fast check:
```
java -jar target/benchmarks.jar -wi 2 -i 2 -f 1 -tu ns -bm avgt InlineMethodBenchmark
```

Analyze:
```
java -jar target/benchmarks.jar -wi 20 -i 10 -f 1 -tu ns -bm avgt -rf text -rff results/benchmarks-8.txt -o log.txt
```