(defproject nepleaks "0.1.0-SNAPSHOT"
  :description "nepleaks"
  :url "http://nepleaks.org/"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.1"]
		 [hiccup "1.0.0"]
                 [lobos "1.0.0-beta1"]
                 [korma "0.3.0-RC4"]
                 [mysql/mysql-connector-java "5.1.16"]
		 [clojurewerkz/elastisch "1.4.0"]
		 [clj-http "0.7.8"]
		 [cascalog "2.0.0"]
                ]
  :plugins [[lein-ring "0.7.1"]]
  :ring {:handler nepleaks.handler/app
         ;; hot-reload http://stackoverflow.com/a/14472281/432903
         ;;:auto-reload? true
         ;;:auto-refresh? true
         }
  :jvm-opts ["-Xmx512m"]
  :profiles { :dev {:dependencies [[ring-mock "0.1.2"]
                     [org.apache.hadoop/hadoop-core "1.1.2"]
                    ]
		   }
	    }
  )
