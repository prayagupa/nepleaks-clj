(ns storm-hello-world.topology
  "Topology

  More info on the Clojure DSL here:

  https://github.com/nathanmarz/storm/wiki/Clojure-DSL"
  (:require
   [backtype.storm [clojure :refer :all] [config :refer :all]])
  (:import [backtype.storm LocalCluster]
           [backtype.storm.topology IRichSpout]))

(defspout sentence-spout ["sentence"]
  [conf context collector]
  (let [sentences ["a little brown dog"
                   "the man petted the dog"
                   "four score and seven years ago"
                   "an apple a day keeps the doctor away"]]
    (spout
     (nextTuple []
                (Thread/sleep 100)
                (emit-spout! collector [(rand-nth sentences)])
                )
     (ack [id]
          ;; You only need to define this method for reliable spouts
          ;; (such as one that reads off of a queue like Kestrel)
          ;; This is an unreliable spout, so it does nothing here
          ))))

(defspout sentence-spout-parameterized ["word"] {:params [sentences] :prepare false}
  [collector]
  (Thread/sleep 500)
  (emit-spout! collector [(rand-nth sentences)]))

(defbolt split-sentence ["word"] [tuple collector]
  (let [words (.split (.getString tuple 0) " ")]
    (doseq [w words]
      (emit-bolt! collector [w] :anchor tuple))
    (ack! collector tuple)
    ))

(defbolt word-count ["word" "count"] {:prepare true}
  [conf context collector]
  (let [counts (atom {})]
    (bolt
     (execute [tuple]
              (let [word (.getString tuple 0)]
                (swap! counts (partial merge-with +) {word 1})
                (emit-bolt! collector [word (@counts word)] :anchor tuple)
                (ack! collector tuple)
                )))))

(def spouts
  ; These strings name the spouts
  {"Randomly Generate a Sentence from A Vector In a let form" (spout-spec sentence-spout)
   "Randomly Generate a Sentence from specified parameters" (spout-spec (sentence-spout-parameterized
                                                                         ["the cat jumped over the door"
                                                                          "greetings from a faraway land"])
                                                                        :p 2)})

(def bolts
  {"Breaks a Sentence up by whitespace and emits words" (bolt-spec
                                                         ; The hash-map below names the connections and specify load balance
                                                         {"Randomly Generate a Sentence from A Vector In a let form" :shuffle
                                                          "Randomly Generate a Sentence from specified parameters" :shuffle}
                                                         split-sentence
                                                         ; :p specifies the number of processes
                                                         :p 5)
   "Create Word Counts"
   (bolt-spec {"Breaks a Sentence up by whitespace and emits words" ["word"]}
              word-count
              :p 6)


   })

(def example-topology
  (topology spouts bolts))

