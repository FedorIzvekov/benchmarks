# Iteration Benchmark

## CPU Intel i7-10510U

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