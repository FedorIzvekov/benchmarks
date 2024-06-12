# Random Integer Generators Benchmark

[**CPU Intel i7-10510U**](#cpu-intel-i7-10510u)

* [Liberica JDK 21.0.3](#liberica-jdk-2103)

## CPU Intel i7-10510U

### Liberica JDK 21.0.3

#### 👍 Best result:

* **SplittableRandom**
* **ThreadLocalRandom**

| Benchmark                   | rangeMin | rangeMax | Mode | Cnt |         Score          |  Error  | Units |
|:----------------------------|:--------:|:--------:|:----:|:---:|:----------------------:|:-------:|:-----:|
| JdkRandom.splittableRandom  |    1     |    10    | avgt | 20  | <green> 4.213 </green> | ± 0.003 | ns/op |
| JdkRandom.splittableRandom  |    1     |   100    | avgt | 20  | <green> 4.213 </green> | ± 0.003 | ns/op |
| JdkRandom.splittableRandom  |    1     |   1000   | avgt | 20  | <green> 4.212 </green> | ± 0.002 | ns/op |
| JdkRandom.splittableRandom  |    1     |  10000   | avgt | 20  | <green> 4.214 </green> | ± 0.004 | ns/op |
| JdkRandom.threadLocalRandom |    1     |    10    | avgt | 20  | <green> 4.646 </green> | ± 0.006 | ns/op |
| JdkRandom.threadLocalRandom |    1     |   100    | avgt | 20  | <green> 4.645 </green> | ± 0.002 | ns/op |
| JdkRandom.threadLocalRandom |    1     |   1000   | avgt | 20  | <green> 4.653 </green> | ± 0.009 | ns/op |
| JdkRandom.threadLocalRandom |    1     |  10000   | avgt | 20  | <green> 4.649 </green> | ± 0.008 | ns/op |
| JdkRandom.random            |    1     |    10    | avgt | 20  |         8.577          | ± 0.217 | ns/op |
| JdkRandom.random            |    1     |   100    | avgt | 20  |         8.605          | ± 0.002 | ns/op |
| JdkRandom.random            |    1     |   1000   | avgt | 20  |         8.615          | ± 0.008 | ns/op |
| JdkRandom.random            |    1     |  10000   | avgt | 20  |         8.628          | ± 0.009 | ns/op |
| JdkRandom.secureRandom      |    1     |    10    | avgt | 20  |  <red> 126.734 </red>  | ± 0.956 | ns/op |
| JdkRandom.secureRandom      |    1     |   100    | avgt | 20  |  <red> 130.093 </red>  | ± 1.873 | ns/op |
| JdkRandom.secureRandom      |    1     |   1000   | avgt | 20  |  <red> 126.225 </red>  | ± 1.343 | ns/op |
| JdkRandom.secureRandom      |    1     |  10000   | avgt | 20  |  <red> 127.882 </red>  | ± 1.559 | ns/op |


#### 🍀 Analysis Luck:
| Benchmark                   | rangeMin | rangeMax | Total random numbers | Lucky random numbers | % success |
|:----------------------------|:--------:|:--------:|:--------------------:|:--------------------:|:---------:|
| SplittableRandom            |    1     |    10    |      1,000,000       |       111,040        |  11.104   |
| ThreadLocalRandom           |    1     |    10    |      1,000,000       |       111,176        |  11.1176  |
| Random                      |    1     |    10    |      1,000,000       |       111,112        |  11.1112  |
| SecureRandom                |    1     |    10    |      1,000,000       |       110,852        |  11.0852  |
| SplittableRandom            |    1     |   100    |      1,000,000       |        10,238        |  1.0238   |
| ThreadLocalRandom           |    1     |   100    |      1,000,000       |        10,141        |  1.0141   |
| Random                      |    1     |   100    |      1,000,000       |        10,225        |  1.0225   |
| SecureRandom                |    1     |   100    |      1,000,000       |        10,149        |  1.0149   |
| SplittableRandom            |    1     |  1,000   |      1,000,000       |         999          |  0.0999   |
| ThreadLocalRandom           |    1     |  1,000   |      1,000,000       |        1,025         |  0.1025   |
| Random                      |    1     |  1,000   |      1,000,000       |        1,001         |  0.1001   |
| SecureRandom                |    1     |  1,000   |      1,000,000       |        1,014         |  0.1014   |
| SplittableRandom            |    1     |  10,000  |      1,000,000       |          80          |   0.008   |
| ThreadLocalRandom           |    1     |  10,000  |      1,000,000       |          84          |  0.0084   |
| Random                      |    1     |  10,000  |      1,000,000       |          94          |  0.0094   |
| SecureRandom                |    1     |  10,000  |      1,000,000       |         102          |  0.0102   |

<style>
H1,H2{color:lightBlue;}
H3{color:darkOrange;}
H4{color:lightGreen;}
green{background:green;}
red{background:red;}
</style>

