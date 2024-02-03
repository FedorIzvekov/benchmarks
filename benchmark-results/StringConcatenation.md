# String Concatenation Benchmark

[**CPU Intel i7-10510U**](#cpu-intel-i7-10510u)

* [Liberica JDK 21.0.1](#liberica-jdk-2101)
* [Liberica JDK 17.0.1](#liberica-jdk-1701)
* [Liberica JDK 11.0.5](#liberica-jdk-1105)
* [Oracle JDK 1.8.0_231](#oracle-jdk-180231)

## CPU Intel i7-10510U

### Liberica JDK 21.0.1

#### 👍 Best result:

* **Operator plus (+) without loop**
* **StringBuilder with capacity**
* **StringBuffer with capacity**

#### 🛑 Worst result:

* **String.format()**
* **formatted()**
* **concat() for large number of strings**
* **Operator plus (+) in loop for large number of strings**

| Benchmark                                           | String Count | String Length | Mode | Cnt |           Score           |   Error   | Units |
|:----------------------------------------------------|:------------:|:-------------:|:----:|:---:|:-------------------------:|:---------:|:-----:|
| StringConcatenation.operatorPlus10                  |     N/A      |      15       | avgt | 20  |  <green> 70.970 </green>  |  ± 0.639  | ns/op |
| StringConcatenation.operatorPlus50                  |     N/A      |      15       | avgt | 20  | <green> 383.229 </green>  |  ± 2.991  | ns/op |
| StringConcatenation.operatorPlus100                 |     N/A      |      15       | avgt | 20  | <green> 795.888 </green>  |  ± 7.951  | ns/op |
| StringConcatenation.operatorPlusWithoutJit10        |     N/A      |      15       | avgt | 20  |          363.994          |  ± 7.338  | ns/op |
| StringConcatenation.operatorPlusWithoutJit50        |     N/A      |      15       | avgt | 20  |         1592.714          | ± 15.511  | ns/op |
| StringConcatenation.operatorPlusWithoutJit100       |     N/A      |      15       | avgt | 20  |         3139.281          | ± 45.340  | ns/op |
| StringConcatenationInLoop.operatorPlus              |      10      |      15       | avgt | 20  |          165.855          |  ± 1.923  | ns/op |
| StringConcatenationInLoop.operatorPlus              |      50      |      15       | avgt | 20  |   <red> 1876.199 </red>   |  ± 5.993  | ns/op |
| StringConcatenationInLoop.operatorPlus              |     100      |      15       | avgt | 20  |   <red> 6882.424 </red>   | ± 21.091  | ns/op |
| StringConcatenationInLoop.stringBuffer              |      10      |      15       | avgt | 20  | <green> 127.247 </green>  |  ± 1.278  | ns/op |
| StringConcatenationInLoop.stringBuffer              |      50      |      15       | avgt | 20  | <green> 494.230 </green>  |  ± 4.999  | ns/op |
| StringConcatenationInLoop.stringBuffer              |     100      |      15       | avgt | 20  |         1104.102          |  ± 5.479  | ns/op |
| StringConcatenationInLoop.stringBufferWithCapacity  |      10      |      15       | avgt | 20  | <green> 121.177 </green>  |  ± 1.186  | ns/op |
| StringConcatenationInLoop.stringBufferWithCapacity  |      50      |      15       | avgt | 20  | <green> 440.987 </green>  |  ± 4.669  | ns/op |
| StringConcatenationInLoop.stringBufferWithCapacity  |     100      |      15       | avgt | 20  | <green> 904.711 </green>  |  ± 5.460  | ns/op |
| StringConcatenationInLoop.stringBuilder             |      10      |      15       | avgt | 20  | <green> 127.427 </green>  |  ± 1.149  | ns/op |
| StringConcatenationInLoop.stringBuilder             |      50      |      15       | avgt | 20  | <green> 494.198 </green>  |  ± 7.129  | ns/op |
| StringConcatenationInLoop.stringBuilder             |     100      |      15       | avgt | 20  | <green> 1066.160 </green> |  ± 6.088  | ns/op |
| StringConcatenationInLoop.stringBuilderWithCapacity |      10      |      15       | avgt | 20  | <green> 131.044 </green>  |  ± 0.730  | ns/op |
| StringConcatenationInLoop.stringBuilderWithCapacity |      50      |      15       | avgt | 20  | <green> 492.654 </green>  |  ± 4.472  | ns/op |
| StringConcatenationInLoop.stringBuilderWithCapacity |     100      |      15       | avgt | 20  | <green> 1013.422 </green> | ± 10.623  | ns/op |
| StringConcatenationInLoop.stringConcat              |      10      |      15       | avgt | 20  |          165.824          |  ± 1.392  | ns/op |
| StringConcatenationInLoop.stringConcat              |      50      |      15       | avgt | 20  |   <red> 1875.446 </red>   | ± 10.055  | ns/op |
| StringConcatenationInLoop.stringConcat              |     100      |      15       | avgt | 20  |   <red> 6886.231 </red>   | ± 25.454  | ns/op |
| StringConcatenationInLoop.stringFormat              |      10      |      15       | avgt | 20  |   <red> 472.964 </red>    |  ± 6.191  | ns/op |
| StringConcatenationInLoop.stringFormat              |      50      |      15       | avgt | 20  |   <red> 2265.542 </red>   | ± 22.339  | ns/op |
| StringConcatenationInLoop.stringFormat              |     100      |      15       | avgt | 20  |   <red> 4465.917 </red>   | ± 55.242  | ns/op |
| StringConcatenationInLoop.stringFormatted           |      10      |      15       | avgt | 20  |   <red> 474.736 </red>    |  ± 5.738  | ns/op |
| StringConcatenationInLoop.stringFormatted           |      50      |      15       | avgt | 20  |   <red> 2244.102 </red>   | ± 30.865  | ns/op |
| StringConcatenationInLoop.stringFormatted           |     100      |      15       | avgt | 20  |   <red> 4518.939 </red>   | ± 29.370  | ns/op |
| StringConcatenationInLoop.stringJoiner              |      10      |      15       | avgt | 20  | <green> 125.947 </green>  |  ± 1.632  | ns/op |
| StringConcatenationInLoop.stringJoiner              |      50      |      15       | avgt | 20  |          617.913          |  ± 7.011  | ns/op |
| StringConcatenationInLoop.stringJoiner              |     100      |      15       | avgt | 20  |         1265.676          | ± 110.655 | ns/op |
| StringConcatenationInLoop.stringStreamJoining       |      10      |      15       | avgt | 20  |          167.515          |  ± 1.361  | ns/op |
| StringConcatenationInLoop.stringStreamJoining       |      50      |      15       | avgt | 20  |          610.023          |  ± 5.536  | ns/op |
| StringConcatenationInLoop.stringStreamJoining       |     100      |      15       | avgt | 20  |         1272.457          |  ± 5.201  | ns/op |

### Liberica JDK 17.0.1

#### 👍 Best result:

* **Operator plus (+) without loop**
* **StringBuilder with capacity**
* **StringBuffer with capacity**

#### 🛑 Worst result:

* **String.format()**
* **formatted()**
* **concat() for large number of strings**
* **Operator plus (+) in loop for large number of strings**

| Benchmark                                           | String Count | String Length | Mode | Cnt |           Score           |   Error   | Units |
|:----------------------------------------------------|:------------:|:-------------:|:----:|:---:|:-------------------------:|:---------:|:-----:|
| StringConcatenation.operatorPlus10                  |     N/A      |      15       | avgt | 20  |  <green> 68.588 </green>  |  ± 0.851  | ns/op |
| StringConcatenation.operatorPlus50                  |     N/A      |      15       | avgt | 20  | <green> 367.404 </green>  |  ± 5.337  | ns/op |
| StringConcatenation.operatorPlus100                 |     N/A      |      15       | avgt | 20  | <green> 772.811 </green>  | ± 12.888  | ns/op |
| StringConcatenation.operatorPlusWithoutJit10        |     N/A      |      15       | avgt | 20  |          338.878          |  ± 4.610  | ns/op |
| StringConcatenation.operatorPlusWithoutJit50        |     N/A      |      15       | avgt | 20  |         1593.979          | ± 23.772  | ns/op |
| StringConcatenation.operatorPlusWithoutJit100       |     N/A      |      15       | avgt | 20  |         3886.157          | ± 283.342 | ns/op |
| StringConcatenationInLoop.operatorPlus              |      10      |      15       | avgt | 20  |          172.108          |  ± 1.445  | ns/op |
| StringConcatenationInLoop.operatorPlus              |      50      |      15       | avgt | 20  |   <red> 1914.682 </red>   | ± 15.182  | ns/op |
| StringConcatenationInLoop.operatorPlus              |     100      |      15       | avgt | 20  |   <red> 6962.105 </red>   | ± 17.748  | ns/op |
| StringConcatenationInLoop.stringBuffer              |      10      |      15       | avgt | 20  | <green> 141.266 </green>  |  ± 2.980  | ns/op |
| StringConcatenationInLoop.stringBuffer              |      50      |      15       | avgt | 20  |          539.472          |  ± 5.511  | ns/op |
| StringConcatenationInLoop.stringBuffer              |     100      |      15       | avgt | 20  |         1135.076          |  ± 7.211  | ns/op |
| StringConcatenationInLoop.stringBufferWithCapacity  |      10      |      15       | avgt | 20  | <green> 130.360 </green>  |  ± 1.043  | ns/op |
| StringConcatenationInLoop.stringBufferWithCapacity  |      50      |      15       | avgt | 20  | <green> 477.530 </green>  |  ± 5.061  | ns/op |
| StringConcatenationInLoop.stringBufferWithCapacity  |     100      |      15       | avgt | 20  | <green> 988.916 </green>  |  ± 5.948  | ns/op |
| StringConcatenationInLoop.stringBuilder             |      10      |      15       | avgt | 20  | <green> 133.225 </green>  |  ± 1.195  | ns/op |
| StringConcatenationInLoop.stringBuilder             |      50      |      15       | avgt | 20  | <green> 522.131 </green>  |  ± 4.104  | ns/op |
| StringConcatenationInLoop.stringBuilder             |     100      |      15       | avgt | 20  |         1125.221          |  ± 7.063  | ns/op |
| StringConcatenationInLoop.stringBuilderWithCapacity |      10      |      15       | avgt | 20  | <green> 139.482 </green>  |  ± 1.367  | ns/op |
| StringConcatenationInLoop.stringBuilderWithCapacity |      50      |      15       | avgt | 20  | <green> 520.988 </green>  |  ± 5.587  | ns/op |
| StringConcatenationInLoop.stringBuilderWithCapacity |     100      |      15       | avgt | 20  | <green> 1083.015 </green> |  ± 7.265  | ns/op |
| StringConcatenationInLoop.stringConcat              |      10      |      15       | avgt | 20  |          167.871          |  ± 1.371  | ns/op |
| StringConcatenationInLoop.stringConcat              |      50      |      15       | avgt | 20  |   <red> 1894.719 </red>   |  ± 6.335  | ns/op |
| StringConcatenationInLoop.stringConcat              |     100      |      15       | avgt | 20  |   <red> 6919.172 </red>   | ± 24.097  | ns/op |
| StringConcatenationInLoop.stringFormat              |      10      |      15       | avgt | 20  |   <red> 489.979 </red>    |  ± 4.136  | ns/op |
| StringConcatenationInLoop.stringFormat              |      50      |      15       | avgt | 20  |   <red> 2320.635 </red>   | ± 26.187  | ns/op |
| StringConcatenationInLoop.stringFormat              |     100      |      15       | avgt | 20  |   <red> 4710.067 </red>   | ± 68.965  | ns/op |
| StringConcatenationInLoop.stringFormatted           |      10      |      15       | avgt | 20  |   <red> 495.102 </red>    |  ± 4.341  | ns/op |
| StringConcatenationInLoop.stringFormatted           |      50      |      15       | avgt | 20  |   <red> 2254.963 </red>   | ± 32.392  | ns/op |
| StringConcatenationInLoop.stringFormatted           |     100      |      15       | avgt | 20  |   <red> 4539.605 </red>   | ± 31.862  | ns/op |
| StringConcatenationInLoop.stringJoiner              |      10      |      15       | avgt | 20  |  <green> 134.142 </red>   |  ± 1.365  | ns/op |
| StringConcatenationInLoop.stringJoiner              |      50      |      15       | avgt | 20  |          616.751          |  ± 6.608  | ns/op |
| StringConcatenationInLoop.stringJoiner              |     100      |      15       | avgt | 20  |         1153.577          | ± 13.992  | ns/op |
| StringConcatenationInLoop.stringStreamJoining       |      10      |      15       | avgt | 20  |          181.475          |  ± 1.903  | ns/op |
| StringConcatenationInLoop.stringStreamJoining       |      50      |      15       | avgt | 20  |          664.516          |  ± 7.062  | ns/op |
| StringConcatenationInLoop.stringStreamJoining       |     100      |      15       | avgt | 20  |         1340.216          | ± 10.494  | ns/op |

### Liberica JDK 11.0.5

#### 👍 Best result: StringBuilder with capacity

#### 🛑 Worst result:

* String.format()
* concat() for large number of strings
* Operator plus (+) for large number of strings

| Benchmark                                           | String Count | String Length | Mode | Cnt |           Score           |   Error   | Units |
|:----------------------------------------------------|:------------:|:-------------:|:----:|:---:|:-------------------------:|:---------:|:-----:|
| StringConcatenationInLoop.operatorPlus              |      10      |      15       | avgt | 20  |          185.663          |  ± 5.332  | ns/op |
| StringConcatenationInLoop.operatorPlus              |      50      |      15       | avgt | 20  |   <red> 1973.417 </red>   |  ± 5.875  | ns/op |
| StringConcatenationInLoop.operatorPlus              |     100      |      15       | avgt | 20  |   <red> 7160.190 </red>   | ± 36.283  | ns/op |
| StringConcatenationInLoop.stringBuffer              |      10      |      15       | avgt | 20  |          185.858          | ± 17.460  | ns/op |
| StringConcatenationInLoop.stringBuffer              |      50      |      15       | avgt | 20  |          812.353          |  ± 2.764  | ns/op |
| StringConcatenationInLoop.stringBuffer              |     100      |      15       | avgt | 20  |         1637.709          |  ± 9.675  | ns/op |
| StringConcatenationInLoop.stringBufferWithCapacity  |      10      |      15       | avgt | 20  |          150.514          |  ± 1.235  | ns/op |
| StringConcatenationInLoop.stringBufferWithCapacity  |      50      |      15       | avgt | 20  |          754.906          |  ± 4.423  | ns/op |
| StringConcatenationInLoop.stringBufferWithCapacity  |     100      |      15       | avgt | 20  |         1547.489          | ± 15.753  | ns/op |
| StringConcatenationInLoop.stringBuilder             |      10      |      15       | avgt | 20  |          163.658          |  ± 3.736  | ns/op |
| StringConcatenationInLoop.stringBuilder             |      50      |      15       | avgt | 20  |          641.099          | ± 13.448  | ns/op |
| StringConcatenationInLoop.stringBuilder             |     100      |      15       | avgt | 20  |         1343.843          | ± 27.650  | ns/op |
| StringConcatenationInLoop.stringBuilderWithCapacity |      10      |      15       | avgt | 20  | <green> 143.107 </green>  |  ± 3.161  | ns/op |
| StringConcatenationInLoop.stringBuilderWithCapacity |      50      |      15       | avgt | 20  | <green> 543.589 </green>  | ± 11.756  | ns/op |
| StringConcatenationInLoop.stringBuilderWithCapacity |     100      |      15       | avgt | 20  | <green> 1056.853 </green> | ± 15.782  | ns/op |
| StringConcatenationInLoop.stringConcat              |      10      |      15       | avgt | 20  |          200.151          |  ± 7.227  | ns/op |
| StringConcatenationInLoop.stringConcat              |      50      |      15       | avgt | 20  |   <red> 1999.272 </red>   | ± 24.456  | ns/op |
| StringConcatenationInLoop.stringConcat              |     100      |      15       | avgt | 20  |  <red> 7249.557 </span>   | ± 49.220  | ns/op |
| StringConcatenationInLoop.stringFormat              |      10      |      15       | avgt | 20  |   <red> 1815.746 </red>   | ± 18.201  | ns/op |
| StringConcatenationInLoop.stringFormat              |      50      |      15       | avgt | 20  |   <red> 8391.629 </red>   | ± 104.358 | ns/op |
| StringConcatenationInLoop.stringFormat              |     100      |      15       | avgt | 20  |  <red> 17427.287 </red>   | ± 433.179 | ns/op |
| StringConcatenationInLoop.stringJoiner              |      10      |      15       | avgt | 20  |          196.539          |  ± 3.488  | ns/op |
| StringConcatenationInLoop.stringJoiner              |      50      |      15       | avgt | 20  |          859.977          | ± 24.205  | ns/op |
| StringConcatenationInLoop.stringJoiner              |     100      |      15       | avgt | 20  |         1844.472          | ± 47.300  | ns/op |
| StringConcatenationInLoop.stringStreamJoining       |      10      |      15       | avgt | 20  |          213.994          |  ± 1.865  | ns/op |
| StringConcatenationInLoop.stringStreamJoining       |      50      |      15       | avgt | 20  |          725.296          | ± 14.702  | ns/op |
| StringConcatenationInLoop.stringStreamJoining       |     100      |      15       | avgt | 20  |         1479.620          | ± 17.037  | ns/op |

### Oracle JDK 1.8.0.231

#### 👍 Best result:

* StringBuilder with capacity
* StringBuffer with capacity

#### 🛑 Worst result:

* String.format()
* concat()
* Operator plus (+) for large number of strings

| Benchmark                                           | String Count | String Length | Mode | Cnt |           Score           |   Error   | Units |
|:----------------------------------------------------|:------------:|:-------------:|:----:|:---:|:-------------------------:|:---------:|:-----:|
| StringConcatenationInLoop.operatorPlus              |      10      |      15       | avgt | 20  | <green> 182.233 </green>  |  ± 0.383  | ns/op |
| StringConcatenationInLoop.operatorPlus              |      50      |      15       | avgt | 20  |   <red> 3492.748 </red>   |  ± 8.582  | ns/op |
| StringConcatenationInLoop.operatorPlus              |     100      |      15       | avgt | 20  |  <red> 13234.876 </red>   | ± 21.618  | ns/op |
| StringConcatenationInLoop.stringBuffer              |      10      |      15       | avgt | 20  |          189.343          |  ± 2.275  | ns/op |
| StringConcatenationInLoop.stringBuffer              |      50      |      15       | avgt | 20  |          832.305          |  ± 6.181  | ns/op |
| StringConcatenationInLoop.stringBuffer              |     100      |      15       | avgt | 20  |         1646.365          |  ± 5.371  | ns/op |
| StringConcatenationInLoop.stringBufferWithCapacity  |      10      |      15       | avgt | 20  | <green> 181.563 </green>  |  ± 0.981  | ns/op |
| StringConcatenationInLoop.stringBufferWithCapacity  |      50      |      15       | avgt | 20  | <green> 729.640 </green>  |  ± 3.208  | ns/op |
| StringConcatenationInLoop.stringBufferWithCapacity  |     100      |      15       | avgt | 20  | <green> 1460.727 </green> | ± 12.899  | ns/op |
| StringConcatenationInLoop.stringBuilder             |      10      |      15       | avgt | 20  |          187.278          |  ± 0.931  | ns/op |
| StringConcatenationInLoop.stringBuilder             |      50      |      15       | avgt | 20  |          866.785          |  ± 8.165  | ns/op |
| StringConcatenationInLoop.stringBuilder             |     100      |      15       | avgt | 20  |         1689.620          |  ± 7.439  | ns/op |
| StringConcatenationInLoop.stringBuilderWithCapacity |      10      |      15       | avgt | 20  | <green> 180.787 </green>  |  ± 1.725  | ns/op |
| StringConcatenationInLoop.stringBuilderWithCapacity |      50      |      15       | avgt | 20  | <green> 660.922 </green>  |  ± 2.705  | ns/op |
| StringConcatenationInLoop.stringBuilderWithCapacity |     100      |      15       | avgt | 20  | <green> 1390.390 </green> |  ± 7.243  | ns/op |
| StringConcatenationInLoop.stringConcat              |      10      |      15       | avgt | 20  |   <red> 269.143 </red>    |  ± 2.245  | ns/op |
| StringConcatenationInLoop.stringConcat              |      50      |      15       | avgt | 20  |   <red> 3429.182 </red>   |  ± 3.774  | ns/op |
| StringConcatenationInLoop.stringConcat              |     100      |      15       | avgt | 20  |  <red> 12953.096 </red>   | ± 20.731  | ns/op |
| StringConcatenationInLoop.stringFormat              |      10      |      15       | avgt | 20  |   <red> 1885.068 </red>   | ± 17.959  | ns/op |
| StringConcatenationInLoop.stringFormat              |      50      |      15       | avgt | 20  |   <red> 8797.748 </red>   | ± 124.813 | ns/op |
| StringConcatenationInLoop.stringFormat              |     100      |      15       | avgt | 20  |  <red> 17401.705 </red>   | ± 167.567 | ns/op |
| StringConcatenationInLoop.stringJoiner              |      10      |      15       | avgt | 20  |          251.704          |  ± 1.994  | ns/op |
| StringConcatenationInLoop.stringJoiner              |      50      |      15       | avgt | 20  |         1067.526          |  ± 7.576  | ns/op |
| StringConcatenationInLoop.stringJoiner              |     100      |      15       | avgt | 20  |         2053.996          |  ± 8.362  | ns/op |
| StringConcatenationInLoop.stringStreamJoining       |      10      |      15       | avgt | 20  |          228.774          |  ± 3.972  | ns/op |
| StringConcatenationInLoop.stringStreamJoining       |      50      |      15       | avgt | 20  |          939.556          |  ± 5.974  | ns/op |
| StringConcatenationInLoop.stringStreamJoining       |     100      |      15       | avgt | 20  |         1793.970          |  ± 9.933  | ns/op |

<style>
H1,H2{color:lightBlue;}
H3{color:darkOrange;}
green{background:green;}
red{background:red;}
</style>