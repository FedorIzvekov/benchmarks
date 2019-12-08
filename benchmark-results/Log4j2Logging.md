# Log4j2 Logging Benchmark

## CPU Intel i7-10510U

### Setup:

* Liberica JDK 11.0.5
* Log4j 2.12.1 version

| Benchmark                                      | (stringLength) | Mode | Cnt |           Score            |   Error    | Units |
|:-----------------------------------------------|:--------------:|:----:|:---:|:--------------------------:|:----------:|:-----:|
| Log4j2Logging.log4j2ErrorConcatenation         |       15       | avgt | 20  |         20396.196          | ± 508.357  | ns/op |
| Log4j2Logging.log4j2ErrorPlaceholder           |       15       | avgt | 20  |         20458.130          | ± 261.298  | ns/op |
| Log4j2Logging.log4j2ErrorSupplierConcatenation |       15       | avgt | 20  |         20871.319          | ± 280.914  | ns/op |
| Log4j2Logging.log4j2InfoConcatenation          |       15       | avgt | 20  |         20390.442          | ± 292.687  | ns/op |
| Log4j2Logging.log4j2InfoPlaceholder            |       15       | avgt | 20  |         20309.933          | ± 265.009  | ns/op |
| Log4j2Logging.log4j2InfoSupplierConcatenation  |       15       | avgt | 20  |         18758.164          | ± 1241.049 | ns/op |
| Log4j2Logging.slf4jErrorConcatenation          |       15       | avgt | 20  | <green> 17414.431 </green> | ± 220.060  | ns/op |
| Log4j2Logging.slf4jErrorPlaceholder            |       15       | avgt | 20  | <green> 17399.880 </green> | ± 377.822  | ns/op |
| Log4j2Logging.slf4jInfoConcatenation           |       15       | avgt | 20  | <green> 17432.517 </green> | ± 292.452  | ns/op |
| Log4j2Logging.slf4jInfoPlaceholder             |       15       | avgt | 20  | <green> 17278.806 </green> | ± 174.756  | ns/op |

<style>
H1{color:lightBlue;}
H2{color:darkOrange;}
green{background:green;}
</style>