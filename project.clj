(defproject hotel "0.1.0-SNAPSHOT"
  :description "nepleaks"
  :url "http://nepleaks.org/"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.1"]
		 [hiccup "1.0.0"]
                 [lobos "1.0.0-beta1"]
                 [korma "0.3.0-RC4"]
                 [mysql/mysql-connector-java "5.1.16"]
                ]
  :plugins [[lein-ring "0.7.1"]]
  :ring {:handler hotel.handler/app}
  :dev-dependencies [[ring-mock "0.1.2"]])
