(ns nepleaks.handler
  (:use compojure.core
	nepleaks.views.post
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.handler  :as handler]
            [compojure.route    :as route]
            [ring.util.response :as resp]))

(comment
	define servlet app-routes
)
(defroutes app-routes
  (GET "/" [] (resp/redirect "/index.html"))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(comment
(run-server {:port 8080}
            "/*" (servlet app-routes))
)
