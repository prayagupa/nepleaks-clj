(ns nepleaks.views.post
	(:use [hiccup core page]
	      [clj-http.client :as client]
              [nepleaks.conf.server :as server]
              [nepleaks.conf.nlp    :as nlpServer]
              )
)

(comment
	define views
)

;;TODO render json here

(defn getJsonResponse []
  (println "getJsonResponse") ;;FIXME replace it with logger
  ;;(println apply str (server/getEsMapping))
  (nlpServer/speak "I'm Prayag")
  (nlpServer/tag-page "http://writequit.org")
  "prayagupd" ;;return
)

(defn index []
  (html5
    [:head
      [:title "nepleaks.org"]
    ]
    [:body
     [:h1 "A leaks pool"]
     [:p (getJsonResponse)]
     ]))

