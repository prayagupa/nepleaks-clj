
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; leaks view
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns nepleaks.views.leak
	(:use [hiccup core page]
	      [clj-http.client :as client]
              ;;[nepleaks-engine.services.esService     :as esService]
              [nepleaks.services.nlpService    :as nlpService]
              ))

(comment
	define views)

;;TODO render json here

(defn leaksJson []
  (println "getJsonResponse") ;;FIXME replace it with logger
  ;;(println apply str (esService/getEsMapping))
  "prayagupd" ;;return
)

(defn leaks []
  (html5
    [:head
      [:title "nepleaks.org"]
    ]
    [:body
     [:h1 "A leaks pool"]
     [:p (leaksJson)]
     ]))
