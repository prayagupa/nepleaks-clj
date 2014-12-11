(ns nepleaks-engine.conf.config
  (:use     [clj-yaml.core]))

;; load config.yml
(defn load-config []
  (try 
     (parse-string (slurp "./resources/nepleaks.yml"))
  (catch Exception e ((throw (new Exception "Invalid yml")))))
)
   
(defn development []
 (let [dev-map (load-config)] 
      (dev-map :development)))

;; conf/elasticsearch.clj
(def es-server {:hostname "http://192.168.1.45:9200/"
                :index    "gccount"})

