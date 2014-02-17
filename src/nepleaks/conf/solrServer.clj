(use 'solrclj)

;; Http Solr Example
(def server (solr-server {:type :http 
                          :host "localhost"}))

;; Http Multi-core Solr Example
(def server (solr-server {:type :http 
                          :core "books"
                          :host "localhost"}))

;; Embedded Solr Example
(def server (solr-server {:type :embedded 
                         :core "mycore"
                         :dir "/home-path"}))
