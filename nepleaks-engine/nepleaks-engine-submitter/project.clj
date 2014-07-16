(defproject alestorm "0.1.0-SNAPSHOT"
  :description "A storm topology in the tradition of 'True Scottish Pirate Metal'"
  :url "https://github.com/opinionlab/alestorm"
  :dependencies [
                 ; Storm needs an old version of clojure!
                 [org.clojure/clojure "1.5.1"]
                 [environ "0.4.0"]
                 [cheshire "5.3.1"]
                 [com.espertech/esper "4.9.0" :exclusions [log4j]]
                 [org.clojure/tools.logging "0.2.6"]
                 ]
  :aot [storm-hello-world.TopologySubmitter]
  ; Storm projects do not have a main, they have a topology that you create and export (using gen-class)
  :jvm-opts ["-Djava.awt.headless=true"]
  :aliases {
            ;"show-config" ["run" "-m" "alestorm.config/show-config"]
            ; Run a test topology using `lein storm` at command line
            "storm" ["run" "-m" "storm-hello-world.core/run!"]
            "d3" ["run" "-m" "storm-hello-world.documentation.show-topology/gen-d3!"]
            }
  :profiles {:provided {:dependencies [[storm "0.8.1"]]}
             :dev {:plugins [[lein-environ "0.4.0"]
                             ; idiomatic clj for lighttable
                             [lein-kibit "0.0.8"]]
                   :dependencies [[clj-stacktrace "0.2.7"]
                                  [storm "0.8.1"]
                                  ; to placate lighttable
                                  [clj-factory "0.2.1"]
                                  [faker "0.2.2"]
                                  [org.clojure/clojurescript "0.0-2030"]
                                  [antler/commons-io "2.2.0"]
                                  [midje "1.6.0"]
                                  [hiccup "1.0.4"]]
                   :injections [(let [orig (ns-resolve (doto 'clojure.stacktrace require)
                                                       'print-cause-trace)
                                      new (ns-resolve (doto 'clj-stacktrace.repl require)
                                                      'pst)]
                                  (alter-var-root orig (constantly (deref new))))]
                   :env {:config "FIX ME"}}})
