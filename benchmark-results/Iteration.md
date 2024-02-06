# Iteration Benchmark

## CPU Intel i7-10510U

[Overall Result](#overall-result)

[Liberica JDK 21.0.1](#liberica-jdk-2101)

* [Array Iteration](#array-iteration-21)
* [ArrayList Iteration](#arraylist-iteration-21)
* [LinkedList Iteration](#linkedlist-iteration-21)
* [HashMap Iteration](#hashmap-iteration-21)
* [HashSet Iteration](#hashset-iteration-21)

[Liberica JDK 17.0.1](#liberica-jdk-1701)

* [Array Iteration](#array-iteration-jdk-17)
* [ArrayList Iteration](#arraylist-iteration-jdk-17)
* [LinkedList Iteration](#linkedlist-iteration-jdk-17)
* [HashMap Iteration](#hashmap-iteration-jdk-17)
* [HashSet Iteration](#hashset-iteration-jdk-17)

[Liberica JDK 11.0.5](#liberica-jdk-1105)

* [Array Iteration](#array-iteration-jdk-11)
* [ArrayList Iteration](#arraylist-iteration-jdk-11)
* [LinkedList Iteration](#linkedlist-iteration-jdk-11)
* [HashMap Iteration](#hashmap-iteration-jdk-11)
* [HashSet Iteration](#hashset-iteration-jdk-11)

[Oracle JDK 1.8.0_231](#oracle-jdk-180231)

* [Array Iteration](#array-iteration-jdk-18)
* [ArrayList Iteration](#arraylist-iteration-jdk-18)
* [LinkedList Iteration](#linkedlist-iteration-jdk-18)
* [HashMap Iteration](#hashmap-iteration-jdk-18)
* [HashSet Iteration](#hashset-iteration-jdk-18)

### Overall Result

| Iteration through a loop of size 10 ≈ ns/op | Oracle JDK 1.8.0.231 | Liberica JDK 11.0.5 | Liberica JDK 17.0.1 | Liberica JDK 21.0.1 |
|:--------------------------------------------|:--------------------:|:-------------------:|:-------------------:|:-------------------:|
| 🏆 Array for-each                           |        51.707        |       56.270        |       48.678        |       20.376        |
| Array for                                   |        53.539        |       57.751        |       53.057        |       25.863        |
| ArrayList while                             |        50.099        |       55.630        |       55.545        |       26.268        |
| 🏆 ArrayList for-each                       |        61.195        |       60.390        |       61.024        |       26.437        |
| ArrayList for                               |        56.399        |       70.000        |       62.981        |       26.843        |
| 🏆 LinkedList for-each                      |        57.556        |       56.489        |       56.947        |       27.682        |
| Array while                                 |        52.410        |       65.403        |       54.195        |       33.126        |
| ArrayList stream                            |        54.109        |       61.064        |       56.758        |       36.259        |
| Array stream                                |        54.770        |       62.535        |       64.436        |       41.150        |
| ArrayList while iterator                    |        61.682        |       66.166        |       69.144        |       42.543        |
| LinkedList stream                           |        54.231        |       64.577        |       57.478        |       45.249        |
| 🏆 HashMap for-each                         |        67.424        |       77.887        |       101.649       |       48.948        |
| LinkedList while                            |        63.152        |       83.721        |       75.866        |       49.540        |
| LinkedList for                              |        63.637        |       70.294        |       79.736        |       51.011        |
| HashMap while                               |        77.086        |       79.790        |       81.737        |       51.760        |
| 🏆 HashSet for-each                         |        69.946        |       80.128        |       105.600       |       56.015        |
| HashMap for                                 |        76.279        |       77.768        |       79.853        |       58.274        |
| HashSet stream                              |        90.881        |       102.879       |       89.799        |       58.495        |
| HashMap stream                              |        87.030        |       102.401       |       87.703        |       61.893        |
| LinkedList while iterator                   |        60.864        |       90.890        |       87.072        |       62.359        |
| HashSet while iterator                      |        84.882        |       131.938       |       121.195       |       90.867        |
| HashMap while iterator                      |        80.839        |       130.991       |       112.240       |       94.602        |
| 🛑 HashMap parallel stream                  |       5251.079       |      8480.055       |      5299.490       |      1821.548       |
| 🛑 HashSet parallel stream                  |       4903.404       |      8443.209       |      5250.481       |      1824.014       |
| 🛑 Array parallel stream                    |       5329.719       |      9990.888       |      5473.166       |      1949.132       |
| 🛑 ArrayList parallel stream                |       5371.340       |      9988.989       |      5405.053       |      1964.288       |
| 🛑 LinkedList parallel stream               |       6363.552       |      11210.383      |      5628.638       |      2531.034       |

| Iteration through a loop of size 100 ≈ ns/op | Oracle JDK 1.8.0.231 | Liberica JDK 11.0.5 | Liberica JDK 17.0.1 | Liberica JDK 21.0.1 |
|:---------------------------------------------|:--------------------:|:-------------------:|:-------------------:|:-------------------:|
| 🏆 Array for-each                            |       516.859        |       553.480       |       485.568       |       183.436       |
| 🏆 ArrayList stream                          |       452.580        |       532.421       |       474.444       |       212.984       |
| ArrayList while                              |       509.745        |       513.783       |       538.366       |       224.564       |
| 🥈 ArrayList for-each                        |       610.563        |       592.748       |       610.599       |       231.363       |
| Array for                                    |       543.807        |       579.586       |       532.068       |       243.417       |
| ArrayList for                                |       559.035        |       708.656       |       626.035       |       267.720       |
| 🏆 LinkedList for-each                       |       599.448        |       548.610       |       599.340       |       291.188       |
| Array while                                  |       512.912        |       633.659       |       518.899       |       318.209       |
| ArrayList while iterator                     |       590.114        |       710.616       |       643.407       |       320.729       |
| LinkedList stream                            |       471.328        |       551.397       |       469.124       |       323.844       |
| Array stream                                 |       476.056        |       507.517       |       570.952       |       350.470       |
| HashMap for                                  |       852.293        |       882.011       |       824.253       |       482.196       |
| 🏆 HashMap for-each                          |       787.167        |       795.503       |      1130.958       |       484.472       |
| 🏆 HashSet for-each                          |       761.753        |       743.816       |      1148.064       |       571.999       |
| HashMap while                                |       756.500        |       802.248       |       782.878       |       572.459       |
| LinkedList while iterator                    |       611.938        |       872.256       |       819.242       |       606.910       |
| HashSet stream                               |       939.203        |      1095.776       |       990.460       |       620.594       |
| HashMap stream                               |       957.775        |      1229.719       |       961.828       |       739.175       |
| 🛑 HashSet while iterator                    |       914.617        |      1324.457       |      1321.125       |      1055.755       |
| 🛑 HashMap while iterator                    |       942.919        |      1463.483       |      1316.566       |      1131.224       |
| 🛑 LinkedList for                            |       1845.988       |      1965.593       |      1930.576       |      1374.561       |
| 🛑 LinkedList while                          |       1762.227       |      1877.147       |      1917.377       |      1393.189       |
| 🛑 ArrayList parallel stream                 |       5298.625       |      14215.759      |      6253.672       |      3946.954       |
| 🛑 Array parallel stream                     |       4670.631       |      14242.178      |      6195.342       |      3952.021       |
| 🛑 HashSet parallel stream                   |       6149.751       |      13407.520      |      6849.802       |      4174.964       |
| 🛑 HashMap parallel stream                   |       8437.223       |      13533.003      |      7546.829       |      4212.106       |
| 🛑 LinkedList parallel stream                |       7311.149       |      13573.413      |      6638.516       |      4477.108       |

| Iteration through a loop of size 1000 ≈ ns/op | Oracle JDK 1.8.0.231 | Liberica JDK 11.0.5 | Liberica JDK 17.0.1 | Liberica JDK 21.0.1 |
|:----------------------------------------------|:--------------------:|:-------------------:|:-------------------:|:-------------------:|
| 🏆 ArrayList for-each                         |       5367.434       |      6245.217       |      5711.255       |      2137.671       |
| Array for                                     |       4541.965       |      5801.407       |      6023.896       |      2170.499       |
| 🏆 Array stream                               |       4836.294       |      4603.617       |      5505.758       |      2174.740       |
| 🥈 ArrayList stream                           |       4304.753       |      6054.121       |      5992.598       |      2281.851       |
| ArrayList for                                 |       5711.178       |      6934.258       |      6592.561       |      2409.123       |
| Array while                                   |       4835.093       |      5280.361       |      5045.783       |      2898.700       |
| 🏆 LinkedList for-each                        |       5918.310       |      6000.391       |      7914.284       |      2957.095       |
| ArrayList while iterator                      |       5885.844       |      6958.425       |      6530.116       |      3069.838       |
| Array for-each                                |       5043.941       |      5028.306       |      5702.426       |      3103.731       |
| LinkedList stream                             |       4796.906       |      5990.053       |      5313.719       |      3207.707       |
| ArrayList while                               |       5081.582       |      5551.269       |      5727.451       |      3553.110       |
| 🏆 HashSet stream                             |      15818.360       |      16047.582      |      15238.307      |      5309.713       |
| ArrayList parallel stream                     |      22495.224       |      24210.603      |      20585.628      |      5324.364       |
| HashMap while                                 |       8286.079       |      9229.163       |      8121.580       |      5387.518       |
| 🏆 HashMap for-each                           |       8847.979       |      7781.086       |      10762.534      |      5445.402       |
| HashMap stream                                |       8606.974       |      8913.807       |      10566.605      |      5522.041       |
| 🛑 Array parallel stream                      |      20611.923       |      24662.142      |      21002.222      |      5555.114       |
| 🛑 LinkedList while iterator                  |       6601.877       |      8420.395       |      7441.360       |      5790.043       |
| 🛑 HashMap for                                |       8688.909       |      9982.192       |      8515.508       |      6304.391       |
| 🛑 HashSet for-each                           |       6824.631       |      15981.403      |      14601.845      |      8447.282       |
| 🛑 HashSet while iterator                     |       7763.406       |      16408.484      |      15049.812      |      8655.897       |
| 🛑 HashSet parallel stream                    |      24917.027       |      27777.871      |      26755.934      |      9381.722       |
| 🛑 HashMap while iterator                     |       7940.917       |      12727.065      |      12052.856      |      9895.865       |
| 🛑 HashMap parallel stream                    |      28978.392       |      28267.920      |      27925.295      |      10115.399      |
| 🛑 LinkedList parallel stream                 |      26361.520       |      27526.746      |      24888.407      |      16433.331      |
| 🛑 LinkedList for                             |      283295.869      |     231836.316      |     228652.514      |     221457.317      |
| 🛑 LinkedList while                           |      291284.300      |     232290.331      |     228899.586      |     222476.555      |

| Iteration through a loop of size 10000 ≈ ns/op | Liberica JDK 17.0.1 | Liberica JDK 21.0.1 |
|------------------------------------------------|---------------------|---------------------|
| 🏆 Array while                                 | 54664.499           | 22342.672           |
| Array for                                      | 60679.335           | 23413.753           |
| 🏆 ArrayList stream                            | 55824.065           | 23954.889           |
| ArrayList while                                | 53715.753           | 24261.134           |
| 🥈 Array for-each                              | 52677.594           | 24466.739           |
| 🥈 ArrayList for-each                          | 58105.518           | 24603.598           |
| ArrayList while iterator                       | 65788.230           | 26993.148           |
| Array for                                      | 58051.600           | 28338.000           |
| Array stream                                   | 54460.128           | 29123.269           |
| Array parallel stream                          | 144901.963          | 34780.239           |
| 🏆 LinkedList stream                           | 59384.735           | 35150.872           |
| 🥈 LinkedList for-each                         | 87337.259           | 35720.881           |
| ArrayList parallel stream                      | 162634.398          | 36069.678           |
| 🏆 HashMap for-each                            | 98246.109           | 52787.407           |
| 🥈 HashMap stream                              | 84355.265           | 52881.223           |
| LinkedList while iterator                      | 75406.493           | 58120.565           |
| HashMap parallel stream                        | 217173.063          | 64616.891           |
| HashMap while                                  | 87906.060           | 65040.647           |
| HashMap for                                    | 94566.753           | 72766.162           |
| 🏆 HashSet parallel stream                     | 264477.717          | 84097.014           |
| HashMap while iterator                         | 111797.313          | 90487.422           |
| LinkedList parallel stream                     | 196098.381          | 107466.241          |
| 🥈 HashSet stream                              | 184003.232          | 140850.208          |
| HashSet while iterator                         | 228361.840          | 185915.457          |
| HashSet for-each                               | 223900.536          | 188980.428          |
| LinkedList while                               | 41399089.356        | 41361742.937        |
| LinkedList for                                 | 41131708.064        | 43125345.962        |

### Liberica JDK 21.0.1

### Array Iteration 21

#### 👍 Best result:

* **for()**
* **For-Each**
* **Stream for large Array**

#### 🛑 Worst result: Parallel Stream

| Benchmark                     | Capacity | String Length | Mode | Count |           Score           |   Error    | Units |
|:------------------------------|:--------:|:-------------:|:----:|:-----:|:-------------------------:|:----------:|:-----:|
| ArrayIteration.for1           |    10    |      15       | avgt |  20   |          25.863           |  ± 0.163   | ns/op |
| ArrayIteration.for1           |   100    |      15       | avgt |  20   |          243.417          |  ± 2.732   | ns/op |
| ArrayIteration.for1           |   1000   |      15       | avgt |  20   | <green> 2170.499 </green> |  ± 24.814  | ns/op |
| ArrayIteration.for1           |  10000   |      15       | avgt |  20   |         28338.000         | ± 172.455  | ns/op |
| ArrayIteration.forEach        |    10    |      15       | avgt |  20   |  <green> 20.376 </green>  |  ± 0.018   | ns/op |
| ArrayIteration.forEach        |   100    |      15       | avgt |  20   | <green> 183.436 </green>  |  ± 1.778   | ns/op |
| ArrayIteration.forEach        |   1000   |      15       | avgt |  20   |         3103.731          |  ± 34.230  | ns/op |
| ArrayIteration.forEach        |  10000   |      15       | avgt |  20   |         24466.739         | ± 432.719  | ns/op |
| ArrayIteration.parallelStream |    10    |      15       | avgt |  20   |   <red> 1949.132 </red>   | ± 160.095  | ns/op |
| ArrayIteration.parallelStream |   100    |      15       | avgt |  20   |   <red> 3952.021 </red>   | ± 285.645  | ns/op |
| ArrayIteration.parallelStream |   1000   |      15       | avgt |  20   |   <red> 5555.114 </red>   | ± 443.349  | ns/op |
| ArrayIteration.parallelStream |  10000   |      15       | avgt |  20   |  <red> 34780.239 </red>   | ± 4884.970 | ns/op |
| ArrayIteration.stream         |    10    |      15       | avgt |  20   |          41.150           |  ± 0.381   | ns/op |
| ArrayIteration.stream         |   100    |      15       | avgt |  20   |          350.470          |  ± 4.916   | ns/op |
| ArrayIteration.stream         |   1000   |      15       | avgt |  20   | <green> 2174.740 </green> |  ± 34.063  | ns/op |
| ArrayIteration.stream         |  10000   |      15       | avgt |  20   |         29123.269         | ± 4263.594 | ns/op |
| ArrayIteration.while1         |    10    |      15       | avgt |  20   |          33.126           |  ± 0.287   | ns/op |
| ArrayIteration.while1         |   100    |      15       | avgt |  20   |          318.209          |  ± 1.592   | ns/op |
| ArrayIteration.while1         |   1000   |      15       | avgt |  20   |         2898.700          |  ± 20.602  | ns/op |
| ArrayIteration.while1         |  10000   |      15       | avgt |  20   |         22342.672         | ± 421.075  | ns/op |

### ArrayList Iteration 21

#### 👍 Best result:

* **Stream**
* **For-Each**

#### 🛑 Worst result: Parallel Stream

| Benchmark                         | Capacity | String Length | Mode | Count |           Score           |   Error    | Units |
|:----------------------------------|:--------:|:-------------:|:----:|:-----:|:-------------------------:|:----------:|:-----:|
| ArrayListIteration.for1           |    10    |      15       | avgt |  20   |          26.843           |  ± 0.448   | ns/op |
| ArrayListIteration.for1           |   100    |      15       | avgt |  20   |          267.720          |  ± 3.200   | ns/op |
| ArrayListIteration.for1           |   1000   |      15       | avgt |  20   |         2409.123          |  ± 24.986  | ns/op |
| ArrayListIteration.for1           |  10000   |      15       | avgt |  20   |         23413.753         | ± 317.334  | ns/op |
| ArrayListIteration.forEach        |    10    |      15       | avgt |  20   |          26.437           |  ± 0.429   | ns/op |
| ArrayListIteration.forEach        |   100    |      15       | avgt |  20   |          231.363          |  ± 3.335   | ns/op |
| ArrayListIteration.forEach        |   1000   |      15       | avgt |  20   | <green> 2137.671 </green> |  ± 25.180  | ns/op |
| ArrayListIteration.forEach        |  10000   |      15       | avgt |  20   |         24603.598         | ± 270.411  | ns/op |
| ArrayListIteration.parallelStream |    10    |      15       | avgt |  20   |   <red> 1964.288 </red>   | ± 162.780  | ns/op |
| ArrayListIteration.parallelStream |   100    |      15       | avgt |  20   |   <red> 3946.954 </red>   | ± 287.417  | ns/op |
| ArrayListIteration.parallelStream |   1000   |      15       | avgt |  20   |   <red> 5324.364 </red>   | ± 531.763  | ns/op |
| ArrayListIteration.parallelStream |  10000   |      15       | avgt |  20   |  <red> 36069.678 </red>   | ± 5294.525 | ns/op |
| ArrayListIteration.stream         |    10    |      15       | avgt |  20   |          36.259           |  ± 0.244   | ns/op |
| ArrayListIteration.stream         |   100    |      15       | avgt |  20   | <green> 212.984 </green>  |  ± 1.888   | ns/op |
| ArrayListIteration.stream         |   1000   |      15       | avgt |  20   |         2281.851          |  ± 32.807  | ns/op |
| ArrayListIteration.stream         |  10000   |      15       | avgt |  20   |         23954.889         | ± 369.626  | ns/op |
| ArrayListIteration.while1         |    10    |      15       | avgt |  20   |  <green> 26.268 </green>  |  ± 0.392   | ns/op |
| ArrayListIteration.while1         |   100    |      15       | avgt |  20   |          224.564          |  ± 2.786   | ns/op |
| ArrayListIteration.while1         |   1000   |      15       | avgt |  20   |         3553.110          |  ± 39.887  | ns/op |
| ArrayListIteration.while1         |  10000   |      15       | avgt |  20   |         24261.134         | ± 402.902  | ns/op |
| ArrayListIteration.whileIterator  |    10    |      15       | avgt |  20   |          42.543           |  ± 0.585   | ns/op |
| ArrayListIteration.whileIterator  |   100    |      15       | avgt |  20   |          320.729          |  ± 5.649   | ns/op |
| ArrayListIteration.whileIterator  |   1000   |      15       | avgt |  20   |         3069.838          |  ± 16.223  | ns/op |
| ArrayListIteration.whileIterator  |  10000   |      15       | avgt |  20   |         26993.148         | ± 553.382  | ns/op |

### LinkedList Iteration 21

#### 👍 Best result: Stream

#### 🛑 Worst result:

* **Parallel Stream**
* **for() for large LinkedList**
* **while() for large LinkedList**

| Benchmark                          | Capacity | String Length | Mode | Count |           Score            |    Error     | Units |
|:-----------------------------------|:--------:|:-------------:|:----:|:-----:|:--------------------------:|:------------:|:-----:|
| LinkedListIteration.for1           |    10    |      15       | avgt |  20   |           51.011           |   ± 1.070    | ns/op |
| LinkedListIteration.for1           |   100    |      15       | avgt |  20   |          1374.561          |   ± 9.824    | ns/op |
| LinkedListIteration.for1           |   1000   |      15       | avgt |  20   |  <red> 221457.317 </red>   |  ± 389.319   | ns/op |
| LinkedListIteration.for1           |  10000   |      15       | avgt |  20   | <red> 43125345.962 </red>  | ± 541220.017 | ns/op |
| LinkedListIteration.forEach        |    10    |      15       | avgt |  20   |  <green> 27.682 </green>   |   ± 0.457    | ns/op |
| LinkedListIteration.forEach        |   100    |      15       | avgt |  20   |  <green> 291.188 </green>  |   ± 2.848    | ns/op |
| LinkedListIteration.forEach        |   1000   |      15       | avgt |  20   | <green> 2957.095 </green>  |   ± 43.336   | ns/op |
| LinkedListIteration.forEach        |  10000   |      15       | avgt |  20   |         35720.881          |  ± 482.480   | ns/op |
| LinkedListIteration.parallelStream |    10    |      15       | avgt |  20   |   <red> 2531.034 </red>    |   ± 95.894   | ns/op |
| LinkedListIteration.parallelStream |   100    |      15       | avgt |  20   |    <red> 4477.108 <red>    |   ± 35.790   | ns/op |
| LinkedListIteration.parallelStream |   1000   |      15       | avgt |  20   |   <red> 16433.331 </red>   |  ± 176.278   | ns/op |
| LinkedListIteration.parallelStream |  10000   |      15       | avgt |  20   |  <red> 107466.241 </red>   | ± 14957.952  | ns/op |
| LinkedListIteration.stream         |    10    |      15       | avgt |  20   |           45.249           |   ± 0.462    | ns/op |
| LinkedListIteration.stream         |   100    |      15       | avgt |  20   |          323.844           |   ± 4.987    | ns/op |
| LinkedListIteration.stream         |   1000   |      15       | avgt |  20   |          3207.707          |   ± 39.080   | ns/op |
| LinkedListIteration.stream         |  10000   |      15       | avgt |  20   | <green> 35150.872 </green> |  ± 225.401   | ns/op |
| LinkedListIteration.while1         |    10    |      15       | avgt |  20   |           49.540           |   ± 5.337    | ns/op |
| LinkedListIteration.while1         |   100    |      15       | avgt |  20   |          1393.189          |   ± 8.862    | ns/op |
| LinkedListIteration.while1         |   1000   |      15       | avgt |  20   |  <red> 222476.555 </red>   |  ± 833.206   | ns/op |
| LinkedListIteration.while1         |  10000   |      15       | avgt |  20   | <red> 41361742.937 </red>  | ± 352207.518 | ns/op |
| LinkedListIteration.whileIterator  |    10    |      15       | avgt |  20   |           62.359           |   ± 0.956    | ns/op |
| LinkedListIteration.whileIterator  |   100    |      15       | avgt |  20   |          606.910           |   ± 10.659   | ns/op |
| LinkedListIteration.whileIterator  |   1000   |      15       | avgt |  20   |          5790.043          |   ± 92.153   | ns/op |
| LinkedListIteration.whileIterator  |  10000   |      15       | avgt |  20   |         58120.565          |  ± 879.956   | ns/op |

### HashMap Iteration 21

#### 👍 Best result:

* **For-Each**
* **while()**

#### 🛑 Worst result:

* **Parallel Stream**
* **while() with Iterator for large HashMap**
* **for() for large HashMap**

| Benchmark                       | Capacity | String Length | Mode | Count |           Score           |    Error    | Units |
|:--------------------------------|:--------:|:-------------:|:----:|:-----:|:-------------------------:|:-----------:|:-----:|
| HashMapIteration.for1           |    10    |      15       | avgt |  20   |          58.274           |   ± 0.597   | ns/op |
| HashMapIteration.for1           |   100    |      15       | avgt |  20   | <green> 482.196 </green>  |   ± 7.798   | ns/op |
| HashMapIteration.for1           |   1000   |      15       | avgt |  20   |         6304.391          |  ± 56.760   | ns/op |
| HashMapIteration.for1           |  10000   |      15       | avgt |  20   |   <red> 72766.162 <red>   |  ± 724.978  | ns/op |
| HashMapIteration.forEach        |    10    |      15       | avgt |  20   |  <green> 48.948 </green>  |   ± 0.418   | ns/op |
| HashMapIteration.forEach        |   100    |      15       | avgt |  20   |          484.472          |   ± 1.105   | ns/op |
| HashMapIteration.forEach        |   1000   |      15       | avgt |  20   |         5445.402          |  ± 83.863   | ns/op |
| HashMapIteration.forEach        |  10000   |      15       | avgt |  20   |         52787.407         | ± 4325.234  | ns/op |
| HashMapIteration.parallelStream |    10    |      15       | avgt |  20   |   <red> 1821.548 </red>   |  ± 185.272  | ns/op |
| HashMapIteration.parallelStream |   100    |      15       | avgt |  20   |   <red> 4212.106 </red>   |  ± 294.673  | ns/op |
| HashMapIteration.parallelStream |   1000   |      15       | avgt |  20   |  <red> 10115.399 </red>   | ± 1841.104  | ns/op |
| HashMapIteration.parallelStream |  10000   |      15       | avgt |  20   |         64616.891         | ± 14257.081 | ns/op |
| HashMapIteration.stream         |    10    |      15       | avgt |  20   |          61.893           |   ± 1.019   | ns/op |
| HashMapIteration.stream         |   100    |      15       | avgt |  20   |          739.175          |   ± 9.886   | ns/op |
| HashMapIteration.stream         |   1000   |      15       | avgt |  20   |         5522.041          |  ± 107.585  | ns/op |
| HashMapIteration.stream         |  10000   |      15       | avgt |  20   |         52881.223         |  ± 316.959  | ns/op |
| HashMapIteration.while1         |    10    |      15       | avgt |  20   |          51.760           |   ± 0.526   | ns/op |
| HashMapIteration.while1         |   100    |      15       | avgt |  20   |          572.459          |  ± 20.303   | ns/op |
| HashMapIteration.while1         |   1000   |      15       | avgt |  20   | <green> 5387.518 </green> |  ± 67.648   | ns/op |
| HashMapIteration.while1         |  10000   |      15       | avgt |  20   |         65040.647         |  ± 778.095  | ns/op |
| HashMapIteration.whileIterator  |    10    |      15       | avgt |  20   |          94.602           |   ± 1.961   | ns/op |
| HashMapIteration.whileIterator  |   100    |      15       | avgt |  20   |         1131.224          |  ± 16.216   | ns/op |
| HashMapIteration.whileIterator  |   1000   |      15       | avgt |  20   |   <red> 9895.865 </red>   |  ± 69.732   | ns/op |
| HashMapIteration.whileIterator  |  10000   |      15       | avgt |  20   |  <red> 90487.422 </red>   | ± 1402.409  | ns/op |

### HashSet Iteration 21

#### 👍 Best result: Stream

#### 🛑 Worst result: Parallel Stream

| Benchmark                       | Capacity | String Length | Mode | Count |           Score           |    Error    | Units |
|:--------------------------------|:--------:|:-------------:|:----:|:-----:|:-------------------------:|:-----------:|:-----:|
| HashSetIteration.forEach        |    10    |      15       | avgt |  20   |  <green> 56.015 </green>  |   ± 3.375   | ns/op |
| HashSetIteration.forEach        |   100    |      15       | avgt |  20   | <green> 571.999 </green>  |  ± 33.454   | ns/op |
| HashSetIteration.forEach        |   1000   |      15       | avgt |  20   |   <red> 8447.282 </red>   |  ± 214.937  | ns/op |
| HashSetIteration.forEach        |  10000   |      15       | avgt |  20   |  <red> 188980.428 </red>  | ± 4174.805  | ns/op |
| HashSetIteration.parallelStream |    10    |      15       | avgt |  20   |   <red> 1824.014 </red>   |  ± 199.018  | ns/op |
| HashSetIteration.parallelStream |   100    |      15       | avgt |  20   |   <red> 4174.964 </red>   |  ± 284.646  | ns/op |
| HashSetIteration.parallelStream |   1000   |      15       | avgt |  20   |   <red> 9381.722 </red>   | ± 1204.958  | ns/op |
| HashSetIteration.parallelStream |  10000   |      15       | avgt |  20   |         84097.014         | ± 10855.182 | ns/op |
| HashSetIteration.stream         |    10    |      15       | avgt |  20   |          58.495           |   ± 0.474   | ns/op |
| HashSetIteration.stream         |   100    |      15       | avgt |  20   |          620.594          |   ± 6.924   | ns/op |
| HashSetIteration.stream         |   1000   |      15       | avgt |  20   | <green> 5309.713 </green> |  ± 100.204  | ns/op |
| HashSetIteration.stream         |  10000   |      15       | avgt |  20   |        140850.208         | ± 2346.375  | ns/op |
| HashSetIteration.whileIterator  |    10    |      15       | avgt |  20   |          90.867           |   ± 1.682   | ns/op |
| HashSetIteration.whileIterator  |   100    |      15       | avgt |  20   |         1055.755          |  ± 20.455   | ns/op |
| HashSetIteration.whileIterator  |   1000   |      15       | avgt |  20   |   <red> 8655.897 <red>    |  ± 160.540  | ns/op |
| HashSetIteration.whileIterator  |  10000   |      15       | avgt |  20   |  <red> 185915.457 </red>  | ± 3214.294  | ns/op |

### Liberica JDK 17.0.1

### Array Iteration JDK 17

#### 👍 Best result:

* **For-Each**
* **while()**

#### 🛑 Worst result: Parallel Stream

| Benchmark                     | Capacity | String Length | Mode | Count |           Score            |    Error    | Units |
|:------------------------------|:--------:|:-------------:|:----:|:-----:|:--------------------------:|:-----------:|:-----:|
| ArrayIteration.for1           |    10    |      15       | avgt |  20   |           53.057           |   ± 0.701   | ns/op |
| ArrayIteration.for1           |   100    |      15       | avgt |  20   |          532.068           |   ± 7.032   | ns/op |
| ArrayIteration.for1           |   1000   |      15       | avgt |  20   |          6023.896          |  ± 24.547   | ns/op |
| ArrayIteration.for1           |  10000   |      15       | avgt |  20   |         58051.600          |  ± 425.371  | ns/op |
| ArrayIteration.forEach        |    10    |      15       | avgt |  20   |  <green> 48.678 </green>   |   ± 0.750   | ns/op |
| ArrayIteration.forEach        |   100    |      15       | avgt |  20   |  <green> 485.568 </green>  |   ± 8.157   | ns/op |
| ArrayIteration.forEach        |   1000   |      15       | avgt |  20   |          5702.426          |  ± 72.019   | ns/op |
| ArrayIteration.forEach        |  10000   |      15       | avgt |  20   | <green> 52677.594 </green> | ± 4068.161  | ns/op |
| ArrayIteration.parallelStream |    10    |      15       | avgt |  20   |   <red> 5473.166 </red>    |  ± 553.019  | ns/op |
| ArrayIteration.parallelStream |   100    |      15       | avgt |  20   |   <red> 6195.342 </red>    |  ± 295.830  | ns/op |
| ArrayIteration.parallelStream |   1000   |      15       | avgt |  20   |   <red> 21002.222 </red>   | ± 1024.855  | ns/op |
| ArrayIteration.parallelStream |  10000   |      15       | avgt |  20   |  <red> 144901.963 </red>   | ± 12947.675 | ns/op |
| ArrayIteration.stream         |    10    |      15       | avgt |  20   |           64.436           |   ± 1.154   | ns/op |
| ArrayIteration.stream         |   100    |      15       | avgt |  20   |          570.952           |   ± 7.863   | ns/op |
| ArrayIteration.stream         |   1000   |      15       | avgt |  20   |          5505.758          |  ± 214.160  | ns/op |
| ArrayIteration.stream         |  10000   |      15       | avgt |  20   |         54460.128          |  ± 387.291  | ns/op |
| ArrayIteration.while1         |    10    |      15       | avgt |  20   |           54.195           |   ± 0.639   | ns/op |
| ArrayIteration.while1         |   100    |      15       | avgt |  20   |          518.899           |   ± 5.493   | ns/op |
| ArrayIteration.while1         |   1000   |      15       | avgt |  20   |  <gren> 5045.783 </green>  |  ± 72.281   | ns/op |
| ArrayIteration.while1         |  10000   |      15       | avgt |  20   |         54664.499          |  ± 514.908  | ns/op |

### ArrayList Iteration JDK 17

#### 👍 Best result:

* **Stream**
* **For-Each**
* **while()**

#### 🛑 Worst result: Parallel Stream

| Benchmark                         | Capacity | String Length | Mode | Count |           Score            |    Error    | Units |
|:----------------------------------|:--------:|:-------------:|:----:|:-----:|:--------------------------:|:-----------:|:-----:|
| ArrayListIteration.for1           |    10    |      15       | avgt |  20   |           62.981           |   ± 0.885   | ns/op |
| ArrayListIteration.for1           |   100    |      15       | avgt |  20   |          626.035           |   ± 8.665   | ns/op |
| ArrayListIteration.for1           |   1000   |      15       | avgt |  20   |          6592.561          |  ± 83.712   | ns/op |
| ArrayListIteration.for1           |  10000   |      15       | avgt |  20   |         60679.335          |  ± 880.874  | ns/op |
| ArrayListIteration.forEach        |    10    |      15       | avgt |  20   |           61.024           |   ± 0.738   | ns/op |
| ArrayListIteration.forEach        |   100    |      15       | avgt |  20   |          610.599           |   ± 6.934   | ns/op |
| ArrayListIteration.forEach        |   1000   |      15       | avgt |  20   | <green> 5711.255 </green>  |  ± 75.821   | ns/op |
| ArrayListIteration.forEach        |  10000   |      15       | avgt |  20   |         58105.518          |  ± 514.004  | ns/op |
| ArrayListIteration.parallelStream |    10    |      15       | avgt |  20   |   <red> 5405.053 </red>    |  ± 605.574  | ns/op |
| ArrayListIteration.parallelStream |   100    |      15       | avgt |  20   |   <red> 6253.672 </red>    |  ± 85.678   | ns/op |
| ArrayListIteration.parallelStream |   1000   |      15       | avgt |  20   |   <red> 20585.628 </red>   | ± 1144.653  | ns/op |
| ArrayListIteration.parallelStream |  10000   |      15       | avgt |  20   |  <red> 162634.398 </red>   | ± 13792.080 | ns/op |
| ArrayListIteration.stream         |    10    |      15       | avgt |  20   |           56.758           |   ± 1.145   | ns/op |
| ArrayListIteration.stream         |   100    |      15       | avgt |  20   |  <green> 474.444 </green>  |   ± 6.968   | ns/op |
| ArrayListIteration.stream         |   1000   |      15       | avgt |  20   |          5992.598          |  ± 74.563   | ns/op |
| ArrayListIteration.stream         |  10000   |      15       | avgt |  20   |         55824.065          | ± 2928.053  | ns/op |
| ArrayListIteration.while1         |    10    |      15       | avgt |  20   |  <green> 55.545 </green>   |   ± 0.716   | ns/op |
| ArrayListIteration.while1         |   100    |      15       | avgt |  20   |          538.366           |   ± 7.641   | ns/op |
| ArrayListIteration.while1         |   1000   |      15       | avgt |  20   |          5727.451          |  ± 76.357   | ns/op |
| ArrayListIteration.while1         |  10000   |      15       | avgt |  20   | <green> 53715.753 </green> |  ± 779.381  | ns/op |
| ArrayListIteration.whileIterator  |    10    |      15       | avgt |  20   |           69.144           |   ± 1.846   | ns/op |
| ArrayListIteration.whileIterator  |   100    |      15       | avgt |  20   |          643.407           |  ± 12.758   | ns/op |
| ArrayListIteration.whileIterator  |   1000   |      15       | avgt |  20   |          6530.116          |  ± 83.605   | ns/op |
| ArrayListIteration.whileIterator  |  10000   |      15       | avgt |  20   |         65788.230          | ± 1005.417  | ns/op |

### LinkedList Iteration JDK 17

#### 👍 Best result: Stream

#### 🛑 Worst result:

* **Parallel Stream**
* **for() for large LinkedList**
* **while() for large LinkedList**

| Benchmark                          | Capacity | String Length | Mode | Cnt |           Score            |    Error     | Units |
|:-----------------------------------|:--------:|:-------------:|:----:|:---:|:--------------------------:|:------------:|:-----:|
| LinkedListIteration.for1           |    10    |      15       | avgt | 20  |           79.736           |    1.129     | ns/op |
| LinkedListIteration.for1           |   100    |      15       | avgt | 20  |    <red> 1930.576 <red>    |    30.275    | ns/op |
| LinkedListIteration.for1           |   1000   |      15       | avgt | 20  |   <red> 228652.514 <red>   |   1270.416   | ns/op |
| LinkedListIteration.for1           |  10000   |      15       | avgt | 20  | <red> 41131708.064 </red>  | ± 495849.521 | ns/op |
| LinkedListIteration.forEach        |    10    |      15       | avgt | 20  |  <green> 56.947 </green>   |    0.796     | ns/op |
| LinkedListIteration.forEach        |   100    |      15       | avgt | 20  |          599.340           |    6.242     | ns/op |
| LinkedListIteration.forEach        |   1000   |      15       | avgt | 20  |          7914.284          |   104.942    | ns/op |
| LinkedListIteration.forEach        |  10000   |      15       | avgt | 20  |         87337.259          |  ± 1177.137  | ns/op |
| LinkedListIteration.parallelStream |    10    |      15       | avgt | 20  |   <red> 5628.638 </red>    |   766.689    | ns/op |
| LinkedListIteration.parallelStream |   100    |      15       | avgt | 20  |   <red> 6638.516 </red>    |   780.850    | ns/op |
| LinkedListIteration.parallelStream |   1000   |      15       | avgt | 20  |   <red> 24888.407 </red>   |   2998.443   | ns/op |
| LinkedListIteration.parallelStream |  10000   |      15       | avgt | 20  |  <red> 196098.381 </red>   | ± 17242.654  | ns/op |
| LinkedListIteration.stream         |    10    |      15       | avgt | 20  |           57.478           |    0.681     | ns/op |
| LinkedListIteration.stream         |   100    |      15       | avgt | 20  |  <green> 469.124 </green>  |    6.177     | ns/op |
| LinkedListIteration.stream         |   1000   |      15       | avgt | 20  | <green> 5313.719 </green>  |    63.573    | ns/op |
| LinkedListIteration.stream         |  10000   |      15       | avgt | 20  | <green> 59384.735 </green> |  ± 3953.400  | ns/op |
| LinkedListIteration.while1         |    10    |      15       | avgt | 20  |           75.866           |    4.003     | ns/op |
| LinkedListIteration.while1         |   100    |      15       | avgt | 20  |   <red> 1917.377 </red>    |    32.820    | ns/op |
| LinkedListIteration.while1         |   1000   |      15       | avgt | 20  |  <red> 228899.586 </red>   |   673.031    | ns/op |
| LinkedListIteration.while1         |  10000   |      15       | avgt | 20  | <red> 41399089.356 </red>  | ± 279970.283 | ns/op |
| LinkedListIteration.whileIterator  |    10    |      15       | avgt | 20  |           87.072           |    0.994     | ns/op |
| LinkedListIteration.whileIterator  |   100    |      15       | avgt | 20  |          819.242           |    7.563     | ns/op |
| LinkedListIteration.whileIterator  |   1000   |      15       | avgt | 20  |          7441.360          |   125.970    | ns/op |
| LinkedListIteration.whileIterator  |  10000   |      15       | avgt | 20  |         75406.493          |  ± 890.032   | ns/op |

### HashMap Iteration JDK 17

#### 👍 Best result:

* **for()**
* **while()**

#### 🛑 Worst result:

* **Parallel Stream**
* **while() with Iterator for large HashMap**

| Benchmark                       | Capacity | String Length | Mode | Cnt |           Score            |    Error    | Units |
|:--------------------------------|:--------:|:-------------:|:----:|:---:|:--------------------------:|:-----------:|:-----:|
| HashMapIteration.for1           |    10    |      15       | avgt | 20  |  <green> 79.853 </green>   |   ± 2.354   | ns/op |
| HashMapIteration.for1           |   100    |      15       | avgt | 20  |          824.253           |   ± 7.826   | ns/op |
| HashMapIteration.for1           |   1000   |      15       | avgt | 20  |          8515.508          |  ± 104.657  | ns/op |
| HashMapIteration.for1           |  10000   |      15       | avgt | 20  |         94566.753          | ± 5652.971  | ns/op |
| HashMapIteration.forEach        |    10    |      15       | avgt | 20  |          101.649           |   ± 1.963   | ns/op |
| HashMapIteration.forEach        |   100    |      15       | avgt | 20  |          1130.958          |   ± 9.345   | ns/op |
| HashMapIteration.forEach        |   1000   |      15       | avgt | 20  |         10762.534          |  ± 128.946  | ns/op |
| HashMapIteration.forEach        |  10000   |      15       | avgt | 20  |         98246.109          | ± 1403.592  | ns/op |
| HashMapIteration.parallelStream |    10    |      15       | avgt | 20  |   <red> 5299.490 </red>    |  ± 575.620  | ns/op |
| HashMapIteration.parallelStream |   100    |      15       | avgt | 20  |   <red> 7546.829 </red>    |  ± 213.304  | ns/op |
| HashMapIteration.parallelStream |   1000   |      15       | avgt | 20  |   <red> 27925.295 </red>   |  ± 791.050  | ns/op |
| HashMapIteration.parallelStream |  10000   |      15       | avgt | 20  |  <red> 217173.063 </red>   | ± 19186.992 | ns/op |
| HashMapIteration.stream         |    10    |      15       | avgt | 20  |           87.703           |   ± 1.171   | ns/op |
| HashMapIteration.stream         |   100    |      15       | avgt | 20  |          961.828           |  ± 11.235   | ns/op |
| HashMapIteration.stream         |   1000   |      15       | avgt | 20  |         10566.605          | ± 1959.950  | ns/op |
| HashMapIteration.stream         |  10000   |      15       | avgt | 20  | <green> 84355.265 </green> | ± 1018.561  | ns/op |
| HashMapIteration.while1         |    10    |      15       | avgt | 20  |           81.737           |   ± 9.045   | ns/op |
| HashMapIteration.while1         |   100    |      15       | avgt | 20  |  <green> 782.878 </green>  |  ± 37.440   | ns/op |
| HashMapIteration.while1         |   1000   |      15       | avgt | 20  | <green> 8121.580 </green>  |  ± 136.315  | ns/op |
| HashMapIteration.while1         |  10000   |      15       | avgt | 20  |         87906.060          | ± 2670.107  | ns/op |
| HashMapIteration.whileIterator  |    10    |      15       | avgt | 20  |          112.240           |   ± 1.773   | ns/op |
| HashMapIteration.whileIterator  |   100    |      15       | avgt | 20  |   <red> 1316.566 </red>    |  ± 14.654   | ns/op |
| HashMapIteration.whileIterator  |   1000   |      15       | avgt | 20  |   <red> 12052.856 </red>   |  ± 146.612  | ns/op |
| HashMapIteration.whileIterator  |  10000   |      15       | avgt | 20  |         111797.313         | ± 1195.115  | ns/op |

### HashSet Iteration JDK 17

#### 👍 Best result:

* **For-Each**
* **Stream**

#### 🛑 Worst result: Parallel Stream

| Benchmark                       | Capacity | String Length | Mode | Cnt |            Score            |    Error    | Units |
|:--------------------------------|:--------:|:-------------:|:----:|:---:|:---------------------------:|:-----------:|:-----:|
| HashSetIteration.forEach        |    10    |      15       | avgt | 20  |           105.600           |   ± 4.360   | ns/op |
| HashSetIteration.forEach        |   100    |      15       | avgt | 20  |          1148.064           |  ± 23.071   | ns/op |
| HashSetIteration.forEach        |   1000   |      15       | avgt | 20  | <green> 14601.845 </green>  |  ± 219.780  | ns/op |
| HashSetIteration.forEach        |  10000   |      15       | avgt | 20  |         223900.536          | ± 4964.818  | ns/op |
| HashSetIteration.parallelStream |    10    |      15       | avgt | 20  |    <red> 5250.481 </red>    |  ± 618.668  | ns/op |
| HashSetIteration.parallelStream |   100    |      15       | avgt | 20  |    <red> 6849.802 </red>    |  ± 370.453  | ns/op |
| HashSetIteration.parallelStream |   1000   |      15       | avgt | 20  |   <red> 26755.934 </red>    |  ± 888.797  | ns/op |
| HashSetIteration.parallelStream |  10000   |      15       | avgt | 20  |         264477.717          | ± 29925.634 | ns/op |
| HashSetIteration.stream         |    10    |      15       | avgt | 20  |   <green> 89.799 </green>   |   ± 1.534   | ns/op |
| HashSetIteration.stream         |   100    |      15       | avgt | 20  |  <green> 990.460 </green>   |  ± 13.013   | ns/op |
| HashSetIteration.stream         |   1000   |      15       | avgt | 20  |          15238.307          |  ± 526.078  | ns/op |
| HashSetIteration.stream         |  10000   |      15       | avgt | 20  | <green> 184003.232 </green> | ± 1235.707  | ns/op |
| HashSetIteration.whileIterator  |    10    |      15       | avgt | 20  |           121.195           |   ± 2.635   | ns/op |
| HashSetIteration.whileIterator  |   100    |      15       | avgt | 20  |          1321.125           |  ± 14.029   | ns/op |
| HashSetIteration.whileIterator  |   1000   |      15       | avgt | 20  |          15049.812          |  ± 490.014  | ns/op |
| HashSetIteration.whileIterator  |  10000   |      15       | avgt | 20  |         228361.840          | ± 6326.544  | ns/op |

### Liberica JDK 11.0.5

### Array Iteration JDK 11

#### 👍 Best result:

* **Stream**
* **For-Each**

#### 🛑 Worst result: Parallel Stream

| Benchmark                     | Capacity | String Length | Mode | Cnt |           Score           |   Error    | Units |
|:------------------------------|:--------:|:-------------:|:----:|:---:|:-------------------------:|:----------:|:-----:|
| ArrayIteration.for1           |    10    |      15       | avgt | 20  |          57.751           |  ± 0.731   | ns/op |
| ArrayIteration.for1           |   100    |      15       | avgt | 20  |          579.586          |  ± 4.880   | ns/op |
| ArrayIteration.for1           |   1000   |      15       | avgt | 20  |         5801.407          | ± 121.491  | ns/op |
| ArrayIteration.forEach        |    10    |      15       | avgt | 20  |  <green> 56.270 </green>  |  ± 0.780   | ns/op |
| ArrayIteration.forEach        |   100    |      15       | avgt | 20  |          553.480          |  ± 7.493   | ns/op |
| ArrayIteration.forEach        |   1000   |      15       | avgt | 20  |         5028.306          |  ± 58.160  | ns/op |
| ArrayIteration.parallelStream |    10    |      15       | avgt | 20  |   <red> 9990.888 </red>   | ± 939.357  | ns/op |
| ArrayIteration.parallelStream |   100    |      15       | avgt | 20  |  <red> 14242.178 </red>   | ± 751.749  | ns/op |
| ArrayIteration.parallelStream |   1000   |      15       | avgt | 20  |  <red> 24662.142 </red>   | ± 1034.395 | ns/op |
| ArrayIteration.stream         |    10    |      15       | avgt | 20  |          62.535           |  ± 0.672   | ns/op |
| ArrayIteration.stream         |   100    |      15       | avgt | 20  | <green> 507.517 </green>  |  ± 5.377   | ns/op |
| ArrayIteration.stream         |   1000   |      15       | avgt | 20  | <green> 4603.617 </green> |  ± 71.129  | ns/op |
| ArrayIteration.while1         |    10    |      15       | avgt | 20  |          65.403           |  ± 0.746   | ns/op |
| ArrayIteration.while1         |   100    |      15       | avgt | 20  |          633.659          |  ± 6.514   | ns/op |
| ArrayIteration.while1         |   1000   |      15       | avgt | 20  |         5280.361          |  ± 80.392  | ns/op |

### ArrayList Iteration JDK 11

#### 👍 Best result:

* **while()**
* **Stream**
* **For-Each**

#### 🛑 Worst result: Parallel Stream

| Benchmark                         | Capacity | String Length | Mode | Cnt |           Score           |   Error    | Units |
|:----------------------------------|:--------:|:-------------:|:----:|:---:|:-------------------------:|:----------:|:-----:|
| ArrayListIteration.for1           |    10    |      15       | avgt | 20  |          70.000           |  ± 0.838   | ns/op |
| ArrayListIteration.for1           |   100    |      15       | avgt | 20  |          708.656          |  ± 9.296   | ns/op |
| ArrayListIteration.for1           |   1000   |      15       | avgt | 20  |         6934.258          |  ± 65.644  | ns/op |
| ArrayListIteration.forEach        |    10    |      15       | avgt | 20  |          60.390           |  ± 0.705   | ns/op |
| ArrayListIteration.forEach        |   100    |      15       | avgt | 20  |          592.748          |  ± 15.818  | ns/op |
| ArrayListIteration.forEach        |   1000   |      15       | avgt | 20  |         6245.217          | ± 100.867  | ns/op |
| ArrayListIteration.parallelStream |    10    |      15       | avgt | 20  |   <red> 9988.989 </red>   | ± 956.308  | ns/op |
| ArrayListIteration.parallelStream |   100    |      15       | avgt | 20  |  <red> 14215.759 </red>   | ± 622.447  | ns/op |
| ArrayListIteration.parallelStream |   1000   |      15       | avgt | 20  |  <red> 24210.603 </red>   | ± 1076.792 | ns/op |
| ArrayListIteration.stream         |    10    |      15       | avgt | 20  |          61.064           |  ± 1.637   | ns/op |
| ArrayListIteration.stream         |   100    |      15       | avgt | 20  |          532.421          |  ± 12.380  | ns/op |
| ArrayListIteration.stream         |   1000   |      15       | avgt | 20  |         6054.121          |  ± 89.996  | ns/op |
| ArrayListIteration.while1         |    10    |      15       | avgt | 20  |  <green> 55.630 </green>  |  ± 1.194   | ns/op |
| ArrayListIteration.while1         |   100    |      15       | avgt | 20  | <green> 513.783 </green>  |  ± 7.767   | ns/op |
| ArrayListIteration.while1         |   1000   |      15       | avgt | 20  | <green> 5551.269 </green> |  ± 91.282  | ns/op |
| ArrayListIteration.whileIterator  |    10    |      15       | avgt | 20  |          66.166           |  ± 0.776   | ns/op |
| ArrayListIteration.whileIterator  |   100    |      15       | avgt | 20  |          710.616          |  ± 7.946   | ns/op |
| ArrayListIteration.whileIterator  |   1000   |      15       | avgt | 20  |         6958.425          |  ± 88.754  | ns/op |

### LinkedList Iteration JDK 11

#### 👍 Best result:

* **Stream**
* **For-Each**

#### 🛑 Worst result:

* **Parallel Stream**
* **for() for large LinkedList**
* **while() for large LinkedList**

| Benchmark                          | Capacity | String Length | Mode | Cnt |           Score           |   Error    | Units |
|:-----------------------------------|:--------:|:-------------:|:----:|:---:|:-------------------------:|:----------:|:-----:|
| LinkedListIteration.for1           |    10    |      15       | avgt | 20  |          70.294           |  ± 3.705   | ns/op |
| LinkedListIteration.for1           |   100    |      15       | avgt | 20  |   <red> 1965.593 </red>   |  ± 61.267  | ns/op |
| LinkedListIteration.for1           |   1000   |      15       | avgt | 20  |  <red> 231836.316 </red>  | ± 1049.019 | ns/op |
| LinkedListIteration.forEach        |    10    |      15       | avgt | 20  |  <green> 56.489 </green>  |  ± 3.578   | ns/op |
| LinkedListIteration.forEach        |   100    |      15       | avgt | 20  | <green> 548.610 </green>  |  ± 29.359  | ns/op |
| LinkedListIteration.forEach        |   1000   |      15       | avgt | 20  |         6000.391          |  ± 51.621  | ns/op |
| LinkedListIteration.parallelStream |    10    |      15       | avgt | 20  |  <red> 11210.383 </red>   | ± 1169.921 | ns/op |
| LinkedListIteration.parallelStream |   100    |      15       | avgt | 20  |  <red> 13573.413 </red>   | ± 1407.634 | ns/op |
| LinkedListIteration.parallelStream |   1000   |      15       | avgt | 20  |   <red> 27526.746 <red>   | ± 2691.355 | ns/op |
| LinkedListIteration.stream         |    10    |      15       | avgt | 20  |          64.577           |  ± 6.203   | ns/op |
| LinkedListIteration.stream         |   100    |      15       | avgt | 20  |          551.397          |  ± 5.548   | ns/op |
| LinkedListIteration.stream         |   1000   |      15       | avgt | 20  | <green> 5990.053 </green> | ± 200.587  | ns/op |
| LinkedListIteration.while1         |    10    |      15       | avgt | 20  |          83.721           |  ± 2.381   | ns/op |
| LinkedListIteration.while1         |   100    |      15       | avgt | 20  |   <red> 1877.147 </red>   |  ± 23.314  | ns/op |
| LinkedListIteration.while1         |   1000   |      15       | avgt | 20  |  <red> 232290.331 </red>  | ± 911.593  | ns/op |
| LinkedListIteration.whileIterator  |    10    |      15       | avgt | 20  |          90.890           |  ± 5.861   | ns/op |
| LinkedListIteration.whileIterator  |   100    |      15       | avgt | 20  |          872.256          |  ± 13.078  | ns/op |
| LinkedListIteration.whileIterator  |   1000   |      15       | avgt | 20  |         8420.395          | ± 123.361  | ns/op |

### HashMap Iteration JDK 11

#### 👍 Best result: For-Each

#### 🛑 Worst result:

* **Parallel Stream**
* **while() with Iterator for large HashMap**

| Benchmark                       | Capacity | String Length | Mode | Cnt |           Score           |   Error    | Units |
|:--------------------------------|:--------:|:-------------:|:----:|:---:|:-------------------------:|:----------:|:-----:|
| HashMapIteration.for1           |    10    |      15       | avgt | 20  |          77.768           |  ± 3.894   | ns/op |
| HashMapIteration.for1           |   100    |      15       | avgt | 20  |          882.011          |  ± 20.649  | ns/op |
| HashMapIteration.for1           |   1000   |      15       | avgt | 20  |         9982.192          | ± 683.371  | ns/op |
| HashMapIteration.forEach        |    10    |      15       | avgt | 20  |  <green> 77.887 </green>  |  ± 1.006   | ns/op |
| HashMapIteration.forEach        |   100    |      15       | avgt | 20  | <green> 795.503 </green>  |  ± 13.209  | ns/op |
| HashMapIteration.forEach        |   1000   |      15       | avgt | 20  | <green> 7781.086 </green> | ± 703.089  | ns/op |
| HashMapIteration.parallelStream |    10    |      15       | avgt | 20  |   <red> 8480.055 </red>   | ± 826.365  | ns/op |
| HashMapIteration.parallelStream |   100    |      15       | avgt | 20  |  <red> 13533.003 </red>   | ± 1368.626 | ns/op |
| HashMapIteration.parallelStream |   1000   |      15       | avgt | 20  |  <red> 28267.920 </red>   | ± 3097.146 | ns/op |
| HashMapIteration.stream         |    10    |      15       | avgt | 20  |          102.401          |  ± 2.709   | ns/op |
| HashMapIteration.stream         |   100    |      15       | avgt | 20  |         1229.719          |  ± 14.898  | ns/op |
| HashMapIteration.stream         |   1000   |      15       | avgt | 20  |         8913.807          | ± 142.410  | ns/op |
| HashMapIteration.while1         |    10    |      15       | avgt | 20  |          79.790           |  ± 5.985   | ns/op |
| HashMapIteration.while1         |   100    |      15       | avgt | 20  |          802.248          |  ± 11.109  | ns/op |
| HashMapIteration.while1         |   1000   |      15       | avgt | 20  |         9229.163          |  ± 91.935  | ns/op |
| HashMapIteration.whileIterator  |    10    |      15       | avgt | 20  |          130.991          |  ± 2.052   | ns/op |
| HashMapIteration.whileIterator  |   100    |      15       | avgt | 20  |   <red> 1463.483 </red>   |  ± 19.734  | ns/op |
| HashMapIteration.whileIterator  |   1000   |      15       | avgt | 20  |  <red> 12727.065 </red>   | ± 189.822  | ns/op |

### HashSet Iteration JDK 11

#### 👍 Best result: For-Each

#### 🛑 Worst result: Parallel Stream

| Benchmark                       | Capacity | String Length | Mode | Cnt |           Score            |   Error    | Units |
|:--------------------------------|:--------:|:-------------:|:----:|:---:|:--------------------------:|:----------:|:-----:|
| HashSetIteration.forEach        |    10    |      15       | avgt | 20  |  <green> 80.128 </green>   |  ± 1.767   | ns/op |
| HashSetIteration.forEach        |   100    |      15       | avgt | 20  |  <green> 743.816 </green>  |  ± 10.185  | ns/op |
| HashSetIteration.forEach        |   1000   |      15       | avgt | 20  | <green> 15981.403 </green> | ± 281.451  | ns/op |
| HashSetIteration.parallelStream |    10    |      15       | avgt | 20  |   <red> 8443.209 </red>    | ± 836.119  | ns/op |
| HashSetIteration.parallelStream |   100    |      15       | avgt | 20  |   <red> 13407.520 </red>   | ± 1470.746 | ns/op |
| HashSetIteration.parallelStream |   1000   |      15       | avgt | 20  |   <red> 27777.871 </red>   | ± 3168.913 | ns/op |
| HashSetIteration.stream         |    10    |      15       | avgt | 20  |          102.879           |  ± 4.971   | ns/op |
| HashSetIteration.stream         |   100    |      15       | avgt | 20  |          1095.776          |  ± 22.307  | ns/op |
| HashSetIteration.stream         |   1000   |      15       | avgt | 20  |         16047.582          | ± 211.221  | ns/op |
| HashSetIteration.whileIterator  |    10    |      15       | avgt | 20  |          131.938           |  ± 8.184   | ns/op |
| HashSetIteration.whileIterator  |   100    |      15       | avgt | 20  |          1324.457          | ± 136.126  | ns/op |
| HashSetIteration.whileIterator  |   1000   |      15       | avgt | 20  |         16408.484          | ± 115.922  | ns/op |

### Oracle JDK 1.8.0.231

### Array Iteration JDK 1.8

#### 🛑 Worst result: Parallel Stream

| Benchmark                     | Capacity | String Length | Mode | Cnt |          Score           |   Error    | Units |
|:------------------------------|:--------:|:-------------:|:----:|:---:|:------------------------:|:----------:|:-----:|
| ArrayIteration.for1           |    10    |      15       | avgt | 20  |          53.539          |  ± 0.748   | ns/op |
| ArrayIteration.for1           |   100    |      15       | avgt | 20  |         543.807          |  ± 5.874   | ns/op |
| ArrayIteration.for1           |   1000   |      15       | avgt | 20  | <green> 4541.965 <green> |  ± 76.231  | ns/op |
| ArrayIteration.forEach        |    10    |      15       | avgt | 20  | <green> 51.707 </green>  |  ± 0.319   | ns/op |
| ArrayIteration.forEach        |   100    |      15       | avgt | 20  |         516.859          |  ± 7.590   | ns/op |
| ArrayIteration.forEach        |   1000   |      15       | avgt | 20  |         5043.941         |  ± 60.792  | ns/op |
| ArrayIteration.parallelStream |    10    |      15       | avgt | 20  |  <red> 5329.719 </red>   | ± 639.004  | ns/op |
| ArrayIteration.parallelStream |   100    |      15       | avgt | 20  |  <red> 4670.631 </red>   | ± 548.846  | ns/op |
| ArrayIteration.parallelStream |   1000   |      15       | avgt | 20  |  <red> 20611.923 </red>  | ± 2363.844 | ns/op |
| ArrayIteration.stream         |    10    |      15       | avgt | 20  |          54.770          |  ± 0.628   | ns/op |
| ArrayIteration.stream         |   100    |      15       | avgt | 20  | <green> 476.056 </green> |  ± 4.114   | ns/op |
| ArrayIteration.stream         |   1000   |      15       | avgt | 20  |         4836.294         |  ± 90.958  | ns/op |
| ArrayIteration.while1         |    10    |      15       | avgt | 20  |          52.410          |  ± 0.863   | ns/op |
| ArrayIteration.while1         |   100    |      15       | avgt | 20  |         512.912          |  ± 6.345   | ns/op |
| ArrayIteration.while1         |   1000   |      15       | avgt | 20  |         4835.093         |  ± 45.038  | ns/op |

### ArrayList Iteration JDK 1.8

#### 👍 Best result: Stream

#### 🛑 Worst result: Parallel Stream

| Benchmark                         | Capacity | String Length | Mode | Cnt |           Score           |   Error    | Units |
|:----------------------------------|:--------:|:-------------:|:----:|:---:|:-------------------------:|:----------:|:-----:|
| ArrayListIteration.for1           |    10    |      15       | avgt | 20  |          56.399           |  ± 0.630   | ns/op |
| ArrayListIteration.for1           |   100    |      15       | avgt | 20  |          559.035          |  ± 7.356   | ns/op |
| ArrayListIteration.for1           |   1000   |      15       | avgt | 20  |         5711.178          |  ± 97.426  | ns/op |
| ArrayListIteration.forEach        |    10    |      15       | avgt | 20  |          61.195           |  ± 0.901   | ns/op |
| ArrayListIteration.forEach        |   100    |      15       | avgt | 20  |          610.563          |  ± 9.151   | ns/op |
| ArrayListIteration.forEach        |   1000   |      15       | avgt | 20  |         5367.434          |  ± 70.113  | ns/op |
| ArrayListIteration.parallelStream |    10    |      15       | avgt | 20  |   <red> 5371.340 </red>   | ± 457.160  | ns/op |
| ArrayListIteration.parallelStream |   100    |      15       | avgt | 20  |   <red> 5298.625 </red>   | ± 241.677  | ns/op |
| ArrayListIteration.parallelStream |   1000   |      15       | avgt | 20  |  <red> 22495.224 </red>   | ± 1112.136 | ns/op |
| ArrayListIteration.stream         |    10    |      15       | avgt | 20  |          54.109           |  ± 0.849   | ns/op |
| ArrayListIteration.stream         |   100    |      15       | avgt | 20  | <green> 452.580 </green>  |  ± 5.771   | ns/op |
| ArrayListIteration.stream         |   1000   |      15       | avgt | 20  | <green> 4304.753 </green> |  ± 95.097  | ns/op |
| ArrayListIteration.while1         |    10    |      15       | avgt | 20  |  <green> 50.099 </green>  |  ± 0.926   | ns/op |
| ArrayListIteration.while1         |   100    |      15       | avgt | 20  |          509.745          |  ± 6.317   | ns/op |
| ArrayListIteration.while1         |   1000   |      15       | avgt | 20  |         5081.582          | ± 104.439  | ns/op |
| ArrayListIteration.whileIterator  |    10    |      15       | avgt | 20  |          61.682           |  ± 0.676   | ns/op |
| ArrayListIteration.whileIterator  |   100    |      15       | avgt | 20  |          590.114          |  ± 8.809   | ns/op |
| ArrayListIteration.whileIterator  |   1000   |      15       | avgt | 20  |         5885.844          |  ± 97.927  | ns/op |

### LinkedList Iteration JDK 1.8

#### 👍 Best result: Stream

#### 🛑 Worst result:

* **Parallel Stream**
* **for() for large LinkedList**
* **while() for large LinkedList**

| Benchmark                          | Capacity | String Length | Mode | Cnt |           Score           |    Error    | Units |
|:-----------------------------------|:--------:|:-------------:|:----:|:---:|:-------------------------:|:-----------:|:-----:|
| LinkedListIteration.for1           |    10    |      15       | avgt | 20  |          63.637           |   ± 2.920   | ns/op |
| LinkedListIteration.for1           |   100    |      15       | avgt | 20  |   <red> 1845.988 </red>   |  ± 36.501   | ns/op |
| LinkedListIteration.for1           |   1000   |      15       | avgt | 20  |  <red> 283295.869 </red>  | ± 16085.759 | ns/op |
| LinkedListIteration.forEach        |    10    |      15       | avgt | 20  |          57.556           |   ± 0.656   | ns/op |
| LinkedListIteration.forEach        |   100    |      15       | avgt | 20  |          599.448          |  ± 14.082   | ns/op |
| LinkedListIteration.forEach        |   1000   |      15       | avgt | 20  |         5918.310          |  ± 82.116   | ns/op |
| LinkedListIteration.parallelStream |    10    |      15       | avgt | 20  |   <red> 6363.552 </red>   |  ± 740.985  | ns/op |
| LinkedListIteration.parallelStream |   100    |      15       | avgt | 20  |   <red> 7311.149 </red>   |  ± 920.666  | ns/op |
| LinkedListIteration.parallelStream |   1000   |      15       | avgt | 20  |  <red> 26361.520 </red>   | ± 2636.214  | ns/op |
| LinkedListIteration.stream         |    10    |      15       | avgt | 20  |  <green> 54.231 </green>  |   ± 0.489   | ns/op |
| LinkedListIteration.stream         |   100    |      15       | avgt | 20  | <green> 471.328 </green>  |   ± 6.671   | ns/op |
| LinkedListIteration.stream         |   1000   |      15       | avgt | 20  | <green> 4796.906 </green> |  ± 145.518  | ns/op |
| LinkedListIteration.while1         |    10    |      15       | avgt | 20  |          63.152           |   ± 0.543   | ns/op |
| LinkedListIteration.while1         |   100    |      15       | avgt | 20  |   <red> 1762.227 </red>   |  ± 13.466   | ns/op |
| LinkedListIteration.while1         |   1000   |      15       | avgt | 20  |  <red> 291284.300 </red>  | ± 13026.234 | ns/op |
| LinkedListIteration.whileIterator  |    10    |      15       | avgt | 20  |          60.864           |   ± 0.915   | ns/op |
| LinkedListIteration.whileIterator  |   100    |      15       | avgt | 20  |          611.938          |   ± 6.539   | ns/op |
| LinkedListIteration.whileIterator  |   1000   |      15       | avgt | 20  |         6601.877          |  ± 117.240  | ns/op |

### HashMap Iteration JDK 1.8

#### 🛑 Worst result: Parallel Stream

| Benchmark                       | Capacity | String Length | Mode | Cnt |           Score           |   Error    | Units |
|:--------------------------------|:--------:|:-------------:|:----:|:---:|:-------------------------:|:----------:|:-----:|
| HashMapIteration.for1           |    10    |      15       | avgt | 20  |          76.279           |  ± 1.294   | ns/op |
| HashMapIteration.for1           |   100    |      15       | avgt | 20  |          852.293          |  ± 8.231   | ns/op |
| HashMapIteration.for1           |   1000   |      15       | avgt | 20  |         8688.909          | ± 152.603  | ns/op |
| HashMapIteration.forEach        |    10    |      15       | avgt | 20  |  <green> 67.424 </green>  |  ± 0.910   | ns/op |
| HashMapIteration.forEach        |   100    |      15       | avgt | 20  |          787.167          |  ± 7.453   | ns/op |
| HashMapIteration.forEach        |   1000   |      15       | avgt | 20  |         8847.979          | ± 184.046  | ns/op |
| HashMapIteration.parallelStream |    10    |      15       | avgt | 20  |   <red> 5251.079 </red>   | ± 586.004  | ns/op |
| HashMapIteration.parallelStream |   100    |      15       | avgt | 20  |   <red> 8437.223 </red>   | ± 321.842  | ns/op |
| HashMapIteration.parallelStream |   1000   |      15       | avgt | 20  |  <red> 28978.392 </red>   | ± 1586.071 | ns/op |
| HashMapIteration.stream         |    10    |      15       | avgt | 20  |          87.030           |  ± 1.050   | ns/op |
| HashMapIteration.stream         |   100    |      15       | avgt | 20  |          957.775          |  ± 8.490   | ns/op |
| HashMapIteration.stream         |   1000   |      15       | avgt | 20  |         8606.974          | ± 196.029  | ns/op |
| HashMapIteration.while1         |    10    |      15       | avgt | 20  |          77.086           |  ± 0.844   | ns/op |
| HashMapIteration.while1         |   100    |      15       | avgt | 20  | <green> 756.500 </green>  |  ± 11.745  | ns/op |
| HashMapIteration.while1         |   1000   |      15       | avgt | 20  |         8286.079          |  ± 86.310  | ns/op |
| HashMapIteration.whileIterator  |    10    |      15       | avgt | 20  |          80.839           |  ± 0.914   | ns/op |
| HashMapIteration.whileIterator  |   100    |      15       | avgt | 20  |          942.919          |  ± 11.897  | ns/op |
| HashMapIteration.whileIterator  |   1000   |      15       | avgt | 20  | <green> 7940.917 </green> | ± 102.367  | ns/op |

### HashSet Iteration JDK 1.8

#### 👍 Best result: For-Each

#### 🛑 Worst result:

* **Parallel Stream**
* **Stream for large HashSet**

| Benchmark                       | Capacity | String Length | Mode | Cnt |           Score           |   Error    | Units |
|:--------------------------------|:--------:|:-------------:|:----:|:---:|:-------------------------:|:----------:|:-----:|
| HashSetIteration.forEach        |    10    |      15       | avgt | 20  |  <green> 69.946 </green>  |  ± 0.681   | ns/op |
| HashSetIteration.forEach        |   100    |      15       | avgt | 20  | <green> 761.753 </green>  |  ± 29.054  | ns/op |
| HashSetIteration.forEach        |   1000   |      15       | avgt | 20  | <green> 6824.631 </green> | ± 107.952  | ns/op |
| HashSetIteration.parallelStream |    10    |      15       | avgt | 20  |   <red> 4903.404 </red>   | ± 603.981  | ns/op |
| HashSetIteration.parallelStream |   100    |      15       | avgt | 20  |   <red> 6149.751 </red>   | ± 683.380  | ns/op |
| HashSetIteration.parallelStream |   1000   |      15       | avgt | 20  |  <red> 24917.027 </red>   | ± 2799.410 | ns/op |
| HashSetIteration.stream         |    10    |      15       | avgt | 20  |          90.881           |  ± 1.182   | ns/op |
| HashSetIteration.stream         |   100    |      15       | avgt | 20  |          939.203          |  ± 13.610  | ns/op |
| HashSetIteration.stream         |   1000   |      15       | avgt | 20  |  <red> 15818.360 </red>   | ± 941.178  | ns/op |
| HashSetIteration.whileIterator  |    10    |      15       | avgt | 20  |          84.882           |  ± 1.080   | ns/op |
| HashSetIteration.whileIterator  |   100    |      15       | avgt | 20  |          914.617          |  ± 30.028  | ns/op |
| HashSetIteration.whileIterator  |   1000   |      15       | avgt | 20  |         7763.406          | ± 423.323  | ns/op |

<style>
H1,H2{color:lightBlue;}
H3{color:darkOrange;}
green{background:green;}
red{background:red;}
</style>