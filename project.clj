(defproject hotel "0.1.0-SNAPSHOT"
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
                ]
  :plugins [[lein-ring "0.7.1"]]
  :ring {:handler nepleaks.handler/app}
  :jvm-opts ["-Xmx512m"]
  :dev-dependencies [[ring-mock "0.1.2"]])
