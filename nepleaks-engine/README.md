# nepleaks-engine

backend repository

[![build image](https://circleci.com/gh/iPrayag/nepleaks.png?circle-token=1a0988f71f3ce75693aa5ee912aba29fe0b1652e)](https://circleci.com/gh/iPrayag/nepleaks.png?circle-token=1a0988f71f3ce75693aa5ee912aba29fe0b1652e)

# run

````
lein run
````

## 1. [play with cascalog cli](http://cascalog.org/articles/getting_started.html)

```
prayagupd@prayagupd:~/backup/hacker_/nepleaks$ lein repl
user=> (use 'cascalog.api)
nil
```
<b>load the built-in example namespace</b>

```
user=> (use 'cascalog.playground)
nil
user=> sentence
[["Four score and seven years ago our fathers brought forth on this continent a new nation"] ["conceived in Liberty and dedicated to the proposition that all men are created equal"] ["Now we are engaged in a great civil war testing whether that nation or any nation so"] ["conceived and so dedicated can long endure We are met on a great battlefield of that war"] ["We have come to dedicate a portion of that field as a final resting place for those who"] ["here gave their lives that that nation might live It is altogether fitting and proper"] ["that we should do this"] ["But in a larger sense we can not dedicate  we can not consecrate  we can not hallow"] ["this ground The brave men living and dead who struggled here have consecrated it"] ["far above our poor power to add or detract The world will little note nor long remember"] ["what we say here but it can never forget what they did here It is for us the living rather"] ["to be dedicated here to the unfinished work which they who fought here have thus far so nobly"] ["advanced It is rather for us to be here dedicated to the great task remaining before us "] ["that from these honored dead we take increased devotion to that cause for which they gave"] ["the last full measure of devotion  that we here highly resolve that these dead shall"] ["not have died in vain  that this nation under God shall have a new birth of freedom"] ["and that government of the people by the people for the people shall not perish"] ["from the earth"]]
```

<b>query</b>

```
user=> (?- (stdout) sentence)
14/02/13 11:19:09 INFO util.HadoopUtil: using default application jar, may cause class not found exceptions on the cluster
14/02/13 11:19:09 INFO planner.HadoopPlanner: using application jar: /home/prayagupd/.m2/repository/cascading/cascading-hadoop/2.2.0/cascading-hadoop-2.2.0.jar
14/02/13 11:19:09 INFO property.AppProps: using app.id: 66FFB8A741E1485382DD1793F1630A36
14/02/13 11:19:10 INFO util.Version: Concurrent, Inc - Cascading 2.2.0
14/02/13 11:19:10 INFO flow.Flow: [] starting
14/02/13 11:19:10 INFO flow.Flow: []  source: MemorySourceTap["MemorySourceScheme[[UNKNOWN]->[ALL]]"]["/7d78e7f9-3546-497a-83fb-9cdbcd7f1cd6"]
14/02/13 11:19:10 INFO flow.Flow: []  sink: StdoutTap["SequenceFile[[UNKNOWN]->[ALL]]"]["/tmp/temp78507057347127259497865011123323"]
14/02/13 11:19:10 INFO flow.Flow: []  parallel execution is enabled: false
14/02/13 11:19:10 INFO flow.Flow: []  starting jobs: 1
14/02/13 11:19:10 INFO flow.Flow: []  allocating threads: 1
14/02/13 11:19:10 INFO flow.FlowStep: [] starting step: (1/1) ...7347127259497865011123323
14/02/13 11:19:11 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
14/02/13 11:19:11 INFO flow.FlowStep: [] submitted hadoop job: job_local_0001
14/02/13 11:19:11 INFO util.ProcessTree: setsid exited with exit code 0
14/02/13 11:19:12 INFO mapred.Task:  Using ResourceCalculatorPlugin : org.apache.hadoop.util.LinuxResourceCalculatorPlugin@be630d4
14/02/13 11:19:12 INFO mapred.MapTask: numReduceTasks: 0
14/02/13 11:19:12 INFO hadoop.FlowMapper: cascading version: 2.2.0
14/02/13 11:19:12 INFO hadoop.FlowMapper: child jvm opts: -Xmx200m
14/02/13 11:19:12 INFO hadoop.FlowMapper: sourcing from: MemorySourceTap["MemorySourceScheme[[UNKNOWN]->[ALL]]"]["/7d78e7f9-3546-497a-83fb-9cdbcd7f1cd6"]
14/02/13 11:19:12 INFO hadoop.FlowMapper: sinking to: StdoutTap["SequenceFile[[UNKNOWN]->[ALL]]"]["/tmp/temp78507057347127259497865011123323"]
14/02/13 11:19:12 INFO mapred.Task: Task:attempt_local_0001_m_000000_0 is done. And is in the process of commiting
14/02/13 11:19:12 INFO mapred.LocalJobRunner: 
14/02/13 11:19:12 INFO mapred.Task: Task attempt_local_0001_m_000000_0 is allowed to commit now
14/02/13 11:19:12 INFO mapred.FileOutputCommitter: Saved output of task 'attempt_local_0001_m_000000_0' to file:/tmp/temp78507057347127259497865011123323
14/02/13 11:19:12 INFO mapred.LocalJobRunner: 
14/02/13 11:19:12 INFO mapred.Task: Task 'attempt_local_0001_m_000000_0' done.
14/02/13 11:19:12 INFO mapred.FileInputFormat: Total input paths to process : 1
14/02/13 11:19:12 INFO util.Hadoop18TapUtil: deleting temp path /tmp/temp78507057347127259497865011123323/_temporary
nil



RESULTS
-----------------------
Four score and seven years ago our fathers brought forth on this continent a new nation
conceived in Liberty and dedicated to the proposition that all men are created equal
Now we are engaged in a great civil war testing whether that nation or any nation so
conceived and so dedicated can long endure We are met on a great battlefield of that war
We have come to dedicate a portion of that field as a final resting place for those who
here gave their lives that that nation might live It is altogether fitting and proper
that we should do this
But in a larger sense we can not dedicate  we can not consecrate  we can not hallow
this ground The brave men living and dead who struggled here have consecrated it
far above our poor power to add or detract The world will little note nor long remember
what we say here but it can never forget what they did here It is for us the living rather
to be dedicated here to the unfinished work which they who fought here have thus far so nobly
advanced It is rather for us to be here dedicated to the great task remaining before us 
that from these honored dead we take increased devotion to that cause for which they gave
the last full measure of devotion  that we here highly resolve that these dead shall
not have died in vain  that this nation under God shall have a new birth of freedom
and that government of the people by the people for the people shall not perish
from the earth
-----------------------
user=> 

```

## 2. storm

```
./run-app.sh
```

realtime leaks count in storm
------------------------------

```
core.clj     | stormService.clj
             |
             | ;;realtime input for 10000 ms
             | (def runlocal
runLocal     |  (.submitTopology cluster "leaks-count" {TOPOLOGY-DEBUG true} (mk-topology))
             |                                                                  |
             |            (defn mk-topology [] _________________________________|
             |             (topology { "1" (spout-spec sentence-spout)
             |                        "2" (spout-spec (sentence-spout-parameterized ["blah blah"]) : p 2)
             |                      }
             |                      { "3" (bolt-spec {"1" :shuffle "2" :shuffle} split-sentence :p 5)
             |                        "4" (bolt-spec {"3" ["word"] word-count :p 6})
             |                      })
             |            )
             |

```


## License

Copyright © 2014

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
