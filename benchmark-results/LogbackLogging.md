# Logback Logging Benchmark

## CPU Intel i7-10510U

### Setup:

* Liberica JDK 11.0.5
* Logback 1.2.3 version
* Slf4j 1.7.29 version

| Benchmark                               | (stringLength) | Mode | Cnt |   Score   |   Error    | Units |
|:----------------------------------------|:--------------:|:----:|:---:|:---------:|:----------:|:-----:|
| LogbackLogging.log4j2ErrorConcatenation |       15       | avgt | 20  | 19586.519 | ± 1440.294 | ns/op |
| LogbackLogging.log4j2InfoConcatenation  |       15       | avgt | 20  | 20198.461 | ± 1552.329 | ns/op |
| LogbackLogging.slf4jErrorConcatenation  |       15       | avgt | 20  | 19407.103 | ± 1440.900 | ns/op |
| LogbackLogging.slf4jErrorPlaceholder    |       15       | avgt | 20  | 19963.135 | ± 1480.626 | ns/op |
| LogbackLogging.slf4jInfoConcatenation   |       15       | avgt | 20  | 19504.800 | ± 1457.468 | ns/op |
| LogbackLogging.slf4jInfoPlaceholder     |       15       | avgt | 20  | 20079.858 | ± 1534.026 | ns/op |

<style>
H1{color:lightBlue;}
H2{color:darkOrange;}
</style>