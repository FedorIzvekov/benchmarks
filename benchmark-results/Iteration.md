# Iteration Benchmark

## CPU Intel i7-10510U

[Oracle JDK 1.8.0_231](#oracle-jdk-180231)

* [Array Iteration](#array-iteration-jdk-18)
* [ArrayList Iteration](#arraylist-iteration-jdk-18)
* [LinkedList Iteration](#linkedlist-iteration-jdk-18)
* [HashMap Iteration](#hashmap-iteration-jdk-18)
* [HashSet Iteration](#hashset-iteration-jdk-18)

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

#### 👍 Best result: Stream for ArrayList

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

#### 👍 Best result: Stream for LinkedList

#### 🛑 Worst result:

* Parallel Stream
* for() for large LinkedList
* while() for large LinkedList

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

#### 👍 Best result: ForEach for HashSet

#### 🛑 Worst result:

* Parallel Stream
* Stream for large HashSet

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