(defproject nepleaks-pallet "0.1.0-SNAPSHOT"
  :description "Example Pallet project for show casing how to get a VM with Java up and running"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.palletops/pallet "0.8.0-RC.3"]
                 [com.palletops/pallet-vmfest "0.3.0-beta.2"]
                 [com.palletops/java-crate "0.8.0-beta.5"]
                 [org.clojars.tbatchelli/vboxjws "4.2.4"]
                 [org.slf4j/slf4j-api "1.6.1"]
                 [ch.qos.logback/logback-core "1.0.0"]
                 [ch.qos.logback/logback-classic "1.0.0"]]
  :profiles {:dev
             {:dependencies
              [[com.palletops/pallet "0.8.0-RC.3"
                :classifier "tests"]]
              :plugins
              [[com.palletops/pallet-lein "0.8.0-alpha.1"]]}
             :leiningen/reply
             {:dependencies [[org.slf4j/jcl-over-slf4j "1.7.2"]]
              :exclusions [commons-logging]}}
  :local-repo-classpath true
  :main nepleaks-pallet.main
  :repositories
  {"sonatype" "https://oss.sonatype.org/content/repositories/releases/"})
