# Demo-Todo-MVC

This project has 5 tags divided in:
```
  - tagAll
  - THA-1
  - THA-2
  - THA-3
  - THA-4
```

To exec a test, you can use this sentence adding a tag, for example @THA-2:

```
mvn test -Denvironments=local_chrome -Dcucumber.features='src/test/resources/features/' -Dcucumber.filter.tags='@THA-2' -Dcucumber.plugin="json:target/site/result.json" -Dcucumber.glue='demo'
```

When the test is finished, you can run this command to generate the report:

```
mvn serenity:aggregate
```

And the evidences will be in this path:

```
target/site/serenity/index.html

```