(defproject nepleaks-engine "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories {"conjars" "http://conjars.org/repo"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [congomongo "0.4.3"]
		 [clojurewerkz/elastisch "1.4.0"]
                 [storm "0.9.0"] 
                 [storm/storm-kafka "0.9.0-wip15b-scala292"]
                 [org.clojure/tools.logging "0.2.6"]
                 [clj-kafka "0.2.0-0.8"]
                 [cascading/cascading-core "2.5.3"
                  :exclusions [javax.mail/mail janino/janino]]
		             [cascalog "2.1.0"]
                 [org.clojure/data.json "0.2.4"]
                 [org.clojure/algo.monads "0.1.5"]
                 ;;;
                 [org.apache.httpcomponents/httpcore "4.3.2"]
                 [org.apache.httpcomponents/httpclient "4.3.3"]
                 [org.apache.httpcomponents/httpmime "4.3.3"]
                 [clojurewerkz/neocons "2.0.1"]
                 [clj-yaml "0.4.0"]
                ]
   :aot [nepleaks-engine.services.leaksSplitterTridentClient
         nepleaks-engine.services.leaksSplitterTridentFunction]
  :profiles { :dev {:dependencies [
                     [org.apache.hadoop/hadoop-core "1.2.1"]
                    ]
		               }
	         }

  ;;:main nepleaks-engine.services.stormService
 )
