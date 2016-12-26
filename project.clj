(defproject me.zzp/lein-as-resource "2.7.1"
  :description "Provide leiningen as a resource jar on the classpath."
  :url "https://github.com/redraiment/lein-as-resource"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies []

  ;; we put the uberjar in classes, which means it will be included
  ;; in the final jar
  :uberjar-name "classes/lein-standalone.jar"
  :auto-clean false

  ;; we build with the lein profile, to pull in lein, but keep it out
  ;; of the project's dependencies.
  :profiles {:lein {:dependencies [[leiningen "2.7.1"]]}}
  :aliases {"jar" ["do" "with-profile" "+lein" "uberjar," "jar"]
            "install" ["do" "with-profile" "+lein" "uberjar," "install"]
            "deploy" ["do" "with-profile" "+lein" "uberjar," "deploy"]})
