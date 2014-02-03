(ns nepleaks.views.post
	(:use [hiccup core page]
	      [clj-http.client :as client])
)

(comment
	define views
)

;;TODO execute nepleaks.conf.server and render json here

(defn index []
  (html5
    [:head
      [:title "nepleaks.org"]
    ]
    [:body
      [:h1 "welcome to nepleaks.org"]]))

