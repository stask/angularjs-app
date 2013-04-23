(ns leiningen.new.angularjs-app
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "angularjs-app"))

(defn angularjs-app
  "Create new web application project with http-kit and angularjs"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
             [".gitignore" (render "gitignore")]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md")]
             ["src/{{sanitized}}/server.clj" (render "server.clj" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["resources/public/js/lib/angular.min.js" (render "angular.min.js")]
             ["resources/public/js/lib/ui-bootstrap-tpls-0.2.0.min.js"
              (render "ui-bootstrap-tpls-0.2.0.min.js")]
             ["resources/public/js/app.js" (render "app.js" data)]
             "resources/public/img"
             ["resources/public/css/bootstrap-combined.min.css"
              (render "boostrap-combined.min.css")]
             ["resources/public/index.html" (render "index.html" data)])))
