(ns {{name}}.server
  (:require [compojure.route :refer [files not-found]]
            [compojure.handler :refer [site]]
            [compojure.core :refer [defroutes GET POST]]
            [org.httpkit.server :refer [run-server]]))

(defroutes main
  (GET "/foo" [] "bar"))
