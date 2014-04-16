(defproject nepleaks-engine "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [congomongo "0.4.3"]
                 [storm "0.9.0"] 
                 [clj-kafka "0.2.0-0.8"]
                ]
  :main nepleaks-engine.services.stormService
 )
