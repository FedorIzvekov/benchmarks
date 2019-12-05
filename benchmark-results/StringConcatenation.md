# String Concatenation Benchmark

[**CPU Intel i7-10510U**](#cpu-intel-i7-10510u)

* [Liberica JDK 11.0.5](#liberica-jdk-1105)
* [Oracle JDK 1.8.0_231](#oracle-jdk-180231)

## CPU Intel i7-10510U

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