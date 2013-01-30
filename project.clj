(defproject hotel "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.1"]
                 [mysql/mysql-connector-java "5.1.16"]
                ]
  :plugins [[lein-ring "0.7.1"]]
  :ring {:handler hotel.handler/app}
  :dev-dependencies [[ring-mock "0.1.2"]])
