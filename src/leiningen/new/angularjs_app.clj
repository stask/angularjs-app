(ns leiningen.new.angularjs-app
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "angularjs-app"))

(defn angularjs-app
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
